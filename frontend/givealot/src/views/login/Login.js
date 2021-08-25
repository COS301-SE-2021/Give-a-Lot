import React from 'react';
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

function Login()
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
                        <form className="LoginForm">
                       <span className="LoginHeader">
                           Sign in
                       </span>
                            <div className="LoginInput" data-validate="Username is required">
                                <span className="LoginInputLabel">
                                    Username
                                </span>
                                <div >
                                    <input className="innerInput validate" type="text" name="username" placeholder="Enter your username" />

                                </div>

                            </div>

                            <div className="LoginInput" data-validate="Username is required">
                                <span className="LoginInputLabel">
                                    Password
                                </span>
                                <input className="innerInput validate" type="text" name="username" placeholder="Enter your password" />
                                <span className="focus-input" ></span>
                            </div>

                                <div className="wrapper-btn">

                                    <Link to={"/"} className="linker">
                                        <button className="Login-btn">
                                            Login
                                        </button>
                                    </Link>
                                </div>

                            <div className="BottomForm">
                                <Link to={"/signUp"} className="BottomLinker">
                                    <span> Need an account?</span>
                                </Link>

                                <Link  className="BottomLinker">
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

export default Login;