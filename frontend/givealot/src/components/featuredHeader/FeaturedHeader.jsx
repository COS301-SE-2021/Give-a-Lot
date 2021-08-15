import React, { Component } from 'react'
import "./featuredHeader.css"
import logo from "../admin/topbar/ID2.png";

export class FeaturedHeader extends Component {

    render() {
        return (
            <div className="featuredShare">
                <div className="featuredWrapperShare">
                    <div className="featuredLeftShare">
                    <span className="logoShare">
                        <img src={logo} alt="logo" style={{width: "220px", height: "60px"}}/>
                    </span>
                    </div>
                </div>
            </div>
        )
    }
}

export default FeaturedHeader