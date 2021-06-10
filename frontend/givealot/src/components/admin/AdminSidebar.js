import React from 'react';
import "./AdminSidebar.css";
import SidebarRows from "./SidebarRows";
import ChatIcon from "@material-ui/icons/Chat";
import PeopleIcon from '@material-ui/icons/People';
import GroupIcon from '@material-ui/icons/Group';
import NotificationsActiveIcon from '@material-ui/icons/NotificationsActive';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";
  
import "./logo.png"


function AdminSidebar() {
    return (
        <div className="Adminsidebar">
            <div className="coLogo">
                <img 
                    src="./logo.png"
                    // src="https://miro.medium.com/max/1000/0*dNX0ywJjZi6iIRfQ.jpg"
                    alt=""
                />
            </div>
            <SidebarRows Icon={GroupIcon} title="Organisations"/>
            <SidebarRows Icon={GroupIcon} title="Users"/>
            <SidebarRows Icon={NotificationsActiveIcon} title="Notifications"/>
        </div>

    )
}

export default AdminSidebar
