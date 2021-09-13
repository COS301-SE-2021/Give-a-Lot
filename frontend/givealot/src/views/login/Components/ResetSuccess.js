import React, { Component } from "react";
import "../../registration/registerOrganisation/Styles/registerOrganisation.css"
import backgroundImg from "../../../assets/homeBackground.jpg"
import Logo from "../Components/Logo"
import { Link } from "react-router-dom";

export class ResetSuccess extends Component {
    styles = {
        main: {
            backgroundImage: `url(${backgroundImg})`
        }
    }

    render() {
        return (
            <div className="registerOrganisation" style={this.styles.main}>
                <div  id={"banner_filter"}>
                    <Logo/>
                    <div className="registerCard">
                        <div className="wrap">
                            <form className="form1">
                           <span className="headerTag1">
                                Email successfully sent
                           </span>
                            <span className="Instruction1">
                                We'll email you instructions to reset the password.
                            </span>
                                <div className="button">
                                    <div className="formButton ">
                                        <Link to={"/login"}>
                                            <button className="register-btn">
                                                {" "}
                                                Login
                                            </button>
                                        </Link>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ResetSuccess;