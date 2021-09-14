import React, {Component} from 'react'
import "../Report/Style/Reports.css"
import Accordions from "../Report/Accordions"
import axios from "axios";



export class Reports extends Component {

    constructor(props) {
        super(props)
        this.state = {
            count: "",
            reports: [],
            //orgId:localStorage.getItem("id"),
            orgId: 60,
            error: "",
        }
    }
    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const dataa = {
            "orgId" : this.state.orgId
        }

        axios.post('http://localhost:8080/report/get/all', dataa  ,config)
            .then(response =>{
                this.setState({reports: response.data.object})
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }


    render() {

        const { reports } = this.state
        if (this.state.count===null){
            return (
                <div className="report">
                    <h1 className="non">
                        You do not have any reports
                    </h1>
                </div>
            )
        }else {
            return (
                <div className="report">
                    <div className="reportHeader">
                        Reports list
                    </div>
                    <div className="accordion">

                        {reports.map((item) =>{
                            return(
                                <Accordions
                                    org={item.orgId}
                                    id={item.reportId}
                                    title={item.reportType}
                                    description={item.description}
                                    appeal={item.appealed}
                                />
                                )
                        })}

                    </div>

                </div>

            )
        }
    }

}

export default Reports