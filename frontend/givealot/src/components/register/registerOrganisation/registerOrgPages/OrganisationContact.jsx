import React, { Component } from 'react'
import "./basic.css"
import FeaturedHeader from "../../../featuredHeader/FeaturedHeader";
// import "./RegisterOrganisation.css"
import Button from '@material-ui/core/Button';
// import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import axios from "axios";
import OutlinedInput from "@material-ui/core/OutlinedInput";
import InputAdornment from "@material-ui/core/InputAdornment";
import PersonOutlineIcon from "@material-ui/icons/PersonOutline";
import PhoneIcon from '@material-ui/icons/Phone';
import MailOutlineIcon from "@material-ui/icons/MailOutline";

export class OrganisationBasic extends Component {

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
                        <p> Registration | Organisation | Contact </p>
                    </div>
                    <form className="form">
                        <div >
                            <OutlinedInput type="text"
                               name="contactPerson"
                               defaultValue={values.contactPerson}
                               // onChange={this.changeHandler}
                               onChange={handleChange('contactPerson')}
                               className="inputBasic" placeholder=" Contact Person"
                               startAdornment={
                                   <InputAdornment position="start">
                                       <PersonOutlineIcon className="orgIcon" />
                                   </InputAdornment>
                               }
                            />
                        </div>

                        <div >
                            <OutlinedInput type="text"
                               name="contactNumber"
                               defaultValue={values.contactNumber}
                               // onChange={this.changeHandler}
                               onChange={handleChange('contactNumber')}
                               className="inputBasic" placeholder=" Contact Number"
                               startAdornment={
                                   <InputAdornment position="start">
                                       <PhoneIcon className="orgIcon" />
                                   </InputAdornment>
                               }
                            />
                        </div>

                        <div >
                            <OutlinedInput type="email" name="email"
                                defaultValue={values.orgEmail}
                               // onChange={this.changeHandler}
                               onChange={handleChange('orgEmail')}
                               className="inputBasic" placeholder="Email"
                               startAdornment={
                                   <InputAdornment position="start">
                                       <MailOutlineIcon className="orgIcon"/>
                                   </InputAdornment>
                               }
                            />
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
                        </div>

                    </form>
                </div>
            </div>
        )
    }
}

export default OrganisationBasic