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
                        <form className="form1">
                       <span className="headerTag">
                           Register Organisation | Media
                       </span>
                            <div className="input alert-validate" data-validate="Username is required">
                                <span className="inputLabel">
                                    Media
                                </span>
                                <div style={{display: "flex"}}>
                                    <input type="file" id="img" name="img" accept="image/*"/>
                                </div>

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
