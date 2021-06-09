import React from 'react';
import "./Login.css";
import LoginBody from "./LoginBody";
import LoginWelcome from "./LoginWelcome";

function Login() {
    return (
        <div className="login">
          
          <div>
                <LoginWelcome />
            </div>
            <div>
                <LoginBody />
            </div>
        </div>
    )
}

export default Login
