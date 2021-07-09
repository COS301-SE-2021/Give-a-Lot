import React, { Component } from 'react'
import logo from "./imagesHome/ID2.png";
import bodyImage from "./imagesHome/bodyImage.png";
import "./Home.css"
import SearchIcon from '@material-ui/icons/Search';
import Button from '@material-ui/core/Button';
import MenuIcon from '@material-ui/icons/Menu';
// import {Switch,Route} from "react-router-dom";

export class Home extends Component {
    
    render() {
        return (
            <div className="register">
                <div className="headerHome">
                    <div className="imageHome">
                        <img id="ID" src={logo} alt=""/>
                    </div>
                    <div className="headerRight">
                        <SearchIcon/>
                        <Button variant="contained">Login</Button>
                        <MenuIcon/>
                    </div>

                </div>
                <div className="container" >
                    <div className="slogan">
                        <span>Your Platform for safe Organisations</span>
                    </div>
                    <div className="mainBody">
                        <div className="bodyImage">
                            <img id="ID" src={bodyImage} alt=""/>
                        </div>
                        <div className="bodyWords">
                            <h1>
                                Where Givers Live
                            </h1>
                            <p>
                                GiveAlot is a relatively simple idea that is meant <br/>
                                to solve the problem that individuals and organisations <br/>
                                encounter when it comes to verifying the authenticity of <br/>
                                charities and many other different kinds of Organisations. <br/>
                                GiveAlot aims to solve this problem by becoming a central point <br/>
                                of reference for the verification for charities and other kinds of organisations.
                            </p>
                        </div>
                    </div>
                    <div className="Homebutton">
                        <Button variant="contained">Browse Organisations</Button>
                    </div>
                    
                    {/* <RegisterBack />
                    <Switch>
                            <Route exact path="/registerOrgs" component={RegisterOrganisation} />
                            <Route exact path="/registeruser" component={RegisterUser} />
                    </Switch> */}
                </div>
                
                
            </div>
        )
    }
}

export default Home
