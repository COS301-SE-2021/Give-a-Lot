import React from 'react'
import "./topbarOrg.css";
import logo from "./ID2.png"
import SettingsIcon from '@material-ui/icons/Settings';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import PrintIcon from '@material-ui/icons/Print';
import NotificationsNoneIcon from '@material-ui/icons/NotificationsNone';

export default function TopbarOrg() {
    return (
        <div className="topbar">
            <div className="topbarWrapper">
                <div className="topleft">
                    <span className="logo">
                        <img src={logo} alt="logo" style={{width: "220px", height: "60px"}}/>
                    </span>
                </div>
                <div className="topright">
                    <div className="topbarIconContainer">
                        <NotificationsNoneIcon />
                        <span className="topIconBadge">2</span>
                    </div>
                    <div className="topbarIconContainer">
                        <PrintIcon />
                    </div>
                    <div className="topbarIconContainer">
                    <AccountCircleIcon />
                    </div>
                    <div className="topbarIconContainer">
                        <SettingsIcon />
                    </div>
                </div>
            </div>
        </div>
    )
}
