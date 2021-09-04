import React, {Component} from 'react';
import "../Certificate/Style/Certificate.css";
import 'date-fns';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";
import { withStyles ,makeStyles } from '@material-ui/core/styles'
import {toast, ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import 'react-datepicker/dist/react-datepicker.css';
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
    orgId:6,
    startDate: new Date(),
    ngoNumber:"",
    ngoDate:"",
};


export class Level0 extends Component {


    state = initialState;
    constructor (props) {
        super(props)

        this.handleDateChange = this.handleDateChange.bind(this);
    }

    handleDateChange(date) {
        this.setState({startDate: date, ngoDate:document.getElementsByClassName("input3")[0].value} )

    }

    handleInputChange = input => e => {

        this.setState({ [input]: e.target.value });

    };


    handleChange = event => {
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    };

    validate = () => {
        let dateError = "";
        let paypalError = "";


        if (!this.state.date) {
            dateError = "Date is require";
        }


        if(!this.state.paypal) {
            paypalError="Link required";
        }

        if ( dateError || paypalError) {
            this.setState({ dateError, paypalError });
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
    onToast = () => {
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

                <Card className="upgrade_card11" variant="outlined">
                    <CardContent>
                        <div className={classes.root}>
                            <form onSubmit={this.handleFormSubmit}>
                                <span className="upgrade_header1">
                                    Additional credentials needed to Upgrade
                                 </span>
                                <div>

                                    <div >
                                        <span className="upgrade_label">
                                            Registration date
                                         </span>
                                        <DatePicker

                                            className="upgrade_datee input3"
                                            selected={ this.state.startDate }
                                            onChange={ this.handleDateChange }
                                            name="startDate"
                                            dateFormat="yyyy/MM/dd"
                                            fullWidth

                                        />
                                    </div>
                                    <TextField
                                        id="outlined-full-width"
                                        label="Registration number"
                                        name="ngoNumber"
                                        style={{ margin: 8 }}
                                        placeholder="Enter registration.."
                                        fullWidth
                                        margin="normal"
                                        InputLabelProps={{
                                            shrink: true,
                                        }}
                                        variant="outlined"
                                        onChange={this.handleChange}
                                    />
                                    <div>
                                        <span className="upgrade_label_logo">
                                            Logo
                                         </span>
                                        <input
                                            className="upgrade_logoo"
                                            type="file"
                                            name="file"
                                            onChange={this.handleInputChange}
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
        );
    }
}
export default withStyles(styles)(Level0);