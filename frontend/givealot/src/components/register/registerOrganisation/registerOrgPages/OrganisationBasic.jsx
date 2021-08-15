import React, { Component } from 'react'
import "./basic.css"
import FeaturedHeader from "../../../featuredHeader/FeaturedHeader";
// import "./RegisterOrganisation.css"
import Button from '@material-ui/core/Button';
// import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import axios from "axios";
import InputAdornment from '@material-ui/core/InputAdornment';
import OutlinedInput from '@material-ui/core/OutlinedInput';
import LockOpenIcon from "@material-ui/icons/LockOpen";
import PersonOutlineIcon from "@material-ui/icons/PersonOutline";

export class OrganisationBasic extends Component {

    // proceed = e => {
    //     e.preventDefault()
    //     console.log(this.state)
    //     let config = {
    //         headers: {
    //             "Content-Type": "application/json",
    //             'Access-Control-Allow-Origin': '*',
    //         }
    //     }
    //     console.log(this.state)
    //     axios.post('http://localhost:8080/registration/type/organisation/info', { "orgName" : "the givers of hop","orgPassword" : "@assassinsCreed2", "orgPasswordConfirm" : "@assassinsCreed2"}, config)
    //         .then(response =>{
    //             console.log(response)
    //             // console.log(response.data[0].org_name)
    //             // this.setState({users: response.data[0].org_name})
    //
    //         })
    //         .catch(error =>{
    //             console.log(error)
    //             this.setState({error : 'Error Retrieving data'})
    //         })
    //     this.props.nextStep();
    // };
    // //   submitting = e => {
    //
    // //   };
    //
    // constructor(props) {
    //     super(props)
    //
    //     this.state = {
    //         orgName: "",
    //         orgPassword: "",
    //         orgPasswordConfirm: ""
    //
    //     }
    // }

    proceed = e => {
        e.preventDefault();
        this.props.nextStep();
    };
    back = e => {
        e.preventDefault();
        this.props.prevStep();
    };
    constructor() {
        super();
        this.state = {
            disabled: false
        };
    }

    changeHandler = (e) =>{
        this.setState({[e.target.name] : e.target.value})
    }


    render() {
        const { values, handleChange } = this.props;
        return (
            <div className="RegisterOrganisation">
                <FeaturedHeader />
                <div className="regOrgContent">
                    <div className="basicTopLine">
                        <p> Registration | Organisation | Info </p>
                    </div>
                    <form className="form">
                        <div >
                            <OutlinedInput type="type"
                               name="orgName" value={values.orgName}
                               onChange={this.changeHandler}
                               className="inputBasic" placeholder=" Name"
                               startAdornment={
                                   <InputAdornment position="start">
                                       <PersonOutlineIcon className="orgIcon" />
                                   </InputAdornment>
                               }
                            />
                        </div>

                        <div >
                            <OutlinedInput type="type"
                               name="orgPassword"
                               value={values.password}
                               onChange={this.changeHandler} className="inputBasic"
                               placeholder="Password"
                               startAdornment={
                                   <InputAdornment position="start">
                                       <LockOpenIcon className="orgIcon"/>
                                   </InputAdornment>
                               }
                            />
                        </div>

                        {/*<div >*/}
                        {/*    <OutlinedInput type="type"*/}
                        {/*       name="orgPasswordConfirm"*/}
                        {/*       value={orgPasswordConfirm}*/}
                        {/*       onChange={this.changeHandler} className="inputBasic"*/}
                        {/*       placeholder="Confirm Password"*/}
                        {/*       startAdornment={*/}
                        {/*           <InputAdornment position="start">*/}
                        {/*               <LockOpenIcon className="orgIcon"/>*/}
                        {/*           </InputAdornment>*/}
                        {/*       }*/}
                        {/*    />*/}
                        {/*</div>*/}
                        <div>
                            <Button
                                // disabled={this.state.submitting}
                                // disabled={!isEnabled}
                                style={{
                                    background: "#991A76",
                                    color: "#FFFFFF",
                                    // marginLeft: "150px",
                                    alignContent: "center",

                                }}
                                label="Continue"
                                onClick={this.proceed}
                            >
                                {" "}
                                Proceed
                            </Button>
                        </div>

                    </form>
                </div>
            </div>
        )
    }
}

export default OrganisationBasic