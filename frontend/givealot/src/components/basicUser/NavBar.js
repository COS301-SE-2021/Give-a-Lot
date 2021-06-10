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
                        <Link  to={'/BasicUser'}>Home</Link>
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

               
                <Route path="/Basic" component={BasicUser} />
                <Route path="/Browse" component={Browse} />
                <Route path="/Login" component={Login} />
                
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
