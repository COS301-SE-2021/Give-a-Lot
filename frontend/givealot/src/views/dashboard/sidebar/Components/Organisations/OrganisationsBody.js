import React, { Component } from 'react'
import "../../styles/Organisations.css"
// import OrgPop from "./OrgPop"
// import Popup from "reactjs-popup";
import { Drawer, Divider, IconButton }
    from '@material-ui/core';



export class OrganisationsBody extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isDrawerOpened: false,
        };
    }
    toggleDrawerStatus = () => {
        this.setState({
            isDrawerOpened: true,
        })
    }
    closeDrawer = () => {
        this.setState({
            isDrawerOpened: false,
        })
    }

    render() {

        const { isDrawerOpened } = this.state;

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
                            {/*<Popup modal*/}
                            {/*       position="right"*/}
                            {/*       trigger={<button className="btn manageButton">Manage</button>}*/}
                            {/*>*/}
                            {/*    {close => <OrgPop close={close} />}*/}
                            {/*</Popup>*/}

                            <button onClick={this.toggleDrawerStatus} className="btn manageButton">
                                {/*{!isDrawerOpened ? <ReorderIcon /> : null }*/}
                                Manage
                            </button>

                            <Drawer
                                variant="temporary"
                                open={isDrawerOpened}
                                onClose={this.closeDrawer}
                                anchor="right"
                            >
                                here are the stuff to manage
                            </Drawer>

                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default OrganisationsBody