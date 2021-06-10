import React, { Component } from "react";
import "./UserBody.css";
import logo from "./logo.png";


class UserBody extends Component {
   
        render() {
            return (
                <div >
                    
                    <form className="form">
                    <img  src={logo} width="350" height="250" alt=""/>
                       
                        <div>

                             <button type="submit" className="button">Login</button>
                         </div>
                    
                     </form>
                </div>
            );
        }
    
}

export default UserBody
