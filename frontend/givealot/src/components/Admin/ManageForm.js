import React, { Component } from 'react'
import "./Manage.css"
// import React, { Component } from 'react';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import {makeStyles} from "@material-ui/core/styles";
import Galleryy from "./Galleryy";
import MenuItem from "@material-ui/core/MenuItem";
import axios from 'axios';

const useStyles = makeStyles((theme) => ({

    buttons: {
        display: 'flex',
        justifyContent: 'flex-end',
        padding: "30",
        margin: "20"
    },
    button: {
        marginTop: theme.spacing(3),
        marginLeft: theme.spacing(1),
        backgroundColor:'#94f8b9'
    },


}));

export class Manage extends Component {


    constructor(props) {
        super(props)

        this.state = {
            users: [],
            org_id: "4fd69da9a34e2c771998e0c8f912b4f4",
            org_name: "",
            org_description: ""
        }

    }

    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        axios.post('http://localhost:8080/organisation/get', { org_id : this.state.org_id}, config)

            //axios.get('http://localhost:8080/organisation/get')
            .then(response =>{
                console.log(response)
                console.log(response.data[0].org_name)
                this.setState({org_name: response.data[0].org_name, org_description : response.data[0].org_description ,org_id: response.data[0].org_id})

            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }


    changeHandler = (e) =>{
        this.setState({[e.target.name] : e.target.value})
    }
    
    handleSuspend = (e) =>{
        e.preventDefault()

        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        console.log("this is ----| ", this.state.org_id )
        axios.post('http://localhost:8080/organisation/suspend',{ org_id : this.state.org_id}, config)
            .then(response =>{
                console.log("this is ", this.state.id )
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }


    handleRenew = (e) =>{
        e.preventDefault()
        console.log("this is ", this.state.org_id )
        axios.post('http://localhost:8080/report/organisation/renew', this.state.org_id)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    render() {

        const { org_id, org_name, org_description} = this.state
        return (
            <div className="manage">
                <div >

                    <div >
                        <h2>{org_name}</h2>

                        <p>{org_description}

                            </p>
                        
                        <Galleryy />
                         <p style={{color: "white"}}>Lazy space, don't remove</p>
                    </div>

                    {/* <form onSubmit={this.submitHandler}> */}
                        <React.Fragment >
                            <Grid container spacing={3}>
                            <form onSubmit={this.handleRemove } style={{padding: "10px"}}>
                                    <input type="hidden" value={org_id} />
                                    <Grid item xs={12} sm={3}>
                                        <Button
                                            variant="contained"
                                            color="primary"
                                           type="submit"
                                           name="org_id"
                                           onChange={this.changeHandler}
                                        >
                                            Verify
                                        </Button>
                                    </Grid>
                                </form>

                                <form onSubmit={this.handleRemove} style={{padding: "10px"}}>
                                    <input type="hidden" value={org_id} />
                                    <Grid item xs={12} sm={3}>
                                        <Button
                                            variant="contained"
                                            color="primary"
                                           type="submit"
                                           name="org_id"
                                           onChange={this.changeHandler}
                                        >
                                            Generate
                                        </Button>
                                    </Grid>
                                </form>
                                <form onSubmit={this.handleRemove} style={{padding: "10px", alignItems: "center"}}>
                                    <input type="hidden" value={org_id} />
                                    <Grid item xs={12} sm={3}>
                                        <Button
                                            variant="contained"
                                            color="primary"
                                           type="submit"
                                           name="org_id"
                                           onChange={this.changeHandler}
                                        >
                                            Revoke
                                        </Button>
                                    </Grid>
                                </form>

                                <form onSubmit={this.handleRenew} style={{padding: "10px"}}>
                                    <input type="hidden" value={org_id} />
                                    <Grid item xs={12} sm={3}>
                                        <Button
                                            variant="contained"
                                            color="primary"
                                           type="submit"
                                           name="org_id"
                                           
                                        >
                                            ReNew
                                        </Button>
                                    </Grid>
                                </form>

                                <form onSubmit={this.handleSuspend} style={{padding: "10px"}}>
                                    <input type="hidden" value={org_id} />
                                    <Grid item xs={12} sm={3}>
                                        <Button
                                            variant="contained"
                                            color="primary"
                                           type="submit"
                                           name="org_id"
                                        >
                                            Suspend
                                        </Button>
                                    </Grid>
                                </form>
                                
                            </Grid>
                        </React.Fragment>
                </div>
            </div>
        )
    }
}

export default Manage
