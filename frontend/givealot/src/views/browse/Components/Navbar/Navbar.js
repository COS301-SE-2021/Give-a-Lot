import {Link} from "react-router-dom";
import logo from "../../../../assets/logo/logo3_1.png";
import React, {useEffect, useState} from "react";
import SearchIcon from "@material-ui/icons/Search";
import SearchResults from "../SearchResults/SearchResults";





function Navbar()
{
    const [searchResultsOrganisations, setSearchResultsOrganisations] = useState([]);
    const [showSearchResults, SetShowSearchResults] = useState(false);
    const [searchResultsOrganisationsRelated, setSearchResultsOrganisationsRelated] = useState([]);


    function searchOrganisation(e)
    {
        e.preventDefault();
        fetch("http://localhost:8080/search/organisation/browse/"+document.getElementById("browse_search_input").value)
        .then(async response =>{
            const data = await response.json();

            if(!response.ok) /* error handling here */
            {
                if(response.status === 500)
                {}

                if(typeof data !== 'undefined')
                {
                    alert(data.message);
                }
            }

            if(data.message === "success") /*successfully fetched*/
            {
                setSearchResultsOrganisations(data.results);
                setSearchResultsOrganisationsRelated(data.suggestions);

                SetShowSearchResults(true);
                document.getElementById("searchResults").hidden = false;
            }
            else
            {
                alert("error occured: " + data.code);
            }
        })
        .catch(error => {
            alert("failed search " + error)
        });
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

   useEffect(() =>{

    },[]);
    return (
        <div id="browseNavSection">

            {showSearchResults && <SearchResults org_list={searchResultsOrganisations}
                            org_suggestions={searchResultsOrganisationsRelated}/>}

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
