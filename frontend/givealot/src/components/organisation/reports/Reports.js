import React from 'react'
import "./Reports.css"
import Accordions from "./Accordions"


function Reports (){
    return (
        <div className="report">
            <div className="accordion">
                <Accordions/>
                {/*<OrgCards Icon={PersonIcon} title="Users" number="1245"/>*/}
            </div>

        </div>
    )
}

export default Reports