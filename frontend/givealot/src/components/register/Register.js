import React from 'react';
import "./Register.css";
import RegisterBody from "./RegisterBody";
import RegisterJoin from "./RegisterJoin";

function Register() {
    return (
        <div className="Register">
          
          <div>
                <RegisterJoin />
            </div>
            <div>
                <RegisterBody />
            </div>
        </div>
    )
}

export default Register