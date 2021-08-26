import React, { Component } from "react";
import "../Styles/registerOrganisation.css"
// import { IoPersonOutline } from "react-icons/io5";
import backgroundImg from "../../../../assets/homeBackground.jpg";
import Logo from "../../../login/Components/Logo"
import ArrowBackIcon from "@material-ui/icons/ArrowBack";
import {Link} from "react-router-dom";

export class RegisterOrganisation extends Component {
    styles = {
        main: {
            backgroundImage: `url(${backgroundImg})`
        }
    }

    proceed = e => {
        e.preventDefault();
        this.props.nextStep();
    };
    constructor() {
        super();
        this.state = {
            disabled: false
        };
    }


    render() {
        const { values, handleChange, nextStep } = this.props;
        return (
            <div className="registerOrganisation" style={this.styles.main}>
                <Logo/>
                <Link to={"/signUp"}>
                    <ArrowBackIcon style={{color: "white", marginLeft: "30px", fontSize: "xx-large"}}/>
                </Link>
                <div className="registerCard">
                    <div className="wrap">
                        <form className="form">
                       <span className="headerTag">
                           Register Organisation
                       </span>
                            <div className="input alert-validate" >
                                <span className="inputLabel">
                                    Organisation Name
                                </span>
                                <div style={{display: "flex"}}>
                                    {/*<IoPersonOutline className="registerIcon"/>*/}
                                    <input className="input100 validateInput"
                                           type="text" name="orgName"
                                           placeholder="Enter Organisation Name"
                                           required
                                           value={values.orgName}
                                           onChange={handleChange('orgName')}
                                    />
                                    <span style={{float: "right", color: "red"}}><small>{this.props.orgNameError}</small></span>
                                </div>

                            </div>

                            <div className="input alert-validate">
                                <span className="inputLabel">
                                    Email
                                </span>
                                <input className="input100 validateInput"
                                       type="text" name="orgEmail"
                                       placeholder="Enter Organisation Email"
                                       required
                                       value={values.orgEmail}
                                       onChange={handleChange('orgEmail')}
                                />
                                <span style={{float: "right", color: "red"}}><small>{this.props.orgEmailError}</small></span>
                            </div>
                            <div className="input alert-validate">
                                <span className="inputLabel">
                                    Password
                                </span>
                                <input className="input100 validateInput"
                                       required
                                       type="password" name="password"
                                       placeholder="Enter Organisation Password"
                                       value={values.password}
                                       onChange={handleChange('password')}
                                />
                                <span style={{float: "right", color: "red"}}><small>{this.props.passwordError}</small></span>
                            </div>
                            <div className="button">
                                    <div className="formButton ">
                                        <button className="register-btn"
                                                onClick={this.proceed}
                                        >
                                            {" "}
                                            next
                                        </button>
                                    </div>

                            </div>
                        </form>
                        <Link to={"/login"}
                              className="BottomReg">
                            <div style={{padding: "10px 0 0 20px"}}> I'm already a member! Sign In</div>
                        </Link>
                    </div>

                </div>
            </div>
        )
    }
}

export default RegisterOrganisation;