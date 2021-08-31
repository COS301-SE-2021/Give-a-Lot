import React, { Component } from 'react';
import "./Validate.css"
import { Link } from "react-router-dom";
import Card from '@material-ui/core/Card'
import CardContent from '@material-ui/core/CardContent'
import Button from '@material-ui/core/Button'
import Typography from '@material-ui/core/Typography'
import axios from "axios";

export class Validate extends Component {

    constructor(props) {
        super(props)
        this.state = {
            valid:[],
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
                this.setState({valid: response.data})
                console.log(this.state.valid)
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    render() {
        const { valid } = this.state
        return (
            <div className="validate">
                <div className="validateInfo">
                    Verify Information
                </div>

                <div className="table">
                    {valid.map((item, index) =>{
                        return(
                    <Card style={{margin: "1em"}}>
                        <CardContent>
                            <Typography className="valid">
                                <Typography component="p">
                                    {item.name}
                                </Typography>
                                <Link to={"/orgValidate"} className="link">
                                    <Button size="small" variant="outlined" className="buttonValid" >
                                        Request to Upgrade to level 1
                                    </Button>
                                </Link>

                                <Link to={"/orgValidate"} className="link">
                                    <Button variant="contained" className="buttonValidView">
                                        View
                                    </Button>
                                </Link>
                            </Typography>
                        </CardContent>
                    </Card>
                        )
                    })}
                </div>
            </div>
        )
    }
}

export default Validate