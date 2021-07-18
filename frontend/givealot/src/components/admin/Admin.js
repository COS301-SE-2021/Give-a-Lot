import React, { Component } from 'react'
import logo from "./imagesRegister/ID2.png"
import AdminSidebar from "./AdminSidebar"
import AdminDashboard from "./AdminDashboard";
import "./Admin.css"
import {Switch,Route} from "react-router-dom";
import AdminUsers from "./adminUsers/AdminUsers"

export class Admin extends Component {

    render() {
        return (
            <div className="admin">
                <div className="Adminheader">
                    <div >
                        <img src={logo} alt="" className="image"/>
                    </div>
                </div>
                <div className="mainBody">
                    <AdminSidebar />
                    <AdminDashboard />
                </div>
                <Switch>
                    <Route exact path="/adminUsers" component={AdminUsers} />
                    <Route exact path="/dashboard" component={AdminDashboard} />
                </Switch>

            </div>
        )
    }
}

export default Admin