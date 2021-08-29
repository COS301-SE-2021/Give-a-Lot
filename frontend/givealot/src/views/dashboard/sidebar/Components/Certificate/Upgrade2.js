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

export class Upgrade2 extends Component {

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
                <div className="upgradeTitle">
                    <p className="upgradeTitle1">Current level:</p>
                    <p className="upgradeTitle2">One</p>
                </div>

                <div className="progress">
                    <div className="progress1">1</div>
                    <div className="progress2">2</div>
                    <div className="progress3">3</div>
                    <div className="progress4">4</div>
                    <div className="progress5">5</div>


                </div>


            </div>
        );
    }
}
export default withStyles(styles)(Upgrade2);