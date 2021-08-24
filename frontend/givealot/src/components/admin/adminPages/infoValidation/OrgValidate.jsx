// import React, { Component } from 'react'
// import "./infoValidation.css"
//
//
// export class OrgValidate extends Component {
//
//     render() {
//         return (
//             <div className="emails">
//                 org validate
//             </div>
//         )
//     }
// }
//
// export default OrgValidate

import React, { Component } from 'react'
import "./infoValidation.css"
import {
    CalendarToday,
    LocationSearching,
    MailOutline,
    PermIdentity,
    PhoneAndroid,
    // Publish,
} from "@material-ui/icons";
// import { Link } from "react-router-dom";

export class OrgValidate extends Component {

    render() {
        return (
            <div className="OrgValidate">
                <div className="ValidateTitleContainer">
                    <h1 className="ValidateTitle">Validate Information</h1>
                </div>
                <div className="ValidateContainer">
                    <div className="ValidateShow">
                        <div className="ValidateShowTop">
                            <img
                                src="https://images.pexels.com/photos/1152994/pexels-photo-1152994.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
                                alt=""
                                className="ValidateShowImg"
                            />
                            <div className="ValidateShowTopTitle">
                                <span className="ValidateShowUsername">Anna Becker</span>
                                <span className="ValidateShowUserTitle">Software Engineer</span>
                            </div>
                        </div>
                        <div className="ValidateShowBottom">
                            <span className="ValidateShowTitle">Account Details</span>
                            <div className="ValidateShowInfo">
                                <PermIdentity className="ValidateShowIcon" />
                                <span className="ValidateShowInfoTitle">annabeck99</span>
                            </div>
                            <div className="ValidateShowInfo">
                                <CalendarToday className="ValidateShowIcon" />
                                <span className="ValidateShowInfoTitle">10.12.1999</span>
                            </div>
                            <span className="ValidateShowTitle">Contact Details</span>
                            <div className="ValidateShowInfo">
                                <PhoneAndroid className="ValidateShowIcon" />
                                <span className="ValidateShowInfoTitle">+1 123 456 67</span>
                            </div>
                            <div className="ValidateShowInfo">
                                <MailOutline className="ValidateShowIcon" />
                                <span className="ValidateShowInfoTitle">annabeck99@gmail.com</span>
                            </div>
                            <div className="ValidateShowInfo">
                                <LocationSearching className="ValidateShowIcon" />
                                <span className="ValidateShowInfoTitle">New York | USA</span>
                            </div>
                        </div>
                    </div>

                    <div className="buttonValidate">
                        <button className="ValidateUpdateButton">Accept</button>
                        <button className="ValidateDeleteButton">Deny</button>
                    </div>

                </div>
            </div>
        )
    }
}

export default OrgValidate

