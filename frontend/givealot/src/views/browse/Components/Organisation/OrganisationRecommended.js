import react from 'react';


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
    let org_image = props.imgUrl;
    if(org_image === null)
    {
        org_image =  "https://avatars.dicebear.com/api/initials/" + props.orgName + ".svg?w=500" ;
    }

    let description = trim_description(props.orgDescription);

    return(
        <div className ="sector_organisation">
        <img src={org_image} alt={"profile-image"}/>
            <div className="sector_organisation_meta">
                <p className="sector_organisation_title">{props.orgName} - <span className="recommended_organisations_organisation_sector">{props.org_sector}</span> </p>
                <p className="sector_organisation_descr">
                    {description}
                </p>
                <p className="sector_organisation_other">{props.dateAdded}</p>
                <p className="sector_organisation_other sector_organisation_level">level {props.certificate_level}</p>
            </div>
    </div>
    );
}