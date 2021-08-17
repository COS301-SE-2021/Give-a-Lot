import React, { Component } from 'react'
import "./featuredInfoOrg.css"
import PeopleIcon from '@material-ui/icons/People';

export class FeaturedInfoOrg extends Component {
    render() {
        return (
            <div className="featuredOrg">
                <div className="featuredItemOrg">
                   <span className="featuredTitleOrg"> Users</span>
                   <div className="featuredMoneyContainerOrg">
                       <span className="featuredMoneyOrg">1234</span>
                       <span className="featuredMoneyRateOrg">
                           <PeopleIcon className="featuredIconOrg"/>
                       </span>
                    </div> 
                    {/* <span className="featureSub">
                        compared to
                    </span> */}
                </div>

                <div className="featuredItemOrg">
                   <span className="featuredTitleOrg"> Organisations</span>
                   <div className="featuredMoneyContainerOrg">
                       <span className="featuredMoneyOrg">1234</span>
                       <span className="featuredMoneyRateOrg">
                           <PeopleIcon className="featuredIconOrg"/>
                       </span>
                    </div> 
                    {/* <span className="featuredSub">
                        compared to
                    </span> */}
                </div>

                <div className="featuredItemOrg">
                   <span className="featuredTitleOrg"> Notifications</span>
                   <div className="featuredMoneyContainerOrg">
                       <span className="featuredMoneyOrg">1234</span>
                       <span className="featuredMoneyRateOrg">
                           <PeopleIcon className="featuredIconOrg"/>
                       </span>
                    </div> 
                    {/* <span className="featureSub">
                        compared to
                    </span> */}
                </div>
            </div>
        )
    }
}

export default FeaturedInfoOrg
