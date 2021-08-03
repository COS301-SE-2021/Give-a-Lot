import React, { Component } from "react";
// import logo from "./imagesRegister/ID2.png";
import Button from '@material-ui/core/Button';
import "./RegisterOrganisation.css"
import HeaderBack from "../../HeaderBack/HeaderBack"
import OutlinedInput from "@material-ui/core/OutlinedInput";
import InputAdornment from "@material-ui/core/InputAdornment";
// import PersonOutlineIcon from "@material-ui/icons/PersonOutline";
import DescriptionIcon from '@material-ui/icons/Description';
// import {TextField} from "@material-ui/core";

class OrganisationAbout extends Component {
    proceed = e => {
        e.preventDefault();
        this.props.nextStep();
      };
      back = e => {
        e.preventDefault();
        // console.log("here", this.props);
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
                   < HeaderBack />
                </div>
                <div className="containerO" >

                 <form className="form">
                     <div className="top">
                         <h4> Registration | Organisation | About</h4>
                     </div>

                     <div >
                         <OutlinedInput type="type"
                            name="slogan"
                            value={values.slogan}
                            onChange={this.handleChange}
                            className="input" placeholder="Slogan"
                            startAdornment={
                                <InputAdornment position="start">
                                    <DescriptionIcon style={{color:"#4f9ccf"}} />
                                </InputAdornment>
                            }
                         />
                     </div>
                     <div >
                         <OutlinedInput type="type"
                            name="sector"
                            value={values.sector}
                            onChange={this.handleChange}
                            className="input" placeholder="Sector"
                            startAdornment={
                                <InputAdornment position="start">
                                    <DescriptionIcon style={{color:"#4f9ccf"}} />
                                </InputAdornment>
                            }
                         />
                     </div>

                     <div >
                         <OutlinedInput type="type"
                            // label="Multiline"
                            multiline
                            maxRows={50}
                            value={values.description}
                            onChange={this.handleChange}
                            className="input" placeholder="Description"
                            startAdornment={
                                <InputAdornment position="start">
                                    <DescriptionIcon style={{color:"#4f9ccf"}} />
                                </InputAdornment>
                            }
                         />
                     </div>

                    <div >
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
                        {/* <button type="submit" className="button">Prcoceed</button> */}
                    </div>

                </form>
                    <div className="gradientOverlay" />
                </div>
            </div>
        );
    }

}

export default OrganisationAbout