import React, { Component } from "react";
// import logo from "./imagesRegister/ID2.png";
import Button from '@material-ui/core/Button';
import "../Register.css"

class OrganisationAbout extends Component {
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
                {/* <div className="header">
                    <div className="image">
                        <img id="ID" src={logo} alt=""/>
                    </div>

                </div> */}
                <div className="container" >

                 <form className="form">
                     <div className="top">
                         <h4> Registration | Organisation | About</h4>
                     </div>
                    <div >
                        <label></label>

                        <input type="slogan"
                        className="control" 
                        placeholder="Slogan" 
                        onChange={handleChange("slogan")}
                        defaultValue={values.slogan}
                        />
                    </div>

                    <div >
                        <label></label>
                        <input type="sector" 
                        className="control" 
                        placeholder="Sector" 
                        onChange={handleChange("sector")}
                        defaultValue={values.sector}
                        />
                    </div>

                    <div >
                        <label></label>
                        <input type="description"
                         className="control" 
                         placeholder="Description"
                         onChange={handleChange("description")}
                        defaultValue={values.description} 
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
                </div>
            </div>
        );
    }

}

export default OrganisationAbout