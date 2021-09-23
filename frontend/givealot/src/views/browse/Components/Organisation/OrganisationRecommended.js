import {useState} from 'react';
import {useHistory} from 'react-router-dom';
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

export default function OrganisationRecommended(props)
{
    let history = useHistory();
    const [serverDomain, setServerDomain] = useState("http://0948-105-208-196-136.ngrok.io")


    const openOrganisation = el =>
    {
        el.preventDefault();
        history.push("/organisation/" + el.target.id);
    }

    let org_image = props.imgUrl;
    if(org_image === null)
    {
        org_image =  serverDomain + "/logo/version/" + props.orgId;
    }

    let description = trim_description(props.orgDescription);

    return(
        <Box className ="recommended">
            <Tooltip title={props.orgName}  aria-label="add">
                <img src={org_image} alt={"profile"} id={props.orgId} onClick={e => openOrganisation(e,"id")}/>
            </Tooltip>
            <Box className="recommended-meta-data-container">
                <p className="recommended-meta-data-title">{props.orgName} - <span className="recommended-meta-data-sector">{props.org_sector}</span> </p>
                <p className="recommended-meta-data-descr">
                    {description}
                </p>
                {/*<p className="sector_organisation_other">{props.dateAdded}</p>*/}
                <Tooltip title="certificate level"  aria-label="add">
                    <p className="recommended-meta-data-lvl">{props.certificate_level}</p>
                </Tooltip>
            </Box>
        </Box>
    );
}