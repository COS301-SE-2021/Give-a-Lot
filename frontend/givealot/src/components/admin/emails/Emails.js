// // import React, { Component } from 'react'
// // import Mailer from "./Mailer"
// // import "./Email.css"
// //
// //
// // export class Emails extends Component {
// //
// //     render() {
// //         return (
// //             <div className="email">
// //                 <Mailer/>
// //             </div>
// //         )
// //     }
// // }
// //
// // export default Emails
//
// import React from 'react';
// import axios from 'axios';
//
// class Emails extends React.Component {
//
//     constructor(props) {
//         super(props);
//         this.state = {
//             name: '',
//             email: '',
//             message: ''
//         }
//     }
//
//     handleSubmit(e){
//         e.preventDefault();
//         axios({
//             method: "POST",
//             url:"http://localhost:3002/send",
//             data:  this.state
//         }).then((response)=>{
//             if (response.data.status === 'success') {
//                 alert("Message Sent.");
//                 this.resetForm()
//             } else if (response.data.status === 'fail') {
//                 alert("Message failed to send.")
//             }
//         })
//     }
//
//     resetForm(){
//         this.setState({name: '', email: '', message: ''})
//     }
//
//     render() {
//         return(
//             <div className="App">
//                 {/*<form id="contact-form" onSubmit={this.handleSubmit.bind(this)} method="POST">*/}
//                 {/*    <div className="form-group">*/}
//                 {/*        <label htmlFor="name">Name</label>*/}
//                 {/*        <input type="text" className="form-control" id="name" value={this.state.name} onChange={this.onNameChange.bind(this)} />*/}
//                 {/*    </div>*/}
//                 {/*    <div className="form-group">*/}
//                 {/*        <label htmlFor="exampleInputEmail1">Email address</label>*/}
//                 {/*        <input type="email" className="form-control" id="email" aria-describedby="emailHelp" value={this.state.email} onChange={this.onEmailChange.bind(this)} />*/}
//                 {/*    </div>*/}
//                 {/*    <div className="form-group">*/}
//                 {/*        <label htmlFor="message">Message</label>*/}
//                 {/*        <textarea className="form-control" rows="5" id="message" value={this.state.message} onChange={this.onMessageChange.bind(this)} />*/}
//                 {/*    </div>*/}
//                 {/*    <button type="submit" className="btn btn-primary">Submit</button>*/}
//                 {/*</form>*/}
//                 {/*<div*/}
//                 {/*    // id="composeModal"*/}
//                 {/*    className="modal fade mt-0 mt-md-5"*/}
//                 {/*    tabIndex="-1"*/}
//                 {/*    role="dialog"*/}
//                 {/*    aria-hidden="true"*/}
//                 {/*    // ref="composeModal"*/}
//                 {/*>*/}
//
//             <div className="modal-body">
//                 <form className="form" autoComplete="off">
//                     <div className="form-row py-2">
//                         <label htmlFor="sendTo" className="col-sm-2 mb-0">
//                             To
//                         </label>
//                         <div className="col">
//                             <input
//                                 type="text"
//                                 name="sendTo"
//                                 id="sendTo"
//                                 className="form-control"
//                                 required=""
//                                 // value={this.props.sendTo}
//                             />
//                         </div>
//                     </div>
//                     <div className="form-row py-2">
//                         <label htmlFor="subject" className="col-sm-2 mb-0">
//                             Subject
//                         </label>
//                         <div className="col">
//                             <input
//                                 type="text"
//                                 name="subject"
//                                 id="subject"
//                                 className="form-control"
//                                 required=""
//                             />
//                         </div>
//                     </div>
//                     <div className="form-row py-2">
//                         <label htmlFor="message2" className="col-sm-2 mb-0">
//                             Message
//                         </label>
//                         <div className="col">
//                             <textarea
//                                 rows="6"
//                                 name="message2"
//                                 id="message2"
//                                 className="form-control"
//                                 required=""
//                             />
//                         </div>
//                     </div>
//                     <div className="form-row py-2">
//                         <div className="col-sm-auto py-1">
//                             <button
//                                 type="submit"
//                                 className="btn btn-outline-secondary btn-block"
//                             >
//                                 Attachments
//                                 <i className="align-middle icon-paper-clip fa fa-paperclip ml-1" />
//                             </button>
//                         </div>
//                         <div className="col py-1">
//                             <button
//                                 type="submit"
//                                 className="btn btn-secondary float-right ml-1"
//                             >
//                                 Send Message
//                             </button>
//                             <button
//                                 type="submit"
//                                 className="btn btn-outline-secondary float-right"
//                             >
//                                 Save Draft
//                             </button>
//                         </div>
//                     </div>
//                 </form>
//             </div>
//     </div>
//     );
//     }
//
//     // onNameChange(event) {
//     //     this.setState({name: event.target.value})
//     // }
//     //
//     // onEmailChange(event) {
//     //     this.setState({email: event.target.value})
//     // }
//     //
//     // onMessageChange(event) {
//     //     this.setState({message: event.target.value})
//     // }
// }
//
// export default Emails;

import React, { Component } from 'react';
import ToolbarComponent from './ToolbarComponent'
import MessagesComponent from './MessagesComponent'
import ComposeMessageComponent from './ComposeMessageComponent'

class Emails extends Component {

    // ================================================
    // STATE
    // ================================================

    // state = {
    //   messages: this.props.messages
    // };

    state = {
        messages: []
    }

    // ================================================
    // React Life Cycle
    // ================================================
    componentDidMount = async () => {
        const response = await fetch('http://localhost:8082/api/messages')
        const messages = await response.json()

        this.setState({
            messages: [
                ...this.state.messages,
                ...messages.map(message => ({
                    ...message,
                    selected: false
                }))
            ],
            display: false
        })
    }

    // ================================================
    // Toggle Compose
    // ================================================
    toggleCompose = () => {
        this.setState({ display: !this.state.display })
    }

    // ================================================
    // Toggle Select All
    // ================================================
    toggleSelectAll = () => {
        const selectedMessages = this.state.messages.filter(message => message.selected)

        const selected = selectedMessages.length !== this.state.messages.length
        this.setState({
            messages: this.state.messages.map(message => message.selected !== selected ? { ...message, selected } : message)
        })
    }

    // ================================================
    // Toggle Property
    // ================================================
    // toggleProperty(message, property) {
    //   const index = this.state.messages.indexOf(message);
    //   this.setState({
    //     messages: [
    //       ...this.state.messages.slice(0, index),
    //       {...message, [property]: !message[property]},
    //       ...this.state.messages.slice(index + 1)
    //     ]
    //   });
    // }

    toggleProperty = async (message, property) => {
        const index = this.state.messages.indexOf(message)

        this.setState({
            messages: [
                ...this.state.messages.slice(0, index),
                { ...message, [property]: !message[property] },
                ...this.state.messages.slice(index + 1)
            ]
        })
    }

    // ================================================
    // Toggle Start
    // ================================================
    // toggleStar = message => {
    //   this.toggleProperty(message, 'starred');
    // }

    toggleStar = async message => {
        await fetch('http://localhost:8082/api/messages', {
            method: 'PATCH',
            body: JSON.stringify({
                messageIds: [message.id],
                command: 'star',
                star: message.starred
            }),
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })

        this.toggleProperty(message, 'starred')
    }

    // ================================================
    // Toggle Select
    // ================================================
    toggleSelect = message => {
        this.toggleProperty(message, 'selected');
    }

    // ================================================
    // Mark Read Status
    // ================================================
    // markReadStatus = readStatus => {
    //   this.setState({
    //     messages: this.state.messages.map(
    //       message =>
    //       message.selected ? {...message, read: readStatus} : message
    //     )
    //   })
    // }

    // markReadStatus = async readStatus => {
    //     // Filter out the selected messages
    //     const selectedMessages = this.state.messages.filter(message => message.selected)
    //
    //     await fetch('http://localhost:8082/api/messages', {
    //         method: 'PATCH',
    //         body: JSON.stringify({
    //             messageIds: [...selectedMessages.map(message => message.id)],
    //             command: 'read',
    //             read: readStatus
    //         }),
    //         headers: {
    //             'Content-Type': 'application/json',
    //             'Accept': 'application/json'
    //         }
    //     })
    //
    //     this.setState({
    //         messages: this.state.messages.map(message => (message.selected ? {...message, read: readStatus} : message))
    //     })
    // }

    // ================================================
    // Add Message
    // ================================================
    addMessage = async (composeMessage) => {
        const { subject, body } = composeMessage
        const response = await fetch('http://localhost:8082/api/messages', {
            method: 'POST',
            body: JSON.stringify({
                subject,
                body
            }),
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })
        const message = await response.json()
        // console.log('messages==> ', this.state.messages);
        // console.log('new message==> ', message);

        this.setState({
            messages: [
                ...this.state.messages,
                message
            ],
            display: !this.state.display
        })
        console.log(this.state);
    }

    // ================================================
    // Delete Messages
    // ================================================
    // deleteMessages = () => {
    //   const messages = this.state.messages.filter(
    //     messages => !messages.selected
    //   );
    //   this.setState({messages})
    // }

    deleteMessages = async () => {
        const messages = this.state.messages.filter(message => !message.selected);
        // Filter out the selected messages
        const selectedMessages = this.state.messages.filter(message => message.selected)

        await fetch('http://localhost:8082/api/messages', {
            method: 'PATCH',
            body: JSON.stringify({
                messageIds: [...selectedMessages.map(message => message.id)],
                command: 'delete'
            }),
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })

        this.setState({ messages })
    }

    // ================================================
    // Apply Label Category
    // ================================================
    // applyLabel = label => {
    //   const messages = this.state.messages.map(message =>
    //     message.selected && !message.labels.includes(label) ?
    //     {...message, labels: [...message.labels, label].sort()}
    //     : message
    //   );
    //   this.setState({messages})
    // };

    applyLabel = async label => {
        const messages = this.state.messages.map(message =>
            message.selected && !message.labels.includes(label)
                ? {...message, labels: [...message.labels, label].sort()}
                : message
        )
        // Filter out the selected messages
        const selectedMessages = this.state.messages.filter(message => message.selected)

        await fetch('http://localhost:8082/api/messages', {
            method: 'PATCH',
            body: JSON.stringify({
                messageIds: [...selectedMessages.map(message => message.id)],
                command: 'addLabel',
                label
            }),
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })

        this.setState({ messages })
    }

    // ================================================
    // Remove Label
    // ================================================
    // removeLabel = label => {
    //   const messages = this.state.messages.map(
    //     message => {
    //       const index = message.labels.indexOf(label)
    //       if (message.selected && index > -1) {
    //         return {...message, labels: [
    //           ...message.labels.slice(0, index),
    //           ...message.labels.slice(index + 1)
    //           ]
    //         }
    //       }
    //       return message;
    //     });
    //   this.setState({messages})
    // };

    removeLabel = async label => {
        const messages = this.state.messages.map(message => {
            const index = message.labels.indexOf(label)
            if (message.selected && index > -1) {
                return {
                    ...message,
                    labels: [
                        ...message.labels.slice(0, index),
                        ...message.labels.slice(index + 1)
                    ]
                }
            }
            return message
        })
        // Filter out the selected messages
        const selectedMessages = this.state.messages.filter(message => message.selected)

        await fetch('http://localhost:8082/api/messages', {
            method: 'PATCH',
            body: JSON.stringify({
                messageIds: [...selectedMessages.map(message => message.id)],
                command: 'removeLabel',
                label
            }),
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })

        this.setState({ messages })
    }

    // ================================================
    // Render
    // ================================================
    render() {
        // console.log(this.state)
        return (
            <div className="App">
                <ToolbarComponent
                    messages={this.state.messages}
                    toggleCompose={this.toggleCompose}
                    toggleSelectAll={this.toggleSelectAll}
                    markReadStatus={this.markReadStatus}
                    deleteMessages={this.deleteMessages}
                    applyLabel={this.applyLabel}
                    removeLabel={this.removeLabel}
                />
                <ComposeMessageComponent
                    display={this.state.display}
                    addMessage={this.addMessage}
                />
                <MessagesComponent
                    messages={this.state.messages}
                    toggleStar={this.toggleStar}
                    toggleSelect={this.toggleSelect}
                />
            </div>
        );
    }
}

export default Emails;
