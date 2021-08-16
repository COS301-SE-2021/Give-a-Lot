import React, { Component } from 'react'
import "./registerUser.css"
import FeaturedHeader from "../../featuredHeader/FeaturedHeader";
import OutlinedInput from "@material-ui/core/OutlinedInput";
import InputAdornment from "@material-ui/core/InputAdornment";
import MailOutlineIcon from "@material-ui/icons/MailOutline";
import LockOpenIcon from "@material-ui/icons/LockOpen";
import {Link} from "react-router-dom";
import axios from "axios";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import PersonIcon from '@material-ui/icons/Person';
import FormError from "./FormError"



export class RegisterUser extends Component {

    constructor(props) {
        super(props)

        this.state = {
            email: "",
            password : "",
            surname: "",
            name: "",
            formErrors: {email: '', password: '', surname: '', name: ''},
            emailValid: false,
            surnameValid: false,
            nameValid: false,
            passwordValid: false,
            formValid: false
        }
    }

    changeHandler = (e) =>{
        const name = e.target.name;
        const value = e.target.value;
        this.setState({[name]: value},
            () => { this.validateField(name, value) });
        // this.setState({[e.target.name] : e.target.value}, () => { this.validateField(name, value) })
    }

    validateField(fieldName, value) {
        let fieldValidationErrors = this.state.formErrors;
        let emailValid = this.state.emailValid;
        let passwordValid = this.state.passwordValid;

        switch(fieldName) {
            case 'email':
                emailValid = value.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i);
                fieldValidationErrors.email = emailValid ? '' : ' is invalid';
                break;
            case 'password':
                passwordValid = value.length >= 6;
                fieldValidationErrors.password = passwordValid ? '': ' is too short';
                break;
            default:
                break;
        }
        this.setState({formErrors: fieldValidationErrors,
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
                toast("Registration successful, You can now Login", {
                    position: toast.POSITION.TOP_RIGHT,
                    className: 'toast-notify',
                    progressClassName: 'notify-progress-bar',
                    // autoClose: 50000000
                });
                // toast.success('Registration success')
                // window.location.href = "/login";
            })
            .catch(error =>{
                console.log(error)
                toast.success('Registration failed ')
            })
    }

    render() {
        const {email, password, surname, name} = this.state
        return (
            <div className="RegisterUser">
                <FeaturedHeader />
                <div className="RegisterUserBody">
                    <div className="RegisterUserContainer">
                        <div className="RegisterUserContent">
                            <div className="RegisterUsercontainer" >
                                <form onSubmit={this.submitHandler}>

                                    <div className="panel panel-default">
                                        <FormError formErrors={this.state.formErrors} />
                                    </div>

                                    <div className="topLine">
                                        <p> Register User </p>
                                    </div>
                                    <div className={`form-group ${this.errorClass(this.state.formErrors.password)}`}>
                                        <OutlinedInput type="type" name="name"
                                           value={name} onChange={this.changeHandler}
                                           className="RegisterUserinput" placeholder="Name" required
                                           startAdornment={
                                               <InputAdornment position="start">
                                                   <PersonIcon className="loginIcon"/>
                                               </InputAdornment>
                                           }
                                        />
                                    </div>

                                    <div className={`form-group ${this.errorClass(this.state.formErrors.password)}`}>
                                        <OutlinedInput type="type"
                                           name="surname" value={surname}
                                           onChange={this.changeHandler} className="RegisterUserinput"
                                           placeholder="Surname"
                                           startAdornment={
                                               <InputAdornment position="start">
                                                   <PersonIcon className="loginIcon"/>
                                               </InputAdornment>
                                           }
                                        />
                                    </div>

                                    <div className={`form-group ${this.errorClass(this.state.formErrors.email)}`}>
                                        <OutlinedInput type="email" name="email"
                                           value={email} onChange={this.changeHandler}
                                           className="RegisterUserinput" placeholder="Email"
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
                                           onChange={this.changeHandler} className="RegisterUserinput"
                                           placeholder="password"
                                           startAdornment={
                                               <InputAdornment position="start">
                                                   <LockOpenIcon className="loginIcon"/>
                                               </InputAdornment>
                                           }
                                        />
                                    </div>


                                    <div style={{color: "white"}}>
                                        <div id="createAccount">
                                            <span>Login?
                                               <Link to="/login">
                                                   <span style={{textDecoration:"underline", color: "white", cursor: "pointer", paddingLeft: "8px"}} >
                                                       Sign In
                                                    </span>
                                                </Link>
                                            </span>
                                        </div>

                                    </div>
                                    <div>
                                        <button type="submit" className="RegisterUserbutton" disabled={!this.state.formValid}>Sign Up</button>
                                    </div>
                                    <div className="form-group">
                                        <ToastContainer/>
                                    </div>

                                </form>
                                <div className="gradientOverlay" />
                            </div>
                        </div>
                    </div>
                </div>
                {/*<div className="form-group">*/}
                {/*    <ToastContainer/>*/}
                {/*</div>*/}
            </div>
        )
    }
}

export default RegisterUser
