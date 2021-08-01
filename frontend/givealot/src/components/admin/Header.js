import React, { Component } from 'react'
import "./Admin.css"
// import logo from "./imagesRegister/ID2.png";
// import logo from "./imagesRegister/ID2.png"
// import ListItemIcon from "@material-ui/core/ListItemIcon";
// import DashboardIcon from "@material-ui/icons/Dashboard";
// import ListItemText from "@material-ui/core/ListItemText";
// import ListItem from "@material-ui/core/ListItem";
import PrintIcon from '@material-ui/icons/Print';

export class Header extends Component {

    render() {
        return (
            <div>
                <div className="headerAdmin">
                    {/*<div>*/}
                    {/*    <img src={logo} alt="" className="imageAdmin"/>*/}
                    {/*</div>*/}
                    <div className="generate-pdf">
                        <PrintIcon />
                        <h6>Generate pdf</h6>
                    </div>
                </div>
            </div>
        )
    }
}

export default Header
