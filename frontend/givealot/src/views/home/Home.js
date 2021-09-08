import React, {useEffect, useState} from "react";
import logo from "../../assets/logo/logo3_1.png";
import DashboardIcon from '@material-ui/icons/Dashboard';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
/* styles import start */
import homeCSS_general from "./Styles/home_general.css";
import homeCSS_tablet from "./Styles/home_tablet.css";
import homeCSS_mobile_portrait from "./Styles/home_mobile.css";
import homeCSS_desktop from "./Styles/home_desktop.css";
/* styles import end  */

import backgroundImg from '../../assets/homeBackground.jpg';
import { Link } from "react-router-dom";
import Button from "@material-ui/core/Button";
const styles = {
    main: {
        backgroundImage: `url(${backgroundImg})`
    }
}


/* 
    Note to self: Remember to use Context to update login status
*/
function Home() 
{
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [btnDisplayText, setBtnDisplayText] = useState("Login");
    const [currentUserId, setCurrentUserId] = useState("");

    useEffect(() => {

            if(localStorage.getItem("id") !== undefined && localStorage.getItem("role") !== undefined)
            {
                if(localStorage.getItem("role") === "organisation" || localStorage.getItem("role") === "admin")
                {
                    setBtnDisplayText("dashboard");
                }
                else if(localStorage.getItem("role") === "general")
                {
                    setBtnDisplayText("logout");
                }
                else
                {
                    setBtnDisplayText("login");
                }
            }
        }
        ,[])



    return (
        <div id="banner" style={styles.main}>
            <div id="banner_filter">
                <div id="homeNav">
                    <img id="logo" src={logo} alt={"logo"}/>
                    {
                        btnDisplayText === "dashboard" ?
                        <Link to="/dashboard">
                            <Button className="loginDashBtn" variant={"contained"}
                                    startIcon={<DashboardIcon />}>
                                {btnDisplayText}

                            </Button>
                        </Link>
                            :
                        btnDisplayText === "logout" ?
                        <Link to="/login">
                            <Button className="loginDashBtn" variant={"contained"}
                            startIcon={<ExitToAppIcon />} onClick={() =>{
                                localStorage.clear();
                            }
                            }>
                                {btnDisplayText}
                            </Button>
                        </Link>
                            :
                        <Link to="/login">
                        <Button className="loginDashBtn" variant={"contained"}
                                startIcon={<AccountCircleIcon/>}>
                            {btnDisplayText}
                        </Button>
                        </Link>
                    }
                </div>

                <div id="main_content_container">
                    <p id="main_head">safe and verified donations</p>
                    <p id="supporting_head">Your hub for verified charities</p>
                    <div id="main_content_btns">
                       <Link to={"/verifyCertificate"}>
                           <Button className="main_content_btns_inputTag" variant="contained" name={currentUserId} disableUnderline={true}>
                               verify certificate
                           </Button>
                        </Link>
                        <Link to={"/browse"}>
                            <Button className="main_content_btns_inputTag" variant="contained" name={currentUserId}>
                                browse organisations
                            </Button>
                        </Link>
                    </div>

                </div>
            </div>
        </div>
    )
}

export default Home;