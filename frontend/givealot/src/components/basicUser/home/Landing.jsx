import React, { Component } from 'react'
import Home from "./Home"
import { Route } from "react-router-dom";
import Login from "../../login/Login"
import VerifyHomePage from "./VerifyHomePage";

export class Landing extends Component {

    render() {
        return (
            <div className="landing">
                <Route path='/' component={Home}>
                    <Route path="login" component={Login} />
                    <Route path="verifyPage" component={VerifyHomePage} />
                </Route>
            </div>
        )
    }
}

export default Landing
