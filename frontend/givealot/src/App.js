import React from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Registration from "./components/registration/registration"; 
import Login from "./components/login/login";
import GeneralUser from "./components/GeneralUser/GeneralUser";
import AdminNav from './components/Admin/AdminNav/AdminNav';
import Admin from "./components/Admin/Admin";
import Organisation from './components/organisation/Organisation';

function App() {
  
  return (
  <Router>
    <div className="App">
      <nav className="navbar navbar-expand-lg navbar-light fixed-top">
        <div className="container">
          <Link className="navbar-brand" to={"/GeneralUser"}>Give Alot</Link>
          <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link className="nav-link" to={"/login"}>Login</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to={"/Registration"}>Registration</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <div className="outer">
        {/* <div className="inner"> */}
          <Switch>
            <Route exact path='/' component={GeneralUser} />
            <Route exact path="/login" component={Login} />
            <Route exact path="/Registration" component={Registration} />
          </Switch>
        {/* </div> */}
      </div>
    </div>
  </Router>

  // <div className="App">
  //   {/* <Admin/> */}
  //   {/* <GeneralUser/> */}
  //   <Organisation/>
  // </div>
  );
}

export default App;
