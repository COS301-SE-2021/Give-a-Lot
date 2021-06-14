import React from 'react';
import SearchIcon from '@material-ui/icons/Search';
import "./AdminOrgs.css";

function AdminUsers() {
    return (
        <div className="Adminorg">
            <div className="header__input">
                <SearchIcon/>
                <input placeholder="search Organisation" type="text" />
            </div>
            <div className="table">
                
            </div>
        </div>
    )
}

export default AdminUsers
