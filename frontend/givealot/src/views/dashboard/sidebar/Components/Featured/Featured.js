import React, { Component } from 'react'
import "./Styles/Featured.css"
import Chart from "./Chart"
import Cards from "./Cards"
// import { userData} from "../../../../../DummyData";
import axios from "axios";

export class Featured extends Component {

    constructor(props) {
        super(props)

        this.state = {
            UsersPerMonth: '',
            OrganisationsPerMonth: '',
            userData: [],
            adminUserEmail: "basic@gmail.com",
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
            // "orgId" : this.state.orgId
            "adminUserEmail":this.state.adminUserEmail
        }
        axios.post(this.state.serverDomain + '/v1/user/get/num_users/per_month', UserPerMonth, config)
            .then(response =>{
                console.log(response)
                this.setState({ userData:[
                        {
                            name: "jan",
                            "Active User": response.data.object.jan,
                        },
                        {
                            name: "feb",
                            "Active User": response.data.object.feb,
                        },
                        {
                            name: "mar",
                            "Active User": response.data.object.mar,
                        },
                        {
                            name: "apr",
                            "Active User": response.data.object.apr,
                        },
                        {
                            name: "may",
                            "Active User": response.data.object.may,
                        },
                        {
                            name: "jun",
                            "Active User": response.data.object.jun,
                        },
                        {
                            name: "jul",
                            "Active User": response.data.object.jul,
                        },
                        {
                            name: "aug",
                            "Active User": response.data.object.aug,
                        },
                        {
                            name: "sept",
                            "Active User": response.data.object.sept,
                        },
                        {
                            name: "oct",
                            "Active User": response.data.object.oct,
                        },
                        {
                            name: "nov",
                            "Active User": response.data.object.nov,
                        },
                        {
                            name: "dec",
                            "Active User": response.data.object.dec,
                        }
                    ]

                })
                // this.setState({ userData: response.data })
                // console.log(this.state.Users)

            })
            .catch(error =>{
                // console.log(error)
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
            // "orgId" : this.state.orgId
            "adminUserEmail":this.state.adminUserEmail
        }
        axios.post(this.state.serverDomain + '/v1/organisation/get/num_organisations/per_month', OrgPerMonth, config)
            .then(response =>{
                console.log(response)
                this.setState({ OrgData:[
                        {
                            name: "jan",
                            "Active User": response.data.object.jan,
                        },
                        {
                            name: "feb",
                            "Active User": response.data.object.feb,
                        },
                        {
                            name: "mar",
                            "Active User": response.data.object.mar,
                        },
                        {
                            name: "apr",
                            "Active User": response.data.object.apr,
                        },
                        {
                            name: "may",
                            "Active User": response.data.object.may,
                        },
                        {
                            name: "jun",
                            "Active User": response.data.object.jun,
                        },
                        {
                            name: "jul",
                            "Active User": response.data.object.jul,
                        },
                        {
                            name: "aug",
                            "Active User": response.data.object.aug,
                        },
                        {
                            name: "sept",
                            "Active User": response.data.object.sept,
                        },
                        {
                            name: "oct",
                            "Active User": response.data.object.oct,
                        },
                        {
                            name: "nov",
                            "Active User": response.data.object.nov,
                        },
                        {
                            name: "dec",
                            "Active User": response.data.object.dec,
                        }
                    ]

            })
                // this.setState({ userData: response.data })
                // console.log(this.state.Users)

            })
            .catch(error =>{
                // console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    ////////////////////////////////////////



    ////////////////////////////////////////

    render() {
        const { userData, OrgData } = this.state
        return (
            <div className="featured">
                <div className="featuredBody">
                    <div className="featuredTop">
                        <Cards />
                        <div style={{display: "flex", flexDirection: "column"}}>
                            <div className="dashGraph">
                                <Chart data={userData} title="Users who registered on the system" grid dataKey="Active User" />
                            </div>
                            <div className="dashGraph">
                                <Chart data={OrgData} title="Organisations who registered on the system" grid dataKey="Active User" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default Featured
