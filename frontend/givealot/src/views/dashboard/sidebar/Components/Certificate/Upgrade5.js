import React, {Component} from 'react';
import "./Style/Certificate.css";
import 'date-fns';
import "react-datepicker/dist/react-datepicker.css";
import { withStyles ,makeStyles } from '@material-ui/core/styles'
import {toast, ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import 'react-datepicker/dist/react-datepicker.css';
import StarOutlineIcon from '@material-ui/icons/StarOutline';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import TextField from "@material-ui/core/TextField";
import Axios from "axios";

const styles = theme => ({

    root: {
        display: "flex",
        flexWrap: "wrap",
        '& .MuiOutlinedInput-root': {
            '& fieldset': {
                borderColor: '#957b9e',
                borderWidth: 2
            },
        },
    },
    textField: {
        marginLeft: theme.spacing(1),
        marginRight: theme.spacing(1),
        width: "30ch",


    },

});


export class Upgrade5 extends Component {

    constructor (props) {
        super(props)
        this.state={


        };
    }




    onToast = () => {
        toast.success('Submit successful',{
            position: toast.POSITION.TOP_RIGHT

        });
    }


    render(){
        const { classes } = this.props;



        return (
            <div className="upgrade">
                <div className="upgradeTitle">
                    <p className="upgradeTitle1">Current level:</p>
                    <p className="upgradeTitle2">One</p>
                </div>

                <div className="progress">
                    <div className="progress_complete"/>
                    <div className="progress_empty"/>
                    <div className="progress_empty"/>
                    <div className="progress_empty"/>
                    <div className="progress_empty"/>
                    <div className="progress6"> <StarOutlineIcon fontSize="large"/></div>
                </div>

                <Card className="upgrade_card" variant="outlined">
                    <CardContent>


                    </CardContent>

                </Card>


            </div>
        );
    }
}
export default withStyles(styles)(Upgrade5);