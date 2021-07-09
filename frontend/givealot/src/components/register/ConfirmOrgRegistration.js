import React, { Component, Fragment } from "react";
import { AppBar, Button, Toolbar, Typography } from "@material-ui/core";
import ListSubheader from "@material-ui/core/ListSubheader";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";

export class ConfirmOrgRegistration extends Component {
  proceed = e => {
    e.preventDefault();
    //PROCESS FORM//
    this.props.nextStep();
  };
  back = e => {
    e.preventDefault();
    this.props.prevStep();
  };

  render() {
    const {
      values: { image, slogan, email, sector, description, contactName, contactPerson, orgName }
    } = this.props;
    return (
      <Fragment>
        <AppBar style={{ background: "#098F8F" }} position="sticky">
          <Toolbar title="Enter Personal Information">
            <Typography color="inherit" variant="title">
              Confirm Details
            </Typography>
          </Toolbar>
        </AppBar>

        <List
          component="nav"
          aria-labelledby="nested-list-subheader"
          subheader={
            <ListSubheader component="div" id="nested-list-subheader">
              Confirm your info
            </ListSubheader>
          }
        >
          <ListItem>
            <ListItemText primary="Organisation Name" secondary={orgName} />
          </ListItem>
          <ListItem>
            <ListItemText primary="Email" secondary={email} />
          </ListItem>
          <ListItem>
            <ListItemText primary="Sector" secondary={sector} />
          </ListItem>
          <ListItem>
            <ListItemText primary="Description" secondary={description} />
          </ListItem>
          <ListItem>
            <ListItemText primary="Contact Name" secondary={contactName} />
          </ListItem>
          <ListItem>
            <ListItemText primary="Contact Person" secondary={contactPerson} />
          </ListItem>
          <ListItem>
            <ListItemText primary="Slogan" secondary={slogan} />
            <ListItem>
            <ListItemText primary="Image" secondary={image} />
          </ListItem>
          </ListItem>
        </List>

        <br />

        <br />
        <Button
          style={{
            background: "#EE3B55",
            color: "#FFFFFF",
            marginRight: "1em"
          }}
          label="Continue"
          onClick={this.back}
        >
          Back
        </Button>
        <Button
          style={{
            background: "#3C61B8",
            color: "#FFFFFF",
            marginRight: "1em"
          }}
          label="Continue"
          onClick={this.proceed}
        >
          Confirm and Continue
        </Button>
      </Fragment>
    );
  }
}

export default ConfirmOrgRegistration;
