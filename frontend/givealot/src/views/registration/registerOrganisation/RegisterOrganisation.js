import React, { Component } from "react";
import "../registerOrganisation/Styles/registerOrganisation.css";

export class RegisterOrganisation extends Component {
    render() {
        return (
            <div className="registerOrganisation">
               <div className="registerCard">
                   <div className="wrap">
                       <form className="form">
                       <span className="headerTag">
                           Register
                       </span>
                           <div className="input alert-validate" data-validate="Username is required">
                                <span className="inputLabel">
                                    Username
                                </span>
                               <input className="input100 validateInput" type="text" name="username" placeholder="Type your username" />
                               <span className="focus-input100" data-symbol=""></span>
                           </div>

                           <div className="input alert-validate" data-validate="Username is required">
                                <span className="inputLabel">
                                    Password
                                </span>
                               <input className="input100 validateInput" type="text" name="username" placeholder="Type your username" />
                               <span className="focus-input100" data-symbol=""></span>
                           </div>
                           <div className="button">
                               <div className="wrap-btn">
                                   <div className="form-btn"></div>
                                   <button className="register-btn">
                                       Login
                                   </button>
                               </div>
                           </div>
                       </form>

                   </div>

               </div>
            </div>
            )
    }
}

export default RegisterOrganisation;