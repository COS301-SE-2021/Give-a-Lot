// import React, { Component } from 'react'
// import "../../styles/Organisations.css"
//
// export class OrganisationsDash extends Component {
//
//     render() {
//         return (
//             <div className="organisations">
//                 orgs here
//             </div>
//         )
//     }
// }
//
// export default OrganisationsDash

import React , { Component } from 'react'
import { Link } from "react-router-dom";
import SearchIcon from "@material-ui/icons/Search";
import AddCircleOutlinedIcon from "@material-ui/icons/AddCircleOutlined";
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button'
import { DeleteOutline } from "@material-ui/icons";
import "../../styles/Organisations.css"
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import axios from 'axios'

// export default function OrganisationsDash() {
export class OrganisationsDash extends Component {

    constructor(props) {
        super(props)

        this.state = {
            org:[],
            error: "",
        }

    }

    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        // const adminUsersRequestBody = {
        //     "adminUserEmail" : this.state.adminUserEmail
        // }
        axios.get('http://jsonplaceholder.typicode.com/users',  config)
            .then(response =>{
                // console.log(response)
                this.setState({org: response.data})
                console.log(this.state.org)
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    // handleDelete = (id) => {
    //     setData(data.filter((item) => item.id !== id));
    // };

    render () {
        const { org } = this.state
        return(
                <div className="OrganisationsDash">
                    <div className="OrgAdd">
                        <Link to={"/addOrg"} className="link">
                            <Button variant="contained" className="buttonAdd">
                                Add Organisation
                                <AddCircleOutlinedIcon/>
                            </Button>
                        </Link>
                        <div className="header__input">
                            <input placeholder="search organisation" type="text" />
                            <SearchIcon/>
                        </div>
                    </div>
                    <div className="table">
                        <Grid container spacing={3}>
                            <Grid item xs={12} >
                                <TableContainer component={Paper}>
                                    <Table >
                                        <TableHead>
                                            {/*table head here*/}
                                        </TableHead>
                                        <TableBody>
                                            {org.map((item, index) =>{
                                                return(
                                                    <TableRow>
                                                        <TableCell><Avatar aria-label="recipe" src="https://st.depositphotos.com/1428083/2946/i/600/depositphotos_29460297-stock-photo-bird-cage.jpg" /> </TableCell>
                                                        <TableCell>{item.name}</TableCell>
                                                        <TableCell>{item.username}</TableCell>
                                                        <TableCell>{item.email}</TableCell>
                                                        <TableCell style={{display: "flex", alignItems: "center", justifyContent: "space-between"}}>
                                                            <Link to={"/org"}>
                                                                <button className="orgListEdits">Edit</button>
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