import React, { Component } from "react";
import AdminNav from "../AdminNav/AdminNav";
// import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
// import AdminNav from "../../AdminNav/AdminNav";

export default class Adminsidebar extends Component {
   
    render() {
        const sidebarstyle ={
            backgroundColor: "white",
            width: "280px",
            height:"100%"
            // backgroud:"#fff"
        }
        return (
            <div>
                <div className="bg-danger h-4">
                    <AdminNav/>
                </div>
               
                <main>
                <div className="">
                <div className="d-flex flex-column flex-shrink-0 p-3 bg-light" style={sidebarstyle}>
                    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
                    {/* <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg> */}
                    <span className="fs-4">Give A lot</span>
                    </a>
                    <hr/>
                    <ul className="nav nav-pills flex-column mb-auto">
                    <li className="nav-item">
                        <a href="#" className="nav-link active" aria-current="page">
                        {/* <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"/></svg> */}
                        Home
                        </a>
                    </li>
                    <li>
                        <a href="#" className="nav-link link-dark">
                        {/* <svg class="bi me-2" width="16" height="16"><use xlink:href="#speedometer2"/></svg> */}
                        Dashboard
                        </a>
                    </li>
                    <li>
                        <a href="#" className="nav-link link-dark">
                        {/* <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"/></svg> */}
                        Orders
                        </a>
                    </li>
                    <li>
                        <a href="#" className="nav-link link-dark">
                        {/* <svg class="bi me-2" width="16" height="16"><use xlink:href="#grid"/></svg> */}
                        Products
                        </a>
                    </li>
                    <li>
                        <a href="#" className="nav-link link-dark">
                        {/* <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"/></svg> */}
                        Customers
                        </a>
                    </li>
                    </ul>
                    <hr/>
                    <div className="dropdown">
                        <a href="#" className="d-flex align-items-center link-dark text-decoration-none dropdown-toggle" id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="https://github.com/mdo.png" alt="" width="32" height="32" className="rounded-circle me-2"/>
                            <strong>mdo</strong>
                        </a>
                        <ul className="dropdown-menu text-small shadow" aria-labelledby="dropdownUser2">
                            <li><a className="dropdown-item" href="#">New project...</a></li>
                            <li><a className="dropdown-item" href="#">Settings</a></li>
                            <li><a className="dropdown-item" href="#">Profile</a></li>
                            <li><hr className="dropdown-divider"/></li>
                            <li><a className="dropdown-item" href="#">Sign out</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            </main>
            </div>
            
        );
    }
}