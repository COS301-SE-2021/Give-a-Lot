import React, { Component } from 'react'
import "./user.css"
import {
    CalendarToday,
    LocationSearching,
    MailOutline,
    PermIdentity,
    PhoneAndroid,
    // Publish,
  } from "@material-ui/icons";
  // import { Link } from "react-router-dom";

export class User extends Component {

    render() {
        return (
            <div className="usersOrg">
               <div className="usersTitleContainer">
        <h1 className="usersTitle">Edit User</h1>
        {/*<Link to="/newUser">*/}
        {/*  <button className="userAddButton">Create</button>*/}
        {/*</Link>*/}
      </div>
      <div className="usersOrgContainer">
        <div className="usersShow">
          <div className="usersShowTop">
            <img
              src="https://images.pexels.com/photos/1152994/pexels-photo-1152994.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
              alt=""
              className="usersShowImg"
            />
            <div className="usersShowTopTitle">
              <span className="usersShowUsername">Anna Becker</span>
              <span className="usersShowUserTitle">Software Engineer</span>
            </div>
          </div>
          <div className="usersShowBottom">
            <span className="usersShowTitle">Account Details</span>
            <div className="usersShowInfo">
              <PermIdentity className="usersShowIcon" />
              <span className="usersShowInfoTitle">annabeck99</span>
            </div>
            <div className="usersShowInfo">
              <CalendarToday className="usersShowIcon" />
              <span className="usersShowInfoTitle">10.12.1999</span>
            </div>
            <span className="usersShowTitle">Contact Details</span>
            <div className="usersShowInfo">
              <PhoneAndroid className="usersShowIcon" />
              <span className="usersShowInfoTitle">+1 123 456 67</span>
            </div>
            <div className="usersShowInfo">
              <MailOutline className="usersShowIcon" />
              <span className="usersShowInfoTitle">annabeck99@gmail.com</span>
            </div>
            <div className="usersShowInfo">
              <LocationSearching className="usersShowIcon" />
              <span className="usersShowInfoTitle">New York | USA</span>
            </div>
          </div>
        </div>
        {/*<div className="userUpdate">*/}
        {/*  <span className="userUpdateTitle">Edit</span>*/}
        {/*  <form className="userUpdateForm">*/}
        {/*    <div className="userUpdateLeft">*/}
        {/*      <div className="userUpdateItem">*/}
        {/*        <label>Username</label>*/}
        {/*        <input*/}
        {/*          type="text"*/}
        {/*          placeholder="annabeck99"*/}
        {/*          className="userUpdateInput"*/}
        {/*        />*/}
        {/*      </div>*/}
        {/*      <div className="userUpdateItem">*/}
        {/*        <label>Full Name</label>*/}
        {/*        <input*/}
        {/*          type="text"*/}
        {/*          placeholder="Anna Becker"*/}
        {/*          className="userUpdateInput"*/}
        {/*        />*/}
        {/*      </div>*/}
        {/*      <div className="userUpdateItem">*/}
        {/*        <label>Email</label>*/}
        {/*        <input*/}
        {/*          type="text"*/}
        {/*          placeholder="annabeck99@gmail.com"*/}
        {/*          className="userUpdateInput"*/}
        {/*        />*/}
        {/*      </div>*/}
        {/*      <div className="userUpdateItem">*/}
        {/*        <label>Phone</label>*/}
        {/*        <input*/}
        {/*          type="text"*/}
        {/*          placeholder="+1 123 456 67"*/}
        {/*          className="userUpdateInput"*/}
        {/*        />*/}
        {/*      </div>*/}
        {/*      <div className="userUpdateItem">*/}
        {/*        <label>Address</label>*/}
        {/*        <input*/}
        {/*          type="text"*/}
        {/*          placeholder="New York | USA"*/}
        {/*          className="userUpdateInput"*/}
        {/*        />*/}
        {/*      </div>*/}
        {/*    </div>*/}
        {/*    <div className="userUpdateRight">*/}
        {/*      <div className="userUpdateUpload">*/}
        {/*        <img*/}
        {/*          className="userUpdateImg"*/}
        {/*          src="https://images.pexels.com/photos/1152994/pexels-photo-1152994.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"*/}
        {/*          alt=""*/}
        {/*        />*/}
        {/*        <label htmlFor="file">*/}
        {/*          <Publish className="userUpdateIcon" />*/}
        {/*        </label>*/}
        {/*        <input type="file" id="file" style={{ display: "none" }} />*/}
        {/*      </div>*/}
        {/*      <button className="userUpdateButton">Update</button>*/}
        {/*    </div>*/}
        {/*  </form>*/}
        {/*</div>*/}
      </div>
            </div>
        )
    }
}

export default User
