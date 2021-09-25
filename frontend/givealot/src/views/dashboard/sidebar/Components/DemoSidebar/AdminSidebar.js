/*import React from 'react'
import './Side.css'
import {AdminData} from "./AdminData";

function AdminSidebar(){
    return(
        <div className="AdminSidebar">
            <ul className="UnorderedList">
                {AdminData.map((val,key)=>{
                    return(
                        <li
                            key={key}
                            id={window.location.pathname==val.link ? "active" : "y"}
                            onClick={()=>{window.location.pathname= val.link}}
                            className="row"
                        >

                            <div id="sidebarIcon">{ val.icon}</div>
                            <div id="sidebarTitle">{ val.title}</div>
                        </li>
                    )
                })}
            </ul>
        </div>
    )
}
export default AdminSidebar*/


import React from 'react'
import "../../styles/Sidebar.css"
import {  Link} from "react-router-dom";
import PeopleOutlineIcon from '@material-ui/icons/PeopleOutline';
import PersonOutlineIcon from '@material-ui/icons/PersonOutline';
import DashboardOutlinedIcon from '@material-ui/icons/DashboardOutlined';
import { useLocation } from "react-router-dom";
import CalendarTodayOutlinedIcon from '@material-ui/icons/CalendarTodayOutlined';
import VerifiedUserOutlinedIcon from '@material-ui/icons/VerifiedUserOutlined';
import Logo from "../../../../login/Components/DashLogo"
import ExitToAppOutlinedIcon from '@material-ui/icons/ExitToAppOutlined';
import { useHistory } from "react-router-dom";


/////general organisation admin
const roles = localStorage.getItem('role')

function Sidebar(){

    function handleLogOut() {
        localStorage.clear();
        window.location.href = '/';
    }

    let history = useHistory();

    //assigning location variable
    const location = useLocation();

    //destructuring pathname from location
    const { pathname } = location;

    //Javascript split method to get the name of the path in array
    const splitLocation = pathname.split("/");

    function Org(){


    }

    return (
        <div className="sidebar">
            <div className="sidebarWrapper">
                <div className="sidebarMenu">
                    <div className="sidebarList">
                        <Logo/>
                        <div className="MuListPadding MuListRoot">
                            {Org()}
                        </div>

                    </div>
                </div>
            </div>
        </div>
    )
}

export default Sidebar
