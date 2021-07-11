import React, { Component } from "react";
import logo from "./imagesRegister/ID2.png";
import "./RegisterOrganisation.css"
import Button from '@material-ui/core/Button';

class OrganisationBasic extends Component {
    proceed = e => {
        e.preventDefault();
        this.props.nextStep();
      };
    
      constructor() {
        super();
        this.state = {};
      }
    render() {
        const { values, handleChange } = this.props;
        return (
            <div >
                <div className="header">
                    <div className="image">
                        <img id="ID" src={logo} alt=""/>
                    </div>

                </div>
                <div className="container" >

                <form className="form">
                <div className="top">
                    <h4> Registration | Organisation | Info</h4>
                </div>
                <div >
                    <label></label>

                    <input type="name" 
                    className="control" 
                    placeholder="Name of Organisation"
                    onChange={handleChange("orgName")} 
                    defaultValue={values.orgName}
                    />
                </div>

                <div >
                    <label></label>
                    <input type="name" 
                    className="control" 
                    placeholder="Password" 
                    onChange={handleChange("orgPassword")}
                    defaultValue={values.orgPassword}
                    />
                </div>

                <div >
                    <label></label>
                    <input type="name" 
                    className="control" 
                    placeholder="Confrim Password" 
                    onChange={handleChange("orgPasswordConfirm")}
                    defaultValue={values.orgPasswordConfirm}
                    />
                </div>
                <div>
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
                </div>

                </form>
</div>

            </div>
        );
    }

}

export default OrganisationBasic