import "./Setting.css";
import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import Divider from "@material-ui/core/Divider";



const useStyles = makeStyles({
    root: {
        minWidth: 275,
    },
    bullet: {
        display: 'inline-block',
        margin: '0 2px',
        transform: 'scale(0.8)',
    },
    title: {
        fontSize: 14,
    },
    pos: {
        marginBottom: 12,
    },
});

export default function Setting() {
    const classes = useStyles();
    const bull = <span className={classes.bullet}>•</span>;

    return (

        <div className="container">

        <Card className={classes.root} variant="outlined">
            <CardContent>



            </CardContent>
            <Divider />
            <Divider />
            <CardActions>
                <button size="small" className="Sbutton" >
                    Save changes
                </button>
            </CardActions>
        </Card>
        </div>
    );
}