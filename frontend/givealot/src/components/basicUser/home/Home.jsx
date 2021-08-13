import React, { Component } from 'react'
import "./home.css"
import FeaturedHeader from "../../featuredHeader/FeaturedHeader";
import HomeHeader from "./HomeHeader"
import bodyImage from "./bodyImage.png"

export class Home extends Component {

    render() {
        return (
            <div className="home">
                <HomeHeader />
                <div className="homeContent">
                    <div className="ribbon">
                        <p>Your platform for safe organizations</p>
                    </div>
                    <div className="bodyHome">
                        <div className="mainBody">

                            <div className="images">
                                <img id="body_ID" src={bodyImage} alt=""/>
                            </div>

                            <div className="words">
                                <p className="bigWord">
                                    Where givers live
                                </p>
                                <p className="smallWord">
                                    GiveAlot is a relatively simple idea that is meant
                                    to solve the problem that individuals and organisations
                                    encounter when it comes to verifying the authenticity of
                                    charities and many other different kinds of Organisations.
                                    GiveAlot aims to solve this problem by becoming a central point
                                    of reference for the verification for charities and other kinds of organisations.
                                </p>
                            </div>
                        </div>
                    </div>
                    <button type="submit" className="browse_button">Browse Organisations</button>
                </div>
            </div>
        )
    }
}

export default Home