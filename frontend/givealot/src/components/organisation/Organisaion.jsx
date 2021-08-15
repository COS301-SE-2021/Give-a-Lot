import './organisation.css';
import TopbarOrg from './topbarOrg/TopbarOrg';
import SidebarOrg from "./sidebarOrg/SidebarOrg"
import DashboardOrg from "./orgPages/orgdashboard/DashboardOrg"
import {
    BrowserRouter as Router,
    Switch,
    Route
} from "react-router-dom";
import OrgUsers from "./orgPages/orgUsers/OrgUsers";
import User from './orgPages/user/User';
import NewUser from "./orgPages/newUser/NewUser"
import OrgCalendar from "./orgPages/orgCalendar/OrgCalendar";
import Profile from "./orgPages/profile/Profile"
import Gallery from "./orgPages/gallery/Gallery";
import Certificate from "./orgPages/certificateOrg/Certificate";
import Reports from "./orgPages/reports/Reports"
import Todos from "./orgPages/todos/Todos"
import Upgrade from "./orgPages/certificateOrg/Upgrade";

function Organisation() {
    return (
        <Router>
            <div className="org">
                <TopbarOrg />
                <div className="container">
                    <SidebarOrg />
                    <Switch>
                        <Route exact path="/">
                            <DashboardOrg />
                        </Route>
                        <Route path="/adminUsers">
                            <OrgUsers />
                        </Route>
                        <Route path="/user/:userId">
                            <User />
                        </Route>
                        <Route path="/newUser">
                            <NewUser />
                        </Route>
                        <Route path="/calendar">
                            <OrgCalendar />
                        </Route>
                        <Route path="/logout">
                            <NewUser />
                        </Route>

                        <Route path="/profile">
                            <Profile />
                        </Route>
                        <Route path="/gallery">
                            <Gallery />
                        </Route>
                        <Route path="/certificate">
                            <Certificate />
                        </Route>
                        <Route path="/reports">
                            <Reports />
                        </Route>
                        <Route path="/todos">
                            <Todos />
                        </Route>
                        <Route path="/upgrade">
                            <Upgrade />
                        </Route>
                    </Switch>

                </div>
            </div>
        </Router>

    );
}

export default Organisation;
