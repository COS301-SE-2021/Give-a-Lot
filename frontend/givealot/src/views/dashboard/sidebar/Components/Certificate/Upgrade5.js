import React, {Component} from 'react';
import "./Style/Certificate.css";

import AddAPhotoIcon from '@material-ui/icons/AddAPhoto';
import Button from '@material-ui/core/Button';
import 'date-fns';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";
import { withStyles } from '@material-ui/core/styles'
import {toast, ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import 'react-datepicker/dist/react-datepicker.css';
import Axios from "axios";

const styles = theme => ({
    button: {
        margin: theme.spacing(1),
    },
});

export class Upgrade5 extends Component {

    constructor (props) {
        super(props)
        this.state={
            level: 0,

        };
    }


    render(){
        const { classes } = this.props;

        return (
            <div className="upgrade">

            </div>
        );
    }
}
export default withStyles(styles)(Upgrade5);