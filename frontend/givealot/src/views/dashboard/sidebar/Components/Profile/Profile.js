import React, { Component } from 'react'
import "../Profile/Styles/Profile.css"
import {toast, ToastContainer} from "react-toastify";


import {
    CalendarToday, CheckCircleOutlineOutlined,
    MailOutline,
    PermIdentity,
    PhoneAndroid, PieChartOutlined,

} from "@material-ui/icons";
import axios from "axios";
import Axios from "axios";
import * as PropTypes from "prop-types";
import {ApiContext} from "../../../../../apiContext/ApiContext";
import FullPageLoader from "../Report/FullPageLoader";


function CancelOutlinedIcon() {
    return null;
}

CancelOutlinedIcon.propTypes = {className: PropTypes.string};

export class Profile extends Component {

    static contextType = ApiContext;
    constructor(props) {
        super(props)

        this.state = {
            persons:{},
            level: 5,
            orgId:localStorage.getItem("id"),
            //orgId: 75,
            orgEmail:"",
            orgName1:"",
            orgNameState:false,
            orgState:"",
            emailState:false,
            orgDescription1:"",
            orgDescriptionState:false,
            contactNumber1:"",
            ContactNumberState:false,
            slogan1:"",
            sloganState:false,
            contactPerson1:"",
            ContactPersonState:false,
            orgAddress:"",
            addressState:false,
            popUp1:false,
            popUp2:false,
            popUp3:false,
            popUp4:false,
            popUp5:false,
            popUp6:false,
            serverDomain : 'http://localhost:8080',
            loader:false,


        }
    }


    componentDidMount(){
      this.setState({loader: true});


        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        console.log(this.props)
        axios.get(this.state.serverDomain + '/v1/organisation/admin/sel/organisation/'+this.state.orgId, config)
            .then(response =>{
                console.log(response)
                this.setState({persons: response.data.object})
                this.setState({loader: false});
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })

        const dataa = {
            "orgid" : this.state.orgId
        }

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
                .then(res => {
                    console.log(res)
                    this.setState({popUp1: res.data.message});
                    this.onToastEmail();
                })
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
                .then(res => {
                    console.log(res)
                    this.setState({popUp2: res.data.message});
                    this.onToastDes();
                })
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
                .then(res => {
                    console.log(res)
                    this.setState({popUp3: res.data.message});
                    this.onToastCPerson();
                })
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



    onToastEmail = () => {

        if(this.state.popUp1){

            toast.success('Email Updated successful', {
                position: toast.POSITION.TOP_RIGHT

            });
        }else{

            toast.error('failed to update Email', {
                position: toast.POSITION.TOP_RIGHT

            });

        }
    }

    onToastDes = () => {

        if(this.state.popUp2){

            toast.success('Description Updated successful', {
                position: toast.POSITION.TOP_RIGHT

            });
        }else{

            toast.error('failed to update Description', {
                position: toast.POSITION.TOP_RIGHT

            });

        }
    }

    onToastCPerson = () => {

        if(this.state.popUp3){

            toast.success('Contact Person Updated successful', {
                position: toast.POSITION.TOP_RIGHT

            });
        }else{

            toast.error('failed to update Contact Person', {
                position: toast.POSITION.TOP_RIGHT

            });

        }
    }



    /* onToastP = () => {
         if (this.state.orgNameState || this.state.orgDescriptionState || this.state.emailState || this.state.ContactNumberState || this.state.ContactPersonState || this.state.sloganState || this.state.addressState) {
             toast.success('Submit successful', {
                 position: toast.POSITION.TOP_RIGHT

             });
         }
     }*/


    render() {
        const { persons } = this.state

        let status

        if(persons.status) {

            if (persons.status === "active") {
                status = <div className="userShowInfo">
                    <CheckCircleOutlineOutlined className="userShowIcon"/>
                    <span className="userShowInfoTitle">{persons.status}</span>
                </div>
            } else if (persons.status === "suspended") {
                status = <div className="userShowInfo">
                    <CancelOutlinedIcon className="userShowIcon"/>
                    <span className="userShowInfoTitle">{persons.status}</span>
                </div>
            }
        }

        let auto_spinner
        if(this.state.loader){
            auto_spinner=<FullPageLoader />
        }




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
                                        <PermIdentity className="userShowIcon" />
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
                                    <div>
                                        {status}
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
                                    <label>Description</label>
                                    <textarea

                                        name="orgDescription1"
                                        onChange={this.handleDescription}
                                        placeholder={persons.orgDescription}
                                        className="userUpdateInput1"
                                    />
                                </div>
                            </div>
                            <div className="userUpdateRight">

                                <button className="userUpdateButton" >Update</button>
                            </div>
                            <div className="form-group">
                                <ToastContainer/>
                            </div>
                        </form>
                    </div>
                </div>
                <div className="line">
                    <div className="profile_line"/>
                    <div className="line_title"> Profile Updates </div>
                    <div className="profile_line"/>

                </div>


                { auto_spinner}


            </div>
        )
    }
}

export default Profile
