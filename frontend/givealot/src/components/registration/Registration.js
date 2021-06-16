
import React, { Component } from "react";
export default class Registration extends Component {
    render() {
        return (
            <form style={{position: "absolute", left: "450px", top: "200px", width:"500px"}}>
                <h3>Register</h3>

                <div className="form-group">
                    <input type="text" className="form-control" placeholder="First name" />
                </div>

                <div className="form-group">
                    <input type="text" className="form-control" placeholder="Last name" />
                </div>

                <div className="form-group">
                    <input type="email" className="form-control" placeholder="Enter email" />
                </div>

                <div className="form-group">

                    <input type="password" className="form-control" placeholder="Enter password" />
                </div>

                <button type="submit" className="btn btn-dark btn-lg btn-block">Register</button>
                <p className="forgot-password text-right">
                    Already registered <a href="/login">log in?</a>
                </p>
            </form>
        );
    }
}