import React, { Component } from "react";
import "./RegisterUser.css"
class RegisterOrganisation extends Component {
    render() {
        return (
            <div >
                <div className="container" >

                 <form className="form">
                     <div className="top">
                         <h4> Registration | Organisation</h4>
                     </div>
                    <div >
                        <label></label>

                        <input type="name" className="control" placeholder=" Name" />
                    </div>

                    <div >
                        <label></label>
                        <input type="name" className="control" placeholder="Surname" />
                    </div>

                    <div >
                        <label></label>
                        <input type="email" className="control" placeholder="Email" />
                    </div>

                    <div >
                        <label></label>
                        <input type="password" className="control" placeholder="Password" />
                    </div>
                    <div>
                        <button type="submit" className="button">Sign Up</button>
                    </div>

                </form>
                </div>
            </div>
        );
    }

}

export default RegisterOrganisation