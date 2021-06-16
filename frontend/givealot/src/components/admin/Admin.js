import React from 'react';
import './Admin.css';
import SidebarRows from './SidebarRows';
import Divider from '@material-ui/core/Divider';
import Header from './Header';
import Dashboard from './Dashboard';
import AdminOrgs from './AdminOrgs';
import AdminUsers from './AdminUsers';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import AdminCerts from "./AdminCerts";
import AdminReports from "./AdminReports";
import AdminDonations from "./AdminDonations";

function Admin() {
  return (
    <div className="admin">
      <div className="header">
        <Header />
        {/* <Divider /> */}
      </div>
      <div className="Adminbody">
        <div className="sidebar">
          <SidebarRows />
          <Divider />
        </div>
        <div className="dashbaord">
          <Switch>
            <Route path="/adminorgs" exact componet={AdminOrgs} />
            <Route path="/adminusers" exact componet={AdminUsers} />
            <Route path="/adminorgs" exact componet={AdminOrgs} />
            <Route path="/certificates" exact componet={AdminCerts} />
            <Route path="/adminreport" exact componet={AdminReports} />
            <Route path="/admindonations" exact componet={AdminDonations} />
            <Route path="/" component={Dashboard} />
          </Switch>
        </div>
      </div>
    </div>
  );
}

export default Admin;
