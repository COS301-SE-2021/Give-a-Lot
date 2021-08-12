import './App.css';
import Topbar from './components/admin/topbar/Topbar';
import Sidebar from "./components/admin/sidebar/Sidebar"
import Dashboard from './components/admin/adminPages/dashboard/Dashboard';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import AdminUsers from './components/admin/adminPages/adminUsers/AdminUsers';
import User from './components/admin/adminPages/user/User';

function App() {
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
        </Switch>
        
      </div>
    </div>
    </Router>
    
  );
}

export default App;
