import React, { Component } from 'react'
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import DashboardIcon from '@material-ui/icons/Dashboard';
import TimelineIcon from '@material-ui/icons/Timeline';
import PersonIcon from '@material-ui/icons/Person';
import ImageIcon from '@material-ui/icons/Image';
import ReportIcon from '@material-ui/icons/Report';
import AssignmentIcon from '@material-ui/icons/Assignment';
import { Link } from 'react-router-dom';
import SettingsIcon from '@material-ui/icons/Settings';
import CalendarTodayIcon from '@material-ui/icons/CalendarToday';
import "./Organisation.css"
import log from "./images/ID2.png"
import ExitToAppIcon from '@material-ui/icons/ExitToApp';
import DialogTitle from '@material-ui/core/DialogTitle'
import Dialog from '@material-ui/core/Dialog'
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import Button from "@material-ui/core/Button";
import Login from "../login/Login"
import {Switch,Route} from "react-router-dom";

export class OrgSidebar extends Component {
    constructor(props) {
        super(props)

        this.state = {
            open: false,
        }

    }
    render() {
        return (
            <div>
                <div className="sidebar">
                    <div>
                        <img src={log} alt="" className="imageOrg"/>
                    </div>

                    <Link to={'/'} className='text-link active'>
                        <ListItem button>
                            <ListItemIcon>
                                <DashboardIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Dashboard" />
                        </ListItem>
                    </Link>
                    <Link to={'/profile'} className='text-link' >
                        <ListItem button>
                            <ListItemIcon>
                                <PersonIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Profile" />
                        </ListItem>
                    </Link>

                    <Link to={'/timeline'} className='text-link' >
                        <ListItem button>
                            <ListItemIcon>
                                <TimelineIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Timeline" />
                        </ListItem>
                    </Link>

                    <Link to={'/gallery'} className='text-link' >
                        <ListItem button>
                            <ListItemIcon>
                                <ImageIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="gallery" />
                        </ListItem>
                    </Link>

                    <Link to={'/OrgCalendar'} className='text-link'>
                        <ListItem button>
                            <ListItemIcon>
                                <CalendarTodayIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Calendar" />
                        </ListItem>
                    </Link>

                    <Link to={'/todo'} className='text-link'>
                        <ListItem button>
                            <ListItemIcon>
                                <AssignmentIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="TO-DO's" />
                        </ListItem>
                    </Link>

                    <Link to={'/reports'} className='text-link'>
                        <ListItem button>
                            <ListItemIcon>
                                <ReportIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="reports" />
                        </ListItem>
                    </Link>

                    <Link to={'/settings'} className='text-link'>
                        <ListItem button>
                            <ListItemIcon>
                                <SettingsIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="settings" />
                        </ListItem>
                    </Link>

                    <Link className='text-link' >
                        <ListItem button className='text-link'
                                  onClick={() => this.setState({ open: !this.state.open })}
                        >
                            <ListItemIcon>
                                <ExitToAppIcon className="icon"/>
                            </ListItemIcon >
                            <ListItemText primary="LogOut" />
                        </ListItem>
                    </Link>
                    <Dialog open={this.state.open}  aria-labelledby="form-dialog-title">
                        <DialogTitle id="form-dialog-title">Log Out</DialogTitle>
                        <DialogContent>
                            <DialogContentText>
                                Are you sure?
                            </DialogContentText>
                        </DialogContent>
                        <DialogActions>
                            <Link to={'/login'} className='text-link' >
                                <Button onClick={() => this.setState({ open: !this.state.open })}  color="primary">
                                    Yes
                                </Button>
                            </Link>
                            <Button onClick={() => this.setState({ open: !this.state.open })}  color="primary">
                                No
                            </Button>
                        </DialogActions>
                    </Dialog>

                </div>
                <Switch>
                    <Route exact path="/login" component={Login} />
                </Switch>

            </div>

        )
    }
}

export default OrgSidebar