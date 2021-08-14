import React, { Component } from 'react'
import "./certificate.css"
import cert from "./stockk.png";


export class Certificate extends Component {

    render() {
        return (
            <div className="certificate">

                <div className="temporary">
                    <img src={cert} alt="cert" style={{width: "220px", height: "60px"}}/>

                </div>
            </div>
        )
    }
}

export default Certificate
