import React from 'react';
import "./AdminSidebar.css";
import SidebarRows from "./SidebarRows";
import GroupIcon from '@material-ui/icons/Group';
import NotificationsActiveIcon from '@material-ui/icons/NotificationsActive';
import "./logo.png";
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";
  import AdminBodyOrg from "./AdminBodyOrg";
  import AdminBodyUser from "./AdminBodyUser";


function AdminSidebar() {
    return (
        <Router>
            <div className="Adminsidebar">
            <div className="coLogo">
                <img 
                    src="./logo.png"
                    src="https://miro.medium.com/max/1000/0*dNX0ywJjZi6iIRfQ.jpg"
                    alt=""
                />
            </div>
            <Link to="/AdminBodyOrg"><SidebarRows Icon={GroupIcon} title="Organisations"/></Link>
            <Link to="/AdminBodyUser"><SidebarRows Icon={GroupIcon} title="Users"/></Link>
                <Switch>
                    <Route path="/AdminBodyOrg">
                        <AdminBodyOrg />
                    </Route>
                    <Route path="/AdminBodyUser">
                        <AdminBodyUser />
                    </Route>
                </Switch>
            </div>
        </Router>
        
    )
}

export default AdminSidebar
