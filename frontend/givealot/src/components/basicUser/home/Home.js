import React, { Component } from 'react'
import logo from "../../login/images/logo.png";
import bodyImage from "./imagesHome/bodyImage.png";
import "./Home.css";
import {FaBars } from "react-icons/fa";
import {FaSearch } from "react-icons/fa";
import { Redirect } from "react-router";
import {Switch,Route} from "react-router-dom";
import Login from "../../login/Login"

export class Home extends Component {
    state = {
        redirect: false
    }
    redirectHandler = () => {
        this.setState({ redirect: true })
        this.renderRedirect();
    }
    renderRedirect = () => {
        if (this.state.redirect) {
            return <Redirect to='/login' />
        }
    }

    render() {
        return (
            <div>
                <div className="home_header">

                    <div className="list">
                        <FaSearch size="1.9em" color="#767676" className="menu" />
                        <button type="submit" className="home_button" onClick={this.redirectHandler} >Login</button>
                        {this.renderRedirect()}
                        <FaBars size="1.9em" color="#767676" className="menu"/>
                    </div>

                    <div >
                        <img src={logo} alt="" className="home_image"/>
                    </div>
                    
                </div>

                <div className="ribbon">
                    <p>Your platform for safe organizations</p>
                </div>

                <div className="mainBody">

                  <div className="images">
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
                <Switch>       
                    <Route exact path="/login" component={Login} />
                </Switch>
            </div>
        )
    }
}

export default Home
