import React from 'react';
import "./Admin.css";
import SidebarRows from "./SidebarRows"
import List from '@material-ui/core/List';
import Divider from '@material-ui/core/Divider';
import Header from "./Header";
import Dashboard from "./Dashboard";
import AdminOrgs from "./AdminOrgs";
import AdminUsers from "./AdminUsers";
import {BrowserRouter as Router,Switch,Route} from "react-router-dom";

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
                    <div className="dashbaord">
                        <Dashboard />
                    </div>
                    <Switch>
                        <Route path="/" exact component={Dashboard} />
                        <Route path="/adminorgs" exact componet={AdminOrgs} />
                        <Route path="/adminusers" exact componet={AdminUsers} />
                        <Route path="/adminorgs" exact componet={AdminOrgs} />
                    </Switch>
                </div>
            </div>
           
      
       
    )
}

export default Admin
