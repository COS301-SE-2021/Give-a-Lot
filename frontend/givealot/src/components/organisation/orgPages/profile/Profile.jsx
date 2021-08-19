import React, { Component } from 'react'
import "./profile.css"
import {
    CalendarToday,
    LocationSearching,
    MailOutline,
    PermIdentity,
    PhoneAndroid,
    Publish,
} from "@material-ui/icons";
import axios from "axios";

export class Profile extends Component {

    constructor(props) {
        super(props)

        this.state = {
            org:[]
        }
    }

    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        axios.get('http://localhost:8080/v1/user/get/users', config)
            .then(response =>{
                console.log(response)
                this.setState({org: response.data.response})
                console.log(this.state.org)
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    render() {
        const { org } = this.state
        return (
            <div className="profileOrg">
                <div className="userTitleContainer">
                    <h1 className="userTitle">Edit Information</h1>
                </div>
                 <div className="userOrgContainer">
                     <div className="userShow">
                        <div className="userShowTop">
                            <img
                                src="https://images.pexels.com/photos/1152994/pexels-photo-1152994.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
                                alt=""
                                className="userShowImg"
                            />
                            <div className="userShowTopTitle">
                                <span className="userShowUsername">Gift of the givers</span>
                                <span className="userShowUserTitle">giving back to the people</span>
                            </div>
                        </div>
                        <div className="userShowBottom">
                            <span className="userShowTitle">Account Details</span>
                            <div className="userShowInfo">
                                <PermIdentity className="userShowIcon" />
                                <span className="userShowInfoTitle">Gift of the givers</span>
                            </div>
                            <div className="userShowInfo">
                                <CalendarToday className="userShowIcon" />
                                <span className="userShowInfoTitle">19.08.2021</span>
                            </div>
                            <span className="userShowTitle">Contact Details</span>

                            <div className="userShowInfo">
                                <PhoneAndroid className="userShowIcon" />
                                <span className="userShowInfoTitle">081 456 675</span>
                            </div>
                            <div className="userShowInfo">
                                <PhoneAndroid className="userShowIcon" />
                                <span className="userShowInfoTitle">081 456 675</span>
                            </div>
                            <div className="userShowInfo">
                                <MailOutline className="userShowIcon" />
                                <span className="userShowInfoTitle">annabeck99@gmail.com</span>
                            </div>
                            <div className="userShowInfo">
                                <LocationSearching className="userShowIcon" />
                                <span className="userShowInfoTitle">Pretoria</span>
                            </div>
                        </div>
                    </div>
                    <div className="userUpdate">
                        <span className="userUpdateTitle">Edit</span>
                        <form className="userUpdateForm">
                            <div className="userUpdateLeft">
                                <div className="userUpdateItem">
                                    <label>Organisation name</label>
                                    <input
                                        type="text"
                                        placeholder="Gift of the givers"
                                        className="userUpdateInput"
                                    />
                                </div>
                                <div className="userUpdateItem">
                                    <label>Contact person</label>
                                    <input
                                        type="text"
                                        placeholder="Tshilidzi Nekhavhambe"
                                        className="userUpdateInput"
                                    />
                                </div>
                                <div className="userUpdateItem">
                                    <label>Contacts</label>
                                    <input
                                        type="text"
                                        placeholder="081 456 675"
                                        className="userUpdateInput"
                                    />
                                </div>
                                <div className="userUpdateItem">
                                    <label>Email</label>
                                    <input
                                        type="text"
                                        placeholder="Givers@gmail.com"
                                        className="userUpdateInput"
                                    />
                                </div>

                                <div className="userUpdateItem">
                                    <label>Address</label>
                                    <input
                                        type="text"
                                        placeholder="Pretoria"
                                        className="userUpdateInput"
                                    />
                                </div>
                            </div>
                            <div className="userUpdateRight">
                                <div className="userUpdateUpload">
                                    <img
                                        className="userUpdateImg"
                                        src="https://images.pexels.com/photos/1152994/pexels-photo-1152994.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
                                        alt=""
                                    />
                                    <label htmlFor="file">
                                        <Publish className="userUpdateIcon" />
                                    </label>
                                    <input type="file" id="file" style={{ display: "none" }} />
                                </div>
                                <button className="userUpdateButton">Update</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        )
    }
}

export default Profile
