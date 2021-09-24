import React, { Component } from 'react'
import "./Styles/Featured.css"
import Chart from "./Chart"
import Cards from "./Cards"
// import { userData} from "../../../../../DummyData";
import axios from "axios";
import {ApiContext, ApiUrlProvider} from "../../../../../apiContext/ApiContext";
import Sidebar from '../../Sidebar';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import OrganisationsDash from "../OrganisationsDash/OrganisationsDash";
import Org from "../OrganisationsDash/Org";
import Users from "../Users/Users";
import Reports from "../Report/Reports";
import Calendar from "../Calendar/Calendar";
import Validate from "../Validate/Validate";
import AddOrg from "../OrganisationsDash/AddOrg";
import OrgValidate from "../Validate/OrgValidate";
import OrganisationTimeline from "../Timeline/Timeline";
import Profile from "../Profile/Profile";
import Certificate from "../Certificate/Certificate";
import Upgrade1 from "../Certificate/Upgrade1";
import Upgrade2 from "../Certificate/Upgrade2";
import Upgrade3 from "../Certificate/Upgrade3";
import Upgrade4 from "../Certificate/Upgrade4";
import Upgrade5 from "../Certificate/Upgrade5";
import Upgrade0 from "../Certificate/Upgrade0";
import BlurImages from "../BlurImages/BlurImages";
export class Featured extends Component {

    static contextType = ApiContext;
    constructor(props) {
        super(props)

        this.state = {
            UsersPerMonth: '',
            OrganisationsPerMonth: '',
            userData: [],
            adminUserEmail: localStorage.getItem('curr_user_email'),
            OrgData: [],
            serverDomain: "http://localhost:8080"
        }
    }

    componentDidMount(){
        this.OrganisationsPerMonth();
        this.UsersPerMonth();
    }

    UsersPerMonth(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const UserPerMonth = {
            "adminUserEmail":this.state.adminUserEmail
        }

        axios.post(this.state.serverDomain + '/v1/user/get/num_users/per_month', UserPerMonth, config)
            .then(response =>{
                // console.log(response)
                this.setState({ userData:[
                        {
                            name: "jan",
                            "Registered Users": response.data.object.jan,
                        },
                        {
                            name: "feb",
                            "Registered Users": response.data.object.feb,
                        },
                        {
                            name: "mar",
                            "Registered Users": response.data.object.mar,
                        },
                        {
                            name: "apr",
                            "Registered Users": response.data.object.apr,
                        },
                        {
                            name: "may",
                            "Registered Users": response.data.object.may,
                        },
                        {
                            name: "jun",
                            "Registered Users": response.data.object.jun,
                        },
                        {
                            name: "jul",
                            "Registered Users": response.data.object.jul,
                        },
                        {
                            name: "aug",
                            "Registered Users": response.data.object.aug,
                        },
                        {
                            name: "sept",
                            "Registered Users": response.data.object.sept,
                        },
                        {
                            name: "oct",
                            "Registered Users": response.data.object.oct,
                        },
                        {
                            name: "nov",
                            "Registered Users": response.data.object.nov,
                        },
                        {
                            name: "dec",
                            "Registered Users": response.data.object.dec,
                        }
                    ]

                })

            })
            .catch(error =>{
                this.setState({error : 'Error Retrieving data'})
            })
    }

    OrganisationsPerMonth(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const OrgPerMonth = {
            "adminUserEmail":this.state.adminUserEmail
        }
        axios.post(this.state.serverDomain + '/v1/organisation/get/num_organisations/per_month', OrgPerMonth, config)
            .then(response =>{
                // console.log(response)
                this.setState({ OrgData:[
                        {
                            name: "jan",
                            "Registered Organisations": response.data.object.jan,
                        },
                        {
                            name: "feb",
                            "Registered Organisations": response.data.object.feb,
                        },
                        {
                            name: "mar",
                            "Registered Organisations": response.data.object.mar,
                        },
                        {
                            name: "apr",
                            "Registered Organisations": response.data.object.apr,
                        },
                        {
                            name: "may",
                            "Registered Organisations": response.data.object.may,
                        },
                        {
                            name: "jun",
                            "Registered Organisations": response.data.object.jun,
                        },
                        {
                            name: "jul",
                            "Registered Organisations": response.data.object.jul,
                        },
                        {
                            name: "aug",
                            "Registered Organisations": response.data.object.aug,
                        },
                        {
                            name: "sept",
                            "Registered Organisations": response.data.object.sept,
                        },
                        {
                            name: "oct",
                            "Registered Organisations": response.data.object.oct,
                        },
                        {
                            name: "nov",
                            "Registered Organisations": response.data.object.nov,
                        },
                        {
                            name: "dec",
                            "Registered Organisations": response.data.object.dec,
                        }
                    ]

            })

            })
            .catch(error =>{
                this.setState({error : 'Error Retrieving data'})
            })
    }

    render() {
        const { userData, OrgData } = this.state
        return (
            <div className="featured">

                <div className="featuredBody">
                    <div className="featuredTop">
                        <Cards />
                        <div style={{display: "flex", flexDirection: "column"}}>
                            <div className="dashGraph">
                                <Chart data={userData} title="Users who registered on the system" grid dataKey="Registered Users" />
                            </div>
                            <div className="dashGraph">
                                <Chart data={OrgData} title="Organisations who registered on the system" grid dataKey="Registered Organisations" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default Featured
