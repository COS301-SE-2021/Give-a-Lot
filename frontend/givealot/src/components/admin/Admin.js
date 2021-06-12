import React from 'react';
import "./Admin.css";
import SidebarRows from "./SidebarRows"
import List from '@material-ui/core/List';
import Divider from '@material-ui/core/Divider';
import Header from "./Header";

function Admin() {
    return (
        <div className="admin">
            <div className="header">
                <List><Header/></List>
                <Divider />
            </div>
            <div className="Adminbody">
            <div className="sidebar">
                <List><SidebarRows/></List>
                <Divider />
            </div>
            <div className="body">
                here are other stuff
            </div>
            </div>
            
            
        </div>
           
    )
}

export default Admin
