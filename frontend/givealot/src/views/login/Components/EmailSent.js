/*import React, { Component } from "react";
import "../../registration/registerOrganisation/Styles/registerOrganisation.css"
import backgroundImg from "../../../assets/homeBackground.jpg"
import Logo from "../Components/Logo"
import { Link } from "react-router-dom";

export class EmailSent extends Component {
    styles = {
        main: {
            backgroundImage: `url(${backgroundImg})`
        }
    }
    constructor(props) {
        super(props);


    }

    render() {
        return (
            <div className="registerOrganisation" style={this.styles.main}>
                <div  id={"banner_filter"}>
                    <Logo/>
                    <div className="registerCard">
                        <div className="wrap">
                            <form className="form1">
                           <span className="headerTag1">
                                Email successfully sent
                           </span>
                            <span className="Instruction1">
                                We’ve sent you an email with instructions.

                            </span>
                                <div className="button">
                                    <div className="formButton ">
                                        <Link to={"/login"}>
                                            <button className="register-btn">
                                                {" "}
                                               Return to Login
                                            </button>
                                        </Link>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default EmailSent;*/

import React, {Component} from 'react';
import { Link } from "react-router-dom";
import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import backgroundImg from "../../../assets/homeBackground.jpg";
import Logo from "../Components/Logo"
import axios from "axios"
import "../Styles/Login.css"
import {Alert} from "@material-ui/lab";



const styles = {
    main: {
        backgroundImage: `url(${backgroundImg})`
    }
}

const initialState = {
    token: "",
    tokenError: "",
};

class EmailSent extends Component {

    state = initialState;

    handleChange = event => {
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    };

    validate = () => {
        let tokenError = "";

        if (!this.state.token) {
            tokenError = "invalid email";
        }


        if ( tokenError ) {
            this.setState({ tokenError });
            return false;
        }

        return true;
    };


    handleSubmit = event => {
        event.preventDefault();
        const isValid = this.validate();
        if (isValid) {
            console.log(this.state);

            const data = {
                token: this.state.token,

            };
            axios.post("http://localhost:8080/v1/login/user/check_token", data)
                .then(res => console.log(res))
                .catch(err => console.log(err));


        }
    };



    render()
    {
        return (
            <div>

                <div className="Login" style={styles.main}>
                    <div  id={"banner_filter"}>
                        <Logo/>
                        <Link to={"/Password"}>
                            <ArrowBackIcon style={{color: "white", marginLeft: "30px", fontSize: "xx-large"}}/>
                        </Link>
                        <div className="LoginCard">
                            <div className="wrapper">
                                <form className="LoginForm" onSubmit={this.handleSubmit}>
                                    <span className="headerTag1">
                                        Email has been sent
                                    </span>
                                    <span className="Instruction">
                                       Please enter the pin code that was sent to your email, to verify that it is your email
                                   </span>
                                    <div className="LoginInput" data-validate="Username is required">
                                            <span className="LoginInputLabel">
                                                Pin Code
                                            </span>
                                                    <div>
                                                        <input
                                                            className="innerInput validate"
                                                            type="text"
                                                            name="token"
                                                            placeholder="Enter pin code"
                                                            onChange={this.handleChange}
                                                        />

                                                    </div>
                                                    <span className="loginError">{this.state.emailError}</span>
                                                </div>

                                                <div className="wrapper-btn">

                                                    <button className="Login-btn" id={"loginBTN_less_rounded"} type="submit" >
                                                        Reset password
                                                    </button>

                                                </div>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default EmailSent;