import React, { Component } from 'react'
import "./loginBody.css"
import axios from "axios"
import MailOutlineIcon from '@material-ui/icons/MailOutline';
import InputAdornment from '@material-ui/core/InputAdornment';
import LockOpenIcon from '@material-ui/icons/LockOpen';
import OutlinedInput from '@material-ui/core/OutlinedInput';
import {Link} from "react-router-dom";

export class Login extends Component {

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
            <div className="LoginBody">
               <div className="loginbodyContainer">
                   <div className="loginContent">
                       <div className="Login_container" >
                           <form onSubmit={this.submitHandler}>
                               <div className="topLine">
                                   <p> Login </p>
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
                                   <button type="submit" className="Login_button">Sign In</button>
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
