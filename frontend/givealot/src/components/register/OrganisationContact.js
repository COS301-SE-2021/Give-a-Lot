import React, { Component } from "react";
import logo from "./imagesRegister/ID2.png";
import "./Register.css"

class OrganisationContact extends Component {
    render() {
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
                         <h4> Registration | Organisation | Contact</h4>
                     </div>
                    <div >
                        <label></label>

                        <input type="name" className="control" placeholder="Contact Person" />
                    </div>

                    <div >
                        <label></label>
                        <input type="name" className="control" placeholder="Contact Number" />
                    </div>

                    <div >
                        <label></label>
                        <input type="email" className="control" placeholder="Email Address" />
                    </div>
                    <div>
                        <button type="submit" className="button">Prcoceed</button>
                    </div>

                </form>
                </div>
            </div>
        );
    }

}

export default OrganisationContact