import React, { Component } from 'react'
import "./Login.css"
import FeaturedHeader from "../featuredHeader/FeaturedHeader"
import LoginBody from "./loginBody/LoginBody"
// import MuiAlert from "@material-ui/lab/Alert";

export class Login extends Component {

    render() {
        return (
            <div className="Login">
                <FeaturedHeader />
                <div className="containerLogin">
                    <LoginBody />
                </div>
            </div>
        )
    }
}

export default Login
