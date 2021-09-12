import React, { Component } from "react";
import "../Styles/registerOrganisation.css"
// import { IoPersonOutline } from "react-icons/io5";
import backgroundImg from "../../../../assets/homeBackground.jpg";
import { IoReload } from "react-icons/io5";
import Logo from "../../../login/Components/Logo";
import axios from "axios";
import { Link } from "react-router-dom";

export class Success extends Component {
    styles = {
        main: {
            backgroundImage: `url(${backgroundImg})`
        }
    }

    constructor() {
        super();
        this.state = {
            disabled: false,
            loading: false
        };
    }

    render() {
        const { loading } = this.state;
        return (
            <div className="registerOrganisation" style={this.styles.main}>
                <div  id={"banner_filter"}>
                    <Logo/>
                    <div className="registerCard">
                        <div className="wrap">
                        <form className="form1">
                           <span className="headerTag">
                               Registration was a success
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

export default Success;
