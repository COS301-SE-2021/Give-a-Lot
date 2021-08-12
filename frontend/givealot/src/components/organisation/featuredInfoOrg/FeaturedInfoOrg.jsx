import React, { Component } from 'react'
import "./featuredInfoOrg.css"
import PeopleIcon from '@material-ui/icons/People';

export class FeaturedInfoOrg extends Component {
    render() {
        return (
            <div className="featured">
                <div className="featuredItem">
                   <span className="featuredTitle"> Users</span>
                   <div className="featuredMoneyContainer">
                       <span className="featuredMoney">1234</span>
                       <span className="featuredMoneyRate">
                           <PeopleIcon className="featuredIcon"/>
                       </span>
                    </div> 
                    {/* <span className="featureSub">
                        compared to
                    </span> */}
                </div>

                <div className="featuredItem">
                   <span className="featuredTitle"> Organisations</span>
                   <div className="featuredMoneyContainer">
                       <span className="featuredMoney">1234</span>
                       <span className="featuredMoneyRate">
                           <PeopleIcon className="featuredIcon"/>
                       </span>
                    </div> 
                    {/* <span className="featuredSub">
                        compared to
                    </span> */}
                </div>

                <div className="featuredItem">
                   <span className="featuredTitle"> Notifications</span>
                   <div className="featuredMoneyContainer">
                       <span className="featuredMoney">1234</span>
                       <span className="featuredMoneyRate">
                           <PeopleIcon className="featuredIcon"/>
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
