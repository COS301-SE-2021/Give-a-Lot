import React, { Component } from 'react'
import Mailer from "./Mailer"
import "./Email.css"


export class Emails extends Component {

    render() {
        return (
            <div className="email">
                <Mailer/>
            </div>
        )
    }
}

export default Emails
