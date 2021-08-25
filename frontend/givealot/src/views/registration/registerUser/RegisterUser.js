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
    name: "",
    email: "",
    password: "",
    nameError: "",
    emailError: "",
    passwordError: ""
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
        let nameError = "";
        let emailError = "";
        // let passwordError = "";

        if (!this.state.name) {
            nameError = "Name is required";
        }

        if (!this.state.email.includes("@")) {
            emailError = "invalid email";
        }

        if (emailError || nameError) {
            this.setState({ emailError, nameError });
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
                                    Name
                                </span>
                                <div>
                                    <input
                                        className="registerUserInnerInput validate"
                                        type="text"
                                        name="name"
                                        placeholder="Enter your full name"
                                        //value={this.state.name}
                                        onChange={this.handleChange}
                                    />
                                </div>

                            </div>
                            <div className="error">{this.state.nameError}</div>


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

                            </div>
                            <div className="error">{this.state.emailError}</div>

                            <div className="registerUserInput" data-validate="Username is required">
                                <span className="registerUserInputLabel">
                                    Password
                                </span>
                                <input
                                    className="registerUserInnerInput validate"
                                    type="password"
                                    name="password"
                                    placeholder="Enter your password"
                                    //value={this.state.password}
                                    onChange={this.handleChange}
                                />
                            </div>
                            <div className="error">{this.state.passwordError}</div>

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
