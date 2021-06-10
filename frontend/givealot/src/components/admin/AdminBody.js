import React from 'react';
import "./AdminBody.css";
import AdminBodyOrg from "./AdminBodyOrg";
import AdminBodyUser from "./AdminBodyUser";

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
