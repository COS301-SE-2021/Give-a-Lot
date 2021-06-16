import React, { Component } from "react";
import "./LoginBody.css";
import logo from "./logo.png";


class LoginBody extends Component {
   
        render() {
            return (
                <div >
                    
                    <form className="form">
                    <img  src={logo} width="350" height="250" alt=""/>
                        <div >
                            <label></label>
                            <input type="email" className="control" placeholder="Enter email" />
                        </div>
    
                        <div >
                            <label></label>
                            <input type="password" className="control" placeholder="Enter password" />
                        </div>

                        <div > 
                            <p ><a className="register" href="#">register</a> <a  className="forgot" href="#"> forget password?</a>   </p>
                        </div>
                        <div>

                             <button type="submit" className="button">Login</button>
                         </div>
                    
                     </form>
                </div>
            );
        }
    
}

export default LoginBody
