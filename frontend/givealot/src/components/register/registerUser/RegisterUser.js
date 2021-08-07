import React, { Component } from "react";
import "./RegisterUser.css"
import axios from 'axios';
import Login from "../../login/Login"
import {Switch,Route, Link} from "react-router-dom";
import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import DialogTitle from '@material-ui/core/DialogTitle'
import Dialog from '@material-ui/core/Dialog'
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import Button from '@material-ui/core/Button';
import Register from "../Register"
import HeaderBack from "../../HeaderBack/HeaderBack"
import InputAdornment from '@material-ui/core/InputAdornment';
import OutlinedInput from '@material-ui/core/OutlinedInput';
import MailOutlineIcon from "@material-ui/icons/MailOutline";
import PersonOutlineIcon from '@material-ui/icons/PersonOutline';
import LockOpenIcon from "@material-ui/icons/LockOpen";

class RegisterUser extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
            name: "",
            surname : "",
            email: "",
            password: "",
            confirmPassword: "",
            open: false,

        }
    }
    changeHandler = (e) =>{
        this.setState({[e.target.name] : e.target.value})
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
        const {name, surname, email, password, confirmPassword} = this.state
        return (
            <div >
                <div>
                    <HeaderBack />
                </div>

                <div className="backArrow">
                    <Link to={'/register'} >
                        <ArrowBackIcon style={{color: "white"}} />
                    </Link>
                </div>
                <div className="containerU" >

                    <form className="form" onSubmit={this.submitHandler}>
                        <div className="top">
                            <p> Registration | USER</p>
                        </div>
                            <div >
                                <OutlinedInput type="type"
                                   name="name" value={name}
                                   onChange={this.changeHandler}
                                   className="input" placeholder=" Name"
                                   startAdornment={
                                       <InputAdornment position="start">
                                           <PersonOutlineIcon style={{color:"#4f9ccf"}} />
                                       </InputAdornment>
                                   }
                                />
                            </div>

                            <div >
                                <OutlinedInput type="type"
                                   name="surname" value={surname}
                                   onChange={this.changeHandler}
                                   className="input" placeholder="Surname"
                                   startAdornment={
                                       <InputAdornment position="start">
                                           <PersonOutlineIcon style={{color:"#4f9ccf"}} />
                                       </InputAdornment>
                                   }
                                />
                            </div>

                        <div >
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

                        <div >
                            <OutlinedInput type="type"
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

                        <div >
                            <OutlinedInput type="type"
                               name="confirmPassword" value={confirmPassword}
                               onChange={this.changeHandler} className="input"
                               placeholder="Confirm Password"
                               startAdornment={
                                   <InputAdornment position="start">
                                       <LockOpenIcon className="loginIcon"/>
                                   </InputAdornment>
                               }
                            />
                        </div>

                        <div>
                            <button className="button" onClick={() => this.setState({ open: !this.state.open })}>
                                Sign Up
                            </button>

                            <header className='App-header'>
                                <Dialog open={this.state.open}>

                                    <DialogTitle id="alert-dialog-title">{"Login to GiveAlot?"}</DialogTitle>
                                    <DialogContent>
                                        <DialogContentText id="alert-dialog-description">
                                            Thank you for Registering
                                        </DialogContentText>
                                    </DialogContent>
                                    <DialogActions>
                                        <Link to={'/login'} >
                                            <Button onClick={() => this.setState({ open: !this.state.open })} color="primary" autoFocus>
                                                Click to Login
                                            </Button>
                                        </Link>

                                    </DialogActions>
                                </Dialog>
                            </header>
                        </div>

                    </form>
                    <div className="gradientOverlay"></div>
                    <Switch>       
                        <Route exact path="/login" component={Login} />
                        <Route exact path="/register" component={Register} />
                    </Switch>
                </div>
            </div>
        );
    }

}

export default RegisterUser