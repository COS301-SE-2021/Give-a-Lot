import React, {useState} from "react"; 
import logo from "../../assets/logo/logo3_1.png";

/* styles import start */
import homeCSS_general from "./Styles/home_general.css";
import homeCSS_tablet from "./Styles/home_tablet.css";
import homeCSS_mobile_portrait from "./Styles/home_mobile.css";
import homeCSS_desktop from "./Styles/home_desktop.css";
/* styles import end  */

import backgroundImg from '../../assets/homeBackground.jpg';
import { Link } from "react-router-dom";
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

    return (
        <div id="banner" style={styles.main}>
            <div id="banner_filter">
                <div id="homeNav">
                    <img id="logo" src={logo} />
                    {btnDisplayText != "Login" ? <Link to="/dashboard"><input className="loginDashBtn" type="button" name={currentUserId} value={btnDisplayText}/></Link> : <Link to="/login"><input className="loginDashBtn" type="button" name={currentUserId} value={btnDisplayText}/></Link> }
                    
                </div>

                <div id="main_content_container">
                    <p id="main_head">safe and verified donations</p>
                    <p id="supporting_head">Your hub for verified charities</p>
                    <div id="main_content_btns">
                       <Link to={"/"}>
                            <input className="main_content_btns_inputTag" type="button" name={currentUserId} value="verify certificate"/>   
                        </Link> 

                        <Link to={"/browse"}>
                            <input className="main_content_btns_inputTag" type="button" name={currentUserId} value="browse organisations"/>
                        </Link>
                    </div>

                </div>
            </div>
        </div>
    )
}

export default Home;