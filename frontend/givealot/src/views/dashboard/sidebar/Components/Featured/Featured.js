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
            Users: []
        }
    }

    componentDidMount(){
        this.getUsers();
    }

    getUsers(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        axios.get('http://localhost:8080/v1/organisation/get/sectors',  config)
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

    render() {
        const { Users } = this.state
        return (
            <div className="featured">
                <div className="featuredBody">
                    {/*<DashHeader />*/}
                    <div className="featuredTop">
                        <Cards />
                        <Chart data={userData} title="Visits" grid dataKey="Active User"/>
                    </div>
                </div>
            </div>
        )
    }
}

export default Featured
