import React from 'react';
import "./Admin.css";
import AdminSidebar from "./AdminSidebar";
import AdminBody from "./AdminBody";
import Cards from "./Cards";
import TotalOrgs from "./TotalOrgs";
import TotalUsers from "./TotalUsers";
import Graph from "./Graph";



function Admin() {
    return (
        <div className="admin">
            <div>
                <AdminSidebar />
            </div>
            <div className="dashboard">
                <Cards />
                <TotalOrgs />
                <TotalUsers />
            </div>
            <div>
                <AdminBody />
            </div>
            
            
        </div>
        
    )
}

export default Admin
