import React, { Component } from "react";
import "../Styles/registerOrganisation.css"
import { IoPersonOutline } from "react-icons/io5";
import backgroundImg from "../../../../assets/homeBackground.jpg";

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
    back = e => {
        e.preventDefault();
        this.props.prevStep();
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
                <div className="registerCard">
                    <div className="wrap">
                        <form className="form">
                       <span className="headerTag">
                           Register Organisation
                       </span>
                            <div className="input alert-validate" data-validate="Username is required">
                                <span className="inputLabel">
                                    Username
                                </span>
                                <div style={{display: "flex"}}>
                                    {/*<IoPersonOutline className="registerIcon"/>*/}
                                    <input className="input100 validateInput"
                                           type="text" name="username"
                                           placeholder="Enter Organisation Name"
                                           value={values.orgName}
                                           onChange={handleChange('orgName')}
                                    />
                                </div>

                            </div>

                            <div className="input alert-validate" data-validate="Username is required">
                                <span className="inputLabel">
                                    Email
                                </span>
                                <input className="input100 validateInput"
                                       type="text" name="username"
                                       placeholder="Enter Organisation Email"
                                       value={values.orgEmail}
                                       onChange={handleChange('orgEmail')}
                                />
                            </div>
                            <div className="input alert-validate" data-validate="Username is required">
                                <span className="inputLabel">
                                    Password
                                </span>
                                <input className="input100 validateInput"
                                       type="text" name="username"
                                       placeholder="Enter Organisation Password"
                                       value={values.password}
                                       onChange={handleChange('password')}
                                />
                            </div>
                            <div className="button">
                                    <div className="formButton ">
                                        <button className="register-btn"
                                                onClick={this.proceed}
                                                label="Continue"
                                        >
                                            {" "}
                                            next
                                        </button>
                                    </div>

                            </div>
                        </form>

                        <p style={{padding: "10px"}}>I'm already a member! <a data-toggle="tab" href="#signin">Sign In</a></p>

                    </div>

                </div>
            </div>
        )
    }
}

export default RegisterOrganisation;