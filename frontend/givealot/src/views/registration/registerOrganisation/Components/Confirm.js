import React, { Component } from "react";
import "../Styles/registerOrganisation.css"
// import { IoPersonOutline } from "react-icons/io5";
import backgroundImg from "../../../../assets/homeBackground.jpg";
import { IoReload } from "react-icons/io5";
import Logo from "../../../login/Components/Logo";
import axios from "axios";

export class Confirm extends Component {
    styles = {
        main: {
            backgroundImage: `url(${backgroundImg})`
        }
    }

    // submit = e => {
    //     e.preventDefault();
    //     this.setState({ loading: true });
    //
    //     //Faking API call here
    //     setTimeout(() => {
    //         this.setState({ loading: false });
    //     }, 2000);
    //
    //     /*TODO: ====================wanda======================*/
    //     /*
    //     * TODO: get the all the data and replace the "some value" strings with corresponding data
    //     * TODO: some value
    //     * */
    //     const new_organisation = new FormData();
    //     new_organisation.append("orgName", this.props.orgName);
    //     new_organisation.append("slogan", this.props.slogan);
    //     new_organisation.append("orgDescription", this.props.orgDescription);
    //     new_organisation.append("orgSector", this.props.orgSector);
    //     new_organisation.append("orgEmail", this.props.orgEmail);
    //     new_organisation.append("contactPerson", this.props.contactPerson);
    //     new_organisation.append("contactNumber", this.props.contactNumber);
    //     new_organisation.append("password", this.props.password);
    //     new_organisation.append("image", this.props.image);
    //
    //     console.log(this.props)
    //
    //     // fetch(
    //     //     'http://localhost:8080/v1/organisation/add/org',
    //     //     {
    //     //         method: 'POST',
    //     //         body: new_organisation,
    //     //     }
    //     // )
    //     // .then((response) => response.json())
    //     // .then((result) => {
    //     //     console.log('Success:', result);
    //     //
    //     // })
    //     // .catch((error) => {
    //     //     console.error('Error:', error);
    //     // });
    // };
    proceed = e => {
        e.preventDefault();
        this.setState({ loading: true });
            //Faking API call here
            setTimeout(() => {
                this.setState({ loading: false });
            }, 2000);
        fetch(
         'http://localhost:8080/v1/organisation/add/org',
                {
                    method: 'POST',
                    // body: new_organisation,
                }
            )
            .then((response) => response.json())
            .then((result) => {
                console.log('Success:', result);

            })
            .catch((error) => {
                console.error('Error:', error);
            });
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
            loading: false
        };
    }

    render() {
        const {
            values: { slogan, orgEmail, orgSector, orgDescription, contactNumber, contactPerson, orgName }
        } = this.props;
        const { loading } = this.state;
        return (
            <div className="registerOrganisation" style={this.styles.main}>
                <div  id={"banner_filter"}>
                    <Logo/>
                    <div className="registerCard">
                        <div className="wrap">
                            <form className="form1">
                           <span className="headerTag">
                               One step away
                           </span>
                                <div className="button">
                                    <div className="formButton">
                                        <button className="about-org-btn"
                                                onClick={this.back}
                                        >
                                            {" "}
                                            back
                                        </button>
                                        <button className="about-org-btn"
                                                onClick={this.proceed}
                                                disabled={loading}
                                        >
                                            {" "}
                                            {/*submit*/}
                                            {loading && (
                                                <IoReload style={{ marginRight: "5px" }} className="refresh"/>

                                                // <i
                                                //     className="fa fa-refresh fa-spin"
                                                //     style={{ marginRight: "5px", color: "white" }}
                                                // />
                                            )}
                                            {!loading && <span>Submit</span>}
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default Confirm;
