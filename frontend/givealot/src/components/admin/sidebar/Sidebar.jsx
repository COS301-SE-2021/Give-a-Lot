import React, { Component } from 'react'
import "./sidebar.css"
import DashboardIcon from '@material-ui/icons/Dashboard';
import PeopleOutlineIcon from '@material-ui/icons/PeopleOutline';
// import MailOutlineIcon from '@material-ui/icons/MailOutline';
// import CalendarTodayIcon from '@material-ui/icons/CalendarToday';
// import AssignmentIcon from '@material-ui/icons/Assignment';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';
import PermIdentityIcon from '@material-ui/icons/PermIdentity';
import InfoIcon from '@material-ui/icons/Info';
import { Link } from "react-router-dom";

export class Sidebar extends Component {
    render() {
        return (
            <div className="sidebar">
                <div className="sidebarWrapper">
                    <div className="sidebarMenu">
                        {/* <h3 className="sidebarTitle">
                            DashBoard
                        </h3> */}
                        <ul className="sidebarList">
                            <Link to="/" className="link">
                                <li className="sidebarListItem active">
                                    <DashboardIcon className="sidebarIcon"/>
                                    Dashboard
                                </li>
                            </Link>

                            <Link to="/adminUsers" className="link">
                                <li className="sidebarListItem">
                                    <PermIdentityIcon className="sidebarIcon"/>
                                    Users
                                </li>
                            </Link>

                            <Link to="/adminOrgs" className="link">
                                <li className="sidebarListItem">
                                    <PeopleOutlineIcon className="sidebarIcon"/>
                                    Organisations
                                </li>
                            </Link>

                            <Link to="/infoValidation" className="link">
                                <li className="sidebarListItem">
                                    <InfoIcon className="sidebarIcon"/>
                                    Information Validation
                                </li>
                            </Link>

                            {/*<Link to="/emails" className="link">*/}
                            {/*    <li className="sidebarListItem">*/}
                            {/*        <MailOutlineIcon className="sidebarIcon"/>*/}
                            {/*        Emails*/}
                            {/*    </li>*/}
                            {/*</Link>*/}

                            {/*<Link to="/calendar" className="link">*/}
                            {/*    <li className="sidebarListItem">*/}
                            {/*        <CalendarTodayIcon className="sidebarIcon"/>*/}
                            {/*        Calendar*/}
                            {/*    </li>*/}
                            {/*</Link>*/}

                            {/*<Link to="/todos" className="link">*/}
                            {/*    <li className="sidebarListItem">*/}
                            {/*        <AssignmentIcon className="sidebarIcon"/>*/}
                            {/*        TO-DO's*/}
                            {/*    </li>*/}
                            {/*</Link>*/}

                            <Link to="/logout" className="link">
                                <li className="sidebarListItem">
                                    <ExitToAppIcon className="sidebarIcon"/>
                                    Logout
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