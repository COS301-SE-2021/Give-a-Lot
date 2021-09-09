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
    uploadPhoto = event => {

        const formData = new FormData();
        formData.append('image', event.target.files[0]);
        formData.append('orgId', this.state.orgId);
        let imageStates = 0;

        alert("take away submit button functionality");

        fetch(
            'http://localhost:8080/v1/organisation/add/logo',
            {
                method: 'POST',
                body: formData,
            }
        )
            .then((response) => response.json())
            .then((result) => {
                console.log('Success:', result);
                imageStates = 1;
            })
            .catch((error) => {
                console.error('Error:', error);
                imageStates = 2;
            });

        if(imageStates===1)
            alert("bring back button functionality");
        else if(imageStates === 2)
            alert("bring back button functionality also tell the user that the image didnt submit");

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
                <div id={"banner_filter"}>
                    <Logo/>
                    <div className="registerCard">
                        <div className="wrap">
                            <form className="form1">
                           <span className="headerTag">
                               Please provide a profile photo
                           </span>
                                <div className="input alert-validate" data-validate="Username is required">
                                    <span className="inputLabel">
                                        Media
                                    </span>
                                    <div style={{display: "flex"}}>
                                        <input type="file" id="img" name="img" accept="image/png" onChange={this.uploadPhoto}/>
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
