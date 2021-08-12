import './admin.css';
import Topbar from './topbar/Topbar';
import Sidebar from "./sidebar/Sidebar"
import Dashboard from './adminPages/dashboard/Dashboard';
import {
    BrowserRouter as Router,
    Switch,
    Route
} from "react-router-dom";
import AdminUsers from './adminPages/adminUsers/AdminUsers';
import User from './adminPages/user/User';
import NewUser from "./adminPages/newUser/NewUser"

function Admin() {
    return (
        <Router>
            <div className="App">
                <Topbar />
                <div className="container">
                    <Sidebar />
                    <Switch>
                        <Route exact path="/">
                            <Dashboard />
                        </Route>
                        <Route path="/adminUsers">
                            <AdminUsers />
                        </Route>
                        <Route path="/user/:userId">
                            <User />
                        </Route>
                        <Route path="/newUser">
                            <NewUser />
                        </Route>
                        <Route path="/adminOrgs">
                            <NewUser />
                        </Route>
                        <Route path="/emails">
                            <NewUser />
                        </Route>
                        <Route path="/calendar">
                            <NewUser />
                        </Route>
                        <Route path="/todos">
                            <NewUser />
                        </Route>
                        <Route path="/logout">
                            <NewUser />
                        </Route>
                    </Switch>

                </div>
            </div>
        </Router>

    );
}

export default Admin;
