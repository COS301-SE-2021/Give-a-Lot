import React from 'react';

function RecommendedOrg(props)
{
     return (
        <div className = 'recommended-organisation'>
            <div className = 'sector-orgImg'>
                <img src = {props.orgImgUrl} alt="img"/>
            </div>
            <p className = 'sector-orgName'>{props.orgName}</p>
            <div className='meta-data-container'>
                <p className = 'sector-recommended'>
                    {props.sector}
                </p>
                <img src={props.verifiedImg} alt={'verified'}/>
            </div>
        </div>
    );
}

export default RecommendedOrg;


