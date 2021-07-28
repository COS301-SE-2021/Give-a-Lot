import React, { Component } from "react";
import Button from '@material-ui/core/Button';
import "./RegisterOrganisation.css"
import logo from "./imagesRegister/ID2.png";
import DialogTitle from '@material-ui/core/DialogTitle'
import Dialog from '@material-ui/core/Dialog'
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';

class OrganisationMedia extends Component {
    proceed = e => {
        e.preventDefault();
        this.props.nextStep();
      };
      back = e => {
        e.preventDefault();
        this.props.prevStep();
      };
      constructor() {
        super();
        this.state = {
          disabled: false,
            open: false,
        };
      }
    render() {
        const { values, handleChange } = this.props;
        return (
            <div >
                <div className="header">
                    <div >
                        <img id="ID" src={logo} alt="" style={{width: "220px ",height: "70px"}}/>
                    </div>

                </div>
                <div className="containerO" >

                 <form className="form">
                     <div className="top">
                         <h4> Registration | Organisation | Media</h4>
                     </div>
                     <div className="top">
                         <h4> You are one step away</h4>
                     </div>
                    <div >
                        {/* <label for="img">Select image:</label> */}
                        <input type="file" 
                        id="img" name="image" 
                        accept="image/*" 
                        onChange={handleChange("image")}
                        defaultValue={values.image}
                        />
                    </div>

                    <div>
                    <Button
                        style={{
                            background: "#EE3B55",
                            color: "#FFFFFF",
                            marginRight: "1em"
                        }}
                        label="Back"
                        onClick={this.back}
                        >
                        Back
                        </Button>
                        <Button
                        style={{
                            background: "#991A76",
                            color: "#FFFFFF"
                        }}
                        label="Continue"
                        // onClick={this.proceed}
                        onClick={() => this.setState({ open: !this.state.open })}
                        >
                        {" "}
                        Proceed
                    </Button>
                        <header className='App-header'>
                            <Dialog open={this.state.open}>

                                <DialogTitle id="alert-dialog-title">{"Login to GiveAlot?"}</DialogTitle>
                                <DialogContent>
                                    <DialogContentText id="alert-dialog-description">
                                        Thank you for Registering
                                    </DialogContentText>
                                </DialogContent>
                                <DialogActions>
                                    <Button onClick={() => this.setState({ open: !this.state.open })} color="primary" autoFocus>
                                        Click to Login
                                    </Button>
                                </DialogActions>
                            </Dialog>
                        </header>

                    </div>

                </form>
                    <div className="gradientOverlay"></div>
                </div>
            </div>
        );
    }

}

export default OrganisationMedia