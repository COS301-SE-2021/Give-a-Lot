import React, { Component } from 'react'
import "./Styles/Featured.css"
import Chart from "./Chart"
import Cards from "./Cards"
import { userData} from "../../../../../DummyData";
import axios from "axios";

export class Featured extends Component {
    render() {
        // const { Users , Organisations, Reports} = this.state
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
