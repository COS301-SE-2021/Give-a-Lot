import React, { Component } from "react";
class RegisterUser extends Component {

    render() {
        return (
            <div>
                <div className="container">
                    <div className="gradientOverlay"></div>
                    <form className="form">
                        <div className="top">
                            <h4> Registration | USER</h4>
                        </div>
                        <div >
                            <label></label>

                            <input type="name" className="control" placeholder=" Name" />
                        </div>

                        <div >
                            <label></label>
                            <input type="name" className="control" placeholder="Surname" />
                        </div>

                        <div >
                            <label></label>
                            <input type="email" className="control" placeholder="Email" />
                        </div>

                        <div >
                            <label></label>
                            <input type="password" className="control" placeholder="Password" />
                        </div>
                        <div>
                            <button type="submit" className="button">Sign Up</button>
                        </div>
                    </form>
                </div>
            </div>
        );
    }

}

export default RegisterUser