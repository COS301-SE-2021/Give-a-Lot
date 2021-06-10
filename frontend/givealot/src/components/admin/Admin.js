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
        <div>
             <div className="admin">
                <div>
                    <AdminSidebar />
                </div>
                <div className="dashboard">
                    <Cards style={{padding:"0 30px"}}/>
                    <TotalOrgs style={{padding:"0 30px"}}/>
                    <TotalUsers style={{padding:"0 30px"}}/>
                </div>
                
            </div> 
            {/* <div>
                <AdminBody />
            </div> */}
        </div>
           
    )
}

export default Admin
