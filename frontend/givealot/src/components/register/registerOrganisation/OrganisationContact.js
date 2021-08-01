import React, { Component } from "react";
import logo from "./imagesRegister/ID2.png";
import Button from '@material-ui/core/Button';
import "./RegisterOrganisation.css"
import HeaderBack from "../../HeaderBack/HeaderBack"

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
                        <label></label>

                        <input type="contactPerson"
                         className="control" 
                         placeholder="Contact Person"
                         onChange={handleChange("contactPerson")}
                        defaultValue={values.contactPerson}
                          />
                    </div>

                    <div >
                        <label></label>
                        <input type="contactNumber"
                         className="control" 
                         placeholder="Contact Number" 
                         onChange={handleChange("contactNumber")}
                        defaultValue={values.contactNumber}
                         />
                    </div>

                    <div >
                        <label></label>
                        <input type="email"
                         className="control" 
                         placeholder="Email Address" 
                         onChange={handleChange("email")}
                        defaultValue={values.email}
                         />
                    </div>
                    <div>
                    <Button
                        style={{
                            background: "#EE3B55",
                            color: "#FFFFFF",
                            marginRight: "1em"
                        }}
                        label="Back"
                        onClick={this.back}
                        >
                        Back
                    </Button>
                    <Button
                        style={{
                            background: "#991A76",
                            color: "#FFFFFF"
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
                    <div className="gradientOverlay"></div>
                </div>
            </div>
        );
    }

}

export default OrganisationContact