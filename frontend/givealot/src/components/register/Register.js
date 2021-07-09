import React, { Component } from 'react'
// import RegisterUser from './RegisterUser'
import RegisterOrganisation from './RegisterOrganisation'

export class Register extends Component {
    render() {
        return (
            <div className="register">
                <RegisterOrganisation />
            </div>
        )
    }
}

export default Register
