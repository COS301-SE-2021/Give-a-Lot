import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';


/* styles import */
import browseCSS_general from "./Styles/browse_general.css";
import browseCSS_tablet from "./Styles/browse_tablet.css";
import browseCSS_mobile_portrait from "./Styles/browse_mobile.css";
import browseCSS_desktop from "./Styles/browse_desktop.css";
/* styles import end */


/* assets import */
import logo from "../../assets/logo/logo3_1.png";
import searchIcon from '../../assets/search_black_24dp.svg';
import filterBtn_mobile from '../../assets/filter_list_black_24dp.svg';
import ui_message_art from '../../assets/feedback-2044700_1280.jpg';
/* assets import end */

/* components import */
import Organisation from './Components/Organisation/Organisation';
import OrganisationRecommended from './Components/Organisation/OrganisationRecommended';
import Sector from "./Components/BrowseBySector/Sector";
/* components import end */

function Browse ()
{
    const [organisations, setOrganisations] = useState([]);
    const [recommendedOrganisations, setRecommendedOrganisations] = useState([]);

    function searchOrganisation(e)
    {
        e.preventDefault();
        alert("searching for " + document.getElementById("browse_search_input").value);
    }

    const mobile_popUpControl_hide = event =>
    {
        event.preventDefault();
        var dark_backdrop_active_for_mobile = document.getElementById("dark_backdrop_active_for_mobile");
        var browse_filters = document.getElementById("browse_filters");

        dark_backdrop_active_for_mobile.style.display = "none";
        browse_filters.style.display = "none";
    }

    const mobile_popUpControl_display = event =>
    {
        event.preventDefault();
        var dark_backdrop_active_for_mobile = document.getElementById("dark_backdrop_active_for_mobile");
        var browse_filters = document.getElementById("browse_filters");

        dark_backdrop_active_for_mobile.style.display = "block";
        browse_filters.style.display = "block";
    }

    const onKeyUp = event =>
    {
        /* 
            code 13 represents the ENTER button
        */
        if (event.charCode === 13) {
            searchOrganisation(event);
        }
    };

    
    /* fetch request - organisations by sections - start*/

    /* 
        REMEMBER HOOKS: ELSE GOOD LUCK TRYING TO SOLVE THE 
                        INEVITABLE SHIT SHOW. 

        TODO: update login to use tokens on the request URL
    */
    useEffect(() => {
        fetch("http://localhost:8080/v1/browse/sectors")
        .then(async response =>{

            const data = await response.json();

            if(!response.ok) /* error handling here */
            {            
                if(response.status === 500)
                {
                    alert("bad parameters, fatal");
                }
                else if(response.status === 401)
                {
                    alert("this token is unauthorized"); /* take them back to login */
                }

                if(typeof data !== 'undefined')
                {
                    alert(data.message);
                }
            }

            if(data.message === "success") /*successfully fetched*/
            {
                setOrganisations(data.object);
            }
            else
            {
                alert("error occured: " + data.code);
                setOrganisations([]);
            }
        })
        
        .catch(error => {
            alert("failed - organisations - sector")
        });
    }
    ,[])
    /* fetch request - organisations by sections - end*/

    let organisations_by_sector = [];
    if(organisations !== undefined)
    {
        for (let i = 0; i < organisations.length; i++)
        {
            let sector = organisations[i].sector;
            let organisations_for_the_sector = [];

            for (let k = 0; k < organisations[i].organisations.length; k++)
            {
                let orgId = organisations[i].organisations[k].orgId;
                let orgName = organisations[i].organisations[k].orgName;
                let dateAdded = organisations[i].organisations[k].dateAdded;
                let imgUrl = organisations[i].organisations[k].imgUrl;
                let orgDescription = organisations[i].organisations[k].orgDescription;
                let certificate_level = organisations[i].organisations[k].certificate_level;

                organisations_for_the_sector.push(<Organisation orgId = {orgId}
                                                                orgName= {orgName}
                                                                dateAdded = {dateAdded}
                                                                imgUrl = {imgUrl}
                                                                certificate_level = {certificate_level}
                                                                orgDescription = {orgDescription}
                                                                key={orgId}/>);
            }
            /*
              Note for future reference: sector takes a list of organisations as prop
            */

            organisations_by_sector.push(<Sector sector={sector}
                                                 organisations_for_sec={organisations_for_the_sector}
                                                 key={sector}/>);
        }
    }


    /* fetch request - recommended - start*/

    /*
        REMEMBER HOOKS: ELSE GOOD LUCK TRYING TO SOLVE THE
                        INEVITABLE SHIT SHOW.

        TODO: update login to use tokens on the request URL
    */
    let user_id = "default"; /*TODO: pull this id from dom storage, if user is not logged in, use default*/

    useEffect(() => {
            fetch("http://localhost:8080/v1/browse/sectors/recommendations/"+user_id)
                .then(async response =>{

                    const data = await response.json();

                    if(!response.ok) /* error handling here */
                    {
                        if(response.status === 500)
                        {
                            alert("bad parameters, fatal");
                        }
                        else if(response.status === 401)
                        {
                            alert("this token is unauthorized"); /* take them back to login */
                        }

                        if(typeof data !== 'undefined')
                        {
                            alert(data.message);
                        }
                    }

                    if(data.message === "success") /*successfully fetched*/
                    {
                        setRecommendedOrganisations(data.object);
                    }
                    else
                    {
                        alert("error occured: " + data.code);
                        setRecommendedOrganisations([]);
                    }
                })

                .catch(error => {
                    alert("failed - organisations - sector")
                });
        }
        ,[])
    /* fetch request - recommended - end*/

    let organisations_recommended = [];
    if(recommendedOrganisations !== undefined)
    {
        for (let k = 0; k < recommendedOrganisations.length; k++)
        {
            let orgId = recommendedOrganisations[k].orgId;
            let orgName = recommendedOrganisations[k].orgName;
            let dateAdded = recommendedOrganisations[k].dateAdded;
            let imgUrl = recommendedOrganisations[k].imgUrl;
            let certificate_level = recommendedOrganisations[k].certificate_level;
            let org_sector = recommendedOrganisations[k].sector;
            let orgDescription = recommendedOrganisations[k].orgDescription;

            organisations_recommended.push(<OrganisationRecommended orgId = {orgId}
                                                                    orgName= {orgName}
                                                                    dateAdded = {dateAdded}
                                                                    imgUrl = {imgUrl}
                                                                    certificate_level = {certificate_level}
                                                                    org_sector = {org_sector}
                                                                    orgDescription = {orgDescription}
                                                                    key={orgId}/>);
            /*
              Note for future reference: sector takes a list of organisations as prop
            */

            /*organisations_by_sector.push(<Sector sector={sector}
                                                 organisations_for_sec={organisations_for_the_sector}
                                                 key={sector}/>);*/
        }
    }
    return (
        <div>
            <div id="browseNavSection">
                <Link to={"/"}><img id="browseLogo" src={logo} alt={"logo"} /></Link>
                <p>browse organisations</p>
            </div>

            <div id="browse_body">
                <div id="browse_search_container">
                    <input 
                        id="browse_search_input"
                        type="input" 
                        onKeyPress={onKeyUp}
                        placeholder="search organisation" 
                    />

                    <img
                        src={searchIcon} 
                        onClick={searchOrganisation}
                        alt={"search-icon"}
                    />
                </div>

                <div id="dark_backdrop_active_for_mobile" onClick={mobile_popUpControl_hide}>
                    {/*this is used on the mobile version of the application,
                       helps minimise the the filters */}
                </div>

                <div id="filters_mobile" onClick={mobile_popUpControl_display}>
                    <p >filters</p><img  src={filterBtn_mobile} alt={"filter-icon"} />
                </div>
                
                <section id="browse_body_main">
                    
                    {/*<div id="browse_filters">
                        <div id="browse_filters_container">
                    
                            <div className="browse_filter_sections">
                                <p>sector</p>
                                <input type="checkbox" id="level1"  value="1"/>
                                <label htmlFor="level1">children</label><br/>

                                <input type="checkbox" id="level2" value="2"/>
                                <label htmlFor="level2">youth</label><br/>

                                <input type="checkbox" id="level3" value="3"/>
                                <label htmlFor="level3">security</label><br/>

                                <input type="checkbox" id="level4" value="4"/>
                                <label htmlFor="level4">food drive</label><br/>

                                <input type="checkbox" id="level5" value="5"/>
                                <label htmlFor="level5">technology</label><br/>
                            </div>

                            <div className="browse_filter_sections">
                                <p>level</p>

                                <input type="checkbox" id="level1" value="1"/>
                                <label htmlFor="level1"> Level 1</label><br/>

                                <input type="checkbox" id="level2" value="2"/>
                                <label htmlFor="level2"> Level 2</label><br/>

                                <input type="checkbox" id="level3" value="3"/>
                                <label htmlFor="level3"> Level 3</label><br/>

                                <input type="checkbox" id="level4" value="4"/>
                                <label htmlFor="level4"> Level 4</label><br/>

                                <input type="checkbox" id="level5" value="5"/>
                                <label htmlFor="level5"> Level 5</label><br/>
                            </div>
                        </div>
                    </div>*/}

                    <div id="browse_organisations">
                        <div id="recommended_organisations">
                            <div className="recommended_section">
                                <p className="browse_sector_name">Recommended for you</p>
                                <div className="recommended_organisations_container">
                                    {organisations_recommended}
                                </div>
                            </div>
                        </div>

                        {/* this block was not a part of the initial design */}
                        <div id="ui_element_message">
                            <img src={ui_message_art} alt={""}/>
                            <div id="ui_element_message_text">
                                <p id="ui_element_message_head">Find a cause that you care about</p>
                                <p id="ui_element_message_subtext">The following organisations have been individually reviewed by givealot<img /></p>
                            </div>
                        </div>
                        {/* this block was not a part of the initial design - end */}

                        <div id="default_organisations">
                            {organisations_by_sector}
                        </div>

                        {/* this block was not a part of the initial design */}
                        <div id="ui_element_message">
                            <img src={ui_message_art} alt={""}/>
                            <div id="ui_element_message_text">
                                <p id="ui_element_message_head">Find a cause that you care about</p>
                                <p id="ui_element_message_subtext">The following organisations have been individually reviewed by givealot<img /></p>
                            </div>
                        </div>
                        {/* this block was not a part of the initial design - end */}
                    </div>
                </section>
               

            </div>
        </div>
    )
}

export default Browse;