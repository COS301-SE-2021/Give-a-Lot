import React, { Component } from "react";
import "./Register.css";
// import {FaGithub } from "react-icons/fa";
import logo from "./imagesRegister/ID2.png";
// import body from "./images/body.png";


class RegisterUser extends Component {

    render() {
        return (
            <div >
                <div className="header">
                    <div className="image">
                        <img id="ID" src={logo} alt=""/>
                    </div>

                </div>
                <div className="container" >

                    <form className="form">
                        <div className="top">
                            <p> Registration | USER</p>
                        </div>
                        <div >
                            <label></label>

                            <input type="name" className="control" placeholder=" Name" />
                        </div>

                        <div >
                            <label></label>
                            <input type="name" className="control" placeholder="Surname" />
                        </div>

                        <div >
                            <label></label>
                            <input type="email" className="control" placeholder="Email" />
                        </div>

                        <div >
                            <label></label>
                            <input type="password" className="control" placeholder="Password" />
                        </div>
                        <div>
                            <button type="submit" className="button">Sign Up</button>
                        </div>

                    </form>
                    <div className="gradientOverlay"></div>
                </div>
            </div>
        );
    }

}

export default RegisterUser