import React, { Component } from 'react'
import "../Profile/Styles/Profile.css"
import Level0 from "./Level0"
import Level1 from "./Level1"
import Level2 from "./Level2"
import Level3 from "./Level3"
import Level4 from "./Level4"


import {
    CalendarToday, CheckCircleOutlineOutlined,
    LocationSearching,
    MailOutline,
    PermIdentity,
    PhoneAndroid, PieChart, PieChartOutlined,
    Publish,
} from "@material-ui/icons";
import axios from "axios";
import Axios from "axios";
import {toast} from "react-toastify";


export class Profile extends Component {

    constructor(props) {
        super(props)

        this.state = {
            persons:"",
            adminId:14,
            orgEmail:"",
            orgName:"",
            orgNameState:false,
            orgState:"",
            emailState:false,
            orgDescription:"",
            orgDescriptionSate:false,
            contactNumber:"",
            contactNumberState:false,
            slogan:"",
            sloganState:false,
            contactPerson:"",
            contactPersonState:false,
            address:"",
            addressState:false,
        }
    }


    componentDidMount() {
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const admin = {
            "adminId" : this.state.adminId
        }
        axios.post('http://localhost:8080/v1/organisation/get/organisations',admin , config)
            .then(response =>{
                console.log(response)
                this.setState({persons: response.data.response[0]})
                console.log(this.state.persons)

            })
            .catch(error =>{
                this.setState({error : 'Error Retrieving data'})
            })

    }

    handleEmail(){
        this.setState({emailState: true});
    }

    handleDescription(){
        this.setState({isDescription: true});
    }

    handleContactNumber(){
        this.setState({contactNumberState: true});
    }
    handleAddress(){
        this.setState({addressState: true});
    }
    handleContactPerson(){
        this.setState({contactPersonState: true});
    }
    handleSlogan(){
        this.setState({contactSloganState: true});
    }

    handleorgName(){
        this.setState({orgNameState: true});
    }


    handleFormSubmit = e => {
        e.preventDefault();

        const data = {

            orgId: this.state.orgId,
            type: "email",
            newValue: this.state.newValue,

        };

        Axios
            .post("http://localhost:8080/v1/organisation/update/info/organisation", data)
            .then(res => console.log(res))
            .catch(err => console.log(err));

    };





    onToast = () => {
        toast.success('Submit successful',{
            position: toast.POSITION.TOP_RIGHT

        });
    }


    render() {
        const { persons } = this.state
        return (
            <div className="profileOrg">
                <div className="userTitleContainer">
                    <div className="userTitle">Edit Information</div>
                </div>
                <div className="userOrgContainer">


                            <div className="userShow">

                                <div className="userShowTop">


                                    <div className="userShowTopTitle">
                                        <span className="userShowUsername">{persons.orgName}</span>
                                        <span className="userShowUserTitle">{persons.slogan} </span>
                                    </div>
                                </div>
                                <div className="userShowBottom">
                                    <span className="userShowTitle">Account Details</span>
                                    <div className="userShowInfo">
                                        <PermIdentity className="userShowIcon" />
                                        <span className="userShowInfoTitle">{persons.orgName}</span>
                                    </div>
                                    <div className="userShowInfo">
                                        <PieChartOutlined className="userShowIcon" />
                                        <span className="userShowInfoTitle">{persons.orgSector}</span>
                                    </div>
                                    <div className="userShowInfo">
                                        <CalendarToday className="userShowIcon" />
                                        <span className="userShowInfoTitle">{persons.dateAdded}</span>
                                    </div>
                                    <span className="userShowTitle">Contact Details</span>

                                    <div className="userShowInfo">
                                        <PhoneAndroid className="userShowIcon" />
                                        <span className="userShowInfoTitle">{persons.contactPerson}</span>
                                    </div>
                                    <div className="userShowInfo">
                                        <PhoneAndroid className="userShowIcon" />
                                        <span className="userShowInfoTitle">{persons.contactNumber}</span>
                                    </div>
                                    <div className="userShowInfo">
                                        <MailOutline className="userShowIcon" />
                                        <span className="userShowInfoTitle">{persons.orgEmail}</span>
                                    </div>

                                    <div className="userShowInfo">
                                        <CheckCircleOutlineOutlined className="userShowIcon" />
                                        <span className="userShowInfoTitle">{persons.status}</span>
                                    </div>
                                    <div className="userShowInfo">
                                        <LocationSearching className="userShowIcon" />
                                        <span className="userShowInfoTitle">Pretoria, arcadia</span>
                                    </div>
                                </div>
                            </div>

                    <div className="userUpdate">
                        <span className="userUpdateTitle">Edit</span>
                        <form className="userUpdateForm" onSubmit={this.handleFormSubmit}>
                            <div className="userUpdateLeft">
                                <div className="userUpdateItem">
                                    <label>Organisation name</label>
                                    <input
                                        type="text"
                                        name="orgName"
                                        placeholder={persons.orgName}
                                        className="userUpdateInput"
                                    />
                                </div>
                                <div className="userUpdateItem">
                                    <label>Contact person</label>
                                    <input
                                        type="text"
                                        name="contactPerson"
                                        placeholder={persons.contactPerson}
                                        className="userUpdateInput"
                                    />
                                </div>
                                <div className="userUpdateItem">
                                    <label>Contacts</label>
                                    <input
                                        type="text"
                                        name="contactNumber"
                                        placeholder={persons.contactNumber}
                                        className="userUpdateInput"
                                    />
                                </div>
                                <div className="userUpdateItem">
                                    <label>Email</label>
                                    <input
                                        type="text"
                                        name="orgEmail"
                                        placeholder={persons.orgEmail}
                                        className="userUpdateInput"
                                    />
                                </div>

                                <div className="userUpdateItem">
                                    <label>Address</label>
                                    <input
                                        type="text"
                                        name="address"
                                        placeholder="Pretoria, arcadia"
                                        className="userUpdateInput"
                                    />
                                </div>

                                <div className="userUpdateItem">
                                    <label>Description</label>
                                    <textarea

                                        type="text"
                                        name="orgDescription"
                                        placeholder={persons.orgDescription}
                                        className="userUpdateInput1"
                                    />
                                </div>
                            </div>
                            <div className="userUpdateRight">

                                <button className="userUpdateButton"  onClick={this.onToast}>Update</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div className="line">
                    <div className="profile_line"/>
                    <div className="line_title"> Certificate Updates </div>
                    <div className="profile_line"/>

                </div>
                <div >
                    <Level0 />
                    <Level1 />

                </div>
                <div >
                    <Level2 />
                    <Level3 />
                </div>
                <div >
                    <Level4 />

                </div>


            </div>
        )
    }
}

export default Profile
