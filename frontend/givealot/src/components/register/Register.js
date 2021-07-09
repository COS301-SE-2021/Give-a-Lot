import React, { Component } from 'react'
import RegisterUser from './RegisterUser'
import RegisterOrganisation from './RegisterOrganisation'
import logo from "./imagesRegister/ID2.png";
import "./Register.css"
import RegisterBack from "./RegisterBack"
import {Switch,Route} from "react-router-dom";

export class Register extends Component {
    
    render() {
        return (
            <div className="register">
                <div className="header">
                    <div className="image">
                        <img id="ID" src={logo} alt=""/>
                    </div>

                </div>
                <div className="container" >
                    <div className="NGOs_made_safer_for_you">
                        <span>NGOs made safer for you</span>
                    </div>
                    <RegisterBack />
                    <Switch>
                            <Route exact path="/registerOrgs" component={RegisterOrganisation} />
                            <Route exact path="/registeruser" component={RegisterUser} />
                    </Switch>
                </div>
                
                
            </div>
        )
    }
}

export default Register
