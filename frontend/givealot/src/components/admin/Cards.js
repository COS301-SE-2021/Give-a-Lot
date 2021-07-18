import React from 'react'
import "./Admin.css"
import Card from '@material-ui/core/Card';
import {CardContent, Grid, Typography} from '@material-ui/core';


function Cards ({number, Icon, title}) {

   
        return (
            <div className="card">
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

export default Cards