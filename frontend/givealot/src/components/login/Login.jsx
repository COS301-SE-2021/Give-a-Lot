import React, { Component } from 'react'
import "./login.css"
import FeaturedHeader from "../featuredHeader/FeaturedHeader"
import {
    BrowserRouter as Router
} from "react-router-dom";
import LoginBody from "./loginBody/LoginBody"


export class Login extends Component {

    render() {
        return (
            <Router>
                <div className="Login">
                    <FeaturedHeader />
                    <div className="containerLogin">
                        <LoginBody />
                        {/*<Switch>*/}
                        {/*    <Route exact path="/">*/}
                        {/*        <Dashboard />*/}
                        {/*    </Route>*/}
                        {/*</Switch>*/}
                    </div>
                </div>
            </Router>
        )
    }
}

export default Login
