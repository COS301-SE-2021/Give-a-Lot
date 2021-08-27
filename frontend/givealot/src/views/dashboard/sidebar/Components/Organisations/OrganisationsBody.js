import React, { Component } from 'react'
import "../../styles/Organisations.css"
// import OrgPop from "./OrgPop"
// import Popup from "reactjs-popup";
import { Drawer, Divider, IconButton }
    from '@material-ui/core';
import CreateIcon from '@material-ui/icons/Create';

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
                                <div className="drawerWrapper">
                                    <div className="drawerHeader">
                                        The Givers of Hope
                                    </div>
                                    <div className="drawerBodyNew">
                                        <div className="bodyInfo">
                                            <div className="bodyLeft">
                                                Contact Person
                                            </div>
                                            <div className="bodyRight">
                                                Kids Next Door
                                            </div>
                                        </div>
                                        <div className="bodyInfo">
                                            <div className="bodyLeft">
                                                Contact Number
                                            </div>
                                            <div className="bodyRight">
                                                0856675478
                                            </div>
                                        </div>
                                        <div className="bodyInfo">
                                            <div className="bodyLeft">
                                                Email
                                            </div>
                                            <div className="bodyRight">
                                                kids@gmail.com
                                            </div>
                                        </div>
                                        <div className="bodyInfo">
                                            <div className="bodyLeft">
                                                Level
                                            </div>
                                            <div className="bodyRight">
                                                5
                                            </div>
                                        </div>
                                        <div className="bodyInfo">
                                            <div className="bodyLeft">
                                                Status
                                            </div>
                                            <div className="bodyRight">
                                                <div className="bodyRightContent">
                                                    <div className="bodyRight">
                                                        Active
                                                    </div>
                                                    <div className="bodyRightIcon">
                                                        <IconButton>
                                                            <CreateIcon />
                                                        </IconButton>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div className="manageButton">
                                            <button className="buttonRemove">
                                                Remove
                                            </button>
                                        </div>
                                    </div>

                                </div>
                            </Drawer>

                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default OrganisationsBody