import React from 'react';
import logo from "../../../assets/logo/givealot-logo-red..png";
import {Link} from "react-router-dom";
import "../Styles/Login.css"

function DashLogo()
{
    return(
        <div className="headers">
            <Link to={"/"}>
                <img id="logo" src={logo} alt={"logo"} style={{height: "70px", width: "130px"}}/>
            </Link>
        </div>
    );
}

export default DashLogo;