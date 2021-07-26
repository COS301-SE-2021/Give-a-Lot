import React, { Component } from 'react'
// import logo from "./imagesRegister/ID2.png"
import AdminSidebar from "./AdminSidebar"
import AdminDashboard from "./AdminDashboard";
import "./Admin.css"
import {Switch,Route} from "react-router-dom";
import AdminUsers from "./adminUsers/AdminUsers"
import Calender from "./calender/Calender";
import LogOut from "./LogOut";
import AdminOrganisations from './adminOrganisations/AdminOrganisations';
import Emails from "./emails/Emails" 

export class Admin extends Component {

    render() {
        return (
            <div>
                
                <div className="AdminBody">
                    <div>
                        <AdminSidebar />
                    </div>
                    <div className="dash">
                        <Switch>
                            <Route exact path="/adminUsers" component={AdminUsers} />
                            <Route exact path="/calendar" component={Calender} />
                            <Route exact path="/" component={AdminDashboard} />
                            <Route exact path="/logout" component={LogOut} />
                            <Route exact path="/adminOrganisaions" component={AdminOrganisations} />
                            <Route exact path="/emails" component={Emails} />
                        </Switch>
                        
                    </div>

                </div>

            </div>
        )
    }
}

export default Admin
