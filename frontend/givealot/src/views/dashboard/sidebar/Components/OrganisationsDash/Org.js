import React, { Component } from 'react'
import "../../styles/Organisations.css"
import axios from "axios";
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import {CalendarToday, LocationSearching, MailOutline, PermIdentity, PhoneAndroid, DescriptionOutlined} from "@material-ui/icons";

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
                <div className="orgCard">
                    <Card className="card1">
                        <CardContent>
                            <Typography color="textPrimary" gutterBottom>
                                <div className="userTitleContainerOrg">
                                    <div className="userTitleOrg">View Information</div>
                                </div>
                                <div >
                                    <div className="userShowTop">
                                        <div className="userShowTopTitle">
                                            <span className="userShowUsername">Gift of the givers</span>
                                            <span className="userShowUserTitle">giving back to the people </span>
                                        </div>
                                    </div>
                                    <div className="userShowBottom">
                                        <span className="userShowTitle">Account Details</span>
                                        <div className="userShowInfo">
                                            <PermIdentity className="userShowIcon" />
                                            <span className="userShowInfoTitle">Gift of the givers</span>
                                        </div>
                                        <div className="userShowInfo">
                                            <CalendarToday className="userShowIcon" />
                                            <span className="userShowInfoTitle">19.08.2021</span>
                                        </div>
                                        <span className="userShowTitle">Contact Details</span>

                                        <div className="userShowInfo">
                                            <PhoneAndroid className="userShowIcon" />
                                            <span className="userShowInfoTitle">Tshilidzi Nekhavhambe</span>
                                        </div>
                                        <div className="userShowInfo">
                                            <PhoneAndroid className="userShowIcon" />
                                            <span className="userShowInfoTitle">081 456 675</span>
                                        </div>
                                        <div className="userShowInfo">
                                            <MailOutline className="userShowIcon" />
                                            <span className="userShowInfoTitle">Givers@gmail.com</span>
                                        </div>
                                    </div>
                                </div>
                            </Typography>
                        </CardContent>
                    </Card>
                    {/*///////////////////////////////////////////////////*/}
                    <Card className="card2">
                        <CardContent>
                            <Typography color="textPrimary" gutterBottom>
                                <div className="userShowBottom">
                                    <span className="userShowTitle">Location</span>
                                    <div className="userShowInfo">
                                        <LocationSearching className="userShowIcon" />
                                        <span className="userShowInfoTitle">Pretoria, arcadia</span>
                                    </div>
                                    <span className="userShowTitle">Description</span>
                                    <div className="userShowInfoO">
                                        {/*<DescriptionOutlined className="userShowIcon" />*/}
                                        <p className="userShowInfoTitle">
                                           Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                        </p>
                                    </div>

                                </div>
                            </Typography>
                        </CardContent>
                        <Typography className="_orgButtons">
                            <Button variant="contained" color="primary">
                                Primary
                            </Button>
                            <Button variant="contained" color="secondary">
                                Secondary
                            </Button>
                            <Button variant="contained" color="secondary">
                                Secondary
                            </Button>
                        </Typography>

                    </Card>
                </div>
            </div>
        )
    }
}

export default Org