import React, { Component } from "react";
import logo from "./imagesRegister/ID2.png";
import "./Register.css"

class OrganisationMedia extends Component {
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
                         <h4> Registration | Organisation | Media</h4>
                     </div>
                     <div className="top">
                         <h4> You are one step away</h4>
                     </div>
                    <div >
                        {/* <label for="img">Select image:</label> */}
                        <input type="file" id="img" name="img" accept="image/*" />
                    </div>

                    <div>
                        <button type="submit" className="button">Register</button>
                    </div>

                </form>
                </div>
            </div>
        );
    }

}

export default OrganisationMedia