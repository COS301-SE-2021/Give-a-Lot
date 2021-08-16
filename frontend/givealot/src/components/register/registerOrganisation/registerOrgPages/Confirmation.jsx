import React, { Component, Fragment } from "react";
import {Button } from "@material-ui/core";
import ListSubheader from "@material-ui/core/ListSubheader";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";
import FeaturedHeader from "../../../featuredHeader/FeaturedHeader";
import "./basic.css"
import { Link } from "react-router-dom";


export class Confirmation extends Component {
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
            values: { slogan, orgEmail, sector, orgDescription, contactNumber, contactPerson, orgName }
        } = this.props;
        return (
            <div className="RegisterOrganisation" style={{margin: "auto"}}>
                <Fragment >
                    <FeaturedHeader />
                    {/*<AppBar style={{ background: "#098F8F" }} position="sticky">*/}
                    {/*    <Toolbar title="Enter Personal Information">*/}
                    {/*        <Typography color="inherit" variant="h4">*/}
                    {/*            Confirm Details*/}
                    {/*        </Typography>*/}
                    {/*    </Toolbar>*/}
                    {/*</AppBar>*/}

                    <List
                        component="nav"
                        aria-labelledby="nested-list-subheader"
                        subheader={
                            <ListSubheader component="div" id="nested-list-subheader" className="confirmWords">
                                Confirm your info
                            </ListSubheader>
                        }
                    >
                        <ListItem className="confirmWords">
                            <ListItemText primary="Organisation Name" secondary={orgName} />
                        </ListItem>
                        <ListItem className="confirmWords">
                            <ListItemText primary="Email" secondary={orgEmail} />
                        </ListItem>
                        <ListItem className="confirmWords">
                            <ListItemText primary="Sector" secondary={sector} />
                        </ListItem>
                        <ListItem className="confirmWords">
                            <ListItemText primary="Description" secondary={orgDescription} />
                        </ListItem>
                        <ListItem className="confirmWords">
                            <ListItemText primary="Contact Number" secondary={contactNumber} />
                        </ListItem>
                        <ListItem className="confirmWords">
                            <ListItemText primary="Contact Person" secondary={contactPerson} />
                        </ListItem>
                        <ListItem className="confirmWords">
                            <ListItemText primary="Slogan" secondary={slogan} />
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
                    <Link to="/login" className="link">
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
                    </Link>
                    {/* <div>
            <div >
                <button className="button" onClick={this.togglePop}>Confirm and Continue</button>
            </div>
            {this.state.seen ? <OrgSuceessRegistration toggle={this.togglePop} /> : null}
        </div> */}

                </Fragment>
            </div>

        );
    }
}

export default Confirmation;