import React, { Component } from 'react'
import logo from "./imagesRegister/ID2.png"
import AdminSidebar from "./AdminSidebar"
import AdminDashboard from "./AdminDashboard";
import "./Admin.css"
import {Switch,Route} from "react-router-dom";
import AdminUsers from "./adminUsers/AdminUsers"
import Calender from "./calender/Calender";
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import LogOut from "./LogOut";
import AdminOrganisations from './adminOrganisations/AdminOrganisations';

export class Admin extends Component {

    render() {
        return (
            <React.Fragment>
                <Grid item xs={2}>
                    <Paper className="HeaderA">
                        <img src={logo} alt="" className="imageAdmin"/>
                    </Paper>
                </Grid>
                <Grid className="AdminBody">
                    <Grid item >
                        <Paper className="sidabar">
                            <AdminSidebar />
                        </Paper>
                    </Grid>
                    <Grid item  >
                        <Paper className="dash">
                            <Switch>
                                <Route exact path="/adminUsers" component={AdminUsers} />
                                <Route exact path="/calendar" component={Calender} />
                                <Route exact path="/" component={AdminDashboard} />
                                <Route exact path="/logout" component={LogOut} />
                                <Route exact path="/adminOrganisaions" component={AdminOrganisations} />
                            </Switch>
                        </Paper>
                    </Grid>
                </Grid>
                
            </React.Fragment>
        )
    }
}

export default Admin
