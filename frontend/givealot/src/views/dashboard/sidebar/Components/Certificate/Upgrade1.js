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


export class Upgrade1 extends Component {

    constructor (props) {
        super(props)
        this.state={
            orgId:"32",
            website: "",
            address:"",

        };
    }

    handleChange = event => {
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    };

    handleFormSubmit = e => {
        e.preventDefault();
        const web = {
            orgId: this.state.orgId,
            website: this.state.website,

        };
        const add = {
            orgId: this.state.orgId,
            address: this.state.address,

        };
        Axios
            .post("http://localhost:8080/v1/organisation/add/website", web)
            .then(res => console.log(res))
            .catch(err => console.log(err));

        Axios
            .post("http://localhost:8080/v1/organisation/add/address", add)
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
                <div className="wrap_upgrade">
                    <div>
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
                        <div className={classes.root}>
                            <form onSubmit={this.handleFormSubmit}>
                                <span className="upgrade_header">
                                    Additional credentials needed to Upgrade to level 2
                                 </span>
                            <div>

                                <TextField
                                    id="outlined-full-width"
                                    label="Website"
                                    name="website"
                                    style={{ margin: 8 }}
                                    placeholder="Enter your website url.."

                                    fullWidth
                                    margin="normal"
                                    InputLabelProps={{
                                        shrink: true,
                                    }}
                                    variant="outlined"
                                    onChange={this.handleChange}
                                />
                                <TextField
                                    id="outlined-full-width"
                                    label="Address"
                                    name="address"
                                    style={{ margin: 8 }}
                                    placeholder="Enter your address.."

                                    fullWidth
                                    margin="normal"
                                    InputLabelProps={{
                                        shrink: true,
                                    }}
                                    variant="outlined"
                                    onChange={this.handleChange}
                                />
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
            </div>


            </div>
        );
    }
}
export default withStyles(styles)(Upgrade1);