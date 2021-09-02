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
import Complete from "../Certificate/Style/complete.png";
import CheckCircleIcon from '@material-ui/icons/CheckCircle';
import Axios from "axios";
import logo from "../../../../../assets/logo/logo3_1.png";

const styles = theme => ({

    root: {
        display: "flex",
        flexWrap: "wrap"
    },
    textField: {
        marginLeft: theme.spacing(1),
        marginRight: theme.spacing(1),
        width: "25ch"
    },
    formControl: {
        margin: theme.spacing.unit * 3
    },

});


export class Upgrade5 extends Component {

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
                    <p className="upgradeTitle2">Five</p>
                </div>

                <div className="progress">
                    <div className="progress_complete"/>
                    <div className="progress_complete"/>
                    <div className="progress_complete"/>
                    <div className="progress_complete"/>
                    <div className="progress_complete"/>
                    <div className="progress6"> <StarOutlineIcon fontSize="large"/></div>
                </div>

                <Card className="upgrade_card4" variant="outlined">
                    <CardContent>
                        <div>
                            <span id="complete_label1">
                                Done!
                            </span>

                        </div>

                        <div>
                            <img id="level5" src={Complete} />
                        </div>
                        <div id="complete_label2">
                            < CheckCircleIcon className="checkIcon" />
                                SUCCESS! Certificate upgrade completed

                        </div>



                    </CardContent>

                </Card>


            </div>
        );
    }
}
export default withStyles(styles)(Upgrade5);