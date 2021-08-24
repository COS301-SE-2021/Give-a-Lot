// import react from 'react';
//import reactDOM from 'react-dom';
import Sector from './browseSector/Sector';
import Navbar from './nav/Navbar';
import RecommendedOrg from "./recommended/Recommended";
import OganisationView from "./popups/OrganisationView"
import SearchController from "./search/searchController";
import {getOranisations} from './Api/OrganisationJSON';
import {getRecommendedOrganisations} from './Api/RecommendedJSON';


import React from "react"; /* function returning json object */




function browse()
{
    /* construct the browse page */

    let sectors = [];
    let json_res = getOranisations();

    for(var i = 0; i < json_res.length; i++)
    {
        sectors.push(<Sector key={i} sector={json_res[i].sector} organisations={json_res[i]}/>);
    }

    /*construct the recommended section of the browse page*/
    let recommended_orgs = [];
    json_res = getRecommendedOrganisations();

    for (let i = 0; i < json_res.length; i++)
    {
        let tmp_org_id = json_res[i].orgId;
        let tmp_name = json_res[i].name;
        let tmp_sector = json_res[i].sector;
        let tmp_org_img_url = json_res[i].imgUrl;
        let tmp_verified_img_url = "./images_tmp/checklist.png";
        let isVerified = json_res[i].isVerified;

        if(!isVerified)
        {
            /*
            * update this to a transparent icon
            * */
            tmp_verified_img_url = "./images_tmp/checklist.png";
        }
        recommended_orgs.push(<RecommendedOrg orgName={tmp_name} sector={tmp_sector} orgImgUrl={tmp_org_img_url} verifiedImg={tmp_verified_img_url} orgId={tmp_org_id}/>);
    }

    return (
            <div>
                <Navbar />
                <div className='recommended-container'>
                    <p className ="sector-Name">Recommended For you</p>
                    <div className = 'sector-container-list'>
                        {recommended_orgs}
                    </div>
                </div>

                {sectors}
                <OganisationView />

                <SearchController />

            </div>
         );
}

export default browse;