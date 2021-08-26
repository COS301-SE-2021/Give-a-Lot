import React, { Component } from "react";
import "../Styles/registerOrganisation.css"
import { IoPersonOutline } from "react-icons/io5";
import backgroundImg from "../../../../assets/homeBackground.jpg";
import Logo from "../../../login/Components/Logo";
import {Link} from "react-router-dom";
import ArrowBackIcon from "@material-ui/icons/ArrowBack";
import axios from 'axios'
import Select from 'react-select';

export class RegisterOrganisation extends Component {
    constructor() {
        super();
        this.state = {
            disabled: false,
            selectOptions : [],
            id: "",
            name: '',
            temp: []
        };
    }

    // componentDidMount(){
        // const res = await axios.get('http://localhost:8080/v1/organisation/get/sectors')
        // const data = res.data
        // console.log(data)

        // const options = data.sectors.map(d => ({
        //     "value" : d.id,
        //     "label" : d.name
        // }))
        // this.setState({selectOptions: data})
    // }

    // componentDidMount(){
    //     this.getOptions()
    // }

    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        // const adminUsersRequestBody = {
        //     "adminUserEmail" : this.state.adminUserEmail
        // }
        axios.get('http://localhost:8080/v1/organisation/get/sectors',  config)
            .then(response =>{
                console.log(response)
                // const options = response.data.sectors.map(d => ({
                //     "value" : d.value,
                //     // "label" : d.name
                // }))
                // this.setState({selectOptions: options})
                this.setState({selectOptions: response.data.sectors})
                // console.log(this.state.selectOptions)
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    styles = {
        main: {
            backgroundImage: `url(${backgroundImg})`
        }
    }

    proceed = e => {
        e.preventDefault();
        this.props.nextStep();
    };
    back = e => {
        e.preventDefault();
        this.props.prevStep();
    };


    render() {
        let optionsTemp = [];
        console.log(this.state.selectOptions);
        for(let i=0; i < this.state.selectOptions.length; i++){
            console.log(this.state.selectOptions[i]);
            // optionsTemp = this.state.selectOptions[i].map(i => ({
            //     //     "value" : d.id,
            //     //     "label" : d.name
            // })
            // optionsTemp.add(<option value={this.state.selectOptions[i]}>{this.state.selectOptions[i]}</option>)
        }
        console.log(optionsTemp);
        const { values, handleChange, nextStep } = this.props;
        return (
            <div className="registerOrganisation" style={this.styles.main}>
                <Logo/>
                <div className="registerCard">
                    <div className="wrap">
                        <form className="form">
                       <span className="headerTag">
                           Register Organisation | About
                       </span>
                            <div className="input alert-validate" data-validate="Username is required">
                                <span className="inputLabel">
                                    Slogan
                                </span>
                                <div style={{display: "flex"}}>
                                    {/*<IoPersonOutline className="registerIcon"/>*/}
                                    <input className="input100 validateInput"
                                           type="text" name="slogan"
                                           placeholder="Enter Organisation Slogan"
                                           value={values.slogan}
                                           onChange={handleChange('slogan')}
                                    />
                                    <span style={{float: "right", color: "red"}}><small>{this.props.sloganError}</small></span>
                                </div>

                            </div>

                            <div className="input alert-validate" data-validate="Username is required">
                                <span className="inputLabel">
                                    Sector
                                </span>
                                {/*<Select options={this.state.selectOptions}*/}
                                {/*        className="input100"*/}
                                {/*        onChange={handleChange('orgSector')}*/}
                                {/*/>*/}
                                <select value={values.orgSector} className="input100" onChange={handleChange('orgSector')}>
                                    <option key="wanda">Enter Sector</option>
                                    {this.state.selectOptions.map((item) =>
                                        <option key={item} value={item}>{item}</option>
                                    )}
                                </select>
                                <span style={{float: "right", color: "red"}}><small>{this.props.orgSectorError}</small></span>
                            </div>
                            <div className="input alert-validate">
                                <span className="inputLabel">
                                    Description
                                </span>
                                <textarea cols="40" rows="5" className="input100"
                                          type="text" name="orgDescription"
                                            placeholder="Enter Organisation Description"
                                            value={values.orgDescription}
                                            onChange={handleChange('orgDescription')}
                                />

                                <span style={{float: "right", color: "red"}}><small>{this.props.orgDescriptionError}</small></span>
                            </div>
                            <div className="button">
                                <div className="formButton ">
                                    <button className="register-btn"
                                            onClick={this.back}
                                            label="back"
                                    >
                                        {" "}
                                        back
                                    </button>
                                    <button className="register-btn"
                                            onClick={this.proceed}
                                            label="Continue"
                                    >
                                        {" "}
                                        next
                                    </button>
                                </div>

                            </div>
                        </form>

                        {/*<p style={{padding: "10px"}}>I'm already a member! <a data-toggle="tab" href="#signin">Sign In</a></p>*/}

                    </div>

                </div>
            </div>
        )
    }
}

export default RegisterOrganisation;