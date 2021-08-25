import React, { Component } from "react";
import { Link } from "react-router-dom";
//import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import "./Styles/RegisterUser.css";
import backgroundImg from "../../../assets/homeBackground.jpg";
import Logo from "../../login/Components/Logo";



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

        if(this.state.password.length <4) {
           passwordError="Password must be greater than 4";
        }

        if (emailError || fnameError|| lnameError || passwordError) {
            this.setState({ emailError, fnameError,lnameError, passwordError });
            return false;
        }



        return true;
    };


    handleSubmit = event => {
        event.preventDefault();
        const isValid = this.validate();
        if (isValid) {
            console.log(this.state);
            // clear form
            this.setState(initialState);
        }
    };

render() {
    return (
        <div>
            <div className="registerUser" style={styles.main}>
                <Logo/>
                <div className="registerUserCard">
                    <div className="wrapp">

                        <form className="registerUserForm" onSubmit={this.handleSubmit}>
                           <span className="registerUserHeader">
                               Sign Up
                           </span>
                            <div className="registerUserInput" data-validate="Username is required">
                                <span className="registerUserInputLabel">
                                    First Name
                                </span>
                                <div>
                                    <input
                                        className="registerUserInnerInput validate"
                                        type="text"
                                        name="firstName"
                                        placeholder="Enter your first name"
                                        //value={this.state.name}
                                        onChange={this.handleChange}
                                    />
                                </div>
                                <span className="error">{this.state.fnameError}</span>
                            </div>


                            <div className="registerUserInput" data-validate="Username is required">
                                <span className="registerUserInputLabel">
                                    Last Name
                                </span>
                                <div>
                                    <input
                                        className="registerUserInnerInput validate"
                                        type="text"
                                        name="lastName"
                                        placeholder="Enter your last name"
                                        //value={this.state.name}
                                        onChange={this.handleChange}
                                    />
                                </div>
                                <span className="error">{this.state.lnameError}</span>
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
                                    placeholder="Enter your password"
                                    //value={this.state.password}
                                    onChange={this.handleChange}
                                />
                            </div>
                                <span className="error">{this.state.passwordError}</span>
                            </div>

                            <div className="wrapp-btn">
                                <button className="registerUser-btn" type="submit">
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
    );
}
}
export default RegisterUser;
