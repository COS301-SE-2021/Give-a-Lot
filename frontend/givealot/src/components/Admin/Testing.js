import React from 'react';
import './Admin.css';
import SidebarRows from './SidebarRows';
import Divider from '@material-ui/core/Divider';
import Header from './Header';
import Dashboard from './Dashboard';
import AdminOrgs from './AdminOrgs';
import AdminUsers from './AdminUsers';
import AdminCerts from "./AdminCerts";
import AdminReports from "./AdminReports";
import AdminDonations from "./AdminDonations"
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Manage from './Manage';
import AddOrg from './AddOrg';
import OrganisationReport from '../organisation/OrganisationReport';
import Sidebar from "../../components/organisation/Sidebar"
function Admin() {
  return (
    <div className="admin">
      <div className="header">
        <Header />
        <Divider />
      </div>
      <div className="Adminbody">
        <div className="sidebar">
          <Sidebar />
          <Divider />
        </div>
        <div className="dashbaord">
          <Switch>
            <Route path="/report" exact component={OrganisationReport} />
            <Route path="/adminusers" exact component={AdminUsers} />
            <Route path="/" component={Dashboard} />
          </Switch>
        </div>
      </div>
    </div>
  );
}
// AddOrgModal

export default Admin;
