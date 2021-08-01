import React, { Component } from "react";
// import logo from "./imagesRegister/ID2.png";
import "./RegisterOrganisation.css"
import Button from '@material-ui/core/Button';
import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import axios from "axios";
import {Switch, Route, Link} from "react-router-dom";
import Register from "../Register";
import HeaderBack from "../../HeaderBack/HeaderBack"

class OrganisationBasic extends Component {
    proceed = e => {
        e.preventDefault()
        console.log(this.state)
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        console.log(this.state)
        axios.post('http://localhost:8080/registration/type/organisation/info', { "orgName" : "the givers of hop","orgPassword" : "@assassinsCreed2", "orgPasswordConfirm" : "@assassinsCreed2"}, config)
            .then(response =>{
                console.log(response)
                // console.log(response.data[0].org_name)
                // this.setState({users: response.data[0].org_name})

            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
        this.props.nextStep();
      };
    //   submitting = e => {
        
    //   };

    constructor(props) {
        super(props)

        this.state = {
            orgName: "",
            // surname : "",
            // email: "",
            orgPassword: "",
            orgPasswordConfirm: ""

        }
    }

    changeHandler = (e) =>{
        this.setState({[e.target.name] : e.target.value})
    }

    render() {
        const {orgName,orgPassword, orgPasswordConfirm} = this.state
        // const { values, handleChange } = this.props;
        // const isEnabled = values.orgName.length > 0 && values.password.length > 0;
        return (
            <div >
                <div className="header">
                   <HeaderBack />
                </div>
                <div className="backArrow">
                    <Link to={'/register'} >
                        <ArrowBackIcon className="iconLogin"/>
                    </Link>
                </div>
                <div className="containerO" >

                <form className="form">
                    <div className="top">
                        <h4> Registration | Organisation | Info</h4>
                    </div>
                    <div >
                        {/*<label></label>*/}

                        <input type="name" 
                        className="control" 
                        placeholder="Name of Organisation"
                        // onChange={handleChange("orgName")}
                        // defaultValue={values.orgName}
                               name="orgName"
                               value={orgName}
                               onChange={this.changeHandler}

                        />
                    </div>

                    <div >
                        {/*<label></label>*/}
                        <input type="name" 
                        className="control" 
                        placeholder="Password" 
                        // onChange={handleChange("orgPassword")}
                        // defaultValue={values.orgPassword}
                               name="orgPassword"
                               value={orgPassword}
                               onChange={this.changeHandler}
                        />
                    </div>

                    <div >
                        {/*<label></label>*/}
                        <input type="name" 
                        className="control" 
                        placeholder="Confirm Password"
                        // onChange={handleChange("orgPasswordConfirm")}
                        // defaultValue={values.orgPasswordConfirm}
                               name="orgPasswordConfirm"
                               value={orgPasswordConfirm}
                               onChange={this.changeHandler}
                        />
                    </div>
                    <div>
                    <Button
                        // disabled={this.state.submitting}
                        // disabled={!isEnabled}
                        style={{
                            background: "#991A76",
                            color: "#FFFFFF",
                            marginLeft: "150px"
                        }}
                        label="Continue"
                        onClick={this.proceed}
                        >
                        {" "}
                        Proceed
                    </Button>
                    </div>

                </form>
                <div className="gradientOverlay" />
                </div>
                <Switch>
                    <Route exact path="/register" component={Register} />
                </Switch>

            </div>
        );
    }

}

export default OrganisationBasic