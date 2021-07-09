import React, { Component } from "react";
// import logo from "./imagesRegister/ID2.png";
import "./Register.css"
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
                    <Button type="submit" className="button"
                    onClick={this.proceed}
                    >Proceed</Button>
                </div>

                </form>
</div>

            </div>
        );
    }

}

export default OrganisationBasic