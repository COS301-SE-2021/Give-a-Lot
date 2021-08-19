import React from 'react'
import "./basic.css"
import FeaturedHeader from "../../../featuredHeader/FeaturedHeader";
import {Button} from "@material-ui/core";
import { Link } from "react-router-dom";

const Success = () => {
    return (
        <div>
            <FeaturedHeader />
            <div className="RegisterOrganisation">
                <div className="successReg">
                    <h1>Thank you for Registering!</h1>
                    <Link to="/login" className="link">
                        <Button
                            style={{
                                background: "#3C61B8",
                                color: "#FFFFFF",
                                marginRight: "1em"
                            }}
                            label="Continue"
                        >
                            Click to Login
                        </Button>
                    </Link>
                </div>

            </div>

        </div>
    )
}

export default Success