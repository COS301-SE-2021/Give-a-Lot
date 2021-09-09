import React, { Component } from "react";
import "../Styles/registerOrganisation.css"
// import { IoPersonOutline } from "react-icons/io5";
import backgroundImg from "../../../../assets/homeBackground.jpg";
import { IoReload } from "react-icons/io5";
import Logo from "../../../login/Components/Logo";
import axios from "axios";

export class Success extends Component {
    styles = {
        main: {
            backgroundImage: `url(${backgroundImg})`
        }
    }

    submit = e => {
        e.preventDefault();
        this.setState({ loading: true });

        //Faking API call here
        setTimeout(() => {
            this.setState({ loading: false });
        }, 2000);

        /*TODO: ====================wanda======================*/
        /*
        * TODO: get the all the data and replace the "some value" strings with corresponding data
        * TODO: some value
        * */
        const new_organisation = new FormData();
        new_organisation.append("orgName", "some value");
        new_organisation.append("slogan", "some value");
        new_organisation.append("orgDescription", "some value");
        new_organisation.append("orgSector", "some value");
        new_organisation.append("orgEmail", "some value");
        new_organisation.append("contactPerson", "some value");
        new_organisation.append("contactNumber", "some value");
        new_organisation.append("password", "some value");
        new_organisation.append("image", ""/*event.target.files[0]*/); //get the image from form

        fetch(
            'http://localhost:8080/v1/organisation/add/org',
            {
                method: 'POST',
                body: new_organisation,
            }
        )
        .then((response) => response.json())
        .then((result) => {
            console.log('Success:', result);

        })
        .catch((error) => {
            console.error('Error:', error);
        });
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
                               Registration was a success
                           </span>
                                <div className="button">
                                    <div className="formButton ">
                                        <button className="register-btn"
                                                onClick={this.submit}
                                                disabled={loading}
                                        >
                                            {" "}
                                            {/*Login*/}
                                            {loading && (
                                                <IoReload style={{ marginRight: "5px" }} className="refresh"/>

                                                // <i
                                                //     className="fa fa-refresh fa-spin"
                                                //     style={{ marginRight: "5px", color: "white" }}
                                                // />
                                            )}
                                            {!loading && <span>Login</span>}
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

export default Success;
