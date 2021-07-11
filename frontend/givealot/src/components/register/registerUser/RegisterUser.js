import React, { Component } from "react";
// import "../Register.css";
import "./RegisterUser.css"
// import {FaGithub } from "react-icons/fa";
import logo from "../imagesRegister/ID2.png";
import axios from 'axios';
import { Redirect } from "react-router";
import Login from "../../login/Login"
import {Switch,Route} from "react-router-dom";
import PopUp from "./PopUp";


class RegisterUser extends Component {
    state = {
        redirect: false
    }
    redirectHandler = () => {
        this.setState({ redirect: true })
        this.renderRedirect();
    }
    renderRedirect = () => {
        if (this.state.redirect) {
            return <Redirect to='/login' />
        }
    }

    constructor(props) {
        super(props)
    
        this.state = {
            name: "",
            surname : "",
            email: "",
            password: "",
            confirmPassword: ""

        }
    }
    state = {
        seen: false
      };
    
      togglePop = () => {
        this.setState({
          seen: !this.state.seen
        });
      };
    

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
                <div className="header">
                    <div style={{width: "220px",height: "70px"}}>
                        <img id="ID" src={logo} alt=""/>
                    </div>

                </div>
                <div className="container" >

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
                        {/* <div>
                            <button type="submit" className="button" onClick={this.redirectHandler}>
                                Sign Up
                                {this.renderRedirect()}
                            </button>
                        </div> */}
                        <div>
                            <div >
                                <button className="button" onClick={this.togglePop}>Sign Up</button>
                            </div>
                            {this.state.seen ? <PopUp toggle={this.togglePop} /> : null}
                        </div>

                    </form>
                    <div className="gradientOverlay"></div>
                    <Switch>       
                        <Route exact path="/login" component={Login} />
                    </Switch>
                </div>
            </div>
        );
    }

}

export default RegisterUser