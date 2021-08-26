import React, {Component} from 'react';
import { Link } from "react-router-dom";
import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import "../login/Styles/Login.css";
import backgroundImg from "../../assets/homeBackground.jpg";
import Logo from "../login/Components/Logo"


const styles = {
    main: {
        backgroundImage: `url(${backgroundImg})`
    }
}

const initialState = {
    username: "",
    password: "",
    usernameError: "",
    passwordError: "",
};

class Login extends Component {

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
        let usernameError = "";
        let passwordError = "";

        if (!this.state.firstName) {
            usernameError = "username is required";
        }


        if(this.state.password.length <4) {
            passwordError="Password must be greater than 4";
        }

        if ( usernameError || passwordError) {
            this.setState({ usernameError, passwordError });
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
    render()
{
    return (
        <div>
            <div className="Login" style={styles.main}>
                <Logo/>
                <Link to={"/"}>
                    <ArrowBackIcon style={{color: "white", marginLeft: "30px", fontSize: "xx-large"}}/>
                </Link>
                <div className="LoginCard">
                    <div className="wrapper">
                        <form className="LoginForm" onSubmit={this.handleSubmit}>
                       <span className="LoginHeader">
                           Sign in
                       </span>
                            <div className="LoginInput" data-validate="Username is required">
                                <span className="LoginInputLabel">
                                    Username
                                </span>
                                <div>
                                    <input
                                        className="innerInput validate"
                                        type="text"
                                        name="username"
                                        placeholder="Enter your username"
                                        onChange={this.handleChange}
                                    />

                                </div>
                                <span className="loginError">{this.state.usernameError}</span>

                            </div>

                            <div className="LoginInput" data-validate="Username is required">
                                <span className="LoginInputLabel">
                                    Password
                                </span>
                                <div>
                                    <input
                                        className="innerInput validate"
                                        type="password"
                                        name="username"
                                        placeholder="Enter your password"
                                        onChange={this.handleChange}
                                    />

                                </div>
                                <span className="loginError">{this.state.passwordError}</span>
                            </div>

                            <div className="wrapper-btn">

                                <button className="Login-btn" type="submit" onClick={this.handleButton}>
                                    Login
                                </button>
                                {/*} <Link to={"/"} className="linker">
                                    <button className="Login-btn">
                                        Login
                                    </button>
                                </Link>*/}
                            </div>

                            <div className="BottomForm">
                                <Link to={"/signUp"} className="BottomLinker">
                                    <span> Need an account?</span>
                                </Link>

                                <Link className="BottomLinker">
                                    <span> Forgot password?</span>
                                </Link>

                            </div>

                        </form>

                    </div>

                </div>
            </div>
        </div>
    );
}
}

export default Login;