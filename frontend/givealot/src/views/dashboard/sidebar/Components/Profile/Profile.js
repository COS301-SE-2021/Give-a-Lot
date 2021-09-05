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
            orgId:32,
            orgEmail:"",
            orgName1:"",
            orgNameState:false,
            orgState:"",
            emailState:false,
            orgDescription1:"",
            orgDescriptionSate:false,
            contactNumber1:"",
            ContactNumberState:false,
            slogan1:"",
            sloganState:false,
            contactPerson1:"",
            ContactPersonState:false,
            orgAddress:"",
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

    handleEmail=event=>{
        this.setState({emailState: true})
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    }

    handleDescription =event=>{
        this.setState({orgDescriptionState: true})
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    }

    handleContactNumber = event=>{
        this.setState({ContactNumberState: true})
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    }
    handleAddress= event =>{
        this.setState({addressState: true})
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    }
    handleContactPerson=event =>{
        this.setState({ContactPersonState: true})
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    }
    handleSlogan=event=>{
        this.setState({sloganState: true})
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    }

    handleOrgName=event=>{
        this.setState({orgNameState: true})
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    }


    handleFormSubmit = e => {
        e.preventDefault();
        if(this.state.emailState) {
            const data1 = {
                orgId: this.state.orgId,
                type: "email",
                newValue: this.state.orgEmail,

            };
            console.log(data1)
            Axios
                .post("http://localhost:8080/v1/organisation/update/info/organisation", data1)
                .then(res => console.log(res))
                .catch(err => console.log(err));
        }
        if(this.state.orgDescriptionState) {
            const data2 = {
                orgId: this.state.orgId,
                type: "description",
                newValue: this.state.orgDescription1,

            };
            console.log(data2)
            Axios
                .post("http://localhost:8080/v1/organisation/update/info/organisation", data2)
                .then(res => console.log(res))
                .catch(err => console.log(err));
        }

        if(this.state.ContactPersonState){
            const data3 = {
                orgId: this.state.orgId,
                type: "contactPerson",
                newValue: this.state.contactPerson1,

            };
            console.log(data3)
            Axios
                .post("http://localhost:8080/v1/organisation/update/info/organisation", data3)
                .then(res => console.log(res))
                .catch(err => console.log(err));
        }

        if(this.state.ContactNumberState) {
            const data4 = {
                orgId: this.state.orgId,
                type: "contactNumber",
                newValue: this.state.contactNumber1,

            };
            console.log(data4)
            Axios
                .post("http://localhost:8080/v1/organisation/update/info/organisation", data4)
                .then(res => console.log(res))
                .catch(err => console.log(err));
        }

        if(this.state.orgNameState) {
            const data5 = {
                orgId: this.state.orgId,
                type: "orgName",
                newValue: this.state.orgName1,

            };
            console.log(data5)
            Axios
                .post("http://localhost:8080/v1/organisation/update/info/organisation", data5)
                .then(res => console.log(res))
                .catch(err => console.log(err));
        }

        if(this.state.addressState) {
            const data6 = {
                orgId: this.state.orgId,
                type: "address",
                newValue: this.state.orgAddress,

            };
            console.log(data6)
            Axios
                .post("http://localhost:8080/v1/organisation/update/info/organisation", data6)
                .then(res => console.log(res))
                .catch(err => console.log(err));
        }


        if(this.state.sloganState) {
            const data7 = {
                orgId: this.state.orgId,
                type: "slogan",
                newValue: this.state.slogan1,

            };
            console.log(data7)
            Axios
                .post("http://localhost:8080/v1/organisation/update/info/organisation", data7)
                .then(res => console.log(res))
                .catch(err => console.log(err));
        }

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
                                        name="orgName1"
                                        placeholder={persons.orgName}
                                        onChange={this.handleOrgName}
                                        className="userUpdateInput"
                                    />
                                </div>
                                <div className="userUpdateItem">
                                    <label>Organisation slogan</label>
                                    <input
                                        type="text"
                                        name="slogan1"
                                        placeholder={persons.slogan}
                                        onChange={this.handleSlogan}
                                        className="userUpdateInput"
                                    />
                                </div>
                                <div className="userUpdateItem">
                                    <label>Contact person</label>
                                    <input
                                        type="text"
                                        name="contactPerson1"
                                        onChange={this.handleContactPerson}
                                        placeholder={persons.contactPerson}
                                        className="userUpdateInput"
                                    />
                                </div>
                                <div className="userUpdateItem">
                                    <label>Contacts</label>
                                    <input
                                        type="text"
                                        name="contactNumber1"
                                        onChange={this.handleContactNumber}
                                        placeholder={persons.contactNumber}
                                        className="userUpdateInput"
                                    />
                                </div>
                                <div className="userUpdateItem">
                                    <label>Email</label>
                                    <input
                                        type="text"
                                        name="orgEmail"
                                        onChange={this.handleEmail}
                                        placeholder={persons.orgEmail}
                                        className="userUpdateInput"
                                    />
                                </div>

                                <div className="userUpdateItem">
                                    <label>Address</label>
                                    <input
                                        type="text"
                                        name="orgAddress"
                                        onChange={this.handleAddress}
                                        placeholder="Pretoria, arcadia"
                                        className="userUpdateInput"
                                    />
                                </div>

                                <div className="userUpdateItem">
                                    <label>Description</label>
                                    <textarea

                                        type="text"
                                        name="orgDescription1"
                                        onChange={this.handleDescription}
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
