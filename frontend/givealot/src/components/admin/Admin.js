import React, { Component } from 'react'
import logo from "./imagesRegister/ID2.png"
import AdminSidebar from "./AdminSidebar"
import AdminDashboard from "./AdminDashboard";
import "./Admin.css"

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
                        <AdminDashboard />
                    </div>
                   
                </div>
            </div>
        )
    }
}

export default Admin