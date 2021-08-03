import React, { useState } from "react";
import SearchResults from "./searchResults";

let searchResults = [];
let query_string = "";
/*
 sends a request to the server and get the results
* */


function getResults() {

    query_string = document.getElementById("organisation_search_input").value;
    searchResults = [];
    /*iterate through results*/

    let t1 = new Date();

    /* 
        remember to change to > 0 when api 
        call code is done, for now this 
        should always show the results
    */
    if (searchResults.length === 0) {
        document.getElementById('search-num-results').setAttribute("style", "display:block");
        document.getElementsByClassName('search-results')[0].setAttribute("style", "display:block");
    }


    let t2 = new Date();
    let dif = t1.getTime() - t2.getTime();

    document.getElementById('search-num-results').innerText = 8 + " results in (" + dif + " seconds)";

    for (let i = 0; i < 8; i++) {
        let orgId = i;
        let orgImg = "";
        let orgName = "the name of the organisation will be here";
        let orgSlogan = "the org slogan here";
        let orgSector = "Engineering";
        let orgDescription = "Amet Lorem do laboris ullamco ut et dolore pariatur aliquip Lorem aliqua eu nisi. Proident do ex eu mollit enim nostrud ullamco elit aute officia qui est. Dolore  velit dolore amet pariatur id id do elit incididunt nisi excepteur ullamco dolor Lorem adipisicing elit adipisicing aliquip consectetur.";
        searchResults.push(<SearchResults organisationId={orgId}
            organisationImg={orgImg}
            organisationName={orgName}
            organisationSector={orgSector}
            organisationSlogan={orgSlogan}
            organisationDescr={orgDescription} />);
    }
}


function hideSearchInterface() {

    document.getElementsByClassName('search-container')[0].setAttribute("style", "display:none");
    document.getElementById('search-close-sensor').setAttribute("style", "display:none");
}

function SearchContainer() {
    const [value, setValue] = useState();

    const refresh = () => {
        getResults();
        setValue({});
    }

    const refreshComponentIfInputAreaIsClear = () => {

        if (document.getElementById('organisation_search_input').value.length === 0) {
            document.getElementsByClassName('search-results')[0].setAttribute("style", "display:none");
            document.getElementById('search-num-results').setAttribute("style", "display:none");
        }

    }

    return (
        <div className="search-container">
            <div id="search-close-sensor" onClick={hideSearchInterface}></div>
            <div className="search-input-icon-container">
                <input type="search" placeholder="searchHere" id="organisation_search_input" onInput={refreshComponentIfInputAreaIsClear} />
                <img src="./images_tmp/search-icon.png" alt="search-icon" onClick={refresh} />
            </div>

            <p id="search-num-results"></p>
            <div className="search-results">
                {searchResults}
            </div>
        </div>
    );
}

export default SearchContainer;