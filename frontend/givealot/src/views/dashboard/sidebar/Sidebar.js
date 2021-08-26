import React, { Component } from 'react'
import "./styles/Sidebar.css"
import { Link } from "react-router-dom";
import DashboardIcon from '@material-ui/icons/Dashboard';

export class Sidebar extends Component {

    render() {
        return (
            <div className="sidebar">
                <div className="sidebarWrapper">
                    <div className="sidebarMenu">
                        <ul className="sidebarList">
                            <Link to="/organisations" className="link">
                                <li className="sidebarListItem ">
                                    <DashboardIcon className="sidebarIcon"/>
                                    Dashboard
                                </li>
                            </Link>

                        </ul>
                    </div>
                </div>
            </div>
        )
    }
}

export default Sidebar