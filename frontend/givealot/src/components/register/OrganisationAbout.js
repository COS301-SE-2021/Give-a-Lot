import React, { Component } from "react";
import logo from "./imagesRegister/ID2.png";
import "./Register.css"

class OrganisationAbout extends Component {
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
                         <h4> Registration | Organisation | About</h4>
                     </div>
                    <div >
                        <label></label>

                        <input type="name" className="control" placeholder="Slogan" />
                    </div>

                    <div >
                        <label></label>
                        <input type="name" className="control" placeholder="Sector" />
                    </div>

                    <div >
                        <label></label>
                        <input type="email" className="control" placeholder="Description" />
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

export default OrganisationAbout