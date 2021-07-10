import React, { Component } from 'react'
import logo from "../../login/images/logo.png";
import bodyImage from "./imagesHome/bodyImage.png";
import "./Home2.css";
import {FaBars } from "react-icons/fa";
import {FaSearch } from "react-icons/fa";

export class Home2 extends Component {

    render() {
        return (
            <div>
                <div className="home_header">

                    <div className="list">
                        <FaSearch size="1.9em" color="#767676" className="menu" />
                        <button type="submit" className="home_button">Login</button>
                        <FaBars size="1.9em" color="#767676" className="menu"/>
                    </div>

                    <div className="home_image">
                        <img id="home_ID" src={logo} alt=""/>
                    </div>

                </div>

                <div className="ribbon">
                    <p>Your platform for safe organizations</p>
                </div>

                <div className="mainBody">

                  <div className="image">
                        <img id="body_ID" src={bodyImage} alt=""/>
                    </div>

                  <div className="words">
                    <p className="bigWord">
                        Where givers live
                    </p>
                    <p className="smallWord">
                        GiveAlot is a relatively simple idea that is meant
                        to solve the problem that individuals and organisations
                        encounter when it comes to verifying the authenticity of
                        charities and many other different kinds of Organisations.
                        GiveAlot aims to solve this problem by becoming a central point
                        of reference for the verification for charities and other kinds of organisations.
                    </p>
                  </div>
                </div>
                <button type="submit" className="browse_button">Browse Organisations</button>

            </div>
        )
    }
}

export default Home2
