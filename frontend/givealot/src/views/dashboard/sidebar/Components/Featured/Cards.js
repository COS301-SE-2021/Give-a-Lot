import React, { Component } from 'react'
import "./Styles/Featured.css"
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import PersonOutlineIcon from '@material-ui/icons/PersonOutline';
import PeopleOutlineIcon from '@material-ui/icons/PeopleOutline';
import ReportIcon from '@material-ui/icons/Report';
import NotificationsOutlinedIcon from '@material-ui/icons/NotificationsOutlined';

export class Cards extends Component {

    render() {
        return (
            <div style={{display: "flex"}} className= "featuredCards">
                <Card variant="outlined" className="cardElement">
                    <CardContent style={{display: "flex", alignItems: "center", justifyContent: "space-evenly"}}>
                        <Typography>
                            <Typography color="textPrimary">
                                Users
                            </Typography>
                            <Typography color="textSecondary">
                                123
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
                                123
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