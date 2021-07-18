import React, { Component } from 'react'
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import DashboardIcon from '@material-ui/icons/Dashboard';
import PeopleIcon from '@material-ui/icons/People';
import BarChartIcon from '@material-ui/icons/BarChart';
import AssignmentIcon from '@material-ui/icons/Assignment';
import { Link } from 'react-router-dom';
import MailOutlineIcon from '@material-ui/icons/MailOutline';
import CalendarTodayIcon from '@material-ui/icons/CalendarToday';
import DescriptionIcon from '@material-ui/icons/Description';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import "./Admin.css"

export class Admin extends Component {

    render() {
        return (
        <div className="sidebar">
            <Link to={'/'} style={{ textDecoration: 'none' }}>
                <ListItem button>
                    <ListItemIcon>
                        <DashboardIcon />
                    </ListItemIcon>
                    <ListItemText primary="Dashboard" />
                </ListItem>
            </Link>
            <Link to={'/adminUsers'} style={{ textDecoration: 'none' }}>
                <ListItem button>
                    <ListItemIcon>
                        <PeopleIcon />
                    </ListItemIcon>
                    <ListItemText primary="View Users" />
                </ListItem>
            </Link>

            <Link to={'/adminOrgs'} style={{ textDecoration: 'none' }}>
                <ListItem button>
                    <ListItemIcon>
                        <PeopleIcon />
                    </ListItemIcon>
                    <ListItemText primary="View Organisations" />
                </ListItem>
            </Link>

            <Link to={'/email'} style={{ textDecoration: 'none' }}>
                <ListItem button>
                    <ListItemIcon>
                        <MailOutlineIcon />
                    </ListItemIcon>
                    <ListItemText primary="Emails" />
                </ListItem>
            </Link>

            <Link to={'/calendar'} style={{ textDecoration: 'none' }}>
                <ListItem button>
                    <ListItemIcon>
                        <CalendarTodayIcon />
                    </ListItemIcon>
                    <ListItemText primary="Calendar" />
                </ListItem>
            </Link>

            <Link to={'/todos'} style={{ textDecoration: 'none' }}>
                <ListItem button>
                    <ListItemIcon>
                        <AssignmentIcon />
                    </ListItemIcon>
                    <ListItemText primary="TO-DO's" />
                </ListItem>
            </Link>

            <Link to={'/documentation'} style={{ textDecoration: 'none' }}>
                <ListItem button>
                    <ListItemIcon>
                        <DescriptionIcon />
                    </ListItemIcon>
                    <ListItemText primary="Documentation" />
                </ListItem>
            </Link>

            <Link to={'/stats'} style={{ textDecoration: 'none' }}>
                <ListItem button>
                    <ListItemIcon>
                        <BarChartIcon />
                    </ListItemIcon>
                    <ListItemText primary="Statistics" />
                </ListItem>
            </Link>

            <Link to={'/logout'} style={{ textDecoration: 'none' }}>
                <ListItem button>
                    <ListItemIcon>
                        <AccountCircleIcon />
                    </ListItemIcon>
                    <ListItemText primary="Logout" />
                </ListItem>
            </Link>

        </div>
        )
    }
}

export default Admin