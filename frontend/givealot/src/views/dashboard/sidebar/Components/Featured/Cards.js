import React, { Component } from 'react'
import "./Styles/Featured.css"
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
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
            orgId: 32,
            reports: [],
            adminId: 14,
            serverDomain: "https://3c73e752688968.localhost.run"
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
        axios.post(this.state.serverDomain + '/report/get/all', adminUsersRequestBodyReports, config)
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
        axios.post(this.state.serverDomain + '/v1/user/get/num_user', adminUsersRequestBody, config)
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
        axios.post(this.state.serverDomain + '/v1/organisation/get/organisations',adminUsersRequestBodyOrg , config)
            .then(response =>{
                console.log(response)
                this.setState({ Organisations: response.data.response })
                // console.log(this.state.Organisations)

            })
            .catch(error =>{
                // console.log(error)
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
        axios.post(this.state.serverDomain + '/v1/notifications/get/num_notifications',adminUsersRequestBodyNotification , config)
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
                        <Typography>
                            <Typography color="textPrimary">
                                Users
                            </Typography>
                            <Typography color="textSecondary">
                                {Users}
                            </Typography>
                        </Typography>
                        <Typography color="textSecondary" className="cardIconUser" >
                            <PersonOutlineIcon />
                        </Typography>
                    </CardContent>
                </Card>

                <Card variant="outlined" className="cardElement">
                    <CardContent style={{display: "flex", alignItems: "center", justifyContent: "space-evenly"}}>
                        <Typography>
                            <Typography color="textPrimary">
                                Organisations
                            </Typography>
                            <Typography color="textSecondary">
                                {Organisations.length}
                            </Typography>
                        </Typography>
                        <Typography color="textSecondary" className="cardIconOrg" >
                            <PeopleOutlineIcon />
                        </Typography>
                    </CardContent>
                </Card>

                <Card variant="outlined" className="cardElement">
                    <CardContent style={{display: "flex", alignItems: "center", justifyContent: "space-evenly"}}>
                        <Typography>
                            <Typography color="textPrimary">
                                Reports
                            </Typography>
                            <Typography color="textSecondary">
                                {reports.length}
                            </Typography>
                        </Typography>
                        <Typography color="textSecondary" className="cardIconReports" >
                            <ReportIcon />
                        </Typography>
                    </CardContent>
                </Card>

                <Card variant="outlined" className="cardElement">
                    <CardContent style={{display: "flex", alignItems: "center", justifyContent: "space-evenly"}}>
                        <Typography>
                            <Typography color="textPrimary">
                                Notifications
                            </Typography>
                            <Typography color="textSecondary">
                                {notifications}
                            </Typography>
                        </Typography>
                        <Typography color="textSecondary" className="cardIconNotifications" >
                            <NotificationsOutlinedIcon />
                        </Typography>
                    </CardContent>
                </Card>

            </div>

        )
    }
}

export default Cards
