import React, { Component } from "react";
import {
  AppBar,
  Toolbar,
  Typography,
  Button,
  MuiThemeProvider
} from "@material-ui/core";
import logo from "./imagesRegister/ID2.png";
import Login from "../../login/Login"
import {Switch,Route, Link} from "react-router-dom";

export class OrgSuceessRegistration extends Component {
  first = e => {
    setTimeout(() => {
      this.props.firstStep();
    }, 1000);
  };
  handleClick = () => {
    this.props.toggle();
  };

  render() {
    return (
      <MuiThemeProvider>
        <div className="header">
            <div style={{width: "220px",height: "70px"}}>
                <img id="ID" src={logo} alt=""/>
            </div>

        </div>
        <div style={{position: "absolute", left:"300px", width: "30%", height: "20%"}}>
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
              style={{ background: "#2386c2", color: "#FFFFFF", textDecoration: "none" }}
              // onClick={this.first}
            >
              <Link to="/login">Close</Link> 
            </Button>
            <Switch>       
                  <Route exact path="/login" component={Login} />
            </Switch>
        </div>
       
      </MuiThemeProvider>
    );
  }
}

export default OrgSuceessRegistration;
