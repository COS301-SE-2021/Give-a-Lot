import {Link} from "react-router-dom";
import logo from "../../../../assets/logo/logo3_1.png";
import React from "react";
import {TextField} from "@material-ui/core";
import SearchIcon from "@material-ui/icons/Search";

{/*<div id="browse_search_container">


                    <img
                        src={searchIcon}
                        onClick={searchOrganisation}
                        alt={"search-icon"}
                    />
                </div>*/}
function Navbar()
{
    function searchOrganisation(e)
    {
        e.preventDefault();
        alert("searching for " + document.getElementById("browse_search_input").value);
    }

    const onKeyUp = event =>
    {
        /*
            code 13 represents the ENTER button
        */
        if (event.charCode === 13) {
            searchOrganisation(event);
        }
    }
    return (
        <div id="browseNavSection">
            <Link to={"/"}><img id="browseLogo" src={logo} alt={"logo"} /></Link>
            <p>browse organisations</p>
            <div className="header__input browseNavSection_searchContainer">
                <input
                    id={"browse_search_input"}
                    placeholder="search organisation"
                    type="text"
                    onKeyPress={onKeyUp}
                />
                <SearchIcon
                    onClick={searchOrganisation}
                />
            </div>
        </div>
    )
}

export default Navbar;