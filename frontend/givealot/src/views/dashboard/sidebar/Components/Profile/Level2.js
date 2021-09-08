import React, {Component} from 'react';
import "../Certificate/Style/Certificate.css";
import 'date-fns';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";
import { withStyles ,makeStyles } from '@material-ui/core/styles'
import {toast, ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import 'react-datepicker/dist/react-datepicker.css';
import StarOutlineIcon from '@material-ui/icons/StarOutline';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';

import Axios from "axios";
import TextField from "@material-ui/core/TextField";
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
        width: "30ch"
    },

});


export class Level2 extends Component {

    constructor (props) {
        super(props)
        this.state={
            level2:[],
            orgId:"6",
            adminId:14,
            date:"",
            dateState:false,
            startDate: new Date(),
            orgInfo:"",
            orgInfoState:false,


        };
        this.handleDateChange = this.handleDateChange.bind(this);
    }

    handleDateChange(date) {
        this.setState({startDate: date, date:document.getElementsByClassName("input3")[0].value, dateState: true}  )

    }
    handleInfo =event=>{
        this.setState({orgInfoState: true})
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    }

    handleChange = event => {
        const formData = new FormData();
        formData.append('image', event.target.files[0]);
        formData.append('orgId', 32);
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


    handleFormSubmit = e => {
        e.preventDefault();

        if (this.state.dateState) {
            const data = {
                orgId: this.state.orgId,
                date: this.state.date,
            };
            Axios
                .post("http://localhost:8080/v1/organisation/add/estdate", data)
                .then(res => console.log(res))
                .catch(err => console.log(err));
        }
        if (this.state.orgInfoState) {

            const paypal = {
                orgId: this.state.orgId,
                orgInfo: this.state.orgInfo,
            };
            Axios
                .post("http://localhost:8080/v1/organisation/add/donation/info", paypal)
                .then(res => console.log(res))
                .catch(err => console.log(err));
        }
    };

    onToast = () => {
        toast.success('Submit successful',{
            position: toast.POSITION.TOP_RIGHT

        });
    }

    componentDidMount() {
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const admin = {
            "adminId" : this.state.adminId
        }

        const org = {
            orgId :32
        }
        axios.post('http://localhost:8080/v1/organisation/get/organisations',admin , config)
            .then(response =>{
                console.log(response)
                this.setState({level2: response.data.response[0]})
                console.log(this.state.level2)

            })
            .catch(error =>{
                this.setState({error : 'Error Retrieving data'})
            })


    }


    render(){
        const { classes } = this.props;
        const { level2 } = this.state;



        return (
            <div className="upgrade">

                <Card className="upgrade_card111" variant="outlined">
                    <CardContent>
                        <div className={classes.root}>
                            <form onSubmit={this.handleFormSubmit}>
                                <span className="upgrade_header1">
                                    Additional credentials needed to Upgrade
                                 </span>
                                <div>

                                    <div >
                                        <span className="upgrade_label">
                                            Establishment date
                                         </span>
                                        <DatePicker

                                            className="upgrade_datee input3"
                                            selected={ this.state.startDate }
                                            onChange={ this.handleDateChange }
                                            name="startDate"
                                            dateFormat="MM/dd/yyyy"
                                            fullWidth


                                        />
                                    </div>
                                    <TextField
                                        id="outlined-full-width"
                                        label="Paypal link"
                                        name="orgInfo"
                                        style={{ margin: 8 }}
                                        placeholder={level2.orgEmail}
                                        fullWidth
                                        margin="normal"
                                        InputLabelProps={{
                                            shrink: true,
                                        }}
                                        variant="outlined"
                                        onChange={this.handleInfo}
                                    />
                                    <div>
                                        <span className="upgrade_label_logo">
                                            QR code
                                         </span>
                                        <input
                                            className="upgrade_logoo"
                                            type="file"
                                            name="QRcode"
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
        );
    }
}
export default withStyles(styles)(Level2);

