import React, { Component } from 'react'
import "./sidebar.css"
import DashboardIcon from '@material-ui/icons/Dashboard';
import PeopleIcon from '@material-ui/icons/People';
import MailOutlineIcon from '@material-ui/icons/MailOutline';
import CalendarTodayIcon from '@material-ui/icons/CalendarToday';
import AssignmentIcon from '@material-ui/icons/Assignment';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';

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
                            <li className="sidebarListItem active">
                                <DashboardIcon className="sidebarIcon"/>
                                Dashboard
                            </li>
                            <li className="sidebarListItem">
                                <PeopleIcon className="sidebarIcon"/>
                                Users
                            </li>
                            <li className="sidebarListItem">
                                <PeopleIcon className="sidebarIcon"/>
                                Organisations
                            </li>
                            <li className="sidebarListItem">
                                <MailOutlineIcon className="sidebarIcon"/>
                                Emails
                            </li>
                            <li className="sidebarListItem">
                                <CalendarTodayIcon className="sidebarIcon"/>
                                Calendar
                            </li>
                            <li className="sidebarListItem">
                                <AssignmentIcon className="sidebarIcon"/>
                                TO-DO's
                            </li>
                            <li className="sidebarListItem">
                                <ExitToAppIcon className="sidebarIcon"/>
                                Logout
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        )
    }
}

export default Sidebar
