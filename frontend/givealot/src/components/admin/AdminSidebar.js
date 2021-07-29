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

export class AdminSidebar extends Component {
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
                        <ListItem button>
                            <ListItemIcon>
                                <ExitToAppIcon className="icon"/>
                            </ListItemIcon >
                            <ListItemText primary="Logout" />
                        </ListItem>
                    </Link>
                    <Divider />

                </div>

            </div>

        )
    }
}

export default AdminSidebar