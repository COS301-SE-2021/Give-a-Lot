import React, {Component} from 'react';
import "./certificate.css";
//import CancelIcon from '@material-ui/icons/Cancel';
//import CheckCircleIcon from '@material-ui/icons/CheckCircle';
import AddAPhotoIcon from '@material-ui/icons/AddAPhoto';
import Button from '@material-ui/core/Button';
import 'date-fns';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";
import { withStyles } from '@material-ui/core/styles'
import {toast, ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css'
import Axios from "axios";


const useStyles = theme => ({
    root: {
        '& > *': {
            margin: theme.spacing(1),
        },
    },
    input: {
        display: 'none',
    },
});

export class Upgrade extends Component {

    constructor (props) {
        super(props)
        /* this.state = {
             startDate: new Date(),

             status1: true,
             status2: false,
             status3: false,
             status4: false,
             status5: false,
             status6: false,
             status7: false,
             status8: false,
             status9: false,
             status10: false,
             status11: false,
             status12: false,
         };*/

        this.state = {
            orgId: "19",
            type: "instagram",
            url:"",
            website: "",
            address:"",
        };
        this.handleChange = this.handleChange.bind(this);
        this.onFormSubmit = this.onFormSubmit.bind(this);

    }

    handleChange(date) {
        this.setState({
            startDate: date
        })
    }

    onFormSubmit(e) {
        e.preventDefault();
        console.log(this.state.startDate)
    }

    onToast = () => {
        toast.success('upload success',{
            position: toast.POSITION.TOP_RIGHT

        });
    }


    handleInputChange = e => {
        this.setState({website: e.target.value});

    };
    handleAddressInputChange = e => {
        this.setState({address: e.target.value});

    };

    handleDateInputChange = e => {
        this.setState({date: e.target.value});

    };
    handleInstaInputChange = e => {
        this.setState({url: e.target.value});

    };
    handleFormChange = e => {
        e.preventDefault();
        const data = {
            orgId: this.state.orgId,
            website: this.state.website
        };
        Axios
            .post("http://localhost:8080/v1/organisation/add/website", data)
            .then(res => console.log(res))
            .catch(err => console.log(err));
    };
    handleAddressFormChange = e => {
        e.preventDefault();
        const data = {
            orgId: this.state.orgId,
            address: this.state.address,
        };
        Axios
            .post("http://localhost:8080/v1/organisation/add/address", data)
            .then(res => console.log(res))
            .catch(err => console.log(err));
    };
    handledateFormChange = e => {
        e.preventDefault();
        const data = {
            orgId: this.state.orgId,
            date: this.state.date,
        };
        Axios
            .post("-", data)
            .then(res => console.log(res))
            .catch(err => console.log(err));
    };

    handleInstaFormChange = e => {
        e.preventDefault();
        const data = {
            orgId: this.state.orgId,
            type: this.state.type,
            url: this.state.url,
        };
        Axios
            .post("http://localhost:8080/v1/organisation/add/socials", data)
            .then(res => console.log(res))
            .catch(err => console.log(err));
    };



    render(){
        const { classes } = this.props;

        /*  let message
          if(this.state.status1){
              message = <div className="contain_Icon"><CheckCircleIcon className="tick_Icon"/></div>
          }*/


        return (
            <div className="upgrade">
                <div className="upgrade_heading">
                    <p className="upgrade_level">Current level:</p>
                    <p className="upgrade_status"> Intermediate</p>

                </div>
                <div className="upgrade_container">
                    <div className="contain">
                        <form className="upgrade_form" onSubmit={this.handleFormChange}>
                            <input
                                name="website"
                                type="text"
                                placeholder="Enter your website url.."
                                className="input1"
                                onChange={this.handleInputChange}
                            />
                            <button type="submit" className="submit1" onClick={this.onToast}>Submit </button>
                            {}

                            <div className="form-group">
                                <ToastContainer/>
                            </div>

                        </form>



                        <form className="upgrade_form" onSubmit={this.handleAddressFormChange}>
                            <input
                                name="address"
                                type="text"
                                placeholder="Enter your address.."
                                className="input1"
                                onChange={this.handleAddressInputChange}
                            />

                            <input type="submit" value="Submit" className="submit1" onClick={this.onToast}/>
                            { }
                            <div className="form-group">
                                <ToastContainer/>
                            </div>

                        </form>

                        <div className="upgrade_form">
                            <label className="upgrade_sublabel">Enter Establishment date</label>
                        </div>

                        <div className="upgrade_form">
                            <form onSubmit={ this.onFormSubmit }>
                                <div >
                                    <DatePicker
                                        selected={ this.state.startDate }
                                        onChange={ this.handleChange }
                                        name="startDate"
                                        dateFormat="MM/dd/yyyy"
                                        className="input1"
                                    />

                                </div>

                            </form>
                            <input type="submit" value="Submit" className="submit1" onClick={this.onToast}/>
                            {}
                            <div className="form-group">
                                <ToastContainer/>
                            </div>
                        </div>


                        <div className="upgrade_form" >
                            <label className="upgrade_label">Social media section</label>
                        </div>

                        <form className="upgrade_form" onSubmit={this.handleInstaFormChange} >
                            <input
                                name="socialMedia1"
                                type="text"
                                placeholder="Enter your social media url"
                                className="input1"
                                onChange={this.handleInstaInputChange}
                            />
                            <input type="submit" value="Submit" className="submit1" onClick={this.onToast}/>
                            {}
                            <div className="form-group">
                                <ToastContainer/>
                            </div>
                        </form>
                        <form className="upgrade_form">
                            <input
                                name="socialMedia2"
                                type="text"
                                placeholder="Enter your social media url"
                                className="input1"
                            />
                            <input type="submit" value="Submit" className="submit1" onClick={this.onToast}/>
                            {}
                            <div className="form-group">
                                <ToastContainer/>
                            </div>
                        </form>


                        <div className="upgrade_form">
                            <label className="upgrade_label">Organisation images section</label>
                        </div>
                        <div className="upgrade_form">
                            <label className="upgrade_sublabel">Upload up to 10 images, each image has 1 point</label>
                        </div>

                        <div className="upgrade_form1">
                            <input
                                accept="image/*"
                                className={classes.input}
                                id="contained-button-file"
                                multiple
                                type="file"
                            />
                            <label htmlFor="contained-button-file">
                                <Button  size="small" variant="contained"  component="span">
                                    <AddAPhotoIcon  /> Choose a file
                                </Button>
                            </label>
                            <input type="submit" value="Upload" className="img_submit" onClick={this.onToast}/>
                            {}
                            <div className="form-group">
                                <ToastContainer/>
                            </div>
                        </div>

                    </div>


                    <div className="contain2">

                        <form className="upgrade_form">
                            <input
                                name="tax"
                                type="text"
                                placeholder="Enter your Tax reference number"
                                className="input1"
                            />
                            <input type="submit" value="Submit" className="submit1" onClick={this.onToast}/>

                            {}
                            <div className="form-group">
                                <ToastContainer/>
                            </div>
                        </form>

                        <form className="upgrade_form">
                            <input
                                name="registered_no"
                                type="text"
                                placeholder="Enter your registered NGO number"
                                className="input1"
                            />
                            <input type="submit" value="Submit" className="submit1" onClick={this.onToast}/>
                            {}
                            <div className="form-group">
                                <ToastContainer/>
                            </div>
                        </form>

                        <form className="upgrade_form">
                            <input
                                name="registered_no"
                                type="text"
                                placeholder="Enter Committee details"
                                className="input1"
                            />
                            <input type="submit" value="Submit" className="submit1" onClick={this.onToast}/>
                            {}
                            <div className="form-group">
                                <ToastContainer/>
                            </div>
                        </form>

                        <div className="upgrade_form">
                            <label className="upgrade_sublabel">Date the NGO was registered</label>
                        </div>

                        <div className="upgrade_form">
                            <form onSubmit={ this.onFormSubmit }>
                                <div >
                                    <DatePicker
                                        selected={ this.state.startDate }
                                        onChange={ this.handleChange }
                                        name="startDate"
                                        dateFormat="MM/dd/yyyy"
                                        className="input1"
                                    />

                                </div>

                            </form>
                            <input type="submit" value="Submit" className="submit1" onClick={this.onToast}/>
                            {}
                            <div className="form-group">
                                <ToastContainer/>
                            </div>
                        </div>


                        <div className="upgrade_form">
                            <label className="upgrade_label">Organisation Auditing section</label>
                        </div>

                        <div className="upgrade_form">
                            <label className="upgrade_sublabel">Upload your Audit document</label>
                        </div>

                        <form className="upgrade_form">

                            <input type="file" name="file"  className="form_file"/>
                            <input type="submit" value="Upload" className="file_submit" onClick={this.onToast}/>
                            {}
                            <div className="form-group">
                                <ToastContainer/>
                            </div>
                        </form>



                        <div className="upgrade_form">
                            <label className="upgrade_sublabel">Upload the Auditors certificate</label>
                        </div>

                        <form className="upgrade_form">

                            <input type="file" name="file"  className="form_file"/>
                            <input type="submit" value="Upload" className="file_submit" onClick={this.onToast}/>
                            {}
                            <div className="form-group">
                                <ToastContainer/>
                            </div>
                        </form>


                        <div className="upgrade_form">
                            <label className="upgrade_label">Organisation Donation section</label>
                        </div>

                        <div className="upgrade_form">
                            <label className="upgrade_sublabel">Upload your donation certificate</label>
                        </div>

                        <form className="upgrade_form">

                            <input type="file" name="file"  className="form_file"/>
                            <input type="submit" value="Upload" className="file_submit" onClick={this.onToast}/>
                            { }
                            <div className="form-group">
                                <ToastContainer/>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        )
    }
}

export default withStyles(useStyles)(Upgrade)
