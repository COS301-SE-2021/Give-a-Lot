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

        console.log(this.props)
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.post('http://localhost:8080/v1/organisation/add/org', this.props ,config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
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
