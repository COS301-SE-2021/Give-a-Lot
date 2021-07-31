import React, { Component } from 'react'
import "./Admin.css"
import logo from "./imagesRegister/ID2.png"
// import ListItem from '@material-ui/core/ListItem';
// import ListItemIcon from '@material-ui/core/ListItemIcon';
// import ListItemText from '@material-ui/core/ListItemText';

export class Header extends Component {

    render() {
        return (
            <div>
                <div>
                    <div className="adminHeader">
                        <img src={logo} alt="" className="imageAdmin"/>
                    </div>

                </div>
            </div>
        )
    }
}

export default Header
