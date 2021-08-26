import {
    BrowserRouter as Router,
    Switch,
    Route
} from "react-router-dom";
import Sidebar from "../dashboard/sidebar/Sidebar"
import "./sidebar/styles/Dashboard.css"
import Logo from "../login/Components/Logo"
import Organisations from "./sidebar/Components/Organisations/Organisations"
import Users from "./sidebar/Components/Users/Users"
import Featured from "./sidebar/Components/Featured/Featured";

function Dashboard() {
    return (
        <Router>
            <div className="Dashboard">
                <Logo />
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
                    </Switch>
                </div>
            </div>
        </Router>

    );
}

export default Dashboard;