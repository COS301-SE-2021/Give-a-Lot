import React, { Component } from "react";
import logo from "../login/images/logo.png";
import "./HeaderBack.css"
import SettingsIcon from '@material-ui/icons/Settings';

class HeaderBack extends Component {

    constructor(props) {
        super(props)

        this.state = {

        }
    }
    render() {

        return (
            <div>
                <div className="logoImageBack">
                    <img src={logo} alt="" style={{height: "65px"}}/>
                    <SettingsIcon />
                </div>
            </div>
        );
    }

}

export default HeaderBack