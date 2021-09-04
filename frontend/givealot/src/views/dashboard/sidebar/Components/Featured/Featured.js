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
            adminUserEmail: "admin@email.com",

        }
    }

    componentDidMount(){
        this.OrganisationsPerMonth();
        // this.getOrganisations();
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
        axios.post('http://localhost:8080/v1/organisation/get/num_organisations/per_month', OrgPerMonth, config)
            .then(response =>{
                console.log(response)
                this.setState({ userData:[
                        {
                            name: "Jan",
                            "Active User": 0,
                        },
                        {
                            name: "Feb",
                            "Active User": 0,
                        },
                        {
                            name: "Mar",
                            "Active User": 0,
                        },
                        {
                            name: "Apr",
                            "Active User": 0,
                        },
                        {
                            name: "May",
                            "Active User": 0,
                        },
                        {
                            name: "Jun",
                            "Active User": 0,
                        },
                        {
                            name: "Jul",
                            "Active User": 0,
                        },
                        {
                            name: "Aug",
                            "Active User": 0,
                        },
                        {
                            name: "Sep",
                            "Active User": 0,
                        },
                        {
                            name: "Oct",
                            "Active User": 0,
                        },
                        {
                            name: "Nov",
                            "Active User": 0,
                        },
                        {
                            name: "Dec",
                            "Active User": 0,
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
        const { userData } = this.state
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
                                <Chart data={userData} title="Organisations who registered on the system" grid dataKey="Active User" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default Featured
