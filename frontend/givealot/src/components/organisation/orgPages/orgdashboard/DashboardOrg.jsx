import React, { Component } from 'react'
import "./dashboardOrg.css"
import FeaturedInfoOrg from '../../featuredInfoOrg/FeaturedInfoOrg'
import Chart from '../../chartOrg/ChartOrg'
import { userData } from '../../../../DummyData'
import WidgetsmOrg from "../../widgetsmOrg/WidgetsmOrg"
import WidgetlgOrg from "../../widgetlgOrg/WidgetlgOrg"

export class Dashboard extends Component {
    render() {
        return (
            <div className="dashboard">
                <FeaturedInfoOrg />
                <Chart data={userData} title="Users" grid dataKey="Active User"/>
                <div className="homeWidgets">
                <WidgetsmOrg/>
                <WidgetlgOrg/>
                </div>
            </div>
        )
    }
}

export default Dashboard
