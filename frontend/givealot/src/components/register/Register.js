import React, { Component } from 'react'
import RegisterUser from './RegisterUser'
import RegisterOrganisation from './RegisterOrganisation'
import back from "./imagesRegister/back.png";
import logo from "./imagesRegister/ID2.png";
import "./Register.css"
import RegisterBack from "./RegisterBack"
import {Switch,Route} from "react-router-dom";

export class Register extends Component {
    
    render() {
        return (
            <div className="register">
                <img id="ID2" src={logo} alt="logo" />
                <div style={{width: "100%", height: "100%"}}>
                    <img id="back" src={back} alt="background" />
                </div>
                
                <div className="NGOs_made_safer_for_you">
                    <span>NGOs made safer for you</span>
                </div>
                <RegisterBack />
                <Switch>
                        <Route exact path="/registerOrgs" component={RegisterOrganisation} />
                        <Route exact path="/registeruser" component={RegisterUser} />
                </Switch>
            </div>
        )
    }
}

export default Register
