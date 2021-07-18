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
                    <div style={{width: "100%",height: "70px"}}>
                        <img id="ID" src={logo} alt="" />
                    </div>
                </div>
                <div className="mainBody">
                    <div className="Adminsidebar">
                        <AdminSidebar />
                    </div>
                    <div className="Adminbody">
                        {/* <AdminDashboard /> */}
                    </div>
                   
                </div>
                <Switch>
                    <Route exact path="/adminUsers" component={AdminUsers} />
                    <Route exact path="/" component={AdminDashboard} />
                </Switch>

            </div>
        )
    }
}

export default Admin