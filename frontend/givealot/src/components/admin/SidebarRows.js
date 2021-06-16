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
import AdminOrgs from "./AdminOrgs";
import AdminUsers from "./AdminUsers";
import {Link} from "react-router-dom";
import {BrowserRouter as Router,Switch,Route} from "react-router-dom";

function SidebarRows({src, Icon, title}) {
    return (
        <Router>
                    <div className="sidebarRow">
            <Link to={"dashboard"}>
                <ListItem button >
                    <ListItemIcon>
                    <DashboardIcon />
                    </ListItemIcon>
                    <ListItemText primary="Dashboard" />
                </ListItem>
            </Link>
            <Link to={"adminorgs"}>
                <ListItem button>
                    <ListItemIcon>
                    <PeopleIcon />
                    </ListItemIcon>
                    <ListItemText primary="Organisations" />
                </ListItem>
            </Link>

            <Link to={"adminusers"}>
                <ListItem button>
                    <ListItemIcon>
                    <PeopleIcon />
                    </ListItemIcon>
                    <ListItemText primary="Users" />
                </ListItem>
            </Link>

            <Link to={"reports"}>
                <ListItem button>
                    <ListItemIcon>
                    <BarChartIcon />
                    </ListItemIcon>
                    <ListItemText primary="Reports" />
                </ListItem>
            </Link>

            <Link to={"donations"}>
                <ListItem button>
                    <ListItemIcon>
                    <BarChartIcon />
                    </ListItemIcon>
                    <ListItemText primary="Donations" />
                </ListItem>
            </Link>

            <Link to={"certificates"}>
                <ListItem button>
                    <ListItemIcon>
                    <AssignmentIcon />
                    </ListItemIcon>
                    <ListItemText primary="Certificates" />
                </ListItem>
            </Link>

            <Switch>
                <Route path="/" exact component={Dashboard} />
                <Route path="/adminorgs" exact componet={AdminOrgs} />
                <Route path="/adminusers" exact componet={AdminUsers} />
                <Route path="/adminorgs" exact componet={AdminOrgs} />
            </Switch>  
            
        </div>
        </Router>

    )
}

export default SidebarRows
