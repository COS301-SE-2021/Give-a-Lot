// import React, { Component } from 'react'
// import Mailer from "./Mailer"
// import "./Email.css"
//
//
// export class Emails extends Component {
//
//     render() {
//         return (
//             <div className="email">
//                 <Mailer/>
//             </div>
//         )
//     }
// }
//
// export default Emails

import React from 'react';
import axios from 'axios';

class Emails extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            email: '',
            message: ''
        }
    }

    handleSubmit(e){
        e.preventDefault();
        axios({
            method: "POST",
            url:"http://localhost:3002/send",
            data:  this.state
        }).then((response)=>{
            if (response.data.status === 'success') {
                alert("Message Sent.");
                this.resetForm()
            } else if (response.data.status === 'fail') {
                alert("Message failed to send.")
            }
        })
    }

    resetForm(){
        this.setState({name: '', email: '', message: ''})
    }

    render() {
        return(
            <div className="App">
                {/*<form id="contact-form" onSubmit={this.handleSubmit.bind(this)} method="POST">*/}
                {/*    <div className="form-group">*/}
                {/*        <label htmlFor="name">Name</label>*/}
                {/*        <input type="text" className="form-control" id="name" value={this.state.name} onChange={this.onNameChange.bind(this)} />*/}
                {/*    </div>*/}
                {/*    <div className="form-group">*/}
                {/*        <label htmlFor="exampleInputEmail1">Email address</label>*/}
                {/*        <input type="email" className="form-control" id="email" aria-describedby="emailHelp" value={this.state.email} onChange={this.onEmailChange.bind(this)} />*/}
                {/*    </div>*/}
                {/*    <div className="form-group">*/}
                {/*        <label htmlFor="message">Message</label>*/}
                {/*        <textarea className="form-control" rows="5" id="message" value={this.state.message} onChange={this.onMessageChange.bind(this)} />*/}
                {/*    </div>*/}
                {/*    <button type="submit" className="btn btn-primary">Submit</button>*/}
                {/*</form>*/}
                {/*<div*/}
                {/*    // id="composeModal"*/}
                {/*    className="modal fade mt-0 mt-md-5"*/}
                {/*    tabIndex="-1"*/}
                {/*    role="dialog"*/}
                {/*    aria-hidden="true"*/}
                {/*    // ref="composeModal"*/}
                {/*>*/}

            <div className="modal-body">
                <form className="form" role="form" autoComplete="off">
                    <div className="form-row py-2">
                        <label htmlFor="sendTo" className="col-sm-2 mb-0">
                            To
                        </label>
                        <div className="col">
                            <input
                                type="text"
                                name="sendTo"
                                id="sendTo"
                                className="form-control"
                                required=""
                                // value={this.props.sendTo}
                            />
                        </div>
                    </div>
                    <div className="form-row py-2">
                        <label htmlFor="subject" className="col-sm-2 mb-0">
                            Subject
                        </label>
                        <div className="col">
                            <input
                                type="text"
                                name="subject"
                                id="subject"
                                className="form-control"
                                required=""
                            />
                        </div>
                    </div>
                    <div className="form-row py-2">
                        <label htmlFor="message2" className="col-sm-2 mb-0">
                            Message
                        </label>
                        <div className="col">
                            <textarea
                                rows="6"
                                name="message2"
                                id="message2"
                                className="form-control"
                                required=""
                            />
                        </div>
                    </div>
                    <div className="form-row py-2">
                        <div className="col-sm-auto py-1">
                            <button
                                type="submit"
                                className="btn btn-outline-secondary btn-block"
                            >
                                Attachments
                                <i className="align-middle icon-paper-clip fa fa-paperclip ml-1" />
                            </button>
                        </div>
                        <div className="col py-1">
                            <button
                                type="submit"
                                className="btn btn-secondary float-right ml-1"
                            >
                                Send Message
                            </button>
                            <button
                                type="submit"
                                className="btn btn-outline-secondary float-right"
                            >
                                Save Draft
                            </button>
                        </div>
                    </div>
                </form>
            </div>
    </div>
    );
    }

    // onNameChange(event) {
    //     this.setState({name: event.target.value})
    // }
    //
    // onEmailChange(event) {
    //     this.setState({email: event.target.value})
    // }
    //
    // onMessageChange(event) {
    //     this.setState({message: event.target.value})
    // }
}

export default Emails;
