import React, { Component } from 'react'
import "./featuredHeader.css"
import logo from "../admin/topbar/ID2.png";

export class FeaturedHeader extends Component {

    render() {
        return (
            <div className="featured">
                <div className="featuredWrapper">
                    <div className="featuredleft">
                    <span className="logo">
                        <img src={logo} alt="logo" style={{width: "220px", height: "60px"}}/>
                    </span>
                    </div>
                </div>
            </div>
        )
    }
}

export default FeaturedHeader