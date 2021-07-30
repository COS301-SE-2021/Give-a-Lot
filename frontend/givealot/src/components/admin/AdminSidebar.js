import React, { Component } from 'react'
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import DashboardIcon from '@material-ui/icons/Dashboard';
import PeopleIcon from '@material-ui/icons/People';
import AssignmentIcon from '@material-ui/icons/Assignment';
import { Link } from 'react-router-dom';
import MailOutlineIcon from '@material-ui/icons/MailOutline';
import CalendarTodayIcon from '@material-ui/icons/CalendarToday';
import "./Admin.css"
import logo from "./imagesRegister/ID2.png"
import Divider from '@material-ui/core/Divider';
import SettingsIcon from '@material-ui/icons/Settings';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';
import DialogTitle from '@material-ui/core/DialogTitle'
import Dialog from '@material-ui/core/Dialog'
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import Button from "@material-ui/core/Button";

export class AdminSidebar extends Component {
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
                        <img src={logo} alt="" className="imageAdmin"/>
                    </div>

                    <Link to={'/'} className='text-link active'>
                        <ListItem button>
                            <ListItemIcon>
                                <DashboardIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Dashboard" />
                        </ListItem>
                    </Link>
                    <Link to={'/adminUsers'} className='text-link' >
                        <ListItem button>
                            <ListItemIcon>
                                <PeopleIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="View Users" />
                        </ListItem>
                    </Link>

                    <Link to={'/adminOrganisations'} className='text-link' >
                        <ListItem button>
                            <ListItemIcon>
                                <PeopleIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="View Organisations" />
                        </ListItem>
                    </Link>

                    <Link to={'/emails'} className='text-link' >
                        <ListItem button>
                            <ListItemIcon>
                                <MailOutlineIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Emails" />
                        </ListItem>
                    </Link>

                    <Link to={'/calendar'} className='text-link'>
                        <ListItem button>
                            <ListItemIcon>
                                <CalendarTodayIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Calendar" />
                        </ListItem>
                    </Link>

                    <Link to={'/todos'} className='text-link'>
                        <ListItem button>
                            <ListItemIcon>
                                <AssignmentIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="TO-DO's" />
                        </ListItem>
                    </Link>

                    <Link to={'/settings'} className='text-link' >
                        <ListItem button>
                            <ListItemIcon>
                                <SettingsIcon className="icon"/>
                            </ListItemIcon >
                            <ListItemText primary="Settings" />
                        </ListItem>
                    </Link>
                    <Link className='text-link' >
                        <ListItem button
                          onClick={() => this.setState({ open: !this.state.open })}
                        >
                            <ListItemIcon>
                                <ExitToAppIcon className="icon"/>
                            </ListItemIcon >
                            <ListItemText primary="Logout" />
                        </ListItem>
                    </Link>
                    <Dialog open={this.state.open}  aria-labelledby="form-dialog-title">
                        <DialogTitle id="form-dialog-title">LogOut</DialogTitle>
                        <DialogContent>
                            <DialogContentText>
                                Are you Sure?
                            </DialogContentText>
                        </DialogContent>
                        <DialogActions>
                            <Button onClick={() => this.setState({ open: !this.state.open })}  color="primary">
                                Yes
                            </Button>
                            <Button onClick={() => this.setState({ open: !this.state.open })}  color="primary">
                                No
                            </Button>
                        </DialogActions>
                    </Dialog>
                    <Divider />

                </div>

            </div>

        )
    }
}

export default AdminSidebar