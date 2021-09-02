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
import { FormHelperText } from '@material-ui/core';
import TextField from "@material-ui/core/TextField";
import Axios from "axios";

const styles = theme => ({

    root: {
        display: "flex",
        flexWrap: "wrap"
    },

});


export class Upgrade4 extends Component {

    constructor (props) {
        super(props)
        this.state={
            orgId:"",
            website: "",
            address:"",

        };
    }

    handleChange = TextField => e => {

        this.setState({ [TextField]: e.target.value });

    };

    handleFormSubmit = e => {
        e.preventDefault();
        const data = {
            orgId: this.state.orgId,
            website: this.state.website,
            address: this.state.address,
        };
        Axios
            .post("", data)
            .then(res => console.log(res))
            .catch(err => console.log(err));
    };

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
                    <p className="upgradeTitle2">Four</p>
                </div>

                <div className="progress">
                    <div className="progress_complete"/>
                    <div className="progress_complete"/>
                    <div className="progress_complete"/>
                    <div className="progress_complete"/>
                    <div className="progress_empty"/>
                    <div className="progress6"> <StarOutlineIcon fontSize="large"/></div>
                </div>

                <Card className="upgrade_card" variant="outlined">
                    <CardContent>
                        <div className={classes.root}>
                            <form onSubmit={this.handleFormSubmit}>
                                <span className="upgrade_header">
                                   Additional credentials needed to Upgrade to level 5
                                 </span>
                                <div>

                                    <div>
                                        <span className="upgrade_label">
                                            Upload images
                                         </span>
                                        <input
                                            className="upgrade_date"
                                            accept="image/*"
                                            id="contained-button-file"
                                            multiple
                                            type="file"

                                        />
                                        {/* <FormHelperText className="helper">labelPlacement start</FormHelperText>*/}
                                    </div>
                                    <div>
                                        <span className="upgrade_label_logo">
                                            Audit financial document
                                         </span>
                                        <input
                                            className="upgrade_logo"
                                            type="file"
                                            name="file"
                                            onChange={this.handleInputChange}
                                        />
                                    </div>
                                </div>
                                <div className="upgrade_Button">
                                    <button className="upgrade-btn" type="submit" onClick={this.onToast}>
                                        Submit
                                    </button>
                                </div>
                                <div className="form-group">
                                    <ToastContainer/>
                                </div>

                            </form>
                        </div>

                    </CardContent>

                </Card>


            </div>
        );
    }
}
export default withStyles(styles)(Upgrade4);