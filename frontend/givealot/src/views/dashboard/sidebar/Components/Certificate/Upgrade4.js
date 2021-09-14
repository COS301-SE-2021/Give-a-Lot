import React, {Component} from 'react';
import "./Style/Certificate.css";
import 'date-fns';
import "react-datepicker/dist/react-datepicker.css";
//import { withStyles ,makeStyles } from '@material-ui/core/styles'
import {toast, ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import 'react-datepicker/dist/react-datepicker.css';
import StarOutlineIcon from '@material-ui/icons/StarOutline';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';

/*const styles =theme => ({

    root: {
        display: "flex",
        flexWrap: "wrap"
    },

});*/


export class Upgrade4 extends Component {

    constructor (props) {
        super(props)
        this.state={
            orgId:localStorage.getItem("id"),
            file: "",
            fileError: "",
            images:"",
            imagesError:"",

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

    handleFileChange = event => {
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

    handleImageChange = event => {
        const formData = new FormData();

        formData.append('image', event.target.files);
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
        let fileError = "";
        let imagesError = "";



        if (!this.state.file) {
            fileError = "required";
        }


        if(!this.state.images) {
            imagesError="required";
        }



        if ( fileError || imagesError) {
            this.setState({ fileError,imagesError });
            return false;
        }

        return true;
    };

    handleFormSubmit = e => {
        e.preventDefault();
        const isValid = this.validate();
        if (isValid) {

        }
    };

    onToastFour = () => {
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
                                            name="images"
                                            id="contained-button-file"
                                            multiple
                                            type="file"
                                            onChange={this.handleImageChange}

                                        />

                                        {/* <FormHelperText className="helper">labelPlacement start</FormHelperText>*/}
                                    </div>
                                    <span className="loginError_certificate">{this.state.imagesError}</span>
                                    <div>
                                        <span className="upgrade_label_logo">
                                            Audit financial document
                                         </span>
                                        <input
                                            className="upgrade_logo"
                                            type="file"
                                            name="file"
                                            onChange={this.handleFileChange}
                                        />

                                    </div>
                                    <span className="loginError_certificate">{this.state.fileError}</span>
                                </div>
                                <div className="upgrade_Button">
                                    <button className="upgrade-btn" type="submit" onClick={this.onToastFour}>
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
export default Upgrade4;