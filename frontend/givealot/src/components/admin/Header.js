import React from 'react';
import "./Header.css";
import SearchIcon from '@material-ui/icons/Search';

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

