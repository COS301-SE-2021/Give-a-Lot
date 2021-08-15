import React from "react";
import { popupOrganisation } from "../popups/OrganisationView";
import { assignNewValue } from "../popups/OrganisationView";

/* 
    reuses the popupOrganisation method to show an organisation.
*/
function preview_organisation_open(orgId) {

    assignNewValue(true);
    document.getElementsByClassName('search-container')[0].setAttribute('style', 'display:none');
    popupOrganisation(orgId);
}


function searchResults(props) {
    return (
        <div className="organisation">
            <img src={props.organisationImg} alt="org-display-img" />
            <div className="metadata">
                <p className="organisation-orgName">{props.organisationName}</p>
                <p className="organisation-orgSlogan">{props.organisationSlogan}</p>
                <p className="organisation-orgShortDescription">
                    {props.organisationDescr}
                </p>
            </div>

            <div className="organisation-sector-preview-btn-container">
                <p>{props.organisationSector}</p>
                <button id={props.organisationId} onClick={(e) => preview_organisation_open(props.organisationId)}>preview</button>
            </div>
            <hr />
        </div>
    );
}

export default searchResults;