import React , { Component } from 'react'
import { Link } from "react-router-dom";
import SearchIcon from "@material-ui/icons/Search";
import AddCircleOutlinedIcon from "@material-ui/icons/AddCircleOutlined";
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button'
import { DeleteOutline } from "@material-ui/icons";
import "../../styles/Organisations.css"
import Grid from '@material-ui/core/Grid';
import axios from 'axios'
import EditIcon from '@material-ui/icons/Edit';
import Dialog from "@material-ui/core/Dialog";
import DialogContent from "@material-ui/core/DialogContent";
import DialogTitle from "@material-ui/core/DialogTitle";
import TextField from "@material-ui/core/TextField";
import AddOrg from "./AddOrg";
import Divider from '@material-ui/core/Divider';
import {IconButton} from "@material-ui/core";
import Card from '@material-ui/core/Card';
import TableContainer from "@material-ui/core/TableContainer";
import Paper from "@material-ui/core/Paper";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableBody from "@material-ui/core/TableBody";
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell";

export class OrganisationsDash extends Component {

    constructor(props) {
        super(props)
        this.state = {
            org:[],
            error: "",
            sectorName: "",
            open: false,
            openAdd: false,
            getSector: []
        }
    }

    openDialog() {
        this.setState({ open: true });
    }
    openDialogAdd() {
        this.setState({ openAdd: true });
    }

    handleClose = () => {
        this.setState({ open: false });
    };

    handleCloseAdd = () => {
        this.setState({ openAdd: false });
    };

    componentDidMount(){
        this.getSectors();
        this.getOrganisations();
    }
    getOrganisations(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        axios.get('http://jsonplaceholder.typicode.com/users',  config)
            .then(response =>{
                // console.log(response)
                this.setState({org: response.data})
                // console.log(this.state.org)
            })
            .catch(error =>{
                // console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }
    getSectors(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        axios.get('http://localhost:8080/v1/organisation/get/sectors',  config)
            .then(response =>{
                // console.log(response)
                this.setState({getSector: response.data.sectors})
            })
            .catch(error =>{
                // console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    changeHandler = (e) =>{
        this.setState({[e.target.name] : e.target.value})
    }

    submitSector = (e) =>{
        e.preventDefault();
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        axios.post('http://localhost:8080/v1/organisation/get/sectors', this.state.sectorName ,config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    render () {
        const { org, getSector, sectorName } = this.state
        return(
                <div className="OrganisationsDash">
                    {/*<DashHeader />*/}
                    <div className="OrgAdd">
                        {/*<Link to={"/addOrg"} className="link">*/}
                            <Button variant="contained" className="buttonAdd" onClick={this.openDialogAdd.bind(this)}>
                                Add Organisation
                                <AddCircleOutlinedIcon/>
                            </Button>
                                <Dialog onClose={this.handleCloseAdd.bind(this)} open={this.state.openAdd}>
                                    <DialogTitle>Add Organisation</DialogTitle>
                                    <DialogContent>
                                        <AddOrg />
                                    </DialogContent>
                                </Dialog>
                        {/*</Link>*/}
                            <Button variant="contained" className="buttonAddSector" onClick={this.openDialog.bind(this)}>
                                Create Sector
                                <AddCircleOutlinedIcon/>
                            </Button>
                                <Dialog onClose={this.handleClose.bind(this)} open={this.state.open} style={{width: "100%"}}>
                                    <DialogTitle style={{color: "#957b9e"}}>Create a Sector</DialogTitle>
                                    <DialogContent style={{display: "flex", alignItems: "center", justifyContent: "center"}}>
                                        <Grid>
                                            <form onSubmit={this.submitSector}>
                                                <TextField
                                                    id="outlined-full-width"
                                                    label="Sector"
                                                    style={{ margin: 8 }}
                                                    placeholder="Sector"
                                                    fullWidth
                                                    margin="normal"
                                                    // InputLabelProps={{
                                                    //     shrink: true,
                                                    // }}
                                                    variant="outlined"
                                                    name="sectorName"
                                                    onChange={this.changeHandler}
                                                    value={sectorName}
                                                />
                                                <Button variant="contained" className="buttonAdd" type="submit">
                                                    Submit
                                                </Button>
                                            </form>
                                            <Divider style={{marginTop: "2em"}}/>
                                            <Grid>
                                                <div style={{marginBottom: "1em",marginTop: "1em", color: "#957b9e",fontSize: "x-large"}}>View Available Sectors</div>
                                                <div>
                                                    {getSector.map((sector) =>{
                                                        return(
                                                            <li key={sector} value={sector}>
                                                                {sector}
                                                            </li>
                                                        )
                                                    })}
                                                </div>
                                            </Grid>
                                        </Grid>

                                    </DialogContent>
                                </Dialog>
                        </div>
                    <div className="header__input">
                        <input placeholder="search organisation" type="text" />
                        <SearchIcon/>
                    </div>

                    <div className="table">
                        <Grid container spacing={3}>
                            <Grid item xs={12} >
                                <TableContainer component={Paper}>
                                    <Table >
                                        <TableHead>

                                        </TableHead>
                                        <TableBody>
                                            {org.map((item, index) =>{
                                                return(
                                                    <TableRow>
                                                        <TableCell><Avatar aria-label="recipe" src="https://st.depositphotos.com/1428083/2946/i/600/depositphotos_29460297-stock-photo-bird-cage.jpg" /> </TableCell>
                                                        <TableCell>{item.name}</TableCell>
                                                        <TableCell>{item.username}</TableCell>
                                                        <TableCell>{item.email}</TableCell>
                                                        <TableCell>{item.username}</TableCell>
                                                        <TableCell>{item.name}</TableCell>
                                                        <TableCell>
                                                            <Link to={"/org"}>
                                                                <EditIcon />
                                                                {/*Edit</CreateIcon>*/}
                                                            </Link>
                                                            <DeleteOutline
                                                                className="orgListDeletes"
                                                                // onClick={() => handleDelete(params.row.id)}
                                                            />
                                                        </TableCell>
                                                    </TableRow>
                                                )
                                            })}
                                        </TableBody>
                                    </Table>
                                </TableContainer>
                            </Grid>
                        </Grid>
                    </div>
                </div>
            );
    }


}

export default OrganisationsDash