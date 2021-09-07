import react from 'react';
import {useHistory} from "react-router-dom";


function trim_description(descr)
{

    let acceptableLength = 84;
    if(descr !== undefined) {

        if(descr.length > acceptableLength)
        {
            let display_dscr = "";
            for(let i = 0; i < acceptableLength - 3; i++)
            {
                display_dscr += descr[i];
            }
            return (display_dscr + "...");
        }
        else return descr;
    }
}

export default function Organisation(props)
{
    let history = useHistory();

    const openOrganisation = el =>
    {
        el.preventDefault();
        history.push("/organisation/" + el.target.id);
    }

    let org_image = props.imgUrl;
    if(org_image === null)
    {
        org_image =  "http://localhost:8080/logo/version/" + props.orgId ;
    }

    let description = trim_description(props.orgDescription);

    return(
    <div className ="sector_organisation">
        <img src={org_image} alt={"profile-image"} id={props.orgId} onClick={e => openOrganisation(e,"id")}/>
        <div className="sector_organisation_meta">
            <p className="sector_organisation_title">{props.orgName}</p>
            <p className="sector_organisation_descr">
                {description}
            </p>
            <p className="sector_organisation_other">{props.dateAdded}</p>
            <p className="sector_organisation_other sector_organisation_level">level {props.certificate_level}</p>
        </div>
    </div>
    );
}