import React, { Component } from 'react'
import "./basic.css"
import FeaturedHeader from "../../../featuredHeader/FeaturedHeader";
// import "./RegisterOrganisation.css"
import Button from '@material-ui/core/Button';
// import ArrowBackIcon from '@material-ui/icons/ArrowBack';
// import axios from "axios";
import OutlinedInput from "@material-ui/core/OutlinedInput";
import InputAdornment from "@material-ui/core/InputAdornment";
// import PersonOutlineIcon from "@material-ui/icons/PersonOutline";
import DescriptionIcon from '@material-ui/icons/Description';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import Select from '@material-ui/core/Select';


export class OrganisationAbout extends Component {

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

    // changeHandler = (e) =>{
    //     this.setState({[e.target.name] : e.target.value})
    // }

    render() {
        const { values, handleChange } = this.props;
        return (
            <div className="RegisterOrganisation">
                <FeaturedHeader />
                <div className="regOrgContent">
                    <div className="basicTopLine">
                        <p> Registration | Organisation | About </p>
                    </div>
                    <form className="form">
                        <div >
                            <OutlinedInput type="type"
                               name="slogan"
                               defaultValue={values.slogan}
                               // onChange={this.handleChange}
                               onChange={handleChange('slogan')}
                               className="inputBasic" placeholder="Slogan"
                               startAdornment={
                                   <InputAdornment position="start">
                                       <DescriptionIcon className="orgIcon" />
                                   </InputAdornment>
                               }
                            />
                        </div>
                        <div >
                            <OutlinedInput type="type"
                               name="orgSector"
                               defaultValue={values.orgSector}
                               // onChange={this.handleChange}
                               onChange={handleChange('orgSector')}
                               className="inputBasic" placeholder="Sector"
                               startAdornment={
                                   <InputAdornment position="start">
                                       <DescriptionIcon className="orgIcon" />
                                   </InputAdornment>
                               }
                            />

                        </div>

                        <div >
                            <OutlinedInput type="type"
                               multiline={true}
                               maxRows={50}
                               defaultValue={values.orgDescription}
                               // onChange={this.handleChange}
                               onChange={handleChange('orgDescription')}
                               className="inputBasic" placeholder="Description"
                               startAdornment={
                                   <InputAdornment position="start">
                                       <DescriptionIcon className="orgIcon" />
                                   </InputAdornment>
                               }
                            />
                        </div>

                        <div style={{display: "flex",alignContent:"center", justifyContent: "space-around"}}>
                            <Button
                                style={{
                                    background: "#EE3B55",
                                    color: "#FFFFFF",
                                    // marginLeft: "120px"
                                }}
                                label="Back"
                                onClick={this.back}
                            >
                                Back
                            </Button>
                            <Button
                                style={{
                                    background: "#991A76",
                                    color: "#FFFFFF",
                                    // marginLeft: "40px"
                                }}
                                label="Continue"
                                onClick={this.proceed}
                            >
                                {" "}
                                Proceed
                            </Button>
                            {/* <button type="submit" className="button">Prcoceed</button> */}
                        </div>

                    </form>
                </div>
            </div>
        )
    }
}

export default OrganisationAbout