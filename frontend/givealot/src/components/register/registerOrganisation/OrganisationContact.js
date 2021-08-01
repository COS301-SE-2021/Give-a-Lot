import React, { Component } from "react";
// import logo from "./imagesRegister/ID2.png";
import Button from '@material-ui/core/Button';
import "./RegisterOrganisation.css"
import HeaderBack from "../../HeaderBack/HeaderBack"
import OutlinedInput from "@material-ui/core/OutlinedInput";
import InputAdornment from "@material-ui/core/InputAdornment";
import PersonOutlineIcon from "@material-ui/icons/PersonOutline";
import PhoneIcon from '@material-ui/icons/Phone';
import MailOutlineIcon from "@material-ui/icons/MailOutline";

class OrganisationContact extends Component {
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
        const { values, handleChange } = this.props;
        return (
            <div >
               <div className="header">
                   <HeaderBack />
                </div>
                <div className="containerO" >

                 <form className="form">
                     <div className="top">
                         <h4> Registration | Organisation | Contact</h4>
                     </div>
                     <div >
                         <OutlinedInput type="type"
                            name="contactPerson"
                            value={values.contactPerson}
                            onChange={this.changeHandler}
                            className="input" placeholder=" Contact Person"
                            startAdornment={
                                <InputAdornment position="start">
                                    <PersonOutlineIcon style={{color:"#4f9ccf"}} />
                                </InputAdornment>
                            }
                         />
                     </div>

                     <div >
                         <OutlinedInput type="type"
                            name="contactNumber"
                            value={values.contactNumber}
                            onChange={this.changeHandler}
                            className="input" placeholder=" Contact Number"
                            startAdornment={
                                <InputAdornment position="start">
                                    <PhoneIcon style={{color:"#4f9ccf"}} />
                                </InputAdornment>
                            }
                         />
                     </div>

                     <div >
                         <OutlinedInput type="type" name="email"
                            value={values.email} onChange={this.changeHandler}
                            className="input" placeholder="Email"
                            startAdornment={
                                <InputAdornment position="start">
                                    <MailOutlineIcon className="loginIcon"/>
                                </InputAdornment>
                            }
                         />
                     </div>

                    <div>
                        <Button
                            style={{
                                background: "#EE3B55",
                                color: "#FFFFFF",
                                marginLeft: "120px"
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
                                marginLeft: "40px"
                            }}
                            label="Continue"
                            onClick={this.proceed}
                            >
                            {" "}
                            Proceed
                        </Button>
                    </div>

                </form>
                    <div className="gradientOverlay" />
                </div>
            </div>
        );
    }

}

export default OrganisationContact