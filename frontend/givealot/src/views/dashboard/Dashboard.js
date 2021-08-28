import {
    BrowserRouter as Router,
    Switch,
    Route
} from "react-router-dom";
import Sidebar from "../dashboard/sidebar/Sidebar"
import "./sidebar/styles/Dashboard.css"
import Organisations from "./sidebar/Components/Organisations/Organisations"
import Users from "./sidebar/Components/Users/Users"
import Email from "./sidebar/Components/Email/Email"
import Featured from "./sidebar/Components/Featured/Featured";
import DashLogo from "../login/Components/DashLogo";
import Reports from "../dashboard/sidebar/Components/Report/Reports";
import Profile from "../dashboard/sidebar/Components/Profile/Profile";

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
                            <Organisations />
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
                        <Route exact path="/profile">
                            <Profile />
                        </Route>
                    </Switch>
                </div>
            </div>
        </Router>

    );
}

export default Dashboard;