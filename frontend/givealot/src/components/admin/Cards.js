import React, { Component } from 'react'
import "./Admin.css"
import Card from '@material-ui/core/Card';
import {CardContent, Grid, Typography} from '@material-ui/core';
import PeopleIcon from '@material-ui/icons/People';

export class Cards extends Component {

    render() {
        return (
            <div className="cards">
                <Card>
                    <CardContent>
                        <Grid container justify="space-between" alignItems="center" style={{display: "flex"}}>
                            <Grid item>
                                <Typography variant="h2" >
                                    <PeopleIcon />
                                </Typography>
                            </Grid>
                            <Grid item>
                                <Typography variant="h3" >
                                    1234
                                </Typography>
                                <Typography variant="subtitle1" >
                                    Organisation
                                </Typography>
                            </Grid>

                        </Grid>
                    </CardContent>
                </Card>
            </div>
        )
    }
}

export default Cards