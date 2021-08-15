import React, { Component } from 'react'
import "./orgs.css"
import {
    CalendarToday,
    LocationSearching,
    MailOutline,
    PermIdentity,
    PhoneAndroid,
    Publish,
} from "@material-ui/icons";
// import { Link } from "react-router-dom";

export class Orgs extends Component {

    render() {
        return (
            <div className="Orgs">
                <div className="OrgsTitleContainer">
                    {/*<h1>here is some thing else</h1>*/}
                    <h1 className="OrgsTitle">Edit Organisation</h1>
                    {/*<Link to="/newUser">*/}
                    {/*    <button className="OrgsAddButton">Create</button>*/}
                    {/*</Link>*/}
                </div>
                <div className="OrgsContainer">
                    <div className="OrgsShow">
                        <div className="OrgsShowTop">
                            <img
                                src="https://images.pexels.com/photos/1152994/pexels-photo-1152994.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
                                alt=""
                                className="OrgsShowImg"
                            />
                            <div className="OrgsShowTopTitle">
                                <span className="OrgsShowUsername">Anna Becker</span>
                                <span className="OrgsShowUserTitle">Software Engineer</span>
                            </div>
                        </div>
                        <div className="OrgsShowBottom">
                            <span className="OrgsShowTitle">Account Details</span>
                            <div className="OrgsShowInfo">
                                <PermIdentity className="OrgsShowIcon" />
                                <span className="OrgsShowInfoTitle">annabeck99</span>
                            </div>
                            <div className="OrgsShowInfo">
                                <CalendarToday className="OrgsShowIcon" />
                                <span className="OrgsShowInfoTitle">10.12.1999</span>
                            </div>
                            <span className="OrgsShowTitle">Contact Details</span>
                            <div className="OrgsShowInfo">
                                <PhoneAndroid className="OrgsShowIcon" />
                                <span className="OrgsShowInfoTitle">+1 123 456 67</span>
                            </div>
                            <div className="OrgsShowInfo">
                                <MailOutline className="OrgsShowIcon" />
                                <span className="OrgsShowInfoTitle">annabeck99@gmail.com</span>
                            </div>
                            <div className="OrgsShowInfo">
                                <LocationSearching className="OrgsShowIcon" />
                                <span className="OrgsShowInfoTitle">New York | USA</span>
                            </div>
                        </div>
                    </div>
                    <div className="OrgsUpdate">
                        <span className="OrgsUpdateTitle">Edit</span>
                        <form className="OrgsUpdateForm">
                            <div className="OrgsUpdateLeft">
                                <div className="OrgsUpdateItem">
                                    <label>Username</label>
                                    <input
                                        type="text"
                                        placeholder="annabeck99"
                                        className="userUpdateInput"
                                    />
                                </div>
                                <div className="OrgsUpdateItem">
                                    <label>Full Name</label>
                                    <input
                                        type="text"
                                        placeholder="Anna Becker"
                                        className="OrgsUpdateInput"
                                    />
                                </div>
                                <div className="OrgsUpdateItem">
                                    <label>Email</label>
                                    <input
                                        type="text"
                                        placeholder="annabeck99@gmail.com"
                                        className="OrgsUpdateInput"
                                    />
                                </div>
                                <div className="OrgsUpdateItem">
                                    <label>Phone</label>
                                    <input
                                        type="text"
                                        placeholder="+1 123 456 67"
                                        className="OrgsUpdateInput"
                                    />
                                </div>
                                <div className="OrgsUpdateItem">
                                    <label>Address</label>
                                    <input
                                        type="text"
                                        placeholder="New York | USA"
                                        className="OrgsUpdateInput"
                                    />
                                </div>
                            </div>
                            <div className="OrgsUpdateRight">
                                <div className="OrgsUpdateUpload">
                                    <img
                                        className="userUpdateImg"
                                        src="https://images.pexels.com/photos/1152994/pexels-photo-1152994.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
                                        alt=""
                                    />
                                    <label htmlFor="file">
                                        <Publish className="OrgsUpdateIcon" />
                                    </label>
                                    <input type="file" id="file" style={{ display: "none" }} />
                                </div>
                                <button className="OrgsUpdateButton">Update</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        )
    }
}

export default Orgs
