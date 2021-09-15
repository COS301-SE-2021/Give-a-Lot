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
    email: "",
    emailError: "",
};

class ResetPassword extends Component {

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
        let emailError = "";

        if (!this.state.email.includes("@")) {
            emailError = "invalid email";
        }


        if ( emailError ) {
            this.setState({ emailError });
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
                email: this.state.email,

            };
            axios.post("http://localhost:8080/v1/login/user/forgot_password", data)
                .then(res => console.log(res))
                .catch(err => console.log(err));


        }
    };

    reset=()=>{
        const isValid = this.validate();
        if (isValid) {
            window.location.assign("/EmailSent");
        }
    }

    render()
    {
        return (
            <div>

                <div className="Login" style={styles.main}>
                    <div  id={"banner_filter"}>
                        <Logo/>
                        <Link to={"/Login"}>
                            <ArrowBackIcon style={{color: "white", marginLeft: "30px", fontSize: "xx-large"}}/>
                        </Link>
                        <div className="LoginCard">
                            <Alert severity="error" id={"badLogin"}>incorrect username or password!</Alert>
                            <div className="wrapper">
                                <form className="LoginForm" onSubmit={this.handleSubmit}>
                       <span className="LoginHeader">
                           Reset your password
                       </span>
                                    <span className="Instruction">
                           We'll email you instructions to reset the password.
                       </span>
                                    <div className="LoginInput" data-validate="Username is required">
                                <span className="LoginInputLabel">
                                    Email
                                </span>
                                        <div>
                                            <input
                                                className="innerInput validate"
                                                type="email"
                                                name="email"
                                                placeholder="Enter your email"
                                                onChange={this.handleChange}
                                            />

                                        </div>
                                        <span className="loginError">{this.state.emailError}</span>
                                    </div>

                                    <div className="wrapper-btn">

                                        <button className="Login-btn" id={"loginBTN_less_rounded"} type="submit" onClick={this.reset}>
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

export default ResetPassword;