import './Admin.css';
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
// import NewUser from "./adminPages/newUser/NewUser"
import AdminOrgs from "./adminPages/adminOrgs/AdminOrgs"
import Orgs from "./adminPages/orgs/Orgs"
import Emails from "./adminPages/emails/Emails";
import Calendar from "./adminPages/calendar/Calendar";
import Todo from "./adminPages/todo/Todo";
import InfoValidation from "./adminPages/infoValidation/InfoValidation";
import OrgValidate from "./adminPages/infoValidation/OrgValidate"
import AddOrg from "./adminPages/AddOrg/AddOrg";

function Admin() {

    const loggedInUser = {
        "id" :localStorage.getItem("id"),
        "role":localStorage.getItem("role")
    };
    console.log(loggedInUser)
    if(localStorage.getItem("id") || loggedInUser.role!="admin")
    {
        ////unauthorized
        console.log("user logged out or not admin")
    }


    ///console.log(foundUser)
    return (
        <Router>
            <div className="App">
                <Topbar />
                <div className="container">
                    <Sidebar />
                    <Switch>
                        <Route exact path="/dash">
                            <Dashboard />
                        </Route>
                        <Route path="/adminUsers">
                            <AdminUsers />
                        </Route>
                        <Route path="/user/:userId">
                            <User />
                        </Route>
                        {/*<Route path="/newUser">*/}
                        {/*    <NewUser />*/}
                        {/*</Route>*/}
                        <Route path="/adminOrgs">
                            <AdminOrgs />
                        </Route>
                        <Route path="/orgs/:orgsId">
                            <Orgs />
                        </Route>
                        <Route path="/emails">
                            <Emails />
                        </Route>
                        <Route path="/calendar">
                            <Calendar />
                        </Route>
                        <Route path="/todos">
                            <Todo />
                        </Route>
                        {/*<Route path="/logout">*/}
                        {/*    <NewUser />*/}
                        {/*</Route>*/}
                        <Route path="/infoValidation">
                            <InfoValidation />
                        </Route>
                        <Route path="/orgValidate/:orgsId">
                            <OrgValidate />
                        </Route>
                        <Route path="/addOrg">
                            <AddOrg />
                        </Route>
                    </Switch>

                </div>
            </div>
        </Router>

    );
}

export default Admin;
