import {Link} from "react-router-dom";
import logo from "../../../../assets/logo/logo3_1.png";
import React from "react";

function Navbar()
{
    return (
        <div id="browseNavSection">
            <Link to={"/"}><img id="browseLogo" src={logo} alt={"logo"} /></Link>
            <p>browse organisations</p>
        </div>
    )
}

export default Navbar;