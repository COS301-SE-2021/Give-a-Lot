import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import HeaderOrg from "./HeaderOrg";
import OrganisationReport from './OrganisationReport';
import Sidebar from "./Sidebar";
import Issue from './Issue';
function Admin() {
  return (
    <div className="admin">
      <div className="header">
        <HeaderOrg />
        {/* <Divider /> */}
      </div>
      <div className="Adminbody">
        <div className="sidebar">
          <Sidebar />
          {/* <Divider /> */}
        </div>
        <div className="dashbaord">
          <Switch>
            <Route path="/report" exact component={OrganisationReport} />
            <Route path="/issue" exact component={Issue} />
            {/* <Route path="/" component={Dashboard} /> */}
          </Switch>
        </div>
      </div>
    </div>
  );
}
// AddOrgModal

export default Admin;
