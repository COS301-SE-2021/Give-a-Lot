import React, { Component } from 'react'
import "./Styles/Featured.css"
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import PersonOutlineIcon from '@material-ui/icons/PersonOutline';
import PeopleOutlineIcon from '@material-ui/icons/PeopleOutline';
import ReportIcon from '@material-ui/icons/Report';
import NotificationsOutlinedIcon from '@material-ui/icons/NotificationsOutlined';
import axios from "axios";

export class Cards extends Component {

    constructor(props) {
        super(props)

        this.state = {
            Users: '',
            Organisations: '',
            notifications: '',
            adminUserEmail:'admin@email.com',
            orgId: 72,
            reports: [],
            adminId: 4
        }
    }

    componentDidMount(){
        this.getUsers();
        this.getOrganisations();
        this.getNotifications();
        this. getReports();
    }


    getReports(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const adminUsersRequestBodyReports = {
            // "orgId":"id of an organisation"
            "orgId" : this.state.orgId
        }
        axios.post('http://localhost:8080/report/get/all', adminUsersRequestBodyReports, config)
            .then(response =>{
                console.log(response)
                this.setState({ reports: response.data.object })
                // console.log(this.state.Users)

            })
            .catch(error =>{
                // console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    getUsers(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const adminUsersRequestBody = {
            "adminUserEmail" : this.state.adminUserEmail
        }
        axios.post('http://localhost:8080/v1/user/get/num_user', adminUsersRequestBody, config)
            .then(response =>{
                console.log(response)
                this.setState({ Users: response.data.response })
                // console.log(this.state.Users)

            })
            .catch(error =>{
                // console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    getOrganisations(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const adminUsersRequestBodyOrg = {
            "adminId" : this.state.adminId
        }
        axios.post('http://localhost:8080/v1/organisation/get/organisations',adminUsersRequestBodyOrg , config)
            .then(response =>{
                console.log(response)
                this.setState({ Organisations: response.data.response })
                // console.log(this.state.Organisations)

            })
            .catch(error =>{
                alert(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    getNotifications(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const adminUsersRequestBodyNotification = {
            "adminUserEmail" : this.state.adminUserEmail
        }
        axios.post('http://localhost:8080/v1/notifications/get/num_notifications',adminUsersRequestBodyNotification , config)
            .then(response =>{
                // console.log(response)
                this.setState({ notifications: response.data.response })
                // console.log(this.state.Reports)

            })
            .catch(error =>{
                // console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    render() {
        const { Users , Organisations, notifications, reports} = this.state
        return (
            <div style={{display: "flex"}} className= "featuredCards">
                <Card variant="outlined" className="cardElement">
                    <CardContent style={{display: "flex", alignItems: "center", justifyContent: "space-evenly"}}>
                        <div>
                            <div color="textPrimary">
                                Users
                            </div>
                            <div color="textSecondary">
                                {Users}
                            </div>
                        </div>
                        <div color="textSecondary" className="cardIconUser" >
                            <PersonOutlineIcon />
                        </div>
                    </CardContent>
                </Card>

                <Card variant="outlined" className="cardElement">
                    <CardContent style={{display: "flex", alignItems: "center", justifyContent: "space-evenly"}}>
                        <div>
                            <div color="textPrimary">
                                Organisations
                            </div>
                            <div color="textSecondary">
                                {Organisations.length}
                            </div>
                        </div>
                        <div color="textSecondary" className="cardIconOrg" >
                            <PeopleOutlineIcon />
                        </div>
                    </CardContent>
                </Card>

                <Card variant="outlined" className="cardElement">
                    <CardContent style={{display: "flex", alignItems: "center", justifyContent: "space-evenly"}}>
                        <div>
                            <div color="textPrimary">
                                Reports
                            </div>
                            <div color="textSecondary">
                                {reports.length}
                            </div>
                        </div>
                        <div color="textSecondary" className="cardIconReports" >
                            <ReportIcon />
                        </div>
                    </CardContent>
                </Card>

                <Card variant="outlined" className="cardElement">
                    <CardContent style={{display: "flex", alignItems: "center", justifyContent: "space-evenly"}}>
                        <div>
                            <div color="textPrimary">
                                Notifications
                            </div>
                            <div color="textSecondary">
                                {notifications}
                            </div>
                        </div>
                        <div color="textSecondary" className="cardIconNotifications" >
                            <NotificationsOutlinedIcon />
                        </div>
                    </CardContent>
                </Card>

            </div>

        )
    }
}

export default Cards
