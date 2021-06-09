import React, { Component } from "react";
import "./RegisterBody.css";
import logo from "./logo.png";


class RegisterBody extends Component {
   
        render() {
            return (
                <div >
                    
                    <form className="form">
                    <img  src={logo} width="350" height="250" alt=""/>


                        <div className="form-inline">
                            
                             <input type="text" className="control1" placeholder="First name" /> 
                              <input type="text" className="control1" placeholder="Last name" /> 
                            
                        </div>
                        <div >
                          
                            <input type="email" className="control" placeholder="Enter email" />
                        </div>

                        <div >
                            
                            <input type="password" className="control" placeholder="Enter password" />
                        </div>
    
                        <div > 
                            <p ><a href="#">or register an organisation?</a> </p>
                        </div>
                        <div>

                             <button type="submit" className="button">Verify Email</button>
                         </div>
                    
                     </form>
                </div>
            );
        }
    
}

export default RegisterBody
