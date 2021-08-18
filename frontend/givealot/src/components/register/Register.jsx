import "./Register.css"
import FeaturedHeader from "../featuredHeader/FeaturedHeader"
import RegisterBody from "./RegisterBody";
import React from "react";

function Register() {
    return (
        <div className="register">
            <FeaturedHeader />
            <div>
                <RegisterBody />
            </div>
        </div>
    );
}

export default Register;

