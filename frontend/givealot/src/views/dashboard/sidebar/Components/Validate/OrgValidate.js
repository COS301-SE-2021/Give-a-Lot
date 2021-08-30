import React, { Component } from 'react'
import "./Validate.css"
import Grid from "@material-ui/core/Grid";
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import CardActions from '@material-ui/core/CardActions';

export class OrgValidate extends Component {

    render() {
        return (
            <div className="validate">
                <div className="validBody">
                    <Card>
                        <CardContent>
                            <div  className="name">
                                Organisation Name
                            </div>
                            <Typography className="validBody">
                                <Typography>
                                    Organisation Name
                                </Typography>
                                <Typography>
                                    Organisation Name
                                </Typography>
                            </Typography>
                            <CardActions style={{display: "flex", alignItems: "center", justifyContent: "center"}}>
                                <Button variant="contained" color="primary">
                                    Verify
                                </Button>
                                <Button variant="contained" color="secondary">
                                    Deny
                                </Button>
                            </CardActions>
                        </CardContent>
                    </Card>
                </div>

            </div>
        )
    }
}

export default OrgValidate