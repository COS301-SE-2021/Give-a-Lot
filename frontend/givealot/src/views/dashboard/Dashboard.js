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
import DashLogo from "../login/Components/DashLogo";
import Reports from "../../views/dashboard/sidebar/Components/Report/Reports"
import Org from "../dashboard/sidebar/Components/OrganisationsDash/Org"
import Profile from "../dashboard/sidebar/Components/Profile/Profile"
import Certificate from "../dashboard/sidebar/Components/Certificate/Certificate"
import Upgrade from "../dashboard/sidebar/Components/Certificate/Upgrade"
import Upgrade2 from "../dashboard/sidebar/Components/Certificate/Upgrade2"
import Upgrade3 from "../dashboard/sidebar/Components/Certificate/Upgrade3"
import Upgrade4 from "../dashboard/sidebar/Components/Certificate/Upgrade4"
import Upgrade5 from "../dashboard/sidebar/Components/Certificate/Upgrade5"
// import Todos from "../dashboard/sidebar/Components/Todos/Todos"
import Calendar from "../dashboard/sidebar/Components/Calendar/Calendar"
import Validate from "../dashboard/sidebar/Components/Validate/Validate"

function Dashboard() {
    return (
        <Router>
            <div className="Dashboard">
                <DashLogo />
                <div className="DashboardContainer">
                    <Sidebar />
                    <Switch>
                        <Route exact path="/featured">
                            <Featured />
                        </Route>
                        <Route exact path="/organisations">
                            <OrganisationsDash />
                        </Route>
                        <Route path="/org/:orgId">
                            <Org />
                        </Route>
                        <Route exact path="/users">
                            <Users />
                        </Route>
                        <Route exact path="/email">
                            <Email />
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
                        <Route exact path="/profile">
                            <Profile />
                        </Route>
                        <Route exact path="/certificate">
                            <Certificate />
                        </Route>
                        <Route exact path="/upgrade">
                            <Upgrade />
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
                    </Switch>
                </div>
            </div>
        </Router>

    );
}

export default Dashboard;