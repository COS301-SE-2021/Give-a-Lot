import React, { Component } from 'react'
import "./featuredInfo.css"
import PeopleIcon from '@material-ui/icons/People';

export class FeaturedInfo extends Component {
    render() {
        return (
            <div className="featuredA">
                <div className="featuredItemA">
                   <span className="featuredTitleA"> Users</span>
                   <div className="featuredMoneyContainerA">
                       <span className="featuredMoneyA">1234</span>
                       <span className="featuredMoneyRateA">
                           <PeopleIcon className="featuredIconA"/>
                       </span>
                    </div> 
                    {/* <span className="featureSub">
                        compared to
                    </span> */}
                </div>

                <div className="featuredItemA">
                   <span className="featuredTitleA"> Organisations</span>
                   <div className="featuredMoneyContainerA">
                       <span className="featuredMoneyA">1234</span>
                       <span className="featuredMoneyRateA">
                           <PeopleIcon className="featuredIconA"/>
                       </span>
                    </div> 
                    {/* <span className="featuredSub">
                        compared to
                    </span> */}
                </div>

                <div className="featuredItemA">
                   <span className="featuredTitleA"> Notifications</span>
                   <div className="featuredMoneyContainerA">
                       <span className="featuredMoneyA">1234</span>
                       <span className="featuredMoneyRateA">
                           <PeopleIcon className="featuredIconA"/>
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

export default FeaturedInfo
