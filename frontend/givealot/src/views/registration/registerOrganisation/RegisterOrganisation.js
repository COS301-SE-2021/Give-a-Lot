import React, { Component } from "react";
import "../registerOrganisation/Styles/registerOrganisation.css";
import { IoPersonOutline } from "react-icons/io5";

export class RegisterOrganisation extends Component {
    render() {
        return (
            <div className="registerOrganisation">
               <div className="registerCard">
                   <div className="wrap">
                       <form className="form">
                       <span className="headerTag">
                           Register Organisation
                       </span>
                           <div className="input alert-validate" data-validate="Username is required">
                                <span className="inputLabel">
                                    Username
                                </span>
                               <div style={{display: "flex"}}>
                                   <IoPersonOutline className="registerIcon"/>
                                   <input className="input100 validateInput" type="text" name="username" placeholder="Type your username" />
                                   {/*<span className="focus-input100">*/}

                               {/*</span>*/}
                               </div>

                           </div>

                           <div className="input alert-validate" data-validate="Username is required">
                                <span className="inputLabel">
                                    Password
                                </span>
                               <input className="input100 validateInput" type="text" name="username" placeholder="Type your username" />
                               <span className="focus-input100" ></span>
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

                       <p style={{padding: "10px"}}>I'm already a member! <a data-toggle="tab" href="#signin">Sign In</a></p>

                   </div>

               </div>
            </div>
            )
    }
}

export default RegisterOrganisation;