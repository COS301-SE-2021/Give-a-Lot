import React, {Component} from 'react'
import "./home.css";
import logo from "../../Admin/topbar/ID2.png"
import SearchIcon from '@material-ui/icons/Search';
import Button from '@material-ui/core/Button';
import MenuIcon from '@material-ui/icons/Menu';
import { Link } from "react-router-dom";

export class HomeHeader extends Component {

        render() {
            return (
                <div className="Hometopbar">
                    <div className="HometopbarWrapper">
                        <div className="Hometopleft">
                    <span className="logo">
                        <img src={logo} alt="logo" style={{width: "220px", height: "60px"}}/>
                    </span>
                        </div>
                        <div className="Hometopright">
                            <div className="HometopbarIconContainer">
                                <Link to="/verifyPage" className="link">
                                    <SearchIcon/>
                                </Link>
                            </div>
                            <div className="HometopbarIconContainer">
                                <Link to="/login" className="link">
                                    <Button variant="outlined" type="submit" className="home_button">
                                        Login
                                    </Button>
                                </Link>

                            </div>
                            <div className="HometopbarIconContainer">
                                <MenuIcon/>
                            </div>
                        </div>
                    </div>
                </div>
            )
        }
    }
export default HomeHeader
