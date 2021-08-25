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
        orgNameError: '',
        slogan : "",
        sloganError: '',
        orgDescription : "",
        orgDescriptionError: "",
        orgSector : "",
        orgSectorError: '',
        orgEmail : "",
        orgEmailError : "",
        contactPerson : "",
        contactPersonError : "",
        contactNumber : "",
        contactNumberError: '',
        password : "",
        passwordError: '',
        image: '',
        imageError: ''

    };


    validate = () => {
        let isError = false;
        const errors = {
            orgNameError: '',
            orgEmailError : "",
            passwordError: '',
            sloganError: '',
            orgSectorError: '',
            orgDescriptionError: '',
            contactPersonError : "",
            contactNumberError: '',
            imageError: ''
        }

        if(this.state.orgEmail.indexOf('@') === -1){
            isError = true;
            errors.orgEmailError = 'Please enter a valid email address';
        }

        if(this.state.password.length < 4){
            isError = true;
            errors.passwordError = 'Password must be at least 4 characters long';
        }

            // if(this.state.password !== this.state.confirm){
            //     isError = true;
            //     errors.confirmError = 'Passwords must match';
            // }
        if(this.state.orgName.length < 1){
            isError = true;
            errors.orgNameError = 'orgName cannot be blank';
        }

        if(this.state.step > 1){
            if(this.state.slogan.length < 1){
                isError = true;
                errors.sloganError = 'slogan cannot be blank';
            }

            if(this.state.orgSector.length < 1){
                isError = true;
                errors.orgSectorError = 'Sector cannot be blank';
            }

            if(this.state.orgDescription.length < 1){
                isError = true;
                errors.orgDescriptionError = 'Description cannot be blank';
            }
        }

        if(this.state.step > 2){
            if(this.state.contactPerson.length < 1){
                isError = true;
                errors.contactPersonError = 'Contact person cannot be blank';
            }
            if (!this.state.contactNumber.match(/^[0-9]{10}$/)) {
                isError = true;
                errors.contactNumberError = "Please enter valid mobile number";
            }
        }

        if(this.state.step > 3){
            if(this.state.contactPerson.length < 1){
                isError = true;
                errors.contactPersonError = 'Contact person cannot be blank';
            }
        }

        if(this.state.step > 4){
            if(this.state.image){
                isError = true;
                errors.imageError = 'Input an image';
            }
        }



        this.setState({
            ...this.state,
            ...errors
        })

        return isError;
    }


    // Go to next step
    nextStep = () => {
        // const { step } = this.state;
        // this.setState({
        //     step: step + 1
        // });
        const err = this.validate()
        if(!err){
            this.setState({
                step:this.state.step + 1,
                orgNameError: '',
                orgEmailError: '',
                passwordError: '',
                sloganError: '',
                orgSectorError: '',
                orgDescriptionError: '',
                contactPersonError: '',
                contactNumberError: '',
                imageError: ''
            })
        }
    };

    // Go to prev step
    prevStep = () => {
        // const { step } = this.state;
        // this.setState({
        //     step: step - 1
        // });
        const err = this.validate()
        if(!err){
            this.setState({step:this.state.step - 1})
        }
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
        const { orgName, slogan, orgDescription, orgSector, orgEmail, contactPerson, contactNumber, password,image } = this.state;
        const values = { orgName, slogan, orgDescription, orgSector, orgEmail, contactPerson, contactNumber, password,image };
        switch (step) {
            default:
                return <h1>User Forms not working. Enable Javascript!</h1>;
            case 1:
                return (
                    <Info
                        orgNameError={this.state.orgNameError}
                        orgEmailError={this.state.orgEmailError}
                        passwordError={this.state.passwordError}
                        nextStep={this.nextStep}
                        handleChange={this.handleChange}
                        values={values}
                    />
                );

            case 2:
                return (
                    <About
                        sloganError={this.state.sloganError}
                        orgSectorError={this.state.orgSectorError}
                        orgDescriptionError={this.state.orgDescriptionError}
                        nextStep={this.nextStep}
                        prevStep={this.prevStep}
                        handleChange={this.handleChange}
                        values={values}
                    />
                );
            case 3:
                return (
                    <Contact
                        contactPersonError={this.state.contactPersonError}
                        contactNumberError={this.state.contactNumberError}
                        nextStep={this.nextStep}
                        prevStep={this.prevStep}
                        handleChange={this.handleChange}
                        values={values}
                    />
                );
            case 4:
                return (
                    <Media
                        imageError={this.state.imageError}
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