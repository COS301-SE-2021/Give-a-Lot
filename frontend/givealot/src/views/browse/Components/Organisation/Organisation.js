import react from 'react';
import {useHistory} from "react-router-dom";
import {Box, Tooltip} from "@material-ui/core";


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
    <Box className ="sector_organisation">
        <Tooltip title={props.orgName}  aria-label="add">
            <img src={org_image} alt={"profile-image"} id={props.orgId} onClick={e => openOrganisation(e,"id")}/>
        </Tooltip>
        <Box className="sector_organisation_meta">
            <p className="sector_organisation_title">{props.orgName}</p>
            <p className="sector_organisation_descr">
                {description}
            </p>
            {/*<p className="sector_organisation_other">{props.dateAdded}</p>*/}
            <Tooltip title="certificate level"  aria-label="add">
                <p className="recommended-meta-data-lvl">5 {props.certificate_level}</p>
            </Tooltip>
        </Box>
    </Box>
    );
}