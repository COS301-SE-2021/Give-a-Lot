import React, { Component } from 'react'
import "../../styles/Organisations.css"
import {
    CalendarToday,
    LocationSearching,
    MailOutline,
    PermIdentity,
    PhoneAndroid,
    Publish,
} from "@material-ui/icons";

export class Org extends Component {

    render() {
        return (
            <div className="org">
                <div className="OrgContainer">
                    <div className="OrgShow">
                        <div className="OrgShowTop">
                            <img
                                src="https://images.pexels.com/photos/1152994/pexels-photo-1152994.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
                                alt=""
                                className="OrgShowImg"
                            />
                            <div className="OrgShowTopTitle">
                                <span className="OrgShowUsername">Anna Becker</span>
                                <span className="OrgShowUserTitle">Software Engineer</span>
                            </div>
                        </div>
                        <div className="OrgShowBottom">
                            <span className="OrgShowTitle">Account Details</span>
                            <div className="OrgShowInfo">
                                <PermIdentity className="OrgShowIcon" />
                                <span className="OrgShowInfoTitle">annabeck99</span>
                            </div>
                            <div className="OrgShowInfo">
                                <CalendarToday className="OrgShowIcon" />
                                <span className="OrgShowInfoTitle">10.12.1999</span>
                            </div>
                            <span className="OrgShowTitle">Contact Details</span>
                            <div className="OrgShowInfo">
                                <PhoneAndroid className="OrgShowIcon" />
                                <span className="OrgShowInfoTitle">+1 123 456 67</span>
                            </div>
                            <div className="OrgShowInfo">
                                <MailOutline className="OrgShowIcon" />
                                <span className="OrgShowInfoTitle">annabeck99@gmail.com</span>
                            </div>
                            <div className="OrgShowInfo">
                                <LocationSearching className="OrgsShowIcon" />
                                <span className="OrgShowInfoTitle">New York | USA</span>
                            </div>
                        </div>
                    </div>

                    {/*<div className="OrgUpdate">*/}
                    {/*    <span className="OrgUpdateTitle">Edit</span>*/}
                    {/*    <form className="OrgUpdateForm">*/}
                    {/*        <div className="OrgUpdateLeft">*/}
                    {/*            <div className="OrgUpdateItem">*/}
                    {/*                <label>Username</label>*/}
                    {/*                <input*/}
                    {/*                    type="text"*/}
                    {/*                    placeholder="annabeck99"*/}
                    {/*                    className="userUpdateInput"*/}
                    {/*                />*/}
                    {/*            </div>*/}
                    {/*            <div className="OrgUpdateItem">*/}
                    {/*                <label>Full Name</label>*/}
                    {/*                <input*/}
                    {/*                    type="text"*/}
                    {/*                    placeholder="Anna Becker"*/}
                    {/*                    className="OrgUpdateInput"*/}
                    {/*                />*/}
                    {/*            </div>*/}
                    {/*            <div className="OrgUpdateItem">*/}
                    {/*                <label>Email</label>*/}
                    {/*                <input*/}
                    {/*                    type="text"*/}
                    {/*                    placeholder="annabeck99@gmail.com"*/}
                    {/*                    className="OrgUpdateInput"*/}
                    {/*                />*/}
                    {/*            </div>*/}
                    {/*            <div className="OrgUpdateItem">*/}
                    {/*                <label>Phone</label>*/}
                    {/*                <input*/}
                    {/*                    type="text"*/}
                    {/*                    placeholder="+1 123 456 67"*/}
                    {/*                    className="OrgUpdateInput"*/}
                    {/*                />*/}
                    {/*            </div>*/}
                    {/*            <div className="OrgUpdateItem">*/}
                    {/*                <label>Address</label>*/}
                    {/*                <input*/}
                    {/*                    type="text"*/}
                    {/*                    placeholder="New York | USA"*/}
                    {/*                    className="OrgUpdateInput"*/}
                    {/*                />*/}
                    {/*            </div>*/}
                    {/*            <div style={{padding: "0.4em"}}>*/}
                    {/*                <button className="OrgUpdateButton">Update</button>*/}
                    {/*            </div>*/}

                    {/*        </div>*/}

                    {/*    </form>*/}
                    {/*</div>*/}
                </div>
            </div>
        )
    }
}

export default Org