import React from 'react';
import "./Admin.css";
import AdminSidebar from "./AdminSidebar";
import AdminBody from "./AdminBody";

function Admin() {
    return (
        <div className="admin">
            <div>
                <AdminSidebar />
            </div>
            <div>
                <AdminBody />
            </div>
        </div>
    )
}

export default Admin
