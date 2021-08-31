import React from 'react'
import "./styles/Sidebar.css"
import {  Link} from "react-router-dom";
import PeopleOutlineIcon from '@material-ui/icons/PeopleOutline';
import PersonOutlineIcon from '@material-ui/icons/PersonOutline';
import AccountCircleOutlinedIcon from '@material-ui/icons/AccountCircleOutlined';
// import EmailOutlinedIcon from '@material-ui/icons/EmailOutlined';
import DashboardOutlinedIcon from '@material-ui/icons/DashboardOutlined';
import ReportOutlinedIcon from '@material-ui/icons/ReportOutlined';
import { useLocation } from "react-router-dom";
import CalendarTodayOutlinedIcon from '@material-ui/icons/CalendarTodayOutlined';
import VerifiedUserOutlinedIcon from '@material-ui/icons/VerifiedUserOutlined';
import Logo from "../../login/Components/DashLogo"

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
                            {/*<div style={{minHeight: "64px"}}>*/}
                                <Logo/>
                            {/*</div>*/}
                            <ul className="MuListPadding MuListRoot">
                                {/* Checking the current path name using javascript ternary operator and if true adding active classname to it */}
                                <li className={splitLocation[1] === "featured" ? "active" : ""} style={{}}>
                                    <Link to='/featured' className="link">
                                        <li className="sidebarListItem ">
                                            <DashboardOutlinedIcon />
                                            <div className="sideIcon" > Dashboard </div>
                                        </li>
                                    </Link>
                                </li>
                                <li className={splitLocation[1] === "organisations" || splitLocation[1] === 'org' ? "active" : ""}>
                                    <Link to='/organisations' className="link">
                                        <li className="sidebarListItem ">
                                            <PeopleOutlineIcon />
                                            <div className="sideIcon" > Organisations </div>
                                        </li>
                                    </Link>
                                </li>
                                <li className={splitLocation[1] === "users" ? "active" : ""}>
                                    <Link to='/users' className="link">
                                        <li className="sidebarListItem ">
                                            <PersonOutlineIcon />
                                            <div className="sideIcon" > Users </div>
                                        </li>
                                    </Link>
                                </li>

                                <li className={splitLocation[1] === "validate" || splitLocation[1] === "orgValidate" ? "active" : ""}>
                                    <Link to='/validate' className="link">
                                        <li className="sidebarListItem ">
                                            <VerifiedUserOutlinedIcon />
                                            <div className="sideIcon" > Validate </div>
                                        </li>
                                    </Link>
                                </li>

                                <li className={splitLocation[1] === "report" ? "active" : ""}>
                                    <Link to='/report' className="link">
                                        <li className="sidebarListItem ">
                                            <ReportOutlinedIcon />
                                            <div className="sideIcon" > Reports </div>
                                        </li>
                                    </Link>
                                </li>

                                <li className={splitLocation[1] === "calendar" ? "active" : ""}>
                                    <Link to='/calendar' className="link">
                                        <li className="sidebarListItem ">
                                            <CalendarTodayOutlinedIcon />
                                            <div className="sideIcon" > Calendar </div>
                                        </li>
                                    </Link>
                                </li>


                                <li className={splitLocation[1] === "profile" ? "active" : ""}>
                                    <Link to='/profile' className="link">
                                        <li className="sidebarListItem ">
                                            <AccountCircleOutlinedIcon />
                                            <div className="sideIcon" > Profile</div>
                                        </li>

                                    </Link>
                                </li>


                                <li className={splitLocation[1] === "certificate" ? "active" : ""}>
                                    <Link to='/certificate' className="link">
                                        <li className="sidebarListItem ">
                                            <VerifiedUserOutlinedIcon />
                                            <div className="sideIcon" > Certificate</div>
                                        </li>

                                    </Link>
                                </li>

                                {/*<li className={splitLocation[1] === "email" ? "active" : ""}>*/}
                                {/*    <Link to='/email' className="link">*/}
                                {/*        <li className="sidebarListItem ">*/}
                                {/*            <EmailOutlinedIcon />*/}
                                {/*            <div className="sideIcon" > Emails </div>*/}
                                {/*        </li>*/}
                                {/*    </Link>*/}
                                {/*</li>*/}

                                {/*<li className={splitLocation[1] === "todos" ? "active" : ""}>*/}
                                {/*    <Link to='/todos' className="link">*/}
                                {/*        <li className="sidebarListItem ">*/}
                                {/*            <ReportOutlinedIcon />*/}
                                {/*            <div className="sideIcon" > Todos </div>*/}
                                {/*        </li>*/}
                                {/*    </Link>*/}
                                {/*</li>*/}
                            </ul>

                        </ul>
                    </div>
                </div>
            </div>
        )
}

export default Sidebar