import React from 'react'
import "./topbarOrg.css";
import logo from "./ID2.png"
import SettingsIcon from '@material-ui/icons/Settings';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import PrintIcon from '@material-ui/icons/Print';
import NotificationsNoneIcon from '@material-ui/icons/NotificationsNone';

export default function TopbarOrg() {
    return (
        <div className="topbarOrg">
            <div className="topbarWrapperOrg">
                <div className="topleftOrg">
                    <span className="logoOrg">
                        <img src={logo} alt="logo" style={{width: "220px", height: "60px"}}/>
                    </span>
                </div>
                <div className="toprightOrg">
                    <div className="topbarIconContainerOrg">
                        <NotificationsNoneIcon />
                        <span className="topIconBadgeOrg">2</span>
                    </div>
                    <div className="topbarIconContainerOrg">
                        <PrintIcon />
                    </div>
                    <div className="topbarIconContainerOrg">
                    <AccountCircleIcon />
                    </div>
                    <div className="topbarIconContainerOrg">
                        <SettingsIcon />
                    </div>
                </div>
            </div>
        </div>
    )
}
