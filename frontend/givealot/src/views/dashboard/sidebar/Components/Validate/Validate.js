import React, { Component } from 'react';
import "./Validate.css"
import { Link } from "react-router-dom";
import SearchIcon from "@material-ui/icons/Search";
import AddCircleOutlinedIcon from "@material-ui/icons/AddCircleOutlined";
import Card from '@material-ui/core/Card'
import CardActions from '@material-ui/core/CardActions'
import CardContent from '@material-ui/core/CardContent'
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button'
import Typography from '@material-ui/core/Typography'

export class Validate extends Component {

    render() {
        return (
            <div className="validate">
                <div className="validateInfo">
                    Verify Information
                </div>

                <div className="table">
                    <Card style={{margin: "1em"}}>
                        <CardContent>
                            <Typography className="valid">
                                <Typography component="p">
                                    Organisation Name
                                </Typography>
                                <Button size="small" variant="outlined" className="buttonValid" >
                                    Request to Upgrade to level 1
                                </Button>
                                <Button variant="contained" className="buttonValidView">
                                    View
                                </Button>
                            </Typography>
                        </CardContent>
                    </Card>
                </div>
            </div>
        )
    }
}

export default Validate