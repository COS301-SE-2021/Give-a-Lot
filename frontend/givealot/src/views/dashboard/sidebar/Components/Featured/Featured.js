import React, { Component } from 'react'
import "./Styles/Featured.css"
import Chart from "./Chart"
import { userData} from "../../../../../DummyData";

export class Featured extends Component {

    render() {
        return (
            <div className="featured">
                <div className="featuredBody">
                    <div className="featuredTop">
                        {/*<div className="charts">*/}
                            <Chart data={userData} title="Visits" grid dataKey="Active User"/>
                        {/*</div>*/}
                        <div className="chartInfo">
                            <div className="userInfoChart">
                                <div className="userChart">Users</div>
                                <div className="userNumbers">34444</div>
                            </div>
                            <div className="userInfoChart">
                                <div className="userChart">Organisations</div>
                                <div className="userNumbers">34444</div>
                            </div>
                            <div className="userInfoChart">
                                <div className="userChart">Reports</div>
                                <div className="userNumbers">34444</div>
                            </div>
                            <div className="userInfoChart">
                                <div className="userChart">Amount Donated</div>
                                <div className="userNumbers">R3444</div>
                            </div>
                        </div>
                    </div>
                    <div className="featuredBottom">
                        bottom
                    </div>
                </div>
            </div>
        )
    }
}

export default Featured