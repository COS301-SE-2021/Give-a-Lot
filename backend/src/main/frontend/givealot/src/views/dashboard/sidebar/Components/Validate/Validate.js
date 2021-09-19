import React, { Component } from 'react';
import "./Validate.css"
import { Link } from "react-router-dom";
import Card from '@material-ui/core/Card'
import CardContent from '@material-ui/core/CardContent'
import Button from '@material-ui/core/Button'
import axios from "axios";

export class Validate extends Component {

    constructor(props) {
        super(props)
        this.state = {
            valid:[],
            error: "",
            adminUserEmail:localStorage.getItem('curr_user_email'),
            serverDomain: "http://localhost:8080"
        }
    }
    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        const adminUsersRequestBody = {
            "adminUserEmail" : this.state.adminUserEmail
        }

        axios.post('http://localhost:8080/v1/notifications/get/notifications', adminUsersRequestBody  ,config)
            .then(response =>{
                this.setState({valid: response.data.response})
                // console.log(response)
            })
            .catch(error =>{
                console.log(error)
                // this.setState({error : 'Error Retrieving data'})
            })
    }

    render() {
        const { valid } = this.state
        return (
            <div className="validate">
                <div className="validateInfo">
                    Verify Information
                </div>

                <div className="table">
                    {valid.map((item, index) =>{
                        return(
                    <Card style={{margin: "1em"}}>
                        <CardContent>
                            <div className="valid">
                                <div >
                                    {item.org_name}
                                </div>
                                    <div>
                                        {item.description}
                                    </div>
                                <Link to={"/orgValidate/" + item.org_id} className="link">
                                    <Button variant="contained" className="buttonValidView">
                                        View
                                    </Button>
                                </Link>
                            </div>
                        </CardContent>
                    </Card>
                        )
                    })}
                </div>
            </div>
        )
    }
}

export default Validate