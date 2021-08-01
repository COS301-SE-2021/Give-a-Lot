import React, { Component } from 'react'
import OrgSidebar from "./OrgSidebar"
import OrgDashboard from "./OrgDashboard";
import "./Organisation.css"
import {Switch,Route} from "react-router-dom";
import OrgHeader from "./OrgHeader"

export class Organisation extends Component {

    render() {
        return (
            <div className="Org">
                <div className="headerOrg">
                    <OrgHeader />
                </div>
                <div className="OrgBody">
                    <div>
                        <OrgSidebar />
                    </div>
                    <div className="dash">
                        <Switch>


                            <Route exact path="/" component={OrgDashboard} />


                        </Switch>

                    </div>

                </div>

            </div>
        )
    }
}

export default Organisation