import React, { Component } from "react";
import { Link } from "react-router-dom";
import "./Styles/RegisterUser.css";
import backgroundImg from "../../../assets/homeBackground.jpg";
import Logo from "../../login/Components/Logo";
import ArrowBackIcon from "@material-ui/icons/ArrowBack";
import axios from "axios";
import UserSuccess from "./UserSuccess"



const styles = {
    main: {
        backgroundImage: `url(${backgroundImg})`
    }
}

const initialState = {
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    fnameError: "",
    lnameError: "",
    emailError: "",
    passwordError: "",
};

class RegisterUser extends Component {

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
        let fnameError = "";
        let lnameError = "";
        let emailError = "";
        let passwordError = "";

        if (!this.state.firstName) {
            fnameError = "first name is required";
        }
        if (!this.state.lastName) {
            lnameError = "Last name is required";
        }

        if (!this.state.email.includes("@")) {
            emailError = "invalid email";
        }

        if(this.state.password.length <8) {
           passwordError="Password must be greater than 8";
        }

        if (emailError || fnameError|| lnameError || passwordError) {
            this.setState({ emailError, fnameError,lnameError, passwordError });
            return false;
        }



        return true;
    };

    Success=()=>{
        const isValid = this.validate();
        if (isValid) {
            window.location.assign("/UserSuccess");
        }
    }


    handleSubmit = event => {
        event.preventDefault();
        const isValid = this.validate();
        if (isValid) {
            console.log(this.state);
            // clear form
            //this.setState(initialState);
            const data = {
                firstName: this.state.firstName,
                lastName: this.state.lastName,
                email: this.state.email,
                password: this.state.password,
            };
            axios.post("http://localhost:8080/v1/user/register/user", data)
                .then(res => console.log(res))
                .catch(err => console.log(err));


        }
    };

render() {
    return (
        <div>
            <div className="registerUser" style={styles.main}>
                <div  id={"banner_filter"}>
                    <Logo/>
                    <Link to={"/signUp"}>
                        <ArrowBackIcon style={{color: "white", marginLeft: "30px", fontSize: "xx-large"}}/>
                    </Link>
                    <div className="registerUserCard">
                        <div className="wrapp">
                            <form className="registerUserForm" onSubmit={this.handleSubmit}>
                               <span className="registerUserHeader">
                                   Sign Up
                               </span>

                                <div className="names">
                                    <div className="registerUserInput1" data-validate="Username is required">
                                        <span className="registerUserInputLabel">
                                            First Name
                                        </span>
                                        <div>
                                            <input
                                                className="nameFields validate"
                                                type="text"
                                                name="firstName"
                                                placeholder="Enter your first name"
                                                onChange={this.handleChange}
                                            />
                                        </div>
                                        <span className="error">{this.state.fnameError}</span>
                                    </div>

                                    <div className="registerUserInput1" data-validate="Username is required">
                                    <span className="registerUserInputLabel">
                                        Last Name
                                    </span>
                                        <div>
                                            <input
                                                className="nameFields validate"
                                                type="text"
                                                name="lastName"
                                                placeholder="Enter your last name"
                                                onChange={this.handleChange}
                                            />
                                        </div>
                                        <span className="error">{this.state.lnameError}</span>
                                    </div>

                                </div>

                                <div className="registerUserInput" data-validate="surname is required">
                                    <span className="registerUserInputLabel">
                                        Email
                                    </span>
                                    <div>
                                        <input
                                            className="registerUserInnerInput validate"
                                            type="email"
                                            name="email"
                                            placeholder="Enter your Email"
                                           // value={this.state.email}
                                            onChange={this.handleChange}/>

                                    </div>
                                    <span className="error">{this.state.emailError}</span>
                                </div>


                                <div className="registerUserInput" data-validate="Username is required">
                                    <span className="registerUserInputLabel">
                                        Password
                                    </span>
                                    <div>
                                    <input
                                        className="registerUserInnerInput validate"
                                        type="password"
                                        name="password"
                                        minLength="8"
                                        maxLength="15"
                                        placeholder="Enter your password"
                                        //pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
                                        //value={this.state.password}
                                        onChange={this.handleChange}
                                    />
                                </div>
                                    <span className="error">{this.state.passwordError}</span>
                                </div>

                                <div className="wrapp-btn">
                                    <button className="registerUser-btn" type="submit" onClick={this.Success}>
                                        Sign Up
                                    </button>

                                    {/* <Link to={"/login"} className="registerUserLinker">
                                        <button className="registerUser-btn">
                                            Sign Up
                                        </button>
                                    </Link>*/}
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
export default RegisterUser;
