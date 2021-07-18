import React, { Component } from "react";
import "./Login.css";
import logo from "./images/logo.png";
import axios from 'axios';
import Register from "../register/Register"
import { Redirect } from "react-router";
import {Switch,Route,Link} from "react-router-dom";
import ArrowBackIcon from '@material-ui/icons/ArrowBack';

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
    ////capture Login details and post them
    constructor(props) {
        super(props)
    
        this.state = {
            email: "",
            password : "",
        }
    }

    changeHandler = (e) =>{
        this.setState({[e.target.name] : e.target.value})
    }
    submitHandler = (e) =>{
        e.preventDefault()
        console.log(this.state)
        axios.post('https://jsonplaceholder.typicode.com/posts', this.state)
        .then(response =>{
            console.log(response)
        })
        .catch(error =>{
            console.log(error)
        })
    }

    render() {
        const {email, password} = this.state
        return (
            <div>
                <div className="Login_header">
                    <div className="Login_image">
                        <img src={logo} alt="" className="Login_image"/>
                    </div>
                    
                </div>
                <div className="backArrow">
                    <ArrowBackIcon />
                </div>
                <div className="Login_container" >
                    <form className="Login_form" onSubmit={this.submitHandler}>
                        <div className="topline">
                            <p> Login </p>
                        </div>

                        <div>
                            <label></label>
                            {/* <FaBeer /> */}
                            <input type="type" name="email" value={email} onChange={this.changeHandler}className="input" placeholder="Email" />
                        </div>

                        <div>
                            <label></label>
                            <input type="type" name="password" value={password} onChange={this.changeHandler} className="input" placeholder="Password" />
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