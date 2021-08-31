import React, { Component } from 'react'
import "./Validate.css"
import Grid from "@material-ui/core/Grid";
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import CardActions from '@material-ui/core/CardActions';
import {Link} from "react-router-dom";
import axios from "axios";

export class OrgValidate extends Component {

    constructor(props) {
        super(props)
        this.state = {
            validation:[],
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
                this.setState({validation: response.data})
                console.log(this.state.validation)
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }


    render() {
        const { validation } = this.state
        return (
            <div className="validate">
                <div className="validBody">
                    <div  className="name">
                        Organisation Name
                    </div>
                    <div className="table">
                        {validation.map((item, index) =>{
                            return(
                                <Card style={{margin: "1em"}}>
                                    <CardContent>
                                        <Typography className="valid">
                                            <Typography component="p">
                                                {item.name}
                                            </Typography>
                                            <Typography style={{display: "flex", alignItems: "center", justifyContent: "space-between"}}>
                                                <Button variant="contained" className="buttonValidView">
                                                    Accept
                                                </Button>
                                                <Button variant="contained" className="buttonValidViewDeny">
                                                    Deny
                                                </Button>
                                            </Typography>

                                        </Typography>
                                    </CardContent>
                                </Card>
                            )
                        })}
                    </div>
                </div>

            </div>
        )
    }
}

export default OrgValidate