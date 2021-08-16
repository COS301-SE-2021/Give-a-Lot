import React, { Component } from 'react'
import "./basic.css"
import FeaturedHeader from "../../../featuredHeader/FeaturedHeader";
// import "./RegisterOrganisation.css"
import Button from '@material-ui/core/Button';
// import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import axios from "axios";
import InputAdornment from '@material-ui/core/InputAdornment';
import OutlinedInput from '@material-ui/core/OutlinedInput';
import LockOpenIcon from "@material-ui/icons/LockOpen";
import PersonOutlineIcon from "@material-ui/icons/PersonOutline";

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
                        <p> Registration | Organisation | Info </p>
                    </div>
                    <form className="form">
                        <div >
                            <OutlinedInput type="type"
                               name="orgName" defaultValue={values.orgName}
                               // onChange={this.changeHandler}
                               onChange={handleChange('orgName')}
                               className="input" placeholder=" Name"
                               startAdornment={
                                   <InputAdornment position="start">
                                       <PersonOutlineIcon style={{color:"#4f9ccf"}} />
                                   </InputAdornment>
                               }
                            />
                        </div>

                        <div >
                            <OutlinedInput type="password"
                               name="orgPassword"
                               defaultValue={values.password}
                               // onChange={this.changeHandler}
                               onChange={handleChange('password')}
                               className="inputBasic"
                               placeholder="Password"
                               startAdornment={
                                   <InputAdornment position="start">
                                       <LockOpenIcon className="orgIcon"/>
                                   </InputAdornment>
                               }
                            />
                        </div>

                        {/*<div >*/}
                        {/*    <OutlinedInput type="type"*/}
                        {/*       name="orgPasswordConfirm"*/}
                        {/*       value={orgPasswordConfirm}*/}
                        {/*       onChange={this.changeHandler} className="inputBasic"*/}
                        {/*       placeholder="Confirm Password"*/}
                        {/*       startAdornment={*/}
                        {/*           <InputAdornment position="start">*/}
                        {/*               <LockOpenIcon className="orgIcon"/>*/}
                        {/*           </InputAdornment>*/}
                        {/*       }*/}
                        {/*    />*/}
                        {/*</div>*/}
                        <div>
                            <Button
                                // disabled={this.state.submitting}
                                // disabled={!isEnabled}
                                style={{
                                    background: "#991A76",
                                    color: "#FFFFFF",
                                    // marginLeft: "150px",
                                    alignContent: "center",

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