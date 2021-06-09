import React from 'react';
import "./AdminBody.css";
import AdminBodyOrg from "./AdminBodyOrg";
import AdminBodyUser from "./AdminBodyUser";

function AdminBody() {
    return (
        <div className="Adminbody">
            <div className="AdminbodyOrg">
                {/* <AdminBodyOrg /> */}
                <AdminBodyUser />
            </div>
            {/* <div className="AdminbodyUser">
            
            </div> */}
        </div>
    )
}

export default AdminBody
