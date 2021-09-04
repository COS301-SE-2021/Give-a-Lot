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
                            name: "jan",
                            "Active User": 0,
                        },
                        {
                            name: "feb",
                            "Active User": 0,
                        },
                        {
                            name: "mar",
                            "Active User": 0,
                        },
                        {
                            name: "apr",
                            "Active User": 0,
                        },
                        {
                            name: "may",
                            "Active User": 0,
                        },
                        {
                            name: "jun",
                            "Active User": 0,
                        },
                        {
                            name: "jul",
                            "Active User": 0,
                        },
                        {
                            name: "aug",
                            "Active User": 0,
                        },
                        {
                            name: "sept",
                            "Active User": 0,
                        },
                        {
                            name: "oct",
                            "Active User": 0,
                        },
                        {
                            name: "nov",
                            "Active User": 0,
                        },
                        {
                            name: "dec",
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
