import React, { Component } from 'react'
import "./loginBody.css"
import axios from "axios"
import MailOutlineIcon from '@material-ui/icons/MailOutline';
import InputAdornment from '@material-ui/core/InputAdornment';
import LockOpenIcon from '@material-ui/icons/LockOpen';
import OutlinedInput from '@material-ui/core/OutlinedInput';
import {Link} from "react-router-dom";
import FormError from "../../register/registerUser/FormError";

export class Login extends Component {

    constructor(props) {
        super(props)

        this.state = {
            email: "",
            password : "",
            formErrors: {email: '', password: ''},
            emailValid: false,
            passwordValid: false,
            formValid: false
        }
    }

    changeHandler = (e) =>{
        // this.setState({[e.target.name] : e.target.value})
        const name = e.target.name;
        const value = e.target.value;
        this.setState({[name]: value},
            () => { this.validateFields(name, value) });
    }

    validateFields(fieldName, value) {
        let fieldValidationError = this.state.formErrors;
        let emailValid = this.state.emailValid;
        let passwordValid = this.state.passwordValid;

        switch(fieldName) {
            case 'email':
                emailValid = value.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i);
                fieldValidationError.email = emailValid ? '' : ' is invalid';
                break;
            case 'password':
                passwordValid = value.length >= 6;
                fieldValidationError.password = passwordValid ? '': ' is too short';
                break;
            default:
                break;
        }
        this.setState({formErrors: fieldValidationError,
            emailValid: emailValid,
            passwordValid: passwordValid
        }, this.validateForm);
    }

    validateForm() {
        this.setState({formValid: this.state.emailValid && this.state.passwordValid});
    }

    errorClass(error) {
        return(error.length === 0 ? '' : 'has-error');
    }


    submitHandler = (e) =>{
        e.preventDefault()
        console.log(this.state)
        axios.post('https://jsonplaceholder.typicode.com/posts', this.state)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    render() {
        const {email, password} = this.state
        return (
            <div className="LoginBody">
               <div className="loginbodyContainer">
                   <div className="loginContent">
                       <div className="Login_container" >
                           <form onSubmit={this.submitHandler}>
                               <div className="topLine">
                                   <p> Login </p>
                               </div>

                               <div className="panel panel-default">
                                   <FormError formErrors={this.state.formErrors} />
                               </div>

                               <div className={`form-group ${this.errorClass(this.state.formErrors.email)}`}>
                                   <OutlinedInput type="type" name="email"
                                      value={email} onChange={this.changeHandler}
                                      className="input" placeholder="Email"
                                      startAdornment={
                                          <InputAdornment position="start">
                                              <MailOutlineIcon className="loginIcon"/>
                                          </InputAdornment>
                                      }
                                   />
                               </div>

                               <div className={`form-group ${this.errorClass(this.state.formErrors.password)}`}>
                                   <OutlinedInput type="password"
                                      name="password" value={password}
                                      onChange={this.changeHandler} className="input"
                                      placeholder="Password"
                                      startAdornment={
                                          <InputAdornment position="start">
                                              <LockOpenIcon className="loginIcon"/>
                                          </InputAdornment>
                                      }
                                    />
                               </div>

                               <div style={{color: "white"}}>
                                   <div id="createAccount">
                                       <span>Create Account?
                                           <Link to="/register">
                                               <span style={{textDecoration:"underline", color: "white", cursor: "pointer", paddingLeft: "8px"}} >
                                                   Sign Up
                                                </span>
                                            </Link>
                                       </span>
                                   </div>
                               </div>
                               <div>
                                   <button type="submit" className="Login_button" disabled={!this.state.formValid}>Sign In</button>
                               </div>
                           </form>
                           <div className="gradientOverlay" />
                       </div>
                   </div>
               </div>
            </div>
        )
    }
}

export default Login