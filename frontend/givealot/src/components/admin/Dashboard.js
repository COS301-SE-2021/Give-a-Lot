import React from 'react';
import Cards from "./Cards";
import Divider from '@material-ui/core/Divider';
import "./Dashboard.css";
import Chart from "./Chart";

function Dashboard() {
    return (
        <div className="dashboard">
            <div className="cards">
                <Cards/>
              
                <Cards/>
               
                <Cards/>
            </div>
            <div className="graph">
                <Chart />
            </div>

            
        </div>
    )
}

export default Dashboard
