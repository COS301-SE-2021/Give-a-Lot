import React, { Component } from "react";
import "./UserBody.css";
import logo from "./logo.png";


class UserBody extends Component {
   
        render() {
            return (
                <div className="form">
                    <img  src={logo} width="350" height="250" alt=""/>
                    <div> 
                        <input className="search" type="text" placeholder="Search here" />
                    </div>
                    
                </div>
            );
        }
    
}

export default UserBody
