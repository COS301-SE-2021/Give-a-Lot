import React from 'react';
import "./Organisation.css";
import Sidebar from "./Sidebar";
import HeaderOrg from "./HeaderOrg";
import OrganisationReport from './OrganisationReport';

function Organisation() {
    return (
        <div className="organisation">
            <HeaderOrg />
            <Sidebar />
            <OrganisationReport />
        </div>
    )
}

export default Organisation
