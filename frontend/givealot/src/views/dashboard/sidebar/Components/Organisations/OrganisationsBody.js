import React, { Component } from 'react'
import "../../styles/Organisations.css"
import OrgPop from "./OrgPop"
import Popup from "reactjs-popup";

export class OrganisationsBody extends Component {

    render() {
        return (
            <div className="organisations">
                <div className="bodyWrapper">
                    <div className="bodyItem">
                        <div className="cardHeader">
                            <span>Name here</span>
                            <span className="level levelNumber">5</span>
                        </div>
                        <div className="bodyContainer">
                            <span className="emailBody">email@gmail.com</span>
                        </div>
                        <div className="bodyButton">
                            <Popup modal
                                   position="right"
                                   trigger={<button className="btn manageButton">Manage</button>}
                                >
                                {close => <OrgPop close={close} />}
                            </Popup>

                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default OrganisationsBody