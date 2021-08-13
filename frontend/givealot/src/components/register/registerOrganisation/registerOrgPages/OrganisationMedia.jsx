import React, { Component } from 'react'
import "./basic.css"
import FeaturedHeader from "../../../featuredHeader/FeaturedHeader";
// import "./RegisterOrganisation.css"
import Button from '@material-ui/core/Button';
// import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import axios from "axios";
import OutlinedInput from "@material-ui/core/OutlinedInput";
import InputAdornment from "@material-ui/core/InputAdornment";
// import PersonOutlineIcon from "@material-ui/icons/PersonOutline";
import DescriptionIcon from '@material-ui/icons/Description';

export class OrganisationMedia extends Component {

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
    //   submitting = e => {

    //   };

    // constructor(props) {
    //     super(props)
    //
    //     this.state = {
    //         orgName: "",
    //         orgPassword: "",
    //         orgPasswordConfirm: ""
    //
    //     }
    // }

    changeHandler = (e) =>{
        this.setState({[e.target.name] : e.target.value})
    }

    render() {
        const { values, handleChange } = this.props;
        return (
            <div className="RegisterOrganisation">
                <FeaturedHeader />
                <div className="regOrgContent">
                    <div className="basicTopLine">
                        <p> Registration | Organisation | Media </p>
                    </div>
                    <form className="form">
                        <div style={{paddingBottom: "10px"}}>
                            <label className="btn btn-default p-0">
                                <input type="file" accept="image/*"
                                   // onChange={this.selectFile}
                                />
                            </label>
                        </div>

                        <div style={{display: "flex",alignContent:"center", justifyContent: "space-around"}}>
                            <Button
                                style={{
                                    background: "#EE3B55",
                                    color: "#FFFFFF",
                                    // marginLeft: "120px"
                                }}
                                label="Back"
                                onClick={this.back}
                            >
                                Back
                            </Button>
                            <Button
                                style={{
                                    background: "#991A76",
                                    color: "#FFFFFF",
                                    // marginLeft: "40px"
                                }}
                                label="Continue"
                                onClick={this.proceed}
                            >
                                {" "}
                                Proceed
                            </Button>
                            {/* <button type="submit" className="button">Prcoceed</button> */}
                        </div>

                    </form>
                </div>
            </div>
        )
    }
}

export default OrganisationMedia