import {
    BrowserRouter as Router,
    Switch,
    Route
} from "react-router-dom";
import Sidebar from "../dashboard/sidebar/Sidebar"
import "./sidebar/styles/Dashboard.css"
import Logo from "../login/Components/Logo"
import Organisations from "./sidebar/Components/Organisations/Organisations"

function Dashboard() {
    return (
        <Router>
            <div className="Dashboard">
                <Logo />
                <div className="DashboardContainer">
                    <Sidebar />
                    <Switch>
                        <Route exact path="/organisations">
                            <Organisations />
                        </Route>
                    </Switch>
                </div>
            </div>
        </Router>

    );
}

export default Dashboard;