import React, { Component } from 'react'
import "./Styles/Featured.css"
import Chart from "./Chart"
import Cards from "./Cards"
import { userData} from "../../../../../DummyData";

export class Featured extends Component {

    render() {
        return (
            <div className="featured">
                <div className="featuredBody">
                    <div className="featuredTop">
                        <div className="featuredCards">
                            <Cards />
                            <Cards />
                            <Cards />
                            <Cards />
                        </div>
                        <Chart data={userData} title="Visits" grid dataKey="Active User"/>
                    </div>
                    {/*<div className="featuredBottom">*/}
                    {/*    bottom*/}
                    {/*</div>*/}
                </div>
            </div>
        )
    }
}

export default Featured