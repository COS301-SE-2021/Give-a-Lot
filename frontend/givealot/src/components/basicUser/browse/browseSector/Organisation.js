//import react from 'react';
import { popupOrganisation } from "../popups/OrganisationView";


function organisation(props) /*props entered from Sector*/ {
    console.log(window.location.origin + "/src/Components/browse/images_tmp/1.jpg");

    return (
        <div className='organisation-container' id={props.id} onClick={(e) => popupOrganisation(props.id)}>
            <div className='sector-orgImg'>
                <img src={props.orgProfileImg} alt="profile" />
            </div>
            <p className='sector-orgName'>{props.orgName}</p>
            <p className='sector-orgDateRegistration'>{props.orgRegistrationDate}</p>
        </div>
    );
}

export default organisation;