// import React from 'react';
// import "./Header.css";

// function Header() {
//     return (
//         <div className="header">
            
//         </div>
//     )
// }

// export default Header

import React from 'react';
import "./Header.css";
import SearchIcon from '@material-ui/icons/Search';
import HomeIcon from '@material-ui/icons/Home';
import FlagIcon from '@material-ui/icons/Flag';
import SubscriptionsOutlinedIcon from '@material-ui/icons/SubscriptionsOutlined';
import StorefrontOutlinedIcon from '@material-ui/icons/StorefrontOutlined';
import SupervisedUserCircleIcon from '@material-ui/icons/SupervisedUserCircle';
import { Avatar, IconButton } from '@material-ui/core';
import AddIcon from "@material-ui/icons/Add";
import ForumIcon from "@material-ui/icons/Forum";
import NotificationsActiveIcon from "@material-ui/icons/NotificationsActive";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";
// import { useStateValue } from "../../StateProvider"

function Header() {
    // const[{user}, dispatch]= useStateValue();
    return (
        <div className="header">
            <div className="header__right">
                {/* <div className="header__info">
                    <Avatar src=""/>
                    <h4>Givealot</h4>
                </div> */}
                <div className="header__input">
                    <SearchIcon/>
                    <input placeholder="search organisation" type="text" />
                </div>
                
            </div>
        </div>
    )
}

export default Header

