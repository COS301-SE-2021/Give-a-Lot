import react from 'react';
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
/* assets import end */

/* components import */
import Organisation from './Components/Organisation/Organisation';
import OrganisationRecommended from './Components/Organisation/OrganisationRecommended';
/* components import end */

function Browse ()
{
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

    return (
        <div>
            <div id="browseNavSection">
                <Link to={"/"}><img id="browseLogo" src={logo} /></Link>
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
                    />
                </div>

            
                <div id="dark_backdrop_active_for_mobile" onClick={mobile_popUpControl_hide}></div>


                <div id="filters_mobile" onClick={mobile_popUpControl_display}>
                    <p >filters</p><img  src={filterBtn_mobile} />
                </div>
                
                <section id="browse_body_main">
                    
                    <div id="browse_filters">
                        <div id="browse_filters_container">
                    
                            <div className="browse_filter_sections">
                                <p>sector</p>
                                <input type="checkbox" id="sec_id1"  value="1"/>
                                <label for="level1">children</label><br/>

                                <input type="checkbox" id="sec_id2" value="2"/>
                                <label for="level2">youth</label><br/>

                                <input type="checkbox" id="sec_id3" value="3"/>
                                <label for="level3">security</label><br/>

                                <input type="checkbox" id="sec_id4" value="4"/>
                                <label for="level4">food drive</label><br/>

                                <input type="checkbox" id="sec_id5" value="5"/>
                                <label for="level5">technology</label><br/>
                            </div>

                            <div className="browse_filter_sections">
                                <p>level</p>

                                <input type="checkbox" id="level1" value="1"/>
                                <label for="level1"> Level 1</label><br/>

                                <input type="checkbox" id="level2" value="2"/>
                                <label for="level2"> Level 2</label><br/>

                                <input type="checkbox" id="level3" value="3"/>
                                <label for="level3"> Level 3</label><br/>

                                <input type="checkbox" id="level4" value="4"/>
                                <label for="level4"> Level 4</label><br/>

                                <input type="checkbox" id="level5" value="5"/>
                                <label for="level5"> Level 5</label><br/>
                            </div>
                        </div>
                    </div>

                    {/* fetch request here */}

                    {/* 
                        REMEMBER HOOKS: ELSE GOOD LUCK TRYING TO SOLVE THE 
                                        INEVITABLE SHIT SHOW. 
                    */}

                    <div id="browse_organisations">
                        <div id="recommended_organisations">
                            <div className="recommended_section">
                                <p className="browse_sector_name">Recommended for you</p>
                                <div className="recommended_organisations_container">
                                    <OrganisationRecommended />
                                    <OrganisationRecommended />
                                    <OrganisationRecommended />
                                     
                                </div>
                            </div>
                        </div>


                        <div id="default_organisations">
                            <div className="browse_sector">
                                <p className="browse_sector_name">sector name</p>
                                <div className="browse_sector_organisations_container">
                                    <Organisation />
                                    <Organisation />
                                    <Organisation />
                                    <Organisation />
                                </div>
                            </div> 

                            <div className="browse_sector">
                                <p className="browse_sector_name">sector name</p>
                                <div className="browse_sector_organisations_container">
                                    <Organisation />
                                    <Organisation />           
                                </div>
                            </div> 

                            <div className="browse_sector">
                                <p className="browse_sector_name">sector name</p>
                                <div className="browse_sector_organisations_container">
                                    <Organisation />
                                    <Organisation />
                                    <Organisation />
                                    <Organisation />
                                </div>
                            </div> 


                            <div className="browse_sector">
                                <p className="browse_sector_name">sector name</p>
                                <div className="browse_sector_organisations_container">
                                    <Organisation />
                                    <Organisation />           
                                    <Organisation />
                                </div>
                            </div> 
                        </div>
                    </div>
                </section>
               

            </div>
        </div>
    )
}

export default Browse;