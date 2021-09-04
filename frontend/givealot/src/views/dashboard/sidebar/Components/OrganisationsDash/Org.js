import React, { Component } from 'react'
import "../../styles/Organisations.css"
import axios from "axios";
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import {useParams} from 'react-router-dom';
import {CalendarToday, LocationSearching, MailOutline, PermIdentity, PhoneAndroid, DescriptionOutlined} from "@material-ui/icons";

export class Org extends Component {

    constructor(props) {
        super(props)

        this.state = {
            orgS:{},
            orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1],
            investigate: ''
        }
        console.log(this.state.orgId)
        // let idUrl = window.location.pathname.split('/')[window.location.pathname.split('/').length - 1]
        // console.log(idUrl)


    }

    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        console.log(this.props)
        axios.get('http://localhost:8080/v1/organisation/sel/organisation/'+this.state.orgId+'/default', config)
            .then(response =>{
                console.log(response)
                this.setState({orgS: response.data.response})
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    handleActivate() {

        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const activate = {
            orgID : window.location.pathname.split('/')[window.location.pathname.split('/').length - 1]
        }
        console.log(activate)
        axios.put('http://localhost:8080/v1/organisation/activate/orgId',activate ,config)
            .then(response =>{
                console.log(response)
                // this.setState({investigate: response.data})
                // console.log(this.state.org)
            })
            .catch(error =>{
                console.log(error)
                // this.setState({error : 'Error Retrieving data'})
            })

    }

    handleInvestigate () {
        // e.preventDefault();
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const investigate = {
            orgID : window.location.pathname.split('/')[window.location.pathname.split('/').length - 1]
        }
        // console.log("investigate")
        axios.put('http://localhost:8080/v1/organisation/investigate/orgId',investigate ,config)
            .then(response =>{
                console.log(response)
                // this.setState({investigate: response.data})
                // console.log(this.state.org)
            })
            .catch(error =>{
                console.log(error)
                // this.setState({error : 'Error Retrieving data'})
            })
    }

    handleSuspend() {

        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const suspend = {
            orgID : window.location.pathname.split('/')[window.location.pathname.split('/').length - 1]
        }
        // console.log("investigate")
        axios.put('http://localhost:8080/v1/organisation/suspend/orgId',suspend ,config)
            .then(response =>{
                console.log(response)
                // this.setState({investigate: response.data})
            })
            .catch(error =>{
                console.log(error)
            })

    }


    render() {
        const { orgS } = this.state
        return (
            <div className="org">

                {/*<div>*/}
                {/*    { console.log(this.props.match.params.orgId)}*/}
                {/*</div>*/}

                {/*<Typography style={{width: "100%", height: "8em"}}>*/}
                    <img src="https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg" style={{width: "100%", height: "30%"}}/>
                {/*</Typography>*/}
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
                                            <span className="userShowUsername">{orgS.orgName}</span>
                                            <span className="userShowUserTitle">{orgS.slogan}</span>
                                        </div>
                                    </div>
                                    <div className="userShowBottom">
                                        <span className="userShowTitle">Account Details</span>
                                        <div className="userShowInfo">
                                            <PermIdentity className="userShowIcon" />
                                            <span className="userShowInfoTitle">{orgS.orgName}</span>
                                        </div>
                                        <div className="userShowInfo">
                                            <CalendarToday className="userShowIcon" />
                                            <span className="userShowInfoTitle">{orgS.dateAdded}</span>
                                        </div>
                                        <span className="userShowTitle">Contact Details</span>

                                        <div className="userShowInfo">
                                            <PhoneAndroid className="userShowIcon" />
                                            <span className="userShowInfoTitle">{orgS.contactPerson}</span>
                                        </div>
                                        <div className="userShowInfo">
                                            <PhoneAndroid className="userShowIcon" />
                                            <span className="userShowInfoTitle">{orgS.contactNumber}</span>
                                        </div>
                                        <div className="userShowInfo">
                                            <MailOutline className="userShowIcon" />
                                            <span className="userShowInfoTitle">{orgS.orgEmail}</span>
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
                                        <span className="userShowInfoTitle">{orgS.orgSector}</span>
                                    </div>
                                    <div className="userShowInfo">
                                        <LocationSearching className="userShowIcon" />
                                        <span className="userShowInfoTitle">{orgS.status}</span>
                                    </div>
                                    <span className="userShowTitle">Description</span>
                                    <div className="userShowInfoO">
                                        {/*<DescriptionOutlined className="userShowIcon" />*/}
                                        <p className="userShowInfoTitle">
                                            {orgS.orgDescription}
                                        </p>
                                    </div>

                                </div>
                            </Typography>
                        </CardContent>
                        <Typography className="_orgButtons">
                            <Button  type="submit" variant="contained" color="primary" onClick={this.handleActivate}>
                                Activate
                            </Button>
                            <Button type="submit" variant="contained" style={{color: "white", backgroundColor: "orange"}}
                                    onClick={this.handleInvestigate}
                            >
                                Investigate
                            </Button>
                            <Button type="submit" variant="contained" color="secondary"
                                    onClick={this.handleSuspend}
                            >
                                Suspend
                            </Button>
                        </Typography>

                    </Card>
                </div>
            </div>
        )
    }
// <button onClick={this.deleteRow.bind(this, id)}>Delete Row</button>
}

export default Org
