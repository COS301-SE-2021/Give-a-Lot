import React from 'react'
import "./styles/Sidebar.css"
import {  Link} from "react-router-dom";
import DashboardIcon from '@material-ui/icons/Dashboard';
import PeopleOutlineIcon from '@material-ui/icons/PeopleOutline';
import PersonOutlineIcon from '@material-ui/icons/PersonOutline';
import { useLocation } from "react-router-dom";

function Sidebar(){

    //assigning location variable
    const location = useLocation();

    //destructuring pathname from location
    const { pathname } = location;

    //Javascript split method to get the name of the path in array
    const splitLocation = pathname.split("/");

        return (
            <div className="sidebar">
                <div className="sidebarWrapper">
                    <div className="sidebarMenu">
                        <ul className="sidebarList">
                                {/* Checking the current path name using javascript ternary operator and if true adding active classname to it */}
                            <li className={splitLocation[1] === "featured" ? "active" : ""}>
                                <Link to='/featured' className="link">
                                    <li className="sidebarListItem ">
                                        <DashboardIcon />
                                        Dashboard
                                    </li>
                                </Link>
                            </li>
                            <li className={splitLocation[1] === "organisations" ? "active" : ""}>
                                <Link to='/organisations' className="link">
                                    <li className="sidebarListItem ">
                                        <PeopleOutlineIcon />
                                        Organisations
                                    </li>
                                </Link>
                            </li>
                            <li className={splitLocation[1] === "users" ? "active" : ""}>
                                <Link to='/users' className="link">
                                    <li className="sidebarListItem ">
                                        <PersonOutlineIcon />
                                        Users
                                    </li>
                                </Link>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        )
}

export default Sidebar