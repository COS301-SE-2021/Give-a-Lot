import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import GeneralUser from "../../GeneralUser/GeneralUser";
import Login from "../../login/login";
// import Login from "./components/login/login";
import Registration from "../../registration/registration";

export default class Navbar extends Component {
    render() {
        return (
            <Router>
            <div className="">
                <nav className="navbar navbar-expand-lg navbar-light fixed-top">
                    <div className="container">
                    <Link className="navbar-brand" to={"/login"}>Give Alot</Link>
                    <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
                        <ul className="navbar-nav ml-auto">
                        <li className="nav-item">
                            <Link className="nav-link" to={"/GeneralUser"}>Home</Link>
                        </li>
                        {/* <li className="nav-item" >
                            <Link className="nav-link" to={"/About"}>About</Link>
                        </li> */}
                        <li className="nav-item" style={{position:"absolute", right:"100px"}}>
                            <Link className="nav-link" to={"/login"}>Login</Link>
                        </li>
                        <li className="nav-item" style={{position:"absolute", right:"300px"}}>
                            <Link className="nav-link" to={"/registration"}>Register organisation</Link>
                        </li>
                        </ul>
                    </div>
                    </div>
                </nav>

        <div className="outer">
        <div className="inner">
          <Switch>
            <Route exact path='/' component={GeneralUser} />
            <Route exact path="/login" component={Login} />
            <Route exact path="/registration" component={Registration} />
          </Switch>
        </div>
      </div>
            </div>
            </Router>
        );
    }
}