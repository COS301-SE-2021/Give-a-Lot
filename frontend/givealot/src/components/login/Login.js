import React, { Component } from "react";
import "./Login.css";
import logo from "./images/logo.png";
// import { FaBeer } from 'react-icons/fa';
// import body from "./images/body.png";
import Register from "../register/Register"
import { Redirect } from "react-router";
import {Switch,Route,Link} from "react-router-dom";

class Login extends Component {
    state = {
        redirect: false
    }
    redirectHandler = () => {
        this.setState({ redirect: true })
        this.renderRedirect();
    }
    renderRedirect = () => {
        if (this.state.redirect) {
            return <Redirect to='/register' />
        }
    }

    render() {
        return (
            <div>
                <div className="Login_header">
                    <div className="Login_image">
                        <img id="Login_ID" src={logo} alt=""/>
                    </div>
                </div>
                <div className="Login_container" >
                    <form className="Login_form">
                        <div className="topline">
                            <p> Login </p>
                        </div>

                        <div>
                            <label></label>
                            {/* <FaBeer /> */}
                            <input type="email" className="input" placeholder="Email" />
                        </div>

                        <div>
                            <label></label>
                            <input type="password" className="input" placeholder="Password" />
                        </div>
                        <div style={{color: "white"}}>
                            <div id="createAccount">
                                <span>Create Account? <span style={{textDecoration:"underline", color: "white", cursor: "pointer"}} ><Link to="/register">Sign Up</Link></span> {this.renderRedirect()}</span>
                                {/* <Link to="/register">Sign Up</Link> */}
                            </div>

                        </div>  
                        <div>
                            <button type="submit" className="Login_button">Sign In</button>
                        </div>

                    </form>
                    <div className="gradientOverlay"></div>
                </div>
                <Switch>       
                    <Route exact path="/register" component={Register} />
                </Switch>
            </div>
        );
    }

}

export default Login