import React, { Component } from 'react'
import "./addOrg.css"


export class AddOrg extends Component {

    render() {
        return (
            <div className="addOrg">
                <div className="newUsers">
                    <h1 className="newUserTitles">New User</h1>
                    <form className="newUserForms">
                        <div className="newUserItems">
                            <label>Username</label>
                            <input type="text" placeholder="john"/>
                        </div>
                        <div className="newUserItems">
                            <label>Full Name</label>
                            <input type="text" placeholder="John Smith"/>
                        </div>
                        <div className="newUserItems">
                            <label>Email</label>
                            <input type="email" placeholder="john@gmail.com"/>
                        </div>
                        <div className="newUserItems">
                            <label>Password</label>
                            <input type="password" placeholder="password"/>
                        </div>
                        <div className="newUserItems">
                            <label>Phone</label>
                            <input type="text" placeholder="+1 123 456 78"/>
                        </div>
                        <div className="newUserItems">
                            <label>Address</label>
                            <input type="text" placeholder="New York | USA"/>
                        </div>
                        <div className="newUserItems">
                            <label>Gender</label>
                            <div className="newUserGenders">
                                <input type="radio" name="gender" id="male" value="male"/>
                                <label htmlFor="male">Male</label>
                                <input type="radio" name="gender" id="female" value="female"/>
                                <label htmlFor="female">Female</label>
                                <input type="radio" name="gender" id="other" value="other"/>
                                <label htmlFor="other">Other</label>
                            </div>
                        </div>
                        <div className="newUserItems">
                            <label>Active</label>
                            <select className="newUserSelects" name="active" id="active">
                                <option value="yes">Yes</option>
                                <option value="no">No</option>
                            </select>
                        </div>
                        <button className="newUserButtons">Create</button>
                    </form>
                </div>
            </div>
        )
    }
}

export default AddOrg
