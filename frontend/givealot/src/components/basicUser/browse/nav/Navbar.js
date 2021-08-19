import logo from "../../../login/images/logo.png";
import { FaSearch } from "react-icons/fa";
import React from "react";


function showSearchInterface() {
    document.getElementsByClassName('search-container')[0].setAttribute("style", "display:block");
    document.getElementById('search-close-sensor').setAttribute("style", "display:block");
}


function navbar() {
    return (

        <div className="browse-navbar">
            <div className="browse-navbar-icons">
                <img src={logo} alt="" />
                <FaSearch size="1.9em" color="#767676" className="menu1" onClick={showSearchInterface} />
            </div>
            <p className="browse-section-label">Browse</p>
        </div>
    );
}

export default navbar;