import {
    BrowserRouter as Router,
    Switch,
    Route
} from "react-router-dom";
import Sidebar from "../dashboard/sidebar/Sidebar"
import "./sidebar/styles/Dashboard.css"
import OrganisationsDash from "./sidebar/Components/OrganisationsDash/OrganisationsDash"
import Users from "./sidebar/Components/Users/Users"
import Email from "./sidebar/Components/Email/Email"
import Featured from "./sidebar/Components/Featured/Featured";
import Reports from "../../views/dashboard/sidebar/Components/Report/Reports"
import Org from "../dashboard/sidebar/Components/OrganisationsDash/Org"
import Profile from "../dashboard/sidebar/Components/Profile/Profile"
import Certificate from "../dashboard/sidebar/Components/Certificate/Certificate"
import Upgrade2 from "./sidebar/Components/Certificate/Upgrade2"
import Upgrade3 from "./sidebar/Components/Certificate/Upgrade3"
import Upgrade5 from "./sidebar/Components/Certificate/Upgrade5"
import Upgrade4 from "./sidebar/Components/Certificate/Upgrade4"
import Upgrade0 from "./sidebar/Components/Certificate/Upgrade0"
import Upgrade1 from "./sidebar/Components/Certificate/Upgrade1"
import Calendar from "../dashboard/sidebar/Components/Calendar/Calendar"
import Validate from "../dashboard/sidebar/Components/Validate/Validate"
import AddOrg from "../dashboard/sidebar/Components/OrganisationsDash/AddOrg"
import OrgValidate from "../dashboard/sidebar/Components/Validate/OrgValidate"
import Timeline from "../dashboard/sidebar/Components/Timeline/Timeline"


const roles = localStorage.getItem('role')


function Dashboard() {

    function features(){
        if(roles === 'admin')
        {
            return(
                <Switch>
                    <Route exact path="/dashboard">
                        <Featured />
                    </Route>
                    <Route exact path="/organisations">
                        <OrganisationsDash />
                    </Route>
                    <Route path="/org/:id">
                        <Org />
                    </Route>
                    <Route exact path="/users">
                        <Users />
                    </Route>
                    <Route exact path="/report">
                        <Reports />
                    </Route>
                    <Route exact path="/calendar">
                        <Calendar />
                    </Route>
                    <Route exact path="/validate">
                        <Validate />
                    </Route>
                    <Route exact path="/addOrg">
                        <AddOrg />
                    </Route>
                    <Route exact path="/orgValidate/:id">
                        <OrgValidate />
                    </Route>
                    <Route exact path="/timeline">
                        <Timeline />
                    </Route>
                </Switch>
            )
        }
        else if(roles === 'organisation'){
            return(
                <Switch>
                    <Route exact path="/dashboard">
                        <Profile />
                    </Route>
                    <Route exact path="/report">
                        <Reports />
                    </Route>
                    <Route exact path="/calendar">
                        <Calendar />
                    </Route>
                    {/*<Route exact path="/profile">*/}
                    {/*    <Profile />*/}
                    {/*</Route>*/}
                    <Route exact path="/certificate">
                        <Certificate />
                    </Route>
                    <Route exact path="/upgrade1">
                        <Upgrade1 />
                    </Route>
                    <Route exact path="/upgrade2">
                        <Upgrade2 />
                    </Route>
                    <Route exact path="/upgrade3">
                        <Upgrade3 />
                    </Route>
                    <Route exact path="/upgrade4">
                        <Upgrade4 />
                    </Route>
                    <Route exact path="/upgrade5">
                        <Upgrade5 />
                    </Route>
                    <Route exact path="/upgrade0">
                        <Upgrade0 />
                    </Route>
                    <Route exact path="/timeline">
                        <Timeline />
                    </Route>
                </Switch>
            )
        }
    }

    return (
        <Router>
            <div className="Dashboard">
                <div className="DashboardContainer">
                    <Sidebar />
                    {features()}
                </div>
            </div>
        </Router>

    );
}

export default Dashboard;
