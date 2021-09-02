import React, {Component} from 'react'
import "../Report/Style/Reports.css"
import Accordions from "../Report/Accordions"
import axios from "axios";



export class Reports extends Component {

    constructor(props) {
        super(props)
        this.state = {
            count: 4,
            reports: [],
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
        axios.get('http://jsonplaceholder.typicode.com/users',  config)
            .then(response =>{
                this.setState({reports: response.data})
                console.log(this.state.reports)
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }


    render() {

        const { reports } = this.state
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

                        {reports.map((item, index) =>{
                            return(
                                <Accordions
                                    id={item.id}
                                    title={item.name}
                                    description={item.email}
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