import  React, {Component} from 'react';
import "./Style/Certificate.css";
import 'date-fns';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";
import { withStyles } from '@material-ui/core/styles'
import {toast, ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import 'react-datepicker/dist/react-datepicker.css';
import StarOutlineIcon from '@material-ui/icons/StarOutline';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Axios from "axios";
import TextField from "@material-ui/core/TextField";

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
        width: "30ch"
    },

});


const initialState = {
    orgId:localStorage.getItem("id"),
    startDate: new Date(),
    ngoNumber:"",
    ngoDate:"",
    logo:"",
    ngoNumberError:"",
    ngoDateError:"",
    logoError:"",
};



export class Upgrade0 extends Component {
    state = initialState;
    constructor (props) {
        super(props)

        this.handleDateChange = this.handleDateChange.bind(this);
    }

    handleDateChange(date) {
        this.setState({startDate: date, ngoDate:document.getElementsByClassName("input3")[0].value} )

    }


    handleInputChange = event => {
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    };

    handleChange = event => {
        const formData = new FormData();
        formData.append('image', event.target.files[0]);
        formData.append('orgId', this.state.orgId);

        let imageStates = 0;
        alert("take away submit button functionality");

        fetch(
            'http://localhost:8080/v1/organisation/add/logo',
            {
                method: 'POST',
                body: formData,
            }
        )
            .then((response) => response.json())
            .then((result) => {
                console.log('Success:', result);
                imageStates = 1;
            })
            .catch((error) => {
                console.error('Error:', error);
                imageStates = 2;
            });

        if(imageStates===1)
            alert("bring back button functionality");
        else if(imageStates === 2)
            alert("bring back button functionality also tell the user that the image didnt submit");

        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    };

    validate = () => {
        let  ngoNumberError = "";
        let  ngoDateError = "";
        let  logoError = "";


        if (!this.state.ngoDate) {
            ngoDateError = "Date is require";
        }

        if (!this.state.logo) {
            logoError = "Logo is require";
        }


        if(!this.state.ngoNumber) {
            ngoNumberError="Ngo number is required";
        }

        if ( ngoDateError || ngoNumberError || logoError) {
            this.setState({ ngoDateError, ngoNumberError, logoError });
            return false;
        }

        return true;
    };

    handleFormSubmit = e => {
        e.preventDefault();
        const isValid = this.validate();
        if (isValid) {
            const data = {
                orgId: this.state.orgId,
                ngoDate: this.state.ngoDate,
                ngoNumber: this.state.ngoNumber,

            };
            console.log(data)
            Axios
                .post("http://localhost:8080/v1/organisation/add/ngopdate", data)
                .then(res => console.log(res))
                .catch(err => console.log(err));

        }
    };

    onToastZero = () => {
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
                    <p className="upgradeTitle2">Zero</p>
                </div>

                <div className="progress">
                    <div className="progress_empty"/>
                    <div className="progress_empty"/>
                    <div className="progress_empty"/>
                    <div className="progress_empty"/>
                    <div className="progress_empty"/>
                    <div className="progress6"> <StarOutlineIcon fontSize="large"/></div>
                </div>

                <Card className="upgrade_card1" variant="outlined">
                    <CardContent>
                        <div className={classes.root}>
                            <form onSubmit={this.handleFormSubmit}>
                                <span className="upgrade_header1">
                                    Additional credentials needed to Upgrade to level 1
                                 </span>
                                <div>

                                    <div >
                                        <span className="upgrade_label">
                                            Registration date
                                         </span>
                                        <DatePicker

                                            className="upgrade_date input3"
                                            selected={ this.state.startDate }
                                            onChange={ this.handleDateChange }
                                            name="startDate"
                                            dateFormat="yyyy/MM/dd"
                                            fullWidth

                                        />
                                    </div>
                                    <span className="loginError_certificate">{this.state.ngoDateError}</span>
                                    <div>
                                        <TextField
                                            id="outlined-full-width"
                                            label="Registration number"
                                            style={{ margin: 8 }}
                                            name="ngoNumber"
                                            placeholder="Enter registration.."
                                            fullWidth
                                            margin="normal"
                                            InputLabelProps={{
                                                shrink: true,
                                            }}
                                            variant="outlined"
                                            onChange={this.handleInputChange}
                                        />
                                    </div>
                                    <span className="loginError_certificate">{this.state.ngoNumberError}</span>
                                    <div>
                                        <span className="upgrade_label_logo">
                                            Logo
                                         </span>
                                        <input
                                            className="upgrade_logo"
                                            type="file"
                                            name="logo"
                                            onChange={this.handleChange}
                                        />
                                    </div>

                                </div>

                                <span className="loginError_certificate">{this.state.logoError}</span>
                                <div className="upgrade_Button">
                                    <button className="upgrade-btn" type="submit" onClick={this.onToastZero}>
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
export default withStyles(styles)(Upgrade0);