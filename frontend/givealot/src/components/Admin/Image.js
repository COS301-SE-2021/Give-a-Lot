import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import logo from "../basicUser/logo.png";
import pic from "./pic.jpg";

const useStyles = makeStyles({
    root: {
        minWidth: 260,
        marginTop: '20px',

    },
    bullet: {
        display: 'inline-block',
        margin: '0 2px',
        transform: 'scale(0.8)',
    },
    title: {
        fontSize: 14,
    },
    button:{
        backgroundColor:'#94f8b9',
        alignContent:'center',
        alignItems:'center',
    }

});

export default function Image() {

    const classes = useStyles();
    const bull = <span className={classes.bullet}>•</span>;

    return (
        <Card className={classes.root}>
            <CardContent>

                <Typography  >
                    <img  src={pic} width="200" height="175" alt=""/>
                </Typography>
            </CardContent>

        </Card>
    );
}