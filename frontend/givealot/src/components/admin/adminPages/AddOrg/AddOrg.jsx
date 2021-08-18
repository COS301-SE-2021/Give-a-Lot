import React, { Component } from 'react'
import "./addOrg.css"
import axios from "axios";


export class AddOrg extends Component {

    constructor(props) {
        super(props)

        this.state = {
            adminUserEmail: "",
            orgName : "",
            slogan : "",
            orgDescription : "",
            orgSector : "",
            orgEmail : "",
            contactPerson : "",
            contactNumber : "",
            password : ""
        }
    }

    changeHandler = (e) =>{
        // this.setState({[e.target.name] : e.target.value})
        // const name = e.target.name;
        // const value = e.target.value;
        this.setState({[e.target.name] : e.target.value})
    }

    submitAdd = (e) =>{
        e.preventDefault()
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        console.log(this.state)
        const AddRequestBody = {
            orgName : this.state.orgName,
            slogan : this.state.slogan,
            orgDescription : this.state.orgDescription,
            orgSector : this.state.orgSector,
            orgEmail : this.state.orgEmail,
            contactPerson : this.state.contactPerson,
            contactNumber : this.state.contactNumber,
            password :  this.state.password,
        }
        console.log(AddRequestBody)
        axios.post('http://localhost:8080/v1/organisation/add/org', AddRequestBody , {config})
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    render() {
        const {orgName, slogan, orgEmail, password, orgSector, contactPerson, contactNumber, orgDescription} = this.state
        return (
            <div className="addOrg">
                <div className="newUsers">
                    <h1 className="newUserTitles">New Organisation</h1>
                    <form className="newUserForms" onSubmit={this.submitAdd}>
                        <div className="newUserItems">
                            <label>Organisation Name</label>
                            <input type="text" placeholder="john"
                               name="orgName"
                               onChange={this.changeHandler}
                               value={orgName}
                            />
                        </div>
                        <div className="newUserItems">
                            <label>Slogan</label>
                            <input type="text" placeholder="John Smith"
                               name="slogan"
                               onChange={this.changeHandler}
                               value={slogan}
                            />
                        </div>
                        <div className="newUserItems">
                            <label>Email</label>
                            <input type="email" placeholder="john@gmail.com"
                               name="orgEmail"
                               onChange={this.changeHandler}
                               value={orgEmail}
                            />
                        </div>
                        <div className="newUserItems">
                            <label>Password</label>
                            <input type="password" placeholder="password"
                               name="password"
                               onChange={this.changeHandler}
                               value={password}
                            />
                        </div>
                        <div className="newUserItems">
                            <label>Sector</label>
                            <input type="text" placeholder="Education"
                               name="contactPerson"
                               onChange={this.changeHandler}
                               value={contactPerson}
                            />
                        </div>
                        <div className="newUserItems">
                            <label>Contact Person</label>
                            <input type="text" placeholder="Name"
                               name="orgSector"
                               onChange={this.changeHandler}
                               value={orgSector}
                            />
                        </div>
                        <div className="newUserItems">
                            <label>Description</label>
                            <input type="text" placeholder="john"
                               name="orgDescription"
                               onChange={this.changeHandler}
                               value={orgDescription}
                            />
                        </div>
                        <div className="newUserItems">
                            <label>Contact Number</label>
                            <input type="text" placeholder="+27 73464 0243"
                               name="contactNumber"
                               onChange={this.changeHandler}
                               value={contactNumber}
                            />
                        </div>
                        {/*<div className="newUserItems">*/}
                        {/*    <label>Status</label>*/}
                        {/*    <input type="text" placeholder="+27 73464 0243"*/}
                        {/*       onChange={this.changeHandler}*/}
                        {/*       value={contactNumber}*/}
                        {/*    />*/}
                        {/*    /!*<select className="newUserSelects" name="active" id="active">*!/*/}
                        {/*    /!*    <option value="yes">Yes</option>*!/*/}
                        {/*    /!*    <option value="no">No</option>*!/*/}
                        {/*    /!*</select>*!/*/}
                        {/*</div>*/}
                        <button className="newUserButtons" type="submit">Create</button>
                    </form>
                </div>
            </div>
        )
    }
}

export default AddOrg
