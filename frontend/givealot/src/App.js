import React from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Registration from "./components/registration/registration"; 
import Login from "./components/login/login";

function App() {
  // return (
  //   <div className="App">
  //    <Registration />
  //   </div>
  // );

  return (<Router>
    <div className="App">
      <nav className="navbar navbar-expand-lg navbar-light fixed-top">
        <div className="container">
          <Link className="navbar-brand" to={"/login"}>Give Alot</Link>
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
        <div className="inner">
          <Switch>
            <Route exact path='/' component={Login} />
            <Route path="/login" component={Login} />
            <Route path="/Registration" component={Registration} />
          </Switch>
        </div>
      </div>
    </div></Router>
  );
}

export default App;
