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
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import TextField from "@material-ui/core/TextField";
import Axios from "axios";


const styles = theme => ({

    root: {
        display: "flex",
        flexWrap: "wrap"
    },
    textField: {
        marginLeft: theme.spacing(1),
        marginRight: theme.spacing(1),
        width: "25ch"
    },formControl: {
        margin: theme.spacing(1),
        minWidth: 149,
    },
    selectEmpty: {
        marginTop: theme.spacing(2),
    },

});


export class Upgrade3 extends Component {

    constructor (props) {
        super(props)
        this.state={
            orgId:"",
            SocialMedia:"",
            address:"",
            name:"",
            contacts:"",

        };
    }

    handleSocialChange = e => {
        this.setState({SocialMedia: e.target.value});

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
                    <p className="upgradeTitle2">Three</p>
                </div>

                <div className="progress">
                    <div className="progress_complete"/>
                    <div className="progress_complete"/>
                    <div className="progress_complete"/>
                    <div className="progress_empty"/>
                    <div className="progress_empty"/>
                    <div className="progress6"> <StarOutlineIcon fontSize="large"/></div>
                </div>

                <Card className="upgrade_card" variant="outlined">
                    <CardContent>
                        <div className={classes.root}>
                            <form onSubmit={this.handleFormSubmit}>
                                <span className="upgrade_header">
                                    Additional credentials needed to Upgrade
                                 </span>
                                <div>
                                    <div className="social_media">
                                        <div>

                                            <FormControl variant="outlined" className={classes.formControl}>
                                                <InputLabel id="demo-controlled-open-select-label">Social platform</InputLabel>
                                                <Select
                                                    labelId="demo-simple-select-outlined-label"
                                                    id="demo-simple-select-outlined"
                                                    value={this.SocialMedia}
                                                    onChange={this.handleSocialChange}
                                                    label="Social platform"


                                                >
                                                    <MenuItem value="">
                                                        <em>None</em>
                                                    </MenuItem>
                                                    <MenuItem value={"Facebook"}>Facebook</MenuItem>
                                                    <MenuItem value={"Instagram"}>Instagram</MenuItem>
                                                    <MenuItem value={"Twitter"}>Twitter</MenuItem>
                                                </Select>
                                            </FormControl>

                                        </div>
                                        <TextField
                                            id="outlined-full-width"
                                            label="Social media"
                                            style={{ margin: 8 }}
                                            placeholder="Enter your social media url..."

                                            fullWidth
                                            margin="normal"
                                            InputLabelProps={{
                                                shrink: true,
                                            }}
                                            variant="outlined"
                                            onChange={this.handleChange}
                                        />
                                    </div>

                                    <div className="social_media">
                                        <div>

                                            <FormControl variant="outlined" className={classes.formControl}>
                                                <InputLabel id="demo-controlled-open-select-label">Social platform</InputLabel>
                                                <Select
                                                    labelId="demo-simple-select-outlined-label"
                                                    id="demo-simple-select-outlined"
                                                    value={this.SocialMedia}
                                                    onChange={this.handleSocialChange}
                                                    label="Social platform"


                                                >
                                                    <MenuItem value="">
                                                        <em>None</em>
                                                    </MenuItem>
                                                    <MenuItem value={"Facebook"}>Facebook</MenuItem>
                                                    <MenuItem value={"Instagram"}>Instagram</MenuItem>
                                                    <MenuItem value={"Twitter"}>Twitter</MenuItem>
                                                </Select>
                                            </FormControl>

                                        </div>
                                        <TextField
                                            id="outlined-full-width"
                                            label="Social media"
                                            style={{ margin: 8 }}
                                            placeholder="Enter your social media url..."

                                            fullWidth
                                            margin="normal"
                                            InputLabelProps={{
                                                shrink: true,
                                            }}
                                            variant="outlined"
                                            onChange={this.handleChange}
                                        />
                                    </div>

                                    <TextField
                                        id="outlined-full-width"
                                        label="Full name"
                                        name="name"
                                        style={{ margin: 8 }}
                                        placeholder="Enter Committee member name..."

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
                                        label="Contacts"
                                        name="contacts"
                                        style={{ margin: 8 }}
                                        placeholder="Enter Committee member phone number..."

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
        );
    }
}
export default withStyles(styles)(Upgrade3);