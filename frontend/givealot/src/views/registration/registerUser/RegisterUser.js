import React from 'react';
import { Link } from "react-router-dom";
import {IoPersonOutline} from "react-icons/io5";
import "./Styles/RegisterUser.css";
import backgroundImg from "../../../assets/homeBackground.jpg";


const styles = {
    main: {
        backgroundImage: `url(${backgroundImg})`
    }
}

function RegisterUser()
{
    return (
        <div>
            <div className="Login" style={styles.main}>
                <div className="LoginCard">
                    <div className="wrapper">
                        <form className="LoginForm">
                       <span className="LoginHeader">
                           Sign Up
                       </span>
                            <div className="LoginInput" data-validate="Username is required">
                                <span className="LoginInputLabel">
                                    Name
                                </span>
                                <div >
                                    <input className="innerInput validate" type="text" name="username" placeholder="Type your full name" />

                                </div>

                            </div>



                            <div className="LoginInput" data-validate="surname is required">
                                <span className="LoginInputLabel">
                                    Email
                                </span>
                                <div >
                                    <input className="innerInput validate" type="email" name="Email" placeholder="Type your Email" />

                                </div>

                            </div>

                            <div className="LoginInput" data-validate="Username is required">
                                <span className="LoginInputLabel">
                                    Password
                                </span>
                                <input className="innerInput validate" type="text" name="username" placeholder="Type your password" />

                            </div>

                            <div className="wrapper-btn">

                                <Link to={"/"} className="linker">
                                    <button className="Login-btn" >
                                        Sign Up
                                    </button>
                                </Link>
                            </div>


                        </form>

                    </div>

                </div>
            </div>
        </div>
    );
}

export default RegisterUser;