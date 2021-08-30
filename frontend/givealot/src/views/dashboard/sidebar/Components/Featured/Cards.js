import React, { Component } from 'react'
import "./Styles/Featured.css"
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import PersonOutlineIcon from '@material-ui/icons/PersonOutline';

export class Cards extends Component {

    render() {
        return (
            // <div className="cardsS">
                <Card variant="outlined" className="cardElement">
                    <CardContent>
                        <Typography color="textSecondary">
                            Users
                        </Typography>
                        <Typography color="textPrimary" className="numberIcon">
                            <Typography color="textSecondary" >
                                <PersonOutlineIcon />
                            </Typography>
                            <Typography color="textPrimary" style={{paddingLeft: "0.3em"}}>
                                123
                            </Typography>
                        </Typography>
                    </CardContent>
                </Card>
            // </div>
        )
    }
}

export default Cards