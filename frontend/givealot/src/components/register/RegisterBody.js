import React, { Component } from "react";
import "./RegisterBody.css";
import logo from "./logo.png";


class RegisterBody extends Component {
   
        render() {
            return (
                <div >
                    
                    <form className="form">
                    <img  src={logo} width="350" height="250" alt=""/>


                        <div >
                            
                             <input type="text" className="control" placeholder="First name" />  <input type="text" className="control" placeholder="First name" /> 
                            
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

                             <button type="submit" className="button">Login</button>
                         </div>
                    
                     </form>
                </div>
            );
        }
    
}

export default RegisterBody
