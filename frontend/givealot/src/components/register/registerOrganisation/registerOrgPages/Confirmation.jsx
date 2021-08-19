import React, { Component, Fragment } from "react";
import {Button } from "@material-ui/core";
import ListSubheader from "@material-ui/core/ListSubheader";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";
import FeaturedHeader from "../../../featuredHeader/FeaturedHeader";
import "./basic.css"
import { Link } from "react-router-dom";
import axios from "axios";
import {LoginBody} from "../../../login/loginBody/LoginBody";
// import {toast} from "react-toastify";
import { Redirect, withRouter } from "react-router";


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
    submit = (e) =>{
        e.preventDefault()
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const RegisterOrganisationRequestBody = {
            "orgName" : this.props.values.orgName,
            "slogan" : this.props.values.slogan,
            "orgDescription" : this.props.values.orgDescription,
            "orgSector" : this.props.values.orgSector,
            "orgEmail" : this.props.values.orgEmail,
            "contactPerson" : this.props.values.contactPerson,
            "contactNumber" : this.props.values.contactNumber,
            "password" : this.props.values.password
        }
        console.log(this.props.values)
        axios.post('http://localhost:8080/v1/organisation/add/org', RegisterOrganisationRequestBody, {config})
            .then(response =>{
                console.log(response)
                this.props.history.push("/login");
            })
            .catch(error =>{
                console.log(error)
                // toast.success('Registration failed ')
            })
    }

    render() {
        const {
            values: { slogan, orgEmail, orgSector, orgDescription, contactNumber, contactPerson, orgName }
        } = this.props;
        return (
            <div className="RegisterOrganisation" style={{margin: "auto"}}>
                <Fragment >
                    <FeaturedHeader />

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
                            <ListItemText primary="Sector" secondary={orgSector} />
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
                        <Button type="submit"
                            style={{
                                background: "#3C61B8",
                                color: "#FFFFFF",
                                marginRight: "1em"
                            }}
                            label="Continue"
                            onClick={this.submit}
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

export default withRouter(Confirmation);