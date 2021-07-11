import React, { Component } from "react";
import {
  AppBar,
  Toolbar,
  Typography,
  Button,
  MuiThemeProvider
} from "@material-ui/core";
import logo from "./imagesRegister/ID2.png";

export class OrgSuceessRegistration extends Component {
  first = e => {
    setTimeout(() => {
      this.props.firstStep();
    }, 1000);
  };
  render() {
    return (
      <MuiThemeProvider>
        <div className="header">
            <div style={{width: "220px",height: "70px"}}>
                <img id="ID" src={logo} alt=""/>
            </div>

        </div>
        <AppBar style={{ background: "#77E976" }} position="sticky">
          <Toolbar title="Enter Personal Information">
            <Typography color="inherit" variant="title">
              Confirm Details
            </Typography>
          </Toolbar>
        </AppBar>
        <br />
        <Typography variant="title">Thank you for your submission!</Typography>
        <br />
        <Typography>You will get an email with further instructions</Typography>
        <Button
          style={{ background: "#2E3B55", color: "#FFFFFF" }}
          onClick={this.first}
        >
          To First
        </Button>
      </MuiThemeProvider>
    );
  }
}

export default OrgSuceessRegistration;
