import React, { Component } from 'react'
import "./Styles/Featured.css"
import Chart from "./Chart"
import Cards from "./Cards"
import { userData} from "../../../../../DummyData";
import axios from "axios";

export class Featured extends Component {

    constructor(props) {
        super(props)

        this.state = {
            Users: [],
            Organisations: [],
            Reports: [],
        }
    }

    componentDidMount(){
        this.getUsers();
        this.getOrganisations();
        this.getReports();
    }

    getUsers(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        axios.get('http://localhost:8080/v1/user/get/users',  config)
            .then(response =>{
                // console.log(response)
                this.setState({ Users: response.data })
                // console.log(this.state.Users)

            })
            .catch(error =>{
                // console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }
    getOrganisations(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        axios.get('http://localhost:8080/v1/organisation/get/organisations',  config)
            .then(response =>{
                // console.log(response)
                this.setState({ Organisations: response.data })
                // console.log(this.state.Organisations)

            })
            .catch(error =>{
                // console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    getReports(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        axios.get('http://localhost:8080/v1/organisation/get/organisations',  config)
            .then(response =>{
                // console.log(response)
                this.setState({ Reports: response.data })
                // console.log(this.state.Reports)

            })
            .catch(error =>{
                // console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    render() {
        const { Users , Organisations, Reports} = this.state
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
