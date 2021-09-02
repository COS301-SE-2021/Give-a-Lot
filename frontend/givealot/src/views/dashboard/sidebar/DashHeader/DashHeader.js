import React from 'react';
import Card from '@material-ui/core/Card';
import Typography from '@material-ui/core/Typography';
import "./DashHeader.css"
import SettingsIcon from '@material-ui/icons/Settings';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import Logo from "../../../login/Components/DashLogo"
// import Button from '@material-ui/core/Button';
// import Popover from '@material-ui/core/Popover';
// import PopupState, { bindTrigger, bindPopover } from 'material-ui-popup-state';


function DashHeader()
{
    return(
        <div className="DashHeader">
            <div className="dashHeader">
                <Card style={{height: "65px"}}>
                    <Typography className="iconsAndHeader">
                        <div className="dashHeaderLogo">
                            <Logo />
                        </div>
                        <div className="topRight">
                            <div className="topBarIconContainer">
                                <AccountCircleIcon />
                            </div>
                            <div className="topBarIconContainer">
                                <SettingsIcon style={{marginLeft: "0.5em"}}/>
                            </div>
                        </div>
                    </Typography>
                </Card>

            </div>
        </div>
    );
}

export default DashHeader;