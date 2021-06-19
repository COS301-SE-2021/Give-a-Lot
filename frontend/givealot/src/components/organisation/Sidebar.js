import React from 'react';
import "./Sidebar.css";
// import { Avatar } from '@material-ui/core';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import ListSubheader from '@material-ui/core/ListSubheader';
import DashboardIcon from '@material-ui/icons/Dashboard';
import PeopleIcon from '@material-ui/icons/People';
import BarChartIcon from '@material-ui/icons/BarChart';
import LayersIcon from '@material-ui/icons/Layers';
import AssignmentIcon from '@material-ui/icons/Assignment';
import Divider from '@material-ui/core/Divider';
import { Link } from 'react-router-dom';



function Sidebar() {
    return (
        <div className="sidebarRow">
        <Link to={'/report'}>
            <ListItem button>
            <ListItemIcon>
                <DashboardIcon />
            </ListItemIcon>
            <ListItemText primary="Report" />
            </ListItem>
        </Link>
        <Link to={'/issue'}>
            <ListItem button>
            <ListItemIcon>
                <PeopleIcon />
            </ListItemIcon>
            <ListItemText primary="Issue" />
            </ListItem>
        </Link>

        
    </div>
    )
}

export default Sidebar