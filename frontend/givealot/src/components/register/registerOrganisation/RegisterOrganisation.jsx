// import React, { Component } from 'react'
// import "./registerOrganisation.css"
// import FeaturedHeader from "../../featuredHeader/FeaturedHeader";
//
// export class RegisterOrganisation extends Component {
//
//     render() {
//         return (
//             <div className="RegisterOrganisation">
//                 <FeaturedHeader />
//                 <div className="regOrgContent">
//                     here is the stuff
//                 </div>
//             </div>
//         )
//     }
// }
//
// export default RegisterOrganisation

import React, { Component } from "react";
import OrganisationBasic from "./registerOrgPages/OrganisationBasic"
import OrganisationContact from "./registerOrgPages/OrganisationContact";
import OrganisationAbout from "./registerOrgPages/OrganisationAbout";
import OrganisationMedia from "./registerOrgPages/OrganisationMedia"

export class RegisterOrganisation extends Component {
    state = {
        step: 1,
        image: "",
        slogan: "",
        sector: "",
        description: "",
        contactPerson: "",
        contactName: "",
        email: "",
        orgName:"",
        orgPassword: "",
        orgPasswordConfirm: "",

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
        console.log(e.target.value);
    };

    render() {
        const { step } = this.state;
        const { image, slogan, email, sector, description, contactNumber, contactPerson, orgName } = this.state;
        const values = { image, slogan, email, sector, description, contactNumber, contactPerson, orgName };

        switch (step) {
            default:
                return <h1>User Forms not working. Enable Javascript!</h1>;
            case 1:
                return (
                    <OrganisationBasic
                        nextStep={this.nextStep}
                        handleChange={this.handleChange}
                        values={values}
                    />
                );

            case 2:
                return (
                    <OrganisationContact
                        nextStep={this.nextStep}
                        prevStep={this.prevStep}
                        handleChange={this.handleChange}
                        values={values}
                    />
                );
            case 3:
                return (
                    <OrganisationAbout
                        nextStep={this.nextStep}
                        prevStep={this.prevStep}
                        handleChange={this.handleChange}
                        values={values}
                    />
                );
            case 4:
                return (
                    <OrganisationMedia
                        nextStep={this.nextStep}
                        prevStep={this.prevStep}
                        handleChange={this.handleChange}
                        values={values}
                    />
                );
            // case 5:
            //   return (
            //     <ConfirmOrgRegistration
            //       nextStep={this.nextStep}
            //       prevStep={this.prevStep}
            //       values={values}
            //     />
            //   );
            //
            // //
            // case 6:
            //   return <OrgSuceessRegistration firstStep={this.firstStep} />;
        }
    }
}
export default RegisterOrganisation;