import React from 'react';
import { Link } from "react-router-dom";
import {IoPersonOutline} from "react-icons/io5";
import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import "./Styles/RegisterUser.css";
import backgroundImg from "../../../assets/homeBackground.jpg";
import Logo from "../../login/Components/Logo";


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
                <Logo/>
                <Link to={"/login"}>
                    <ArrowBackIcon style={{color: "white", marginLeft: "30px", fontSize: "xx-large"}}/>
                </Link>
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
                                    <input className="innerInput validate" type="text" name="username" placeholder="Enter your full name" />

                                </div>

                            </div>



                            <div className="LoginInput" data-validate="surname is required">
                                <span className="LoginInputLabel">
                                    Email
                                </span>
                                <div >
                                    <input className="innerInput validate" type="email" name="Email" placeholder="Enter your Email" />

                                </div>

                            </div>

                            <div className="LoginInput" data-validate="Username is required">
                                <span className="LoginInputLabel">
                                    Password
                                </span>
                                <input className="innerInput validate" type="text" name="username" placeholder="Enter your password" />

                            </div>

                            <div className="wrapper-btn">

                                <Link to={"/login"} className="linker">
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