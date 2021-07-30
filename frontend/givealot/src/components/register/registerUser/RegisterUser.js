import React, { Component } from "react";
import "./RegisterUser.css"
import logo from "../imagesRegister/ID2.png";
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
                    <img id="ID" src={logo} alt="" style={{width: "220px ",height: "70px"}}/>
                </div>

                <div className="backArrow">
                    <Link to={'/register'} >
                        <ArrowBackIcon className="iconLogin"/>
                    </Link>
                </div>
                <div className="containerU" >

                    <form className="form" onSubmit={this.submitHandler}>
                        <div className="top">
                            <p> Registration | USER</p>
                        </div>
                        <div >
                            <label></label>

                            <input type="type" name="name" value={name} onChange={this.changeHandler}className="control" placeholder=" Name" />
                        </div>

                        <div >
                            <label></label>
                            <input type="type" name="surname" value={surname} onChange={this.changeHandler}className="control" placeholder="Surname" />
                        </div>

                        <div >
                            <label></label>
                            <input type="type" name="email" value={email} onChange={this.changeHandler}className="control" placeholder="Email" />
                        </div>

                        <div >
                            <label></label>
                            <input type="password" name="password" value={password} onChange={this.changeHandler}className="control" placeholder="Password" />
                        </div>
                        <div >
                            <label></label>
                            <input type="password" name="confirmPassword" value={confirmPassword} onChange={this.changeHandler} className="control" placeholder="Confirm Password" />
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
                                        <Button onClick={() => this.setState({ open: !this.state.open })} color="primary" autoFocus>
                                            Click to Login
                                        </Button>
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