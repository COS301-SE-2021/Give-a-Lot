import React, {Component} from 'react'
import "../Report/Style/Reports.css"
import Accordions from "../Report/Accordions"



export class Reports extends Component {
    state={
        count: 4
    };



    render()
    {
        if (this.state.count===0){
            return (
                <div className="non">

                    <h1> You do not have any reports</h1>

                </div>
            )
        }else {
            return (
                <div className="report">
                    <div className="reportHeader">
                        Reports list
                    </div>
                    <div className="accordion">
                        <Accordions
                            id="Report #1"
                            title="Fraud report"
                            description=" Donec placerat, lectus sed mattis semper, neque lectus feugiat lectus, varius pulvinar
                        diam eros in elit. Pellentesque convallis laoreet laoreet.

                        Donec placerat, lectus sed mattis semper, neque lectus feugiat lectus, varius pulvinar
                        diam eros in elit. Pellentesque convallis laoreet laoreet."
                        />

                        <Accordions
                            id="Report #2"
                            title="Scam report"
                            description="But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and
                    I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth,
                     the master-builder of human happiness. No one rejects, "
                        />

                        <Accordions
                            id="Report #3"
                            title="Fraud report"
                            description=" dislikes, or avoids pleasure itself, because it is pleasure, but because
                      those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful.
                       Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain,
                        but because occasionally circumstances occur in which toil and pain can procure him some great pleasure."
                        />
                        <Accordions
                            id="Report #3"
                            title="Fraud report"
                            description=" dislikes, or avoids pleasure itself, because it is pleasure, but because
                      those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful.
                       Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain,
                        but because occasionally circumstances occur in which toil and pain can procure him some great pleasure."
                        />


                    </div>

                </div>

            )
        }
    }

}

export default Reports