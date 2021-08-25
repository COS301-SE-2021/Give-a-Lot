import React from 'react';
import { Link } from "react-router-dom";
import {IoPersonOutline} from "react-icons/io5";
import "../login/Styles/Login.css";
import backgroundImg from "../../assets/homeBackground.jpg";


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
                                    <input className="innerInput validate" type="text" name="username" placeholder="Type your username" />

                                </div>

                            </div>

                            <div className="LoginInput" data-validate="Username is required">
                                <span className="LoginInputLabel">
                                    Password
                                </span>
                                <input className="innerInput validate" type="text" name="username" placeholder="Type your username" />
                                <span className="focus-input" ></span>
                            </div>

                                <div className="wrapper-btn">
                                    <button className="Login-btn">
                                        Login
                                    </button>
                                </div>

                        </form>

                    </div>

                </div>
            </div>
        </div>
    );
}

export default Login;