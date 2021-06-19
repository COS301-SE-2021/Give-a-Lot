import React from 'react';
import "./Organisation.css";
import Sidebar from "./Sidebar";
import HeaderOrg from "./HeaderOrg";
import OrganisationReport from './OrganisationReport';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

function Organisation() {
    return (
        <div className="organisation">
            <HeaderOrg />
            <Sidebar />
            {/* <OrganisationReport /> */}

            <div className="dashbaord">
                <Switch>
                <Route path="/orgReport" exact component={OrganisationReport} />
                <Route path="/" component={Organisation} />
                </Switch>
            </div>
        </div>
        
    )
}



export default Organisation
