import React, { Component } from 'react'
import "../../styles/Organisations.css"

export class OrganisationsBody extends Component {

    render() {
        return (
            <div className="organisations">
                <div className="bodyWrapper">
                    <div className="bodyItem">
                        <div className="cardHeader">
                            <span>Name here</span>
                            <span>5</span>
                        </div>
                        <div className="bodyContainer">
                            <span className="emailBody">email@gmail.com</span>
                        </div>
                        <div className="bodyButton">
                            <button  className="btn manageButton"> Manage </button>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default OrganisationsBody