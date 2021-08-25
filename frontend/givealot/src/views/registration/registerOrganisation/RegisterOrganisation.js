import React, { Component } from "react";
import "../registerOrganisation/Styles/registerOrganisation.css";
import Info from "./Components/Info";
import About from "./Components/About";
import Contact from "./Components/Contact";
import Media from "./Components/Media"

export class RegisterOrganisation extends Component {

    state = {
        step: 1,
        orgName : "",
        slogan : "",
        orgDescription : "",
        orgSector : "",
        orgEmail : "",
        contactPerson : "",
        contactNumber : "",
        password : ""
    };
    // Go to next step
    nextStep = () => {
        const { step } = this.state;
        this.setState({
            step: step + 1
        });
    };

    // Go to prev step
    prevStep = () => {
        const { step } = this.state;
        this.setState({
            step: step - 1
        });
    };
    firstStep = () => {
        this.setState({
            step: 1
        });
    };
    // Handle fields change
    handleChange = input => e => {
        // console.log(e.target.value);
        this.setState({ [input]: e.target.value });
        // console.log(e.target.value);
    };

    render() {

        const { step } = this.state;
        const { orgName, slogan, orgDescription, orgSector, orgEmail, contactPerson, contactNumber, password } = this.state;
        const values = { orgName, slogan, orgDescription, orgSector, orgEmail, contactPerson, contactNumber, password };
        switch (step) {
            default:
                return <h1>User Forms not working. Enable Javascript!</h1>;
            case 1:
                return (
                    <Info
                        nextStep={this.nextStep}
                        handleChange={this.handleChange}
                        values={values}
                    />
                );

            case 2:
                return (
                    <About
                        nextStep={this.nextStep}
                        prevStep={this.prevStep}
                        handleChange={this.handleChange}
                        values={values}
                    />
                );
            case 3:
                return (
                    <Contact
                        nextStep={this.nextStep}
                        prevStep={this.prevStep}
                        handleChange={this.handleChange}
                        values={values}
                    />
                );
            case 4:
                return (
                    <Media
                        nextStep={this.nextStep}
                        prevStep={this.prevStep}
                        handleChange={this.handleChange}
                        values={values}
                    />
                );
            // case 4:
            //     return (
            //         <Confirmation
            //             nextStep={this.nextStep}
            //             prevStep={this.prevStep}
            //             values={values}
            //         />
            //     );
            //
            // case 5:
            //     return <Success />;
        }
    }
}

export default RegisterOrganisation;