import React from 'react'
import "./Organisation.css"
import Card from '@material-ui/core/Card';
import {CardContent, Grid, Typography} from '@material-ui/core';


function OrgCards ({number, Icon, title}) {


    return (
        <div className="cards">
            <Card >
                <CardContent>
                    <Grid className="cardItems">
                        <Grid item>
                            <Typography variant="h2" style={{fontSize: "xx-large"}}>
                                {Icon && <Icon /> }
                            </Typography>
                        </Grid>
                        <Grid item>
                            <Typography variant="h6" >
                                {number}
                            </Typography>
                            <Typography variant="subtitle1" >
                                {title}
                            </Typography>
                        </Grid>

                    </Grid>
                </CardContent>
            </Card>
        </div>
    )

}

export default OrgCards