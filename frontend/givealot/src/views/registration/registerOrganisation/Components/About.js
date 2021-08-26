import React, { Component } from "react";
import "../Styles/registerOrganisation.css"
// import { IoPersonOutline } from "react-icons/io5";
import backgroundImg from "../../../../assets/homeBackground.jpg";
import Logo from "../../../login/Components/Logo";
import axios from 'axios'

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

    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        axios.get('http://localhost:8080/v1/organisation/get/sectors',  config)
            .then(response =>{
                console.log(response)
                this.setState({selectOptions: response.data.sectors})
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
                                <select value={values.orgSector} className="input100" onChange={handleChange('orgSector')}>
                                    <option key="kidsNextDoor">Enter Sector</option>
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
                                    >
                                        {" "}
                                        back
                                    </button>
                                    <button className="register-btn"
                                            onClick={this.proceed}
                                    >
                                        {" "}
                                        next
                                    </button>
                                </div>

                            </div>
                        </form>

                    </div>

                </div>
            </div>
        )
    }
}

export default RegisterOrganisation;