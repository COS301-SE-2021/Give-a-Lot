import React from 'react';
import "./SidebarRows.css";
import { Avatar } from '@material-ui/core';
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

function SidebarRows({src, Icon, title}) {
    return (
        <div className="sidebarRow">
            {/* if you pass a source, render a source, if oyu pass an icon render an icon */}
            {/* {src && <Avatar src={src} /> }
            {Icon && <Icon /> }
            <h4>{title}</h4> */}
            <ListItem button >
                <ListItemIcon>
                <DashboardIcon />
                </ListItemIcon>
                <ListItemText primary="Dashboard" />
            </ListItem>
            <ListItem button>
                <ListItemIcon>
                <PeopleIcon />
                </ListItemIcon>
                <ListItemText primary="Organisations" />
            </ListItem>
            <ListItem button>
                <ListItemIcon>
                <PeopleIcon />
                </ListItemIcon>
                <ListItemText primary="Users" />
            </ListItem>
            <ListItem button>
                <ListItemIcon>
                <BarChartIcon />
                </ListItemIcon>
                <ListItemText primary="Reports" />
            </ListItem>
        </div>
    )
}

export default SidebarRows
