import React from 'react';
import "./AdminBody.css";
import AdminBodyOrg from "./AdminBodyOrg";
import AdminBodyUser from "./AdminBodyUser";
import Cards from "./Cards";
import TotalOrgs from "./TotalOrgs";
import TotalUsers from "./TotalUsers";

function AdminBody({AdminBodyOrg, AdminBodyUser}) {
    return (
        <div className="Adminbody">
            <div className="AdminbodyOrg">
                
                {AdminBodyOrg && < AdminBodyOrg/>}
                {AdminBodyUser && < AdminBodyUser/>}
            </div>
        </div>
    )
}

export default AdminBody
