import React from 'react';
import { Link } from "react-router-dom";
import "../Styles/SignUp.css"

import backgroundImg from "../../../assets/homeBackground.jpg";



const styles = {
    main: {
        backgroundImage: `url(${backgroundImg})`
    }
}

function SignUp()
{
    return (
        <div>
            <div className="signup" style={styles.main}>
                <div className="signupCard">
                    <div className="signupWrapper">
                        <form className="signupForm">
                       <span className="signupHeader">
                           Sign Up
                       </span>

                            <div className="container">
                                <div className="signup-wrapper-btn">

                                    <Link to={"/registerUser"} className="signup-linker">

                                        <input className="signup-btn" type="button" name="user" value="Sign Up as a User"/>
                                    </Link>

                                </div>

                                <div className="signup-wrapper-btn">

                                    <Link to={"/registerOrg"} className="signup-linker">

                                        <input className="signup-btn" type="button" name="org" value="Sign Up as an Organisation"/>
                                    </Link>

                                </div>

                                <div className="terms">
                                    <p>By signing up, you agree to Givealot's </p>
                                    <Link to={"/"} className="BottomLink">
                                        <p>Terms of service and privacy</p>
                                    </Link>
                                </div>

                            </div>

                        </form>

                    </div>

                </div>
            </div>
        </div>
    );
}

export default SignUp;