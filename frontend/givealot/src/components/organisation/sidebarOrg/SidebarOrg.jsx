import React, { Component } from 'react'
import "./sidebarOrg.css"
import DashboardIcon from '@material-ui/icons/Dashboard';
import CalendarTodayIcon from '@material-ui/icons/CalendarToday';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';
import PermIdentityIcon from '@material-ui/icons/PermIdentity';
import ImageIcon from '@material-ui/icons/Image';
import AssignmentIcon from '@material-ui/icons/Assignment';
import ReportIcon from '@material-ui/icons/Report';
import VerifiedUserIcon from '@material-ui/icons/VerifiedUser';
import PeopleOutlineIcon from '@material-ui/icons/PeopleOutline';
import { Link } from "react-router-dom";


export class SidebarOrg extends Component {
    render() {
        return (
            <div className="sidebarOrg">
                <div className="sidebarWrapperOrg">
                    <div className="sidebarMenuOrg">
                        {/* <h3 className="sidebarTitle">
                            DashBoard
                        </h3> */}
                        <ul className="sidebarListOrg">
                            <Link to="/" className="link">
                                <li className="sidebarListItemOrg active">
                                    <DashboardIcon className="sidebarIconOrg"/>
                                    Dashboard
                                </li>
                            </Link>

                            <Link to="/adminUsers" className="link">
                                <li className="sidebarListItemOrg">
                                    <PeopleOutlineIcon className="sidebarIconOrg"/>
                                    Users
                                </li>
                            </Link>

                            <Link to="/profile" className="link">
                                <li className="sidebarListItemOrg">
                                    <PermIdentityIcon className="sidebarIconOrg"/>
                                    Profile
                                </li>
                            </Link>

                            <Link to="/gallery" className="link">
                                <li className="sidebarListItemOrg">
                                    <ImageIcon className="sidebarIconOrg"/>
                                    Gallery
                                </li>
                            </Link>

                            <Link to="/calendar" className="link">
                                <li className="sidebarListItemOrg">
                                    <CalendarTodayIcon className="sidebarIconOrg"/>
                                    Calendar
                                </li>
                            </Link>

                            <Link to="/todos" className="link">
                                <li className="sidebarListItemOrg">
                                    <AssignmentIcon className="sidebarIconOrg"/>
                                    To-do's
                                </li>
                            </Link>

                            <Link to="/reports" className="link">
                                <li className="sidebarListItemOrg">
                                    <ReportIcon className="sidebarIconOrg"/>
                                    Reports
                                </li>
                            </Link>

                            <Link to="/certificate" className="link">
                                <li className="sidebarListItemOrg">
                                    <VerifiedUserIcon className="sidebarIconOrg"/>
                                    Certificate
                                </li>
                            </Link>

                            <Link to="/logout" className="link">
                                <li className="sidebarListItemOrg">
                                    <ExitToAppIcon className="sidebarIconOrg"/>
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

export default SidebarOrg
