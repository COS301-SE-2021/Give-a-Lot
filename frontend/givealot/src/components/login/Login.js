import React, { Component } from "react";
import "./Login.css";
import {FaBars } from "react-icons/fa";
import logo from "./images/logo.png";
// import body from "./images/body.png";


class Login extends Component {

    render() {
        return (
            <div >
                <div className="Login_header">
                    <div className="Login_image">
                        <img id="Login_ID" src={logo} alt=""/>
                    </div>

                </div>
                <div className="Login_container" >

                    <form className="Login_form">
                        <div className="topline">
                            <p> Login | USER</p>
                        </div>

                        <div >
                            <label></label>
                            <input type="email" className="input" placeholder="Email" />
                        </div>

                        <div >
                            <label></label>
                            <input type="password" className="input" placeholder="Password" />
                        </div>
                        <div>
                            <button type="submit" className="Login_button">Sign Up</button>
                        </div>

                    </form>
                    <div className="gradientOverlay"></div>
                </div>
            </div>
        );
    }

}

export default Login