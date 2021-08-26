import React, { Component } from "react";
import "../Styles/registerOrganisation.css"
// import { IoPersonOutline } from "react-icons/io5";
import backgroundImg from "../../../../assets/homeBackground.jpg";
import Logo from "../../../login/Components/Logo";

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
                <Logo/>
                <div className="registerCard">
                    <div className="wrap">
                        <form className="form">
                       <span className="headerTag">
                           Register Organisation | Contact
                       </span>
                            <div className="input alert-validate" data-validate="Username is required">
                                <span className="inputLabel">
                                    contact Person
                                </span>
                                <div style={{display: "flex"}}>
                                    {/*<IoPersonOutline className="registerIcon"/>*/}
                                    <input className="input100 validateInput"
                                           type="text" name="contactPerson"
                                           placeholder="Enter Organisation Contact Person"
                                           value={values.contactPerson}
                                           onChange={handleChange('contactPerson')}
                                    />
                                    <span style={{float: "right", color: "red"}}><small>{this.props.contactPersonError}</small></span>
                                </div>

                            </div>

                            <div className="input alert-validate">
                                <span className="inputLabel">
                                    Contact Number
                                </span>
                                <input className="input100 validateInput"
                                       type="text" name="contactNumber"
                                       placeholder="Enter Organisation Contact Number"
                                       value={values.contactNumber}
                                       onChange={handleChange('contactNumber')}
                                />
                                <span style={{float: "right", color: "red"}}><small>{this.props.contactNumberError}</small></span>
                            </div>

                            <div className="button">
                                <div className="formButton ">
                                    <button className="register-btn"
                                            onClick={this.back}
                                    >
                                        {" "}
                                        back
                                    </button>
                                    <button className="register-btn"
                                            onClick={this.proceed}
                                    >
                                        {" "}
                                        next
                                    </button>
                                </div>

                            </div>
                        </form>
                    </div>

                </div>
            </div>
        )
    }
}

export default RegisterOrganisation;