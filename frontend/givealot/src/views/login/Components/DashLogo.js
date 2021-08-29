import React from 'react';
import logo from "../../../assets/logo/givealot-logo-red..png";
import {Link} from "react-router-dom";
import "../Styles/Login.css"

function DashLogo()
{
    return(
        <div style={{width: "200px", marginLeft: "15px"}} className="headers">
            <Link to={"/"}>
                <img id="logo" src={logo} />
            </Link>
        </div>
    );
}

export default DashLogo;