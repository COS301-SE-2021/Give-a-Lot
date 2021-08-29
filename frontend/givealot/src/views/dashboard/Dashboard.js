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
// import Todos from "../dashboard/sidebar/Components/Todos/Todos"
import Calendar from "../dashboard/sidebar/Components/Calendar/Calendar"
import Validate from "../dashboard/sidebar/Components/Validate/Validate"
import AddOrg from "../dashboard/sidebar/Components/OrganisationsDash/AddOrg"

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
                        <Route exact path="/addOrg">
                            <AddOrg />
                        </Route>

                    </Switch>
                </div>
            </div>
        </Router>

    );
}

export default Dashboard;