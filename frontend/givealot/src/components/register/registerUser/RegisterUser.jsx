import React, { Component } from 'react'
import "./registerUser.css"
import FeaturedHeader from "../../featuredHeader/FeaturedHeader";
import OutlinedInput from "@material-ui/core/OutlinedInput";
import InputAdornment from "@material-ui/core/InputAdornment";
import MailOutlineIcon from "@material-ui/icons/MailOutline";
import LockOpenIcon from "@material-ui/icons/LockOpen";
import {Link} from "react-router-dom";
import axios from "axios";

export class RegisterUser extends Component {

    constructor(props) {
        super(props)

        this.state = {
            email: "",
            password : "",
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
        const {email, password} = this.state
        return (
            <div className="RegisterUser">
                <FeaturedHeader />
                <div className="RegisterUserBody">
                    <div className="RegisterUserContainer">
                        <div className="RegisterUserContent">
                            <div className="RegisterUsercontainer" >
                                <form onSubmit={this.submitHandler}>
                                    <div className="topLine">
                                        <p> Register User </p>
                                    </div>
                                    <div >
                                        <OutlinedInput type="type" name="email"
                                           value={email} onChange={this.changeHandler}
                                           className="RegisterUserinput" placeholder="Name"
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
                                           onChange={this.changeHandler} className="RegisterUserinput"
                                           placeholder="Surname"
                                           startAdornment={
                                               <InputAdornment position="start">
                                                   <LockOpenIcon className="loginIcon"/>
                                               </InputAdornment>
                                           }
                                        />
                                    </div>

                                    <div >
                                        <OutlinedInput type="type" name="email"
                                           value={email} onChange={this.changeHandler}
                                           className="RegisterUserinput" placeholder="Name"
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
                                           onChange={this.changeHandler} className="RegisterUserinput"
                                           placeholder="Surname"
                                           startAdornment={
                                               <InputAdornment position="start">
                                                   <LockOpenIcon className="loginIcon"/>
                                               </InputAdornment>
                                           }
                                        />
                                    </div>

                                    <div style={{color: "white"}}>
                                        <div id="createAccount">
                                            <span>Login? <span style={{textDecoration:"underline", color: "white", cursor: "pointer"}} ><Link to="/register">Sign in</Link></span></span>
                                        </div>

                                    </div>
                                    <div>
                                        <button type="submit" className="RegisterUserbutton">Sign Up</button>
                                    </div>

                                </form>
                                <div className="gradientOverlay" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default RegisterUser
