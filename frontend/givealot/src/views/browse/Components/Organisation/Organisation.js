import react from 'react';

export default function Organisation(props)
{
    let org_image = props.imgUrl;
    if(org_image === null)
    {
        org_image =  "https://avatars.dicebear.com/api/initials/" + props.orgName + ".svg?w=500" ;
    }
    return(
    <div className ="sector_organisation">
        <img src={org_image}/>
        <div className="sector_organisation_meta">
            <p className="sector_organisation_title">{props.orgName}</p>
            <p className="sector_organisation_descr">
                this is the shortened description of the organisation
                it should cont......
            </p>
            <p className="sector_organisation_other">{props.dateAdded}</p>
            <p className="sector_organisation_other sector_organisation_level">level {props.certificate_level}</p>
        </div>
    </div>
    );
}