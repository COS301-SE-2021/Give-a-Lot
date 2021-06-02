import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
// import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
// import './App.css';

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
                            <Link className="nav-link" to={"/Home"}>Home</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to={"/About"}>About</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to={"/About"}>Contacts</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to={"/About"}>Register organisation</Link>
                        </li>
                        </ul>
                    </div>
                    </div>
                </nav>
            </div>
            </Router>
        );
    }
}