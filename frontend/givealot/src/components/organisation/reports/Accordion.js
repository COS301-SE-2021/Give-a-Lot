/*import React from 'react'
import "./Organisation.css"
import Card from '@material-ui/core/Card';
import {CardContent, Grid, Typography} from '@material-ui/core';


function Accordion ({number, Icon, title}) {


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

export default According*/

import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Accordion from '@material-ui/core/Accordion';
import AccordionDetails from '@material-ui/core/AccordionDetails';
import AccordionSummary from '@material-ui/core/AccordionSummary';
import Typography from '@material-ui/core/Typography';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';

const useStyles = makeStyles((theme) => ({
    root: {
        width: '100%',
    },
    heading: {
        fontSize: theme.typography.pxToRem(15),
        flexBasis: '33.33%',
        flexShrink: 0,
    },
    secondaryHeading: {
        fontSize: theme.typography.pxToRem(15),
        color: theme.palette.text.secondary,
    },
}));

export default function Accordion() {
    const classes = useStyles();
    const [expanded, setExpanded] = React.useState(false);

    const handleChange = (panel) => (event, isExpanded) => {
        setExpanded(isExpanded ? panel : false);
    };

    return (
        <div className={classes.root}>

            <Accordion expanded={expanded === 'panel2'} onChange={handleChange('panel2')}>
                <AccordionSummary
                    expandIcon={<ExpandMoreIcon />}
                    aria-controls="panel2bh-content"
                    id="panel2bh-header"
                >
                    <Typography className={classes.heading}>Users</Typography>
                    <Typography className={classes.secondaryHeading}>
                        You are currently not an owner
                    </Typography>
                </AccordionSummary>
                <AccordionDetails>
                    <Typography>
                        Donec placerat, lectus sed mattis semper, neque lectus feugiat lectus, varius pulvinar
                        diam eros in elit. Pellentesque convallis laoreet laoreet.
                    </Typography>
                </AccordionDetails>
            </Accordion>

        </div>
    );
}
