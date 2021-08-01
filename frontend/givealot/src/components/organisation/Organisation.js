import React, { Component } from 'react'
import OrgSidebar from "./OrgSidebar"
import OrgDashboard from "./OrgDashboard";
import "./Organisation.css"
import {Switch,Route} from "react-router-dom";
import OrgHeader from "./OrgHeader"
import OrgCalender from "../organisation/orgCalender/OrgCalender";

import Logout from "../organisation/Logout";

import OrgTodo from "../organisation/orgTodo/OrgTodo";

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
                            <Route exact path="/OrgCalendar" component={OrgCalender} />
                            <Route exact path="/logout" component={Logout} />
                            <Route exact path="/todo" component={OrgTodo} />


                        </Switch>

                    </div>

                </div>

            </div>
        )
    }
}

export default Organisation