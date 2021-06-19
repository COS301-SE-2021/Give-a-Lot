import React from 'react';
import "./Organisation.css";
import Sidebar from "./Sidebar";
import HeaderOrg from "./HeaderOrg";
import OrganisationReport from './OrganisationReport';
import Issue from './Issue';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

function Organisation() {
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

export default Organisation
