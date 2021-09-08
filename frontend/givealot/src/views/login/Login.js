import React, {Component} from 'react';
import { Link } from "react-router-dom";
import ArrowBackIcon from '@material-ui/icons/ArrowBack';

import backgroundImg from "../../assets/homeBackground.jpg";
import Logo from "../login/Components/Logo";
import axios from "axios"
import "../login/Styles/Login.css";


const styles = {
    main: {
        backgroundImage: `url(${backgroundImg})`
    }
}

const initialState = {
    email: "",
    password: "",
    emailError: "",
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
        let emailError = "";
        let passwordError = "";


        if (!this.state.email.includes("@")) {
            emailError = "invalid email";
        }


        if(this.state.password.length <4) {
            passwordError="Password must be greater than 4";
        }

        if ( emailError || passwordError) {
            this.setState({ emailError, passwordError });
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
            //this.setState(initialState);

            const data = {
                "username" : this.state.email,
                "password" : this.state.password,
                "role" : ""
            }
            localStorage.clear();
            axios.post('http://localhost:8080/v1/login/user/determine', data )
                .then(response =>{
                    console.log(response.data)
                    const loggedUser={
                        "id":response.data.id,
                        "email":response.data.username,
                        "role":response.data.jwttoken
                    }
                    localStorage.setItem( "id" ,response.data.id);
                    localStorage.setItem( "role" ,response.data.jwttoken)

                    if (response.data.jwttoken === "general")
                    {
                        this.props.history.push("/");
                    }else if (response.data.jwttoken === "admin")
                    {
                        this.props.history.push("/dashboard/");
                    }
                    else if (response.data.jwttoken === "organisation"){
                        this.props.history.push("/dashboard/");
                    }
                    else{
                        this.props.history.push("/browse");
                    }
                })
                .catch(error =>{
                    console.log(error)
                    alert("pizza time")
                })
            }


        };

render()
{
    return (
        <div>
            <div className="Login" style={styles.main}>
            <div  id={"banner_filter"}>
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

                            <div className="LoginInput" data-validate="Username is required">
                                <span className="LoginInputLabel">
                                    Password
                                </span>
                                <div>
                                    <input
                                        className="innerInput validate"
                                        type="password"
                                        name="password"
                                        placeholder="Enter your password"
                                        onChange={this.handleChange}
                                    />

                                </div>
                                <span className="loginError">{this.state.passwordError}</span>
                            </div>

                            <div className="wrapper-btn">

                                <button className="Login-btn" id={"loginBTN_less_rounded"} type="submit">
                                    Login
                                </button>
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
        </div>
    );
}
}

export default Login;