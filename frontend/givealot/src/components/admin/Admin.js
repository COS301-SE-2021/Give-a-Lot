import React, { Component } from 'react'
import logo from "./imagesRegister/ID2.png"
import AdminSidebar from "./AdminSidebar"

export class Admin extends Component {

    render() {
        return (
            <div className="admin">
                <div className="header">
                    <div style={{width: "220px",height: "70px"}}>
                        <img id="ID" src={logo} alt=""/>
                    </div>

                </div>
                <div className="mainBody">
                    <AdminSidebar />
                    {/*here is other stuff*/}
                </div>
            </div>
        )
    }
}

export default Admin