import React, { Component } from 'react'
import "../../styles/Organisations.css"
import {
    CalendarToday,
    LocationSearching,
    MailOutline,
    PermIdentity,
    PhoneAndroid,
    Publish,
} from "@material-ui/icons";
import axios from "axios";

export class Org extends Component {

    constructor(props) {
        super(props)

        this.state = {
            orgS:[]
        }
    }

    componentDidMount(){
        /*    let config = {
                headers: {
                    "Content-Type": "application/json",
                    'Access-Control-Allow-Origin': '*',
                }
            }*/
        axios.get('http://localhost:8080/v1/user/get/users')
            .then(response =>{
                console.log(response)
                const orgS = response.data;
                this.setState({ orgS });
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    render() {
        return (
            <div className="org">
                    org here
            </div>
        )
    }
}

export default Org