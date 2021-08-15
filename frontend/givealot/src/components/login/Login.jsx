import React, { Component } from 'react'
import "./login.css"
import FeaturedHeader from "../featuredHeader/FeaturedHeader"
import LoginBody from "./loginBody/LoginBody"

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
