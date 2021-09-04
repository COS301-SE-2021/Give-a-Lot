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
            Reports: [],
            adminUserEmail:'admin@email.com',
        }
    }

    componentDidMount(){
        this.getUsers();
        this.getOrganisations();
        this.getReports();
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
            "adminUserEmail" : this.state.adminUserEmail
        }
        axios.post('http://localhost:8080/v1/organisation/get/num_organisation',adminUsersRequestBodyOrg , config)
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

    getReports(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        axios.get('http://localhost:8080/v1/organisation/get/organisations',  config)
            .then(response =>{
                // console.log(response)
                this.setState({ Reports: response.data })
                // console.log(this.state.Reports)

            })
            .catch(error =>{
                // console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }


    render() {
        const { Users , Organisations, Reports} = this.state
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
                                {Organisations}
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
                                123
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
                                123
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
