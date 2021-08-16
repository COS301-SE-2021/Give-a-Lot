import React from 'react'
import "./chartOrg.css"
import {
    LineChart,
    Line,
    XAxis,
    CartesianGrid,
    Tooltip,
    ResponsiveContainer,
  } from "recharts";
  

  export default function ChartOrg ({ title, data, dataKey, grid }) {
    // render() {
        return (
            <div className="charts">
                 <h3 className="chartTitleOrg">{title}</h3>
                <ResponsiveContainer width="100%" aspect={4 / 1}>
                    <LineChart data={data}>
                        <XAxis dataKey="name" stroke="#5550bd" />
                        <Line type="monotone" dataKey={dataKey} stroke="#5550bd" />
                        <Tooltip />
                        {grid && <CartesianGrid stroke="#e0dfdf" strokeDasharray="5 5" />}
                    </LineChart>
                </ResponsiveContainer>
            </div>
        )
    // }
}

// export default Chart
