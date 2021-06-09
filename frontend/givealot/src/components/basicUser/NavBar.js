import React from 'react'
import "./NavBar.css";
import BasicUser from "./BasicUser";
import Login from "../login/Login";
import Browse from "../browse/Browse";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

function NavBar() {
    return ( <Router>
        <nav className="container">
            <div >
                <ul>
                    <li >
                        <Link  to={"/BasicUser"}>Home</Link>
                    </li>
                    <li>
                        <Link to={"/Browse"}>Browse</Link>
                    </li>
                    <li>
                        <Link to={"/Login"}>Login</Link>
                    </li>
                </ul>

            </div>
        </nav>

        <div>
            <Switch>
                <Route></Route>
                <Route path="Browse" ></Route>
                <Route path="/Login" component={Login}></Route>
            </Switch>
        </div>


     </Router>

        
        
        /*<div >
            <h1 className="linkk">Home</h1>
       
            <h1 className="welcome_back">welcome back</h1>
        </div>*/
    )
}

export default NavBar
