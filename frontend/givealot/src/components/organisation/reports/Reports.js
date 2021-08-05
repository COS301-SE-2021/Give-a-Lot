import React from 'react'
import "./Reports.css"
import Accordions from "./Accordions"
import ReportIcon from '@material-ui/icons/Report';


function Reports (){
    return (
        <div className="report">
            <div className="accordion">
                <Accordions
                    id="Report #1"
                    title="Report on Fraud"
                    description=" Donec placerat, lectus sed mattis semper, neque lectus feugiat lectus, varius pulvinar
                        diam eros in elit. Pellentesque convallis laoreet laoreet.

                        Donec placerat, lectus sed mattis semper, neque lectus feugiat lectus, varius pulvinar
                        diam eros in elit. Pellentesque convallis laoreet laoreet."
                />


            </div>

        </div>
    )
}

export default Reports