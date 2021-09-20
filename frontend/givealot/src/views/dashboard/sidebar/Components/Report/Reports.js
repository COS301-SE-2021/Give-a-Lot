import React, {Component} from 'react'
import "../Report/Style/Reports.css"
import Accordions from "../Report/Accordions"
import axios from "axios";
import {ApiContext} from "../../../../../apiContext/ApiContext";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import Card from "@material-ui/core/Card";



export class Reports extends Component {

    static contextType = ApiContext;
    constructor(props) {
        super(props)
        this.state = {
            count: "",
            reports: [],
            orgId:localStorage.getItem("id"),
            error: "",
            serverDomain : 'http://localhost:8080',
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
        }
        else if(reports.length === 0){
            return(
                <div className="report">
                    <div className="reportHeader">
                        Reports list
                    </div>
                    <Card style={{margin: "1em", width: "100%"}}>
                        <CardContent>
                            <Typography className="valid">
                                <Typography>
                                    No Reports
                                </Typography>
                            </Typography>
                        </CardContent>
                    </Card>
                </div>
            )
        }

        else{
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
