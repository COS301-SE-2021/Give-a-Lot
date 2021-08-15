//import react from 'react';

import Organisation from './Organisation';

function sector(props) 
{
    console.log(props.organisations.organisations);

    let organisations_tmp = [];

    /*
    * get all organisations with from a sector (follows the response object)
    * */
    for (let index = 0; index < props.organisations.organisations.length; index++)
    {
        let orgId = props.organisations.organisations[index].orgId;
        let org_Name = props.organisations.organisations[index].name;
        let orgRegistrationDate = props.organisations.organisations[index].dateAdded;
        let orgImgUrl = props.organisations.organisations[index].imgUrl;

        /*
        * save all these organisations in an array
        * */
        console.log(orgId);
        organisations_tmp.push(<Organisation key={orgId} orgName={org_Name} id={orgId} orgRegistrationDate={orgRegistrationDate} orgProfileImg={orgImgUrl}/>);
    }

    return(
        <div className = 'sector-container'>
            <p className ="sector-Name">{props.sector}</p>
            <div className = 'sector-container-list'>
                {/*display all these organisations*/}
                {organisations_tmp}
            </div>
        </div>
    );
}

export default sector;