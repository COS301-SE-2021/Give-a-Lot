import React from 'react';
import "./Organisation.css";
import Sidebar from "./Sidebar";
import Header from "./Header";
import OrganisationReport from './OrganisationReport';

function Organisation() {
    return (
        <div className="organisation">
            <Header />
            <Sidebar />
            <OrganisationReport />
        </div>
    )
}

export default Organisation
