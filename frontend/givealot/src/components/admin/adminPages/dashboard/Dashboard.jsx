import React, { Component } from 'react'
import "./dashboard.css"
import FeaturedInfo from '../../featuredInfo/FeaturedInfo'
import Chart from '../../chart/Chart'
import { userData } from '../../../../DummyData'
import Widgetsm from "../../widgetsm/Widgetsm"
import Widgetlg from "../../widgetlg/Widgetlg"

export class Dashboard extends Component {
    render() {
        return (
            <div className="dashboard">
                <FeaturedInfo />
                <Chart data={userData} title="Users" grid dataKey="Active User"/>
                <div className="homeWidgets">
                <Widgetsm/>
                <Widgetlg/>
                </div>
            </div>
        )
    }
}

export default Dashboard
