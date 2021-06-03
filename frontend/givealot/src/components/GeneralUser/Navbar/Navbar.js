import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Login from "../../login/login";
import Registration from "../../registration/registration";
import GeneralUser from "../GeneralUser";
// import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
// import './App.css';

export default class Navbar extends Component {
    render() {
        return (
        //     <Router>
        //     <div className="App">
        //       <nav className="navbar navbar-expand-lg navbar-light fixed-top">
        //         <div className="container">
        //           <Link className="navbar-brand" to={"/GeneralUser"}>Give Alot</Link>
        //           <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
        //             <ul className="navbar-nav ml-auto">
        //               <li className="nav-item">
        //                 <Link className="nav-link" to={"/login"}>Login</Link>
        //               </li>
        //               <li className="nav-item">
        //                 <Link className="nav-link" to={"/Registration"}>Registration</Link>
        //               </li>
        //             </ul>
        //           </div>
        //         </div>
        //       </nav>
        
        //       <div className="outer">
        //         {/* <div className="inner"> */}
        //           <Switch>
        //             <Route exact path='/' component={GeneralUser} />
        //             <Route path="/login" component={Login} />
        //             <Route path="/Registration" component={Registration} />
        //           </Switch>
        //         {/* </div> */}
        //       </div>
        //     </div>
        //   </Router>
        <div>
            
        </div>
        
        );
    }
}