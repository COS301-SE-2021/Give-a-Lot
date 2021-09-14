import React, { Component } from "react";
import "../Styles/registerOrganisation.css"
// import { IoPersonOutline } from "react-icons/io5";
import backgroundImg from "../../../../assets/homeBackground.jpg";
import Logo from "../../../login/Components/Logo";
import Success from "./Success";

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
            disabled: false,
        };
    }

    render() {
        const { values, handleChange,handleChangeImage } = this.props;
        return (
            <div className="registerOrganisation" style={this.styles.main}>
                <div id={"banner_filter"}>
                    <Logo/>
                    <div className="registerCard">
                        <div className="wrap">
                            <form className="form1">
                           <span className="headerTag">
                               Please provide a profile photo
                           </span>
                                <div className="input alert-validate">
                                    <span className="inputLabel">
                                        Media
                                    </span>
                                    <div style={{display: "flex"}}>
                                        <input type="file" id="images" name="images"
                                               accept="image/*"
                                               value={values.images}
                                               // onChange={uploadPhoto}
                                               onChange={handleChangeImage('images')}
                                        />
                                    </div>
                                </div>

                                <div className="button">
                                    <div className="formButton">
                                        <button className="about-org-btn"
                                                onClick={this.back}
                                        >
                                            {" "}
                                            back
                                        </button>
                                        <button className="about-org-btn"
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
            </div>
        )
    }
}

export default RegisterOrganisation;
