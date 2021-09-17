import React, {Component} from 'react';
import "../Certificate/Style/Certificate.css";
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
import axios from "axios";


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
        width: "25ch"
    },formControl: {
        margin: theme.spacing(1),
        minWidth: 226,
    },
    selectEmpty: {
        marginTop: theme.spacing(2),
    },

});

const initialState = {
    level3:{},
    orgId:"60",
    //orgId:localStorage.getItem("id"),
    url:"",
    urlError:"",
    type:"",
    typeError:"",
    url1:"",
    url1Error:"",
    type1:"",
    type1Error:"",
    ChairpersonName:"",
    ChairpersonNameError:"",
    ChairpersonContacts:"",
    ChairpersonContactsError:"",
    managerName:"",
    managerNameError:"",
    managerContacts:"",
    managerContactsError:"",
    treasurerName:"",
    treasurerNameError:"",
    treasurerContacts:"",
    treasurerContactsError:"",
    secretaryName:"",
    secretaryNameError:"",
    secretaryContacts:"",
    secretaryContactsError:"",
    committee:""

};


export class Level3 extends Component {

    constructor (props) {
        super(props)


    }


    state = initialState;
    constructor (props) {
        super(props)

    }

    handleSocialChange = e => {
        this.setState({type: e.target.value});

    };

    handleSocial1Change = e => {
        this.setState({type1: e.target.value});

    };

    handleChange = event => {
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    };

    handleCommitteeChange = event => {
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    };

    validate = () => {

        let ChairpersonNameError = "";
        let managerNameError = "";
        let treasurerNameError = "";
        let secretaryNameError = "";
        let ChairpersonContactsError = "";
        let managerContactsError = "";
        let treasurerContactsError = "";
        let secretaryContactsError = "";
        let urlError = "";
        let url1Error = "";
        let typeError = "";
        let type1Error = "";



        if (!this.state.ChairpersonName) {
            ChairpersonNameError = "required";
        }

        if (!this.state.managerName) {
            managerNameError = "required";
        }
        if (!this.state.treasurerName) {
            treasurerNameError = "required";
        }
        if (!this.state.secretaryName) {
            secretaryNameError = "required";
        }
        if (!this.state.ChairpersonContacts) {
            ChairpersonContactsError = "required";
        }
        if (!this.state.managerContacts) {
            managerContactsError = "required";
        }
        if (!this.state.treasurerContacts) {
            treasurerContactsError = "required";
        }
        if (!this.state.secretaryContacts) {
            secretaryContactsError = "required";
        }
        if (!this.state.url) {
            urlError = "required";
        }

        if (!this.state.url1) {
            url1Error = "required";
        }

        if (!this.state.type) {
            typeError = "required";
        }
        if (!this.state.type1) {
            type1Error = "required";
        }


        if ( urlError || url1Error || typeError || type1Error || treasurerContactsError || secretaryContactsError || managerContactsError || ChairpersonContactsError || treasurerNameError || secretaryNameError || managerNameError || ChairpersonNameError) {
            this.setState({urlError, url1Error, typeError, type1Error , treasurerContactsError, secretaryContactsError,managerContactsError ,ChairpersonContactsError ,treasurerNameError, secretaryNameError, managerNameError ,ChairpersonNameError });
            return false;
        }

        return true;
    };


    handleFormSubmit = e => {
        e.preventDefault();
        const isValid = this.validate();
        if (isValid) {
            const com = {
                orgId: this.state.orgId,
                committee: this.state.ChairpersonName + "," + this.state.ChairpersonContacts + "," + this.state.managerName + "," + this.state.managerContacts + "," + this.state.treasurerName + "," + this.state.treasurerContacts + "," + this.state.treasurerName + "," + this.state.treasurerContacts,
            };


            const social = {
                orgId: this.state.orgId,
                socialType: this.state.type,
                url: this.state.url,
            };

            const social1 = {
                orgId: this.state.orgId,
                socialType: this.state.type1,
                url: this.state.url1,
            };
            console.log(com)
            Axios
                .post("http://localhost:8080/v1/organisation/add/committee", com)
                .then(res => console.log(res))
                .catch(err => console.log(err));

            console.log(social)
            Axios
                .post("http://localhost:8080/v1/organisation/add/socials", social)
                .then(res => console.log(res))
                .catch(err => console.log(err));

            console.log(social1)
            Axios
                .post("http://localhost:8080/v1/organisation/add/socials", social1)
                .then(res => console.log(res))
                .catch(err => console.log(err));

            // clear form
            this.setState(initialState);
        }




    };

    onToast3 = () => {
        const isValid = this.validate();
        if (isValid) {

            toast.success('Submit successful', {
                position: toast.POSITION.TOP_RIGHT

            });
        }

    }




    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        console.log(this.props)
        axios.get('http://localhost:8080/v1/organisation/sel/organisation/'+this.state.orgId+'/default', config) //Change the API
            .then(response =>{
                console.log(response)
                this.setState({level2: response.data.response})
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })

    }

    render(){
        const { classes } = this.props;
        const { level3 } = this.state;



     /*   return (
            <div className="upgrade">


                <Card className="upgrade_card33" variant="outlined">
                    <CardContent>
                        <div className={classes.root}>
                            <form onSubmit={this.handleFormSubmit}>
                                <span className="upgrade_header">
                                    Additional credentials needed to Upgrade
                                 </span>
                                <div>
                                    <div className="social_mediaa">
                                        <div>

                                            <FormControl variant="outlined" className={classes.formControl}>
                                                <InputLabel id="demo-controlled-open-select-label">Social media platform</InputLabel>
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
                                            label="Social media url"
                                            style={{ margin: 8 }}
                                            placeholder="Enter your url..."

                                            fullWidth
                                            margin="normal"
                                            InputLabelProps={{
                                                shrink: true,
                                            }}
                                            variant="outlined"
                                            onChange={this.handleChange}
                                        />
                                    </div>

                                    <div className="social_mediaa">
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
                                            label="Social media url"
                                            style={{ margin: 8 }}
                                            placeholder="Enter your url..."
                                            fullWidth
                                            margin="normal"
                                            InputLabelProps={{
                                                shrink: true,
                                            }}
                                            variant="outlined"
                                            onChange={this.handleChange}
                                        />
                                    </div>
                                    <div className="social_mediaa">
                                        <TextField
                                            id="outlined-full-width"
                                            label="Director"
                                            name="name"
                                            style={{ margin: 8 }}
                                            placeholder="Enter name and contacts..."

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
                                            label="Treasurer"
                                            name="contacts"
                                            style={{ margin: 8 }}
                                            placeholder="Enter name and contacts..."

                                            fullWidth
                                            margin="normal"
                                            InputLabelProps={{
                                                shrink: true,
                                            }}
                                            variant="outlined"
                                            onChange={this.handleChange}
                                        />

                                    </div>
                                    <div className="social_mediaa">
                                        <TextField
                                            id="outlined-full-width"
                                            label="Deputy director"
                                            name="name"
                                            style={{ margin: 8 }}
                                            placeholder="Enter name and contacts..."

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
                                            label="Secretary"
                                            name="contacts"
                                            style={{ margin: 8 }}
                                            placeholder="Enter name and contacts..."

                                            fullWidth
                                            margin="normal"
                                            InputLabelProps={{
                                                shrink: true,
                                            }}
                                            variant="outlined"
                                            onChange={this.handleChange}
                                        />

                                    </div>


                                </div>
                                <div className="upgrade_Button">
                                    <button className="upgrade-btnn" type="submit" onClick={this.onToast}>
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
        );*/
        return (
            <div className="upgrade">
                <Card className="upgrade_card_4" variant="outlined">
                    <CardContent>
                        <div className={classes.root}>
                            <form onSubmit={this.handleFormSubmit}>
                                <span className="upgrade_header">
                                    Additional credentials needed to Upgrade to level 4
                                 </span>
                                <div className="wrapIt">

                                    <div>
                                        <div className="social_media">
                                            <TextField
                                                id="outlined-full-width"
                                                label="Chairperson"
                                                name="ChairpersonName"
                                                style={{ margin: 8 }}
                                                placeholder={level3.contactPerson}

                                                fullWidth
                                                margin="normal"
                                                InputLabelProps={{
                                                    shrink: true,
                                                }}
                                                variant="outlined"
                                                onChange={this.handleCommitteeChange}
                                            />
                                            <TextField
                                                id="outlined-full-width"
                                                label="Chairperson"
                                                name="ChairpersonContacts"
                                                style={{ margin: 8 }}
                                                placeholder={level3.contactNumber}

                                                fullWidth
                                                margin="normal"
                                                InputLabelProps={{
                                                    shrink: true,
                                                }}
                                                variant="outlined"
                                                onChange={this.handleCommitteeChange}
                                            />

                                        </div>
                                        <div className="social_media">
                                            <TextField
                                                id="outlined-full-width"
                                                label="manager"
                                                name="managerName"
                                                style={{ margin: 8 }}
                                                placeholder={level3.contactPerson}

                                                fullWidth
                                                margin="normal"
                                                InputLabelProps={{
                                                    shrink: true,
                                                }}
                                                variant="outlined"
                                                onChange={this.handleCommitteeChange}
                                            />
                                            <TextField
                                                id="outlined-full-width"
                                                label="manager"
                                                name="managerContacts"
                                                style={{ margin: 8 }}
                                                placeholder={level3.contactNumber}

                                                fullWidth
                                                margin="normal"
                                                InputLabelProps={{
                                                    shrink: true,
                                                }}
                                                variant="outlined"
                                                onChange={this.handleCommitteeChange}
                                            />

                                        </div>
                                        <div className="social_media">
                                            <TextField
                                                id="outlined-full-width"
                                                label="treasurer"
                                                name="treasurerName"
                                                style={{ margin: 8 }}
                                                placeholder={level3.contactPerson}

                                                fullWidth
                                                margin="normal"
                                                InputLabelProps={{
                                                    shrink: true,
                                                }}
                                                variant="outlined"
                                                onChange={this.handleCommitteeChange}
                                            />
                                            <TextField
                                                id="outlined-full-width"
                                                label="treasurer"
                                                name="treasurerContacts"
                                                style={{ margin: 8 }}
                                                placeholder={level3.contactNumber}

                                                fullWidth
                                                margin="normal"
                                                InputLabelProps={{
                                                    shrink: true,
                                                }}
                                                variant="outlined"
                                                onChange={this.handleCommitteeChange}
                                            />

                                        </div>

                                        <div className="social_media">
                                            <TextField
                                                id="outlined-full-width"
                                                label="secretary"
                                                name="secretaryName"
                                                style={{ margin: 8 }}
                                                placeholder={level3.contactPerson}

                                                fullWidth
                                                margin="normal"
                                                InputLabelProps={{
                                                    shrink: true,
                                                }}
                                                variant="outlined"
                                                onChange={this.handleCommitteeChange}
                                            />
                                            <TextField
                                                id="outlined-full-width"
                                                label="secretary"
                                                name="secretaryContacts"
                                                style={{ margin: 8 }}
                                                placeholder={level3.contactNumber}

                                                fullWidth
                                                margin="normal"
                                                InputLabelProps={{
                                                    shrink: true,
                                                }}
                                                variant="outlined"
                                                onChange={this.handleCommitteeChange}
                                            />

                                        </div>
                                    </div>

                                    <div className="WrapItsSocial">
                                        <div className="social_media">
                                            <div>

                                                <FormControl variant="outlined" className={classes.formControl}>
                                                    <InputLabel id="demo-controlled-open-select-label">Social media platform</InputLabel>
                                                    <Select
                                                        labelId="demo-simple-select-outlined-label"
                                                        id="demo-simple-select-outlined"
                                                        name="type"
                                                        value={this.type}
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
                                                label="Social media url"
                                                name="url"
                                                style={{ margin: 8 }}
                                                placeholder="Enter your url..."

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
                                                    <InputLabel id="demo-controlled-open-select-label">Social media platform</InputLabel>
                                                    <Select
                                                        labelId="demo-simple-select-outlined-label"
                                                        id="demo-simple-select-outlined"
                                                        value={this.type1}
                                                        name="type1"
                                                        onChange={this.handleSocial1Change}
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
                                                label="Social media url"
                                                style={{ margin: 8 }}
                                                name="url1"
                                                placeholder="Enter your url..."
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
                                            <button className="upgrade-btn" type="submit" onClick={this.onToast3}>
                                                Submit
                                            </button>
                                        </div>

                                    </div>



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
export default withStyles(styles)(Level3);