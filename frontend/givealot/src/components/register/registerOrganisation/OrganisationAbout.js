import React, { Component } from "react";
// import logo from "./imagesRegister/ID2.png";
import Button from '@material-ui/core/Button';
import "./RegisterOrganisation.css"
import HeaderBack from "../../HeaderBack/HeaderBack"

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
                        {/*<label></label>*/}

                        <input type="slogan"
                        className="control" 
                        placeholder="Slogan" 
                        onChange={handleChange("slogan")}
                        defaultValue={values.slogan}
                        />
                    </div>

                    <div >
                        {/*<label></label>*/}
                        <input type="sector" 
                        className="control" 
                        placeholder="Sector" 
                        onChange={handleChange("sector")}
                        defaultValue={values.sector}
                        />
                    </div>

                    <div >
                        <input type="description"
                        id="textContract"
                        // type="text"
                         className="formControlMultiline"
                         placeholder="Description"
                         onChange={handleChange("description")}
                        defaultValue={values.description}
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
                    <div className="gradientOverlay"></div>
                </div>
            </div>
        );
    }

}

export default OrganisationAbout