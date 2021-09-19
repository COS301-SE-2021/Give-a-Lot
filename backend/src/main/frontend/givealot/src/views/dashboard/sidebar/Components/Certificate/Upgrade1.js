import React, {Component} from 'react';
import "./Style/Certificate.css";
import 'date-fns';
import "react-datepicker/dist/react-datepicker.css";
import { withStyles } from '@material-ui/core/styles'
import {toast, ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import 'react-datepicker/dist/react-datepicker.css';
import StarOutlineIcon from '@material-ui/icons/StarOutline';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import TextField from "@material-ui/core/TextField";
import Axios from "axios";
import {ApiContext} from "../../../../../apiContext/ApiContext";

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

const initialState = {
    orgId:localStorage.getItem("id"),
    website: "",
    websiteError: "",
    address:"",
    addressError:"",
    //serverDomain: "https://3c73e752688968.localhost.run"
    serverDomain: 'https://localhost:8080'
};
export class Upgrade1 extends Component {

    state = initialState;
    static contextType = ApiContext;
    constructor (props) {
        super(props)

    }

    handleChange = event => {
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    };

    validate = () => {
        let  websiteError = "";
        let  addressError = "";


        if (!this.state.website) {
            websiteError = "Website is require";
        }



        if(!this.state.address) {
            addressError="address is required";
        }

        if ( websiteError || addressError) {
            this.setState({ websiteError, addressError });
            return false;
        }

        return true;
    };


    handleFormSubmit = e => {
        e.preventDefault();
        const isValid = this.validate();
        if (isValid) {
            const web = {
                orgId: this.state.orgId,
                website: this.state.website,

            };
            const add = {
                orgId: this.state.orgId,
                address: this.state.address,

            };
            Axios
                .post( "http://localhost:8080/v1/organisation/add/website", web)
                .then(res => console.log(res))
                .catch(err => console.log(err));

            Axios
                .post("http://localhost:8080/v1/organisation/add/address", add)
                .then(res => console.log(res))
                .catch(err => console.log(err));

            const notification_update_body = {
                org_id: this.state.orgId,
            };

            Axios
                .post("http://localhost:8080/v1/notifications/update/notifications", notification_update_body)
                .then(res => console.log(res))
                .catch(err => console.log(err))

            // clear form
            this.setState(initialState);
        }
    };

    onToastOne = () => {
        const isValid = this.validate();
        if (isValid) {
            toast.success('Submit successful', {
                position: toast.POSITION.TOP_RIGHT

            });
        }
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
                                <span className="loginError_certificate">{this.state.websiteError}</span>
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
                                <span className="loginError_certificate">{this.state.addressError}</span>
                            </div>
                                <div className="upgrade_Button">
                                    <button className="upgrade-btn" type="submit" onClick={this.onToastOne}>
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
