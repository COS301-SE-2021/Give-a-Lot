import React from 'react'
import "./NavBar.css";
import BasicUser from "./BasicUser";
import Login from "../login/Login";
import Browse from "../browse/Browse";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

function NavBar() {
        const mystyle={
            color:'#303030',
            textDecoration: 'none',
           

        };

        const mystyle1={
            color:'#303030',
            textDecoration: 'none',
            borderBottomColor:  'red',

        };
   

    return ( <Router>
        <nav >
            <div >
                <ul>
                    <li className="one" >
                        <Link style={mystyle1} to={'/BasicUser'}>home</Link>
                    </li>
                    <li>
                        <Link style={mystyle} to={"/Browse"}>browse</Link>
                    </li>
                    <li>
                        <Link style={mystyle} to={"/Login"}>login</Link>
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
