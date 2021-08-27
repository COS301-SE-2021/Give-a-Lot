import React, { Component } from 'react'
import "../Email/Styles/Email.css"

export class Email extends Component {

    render() {
        return (
            <div className="email">
               <div className="email-container">

                   <div className="container">
                       <form >
                           <div className="row">
                               <div className="col-25">
                                   <label >First Name</label>
                               </div>
                               <div className="col-75">
                                   <input
                                       type="text"
                                       id="fname"
                                       name="firstname"
                                       placeholder="Your name.."
                                   />
                               </div>
                           </div>
                           <div className="row">
                               <div className="col-25">
                                   <label >Last Name</label>
                               </div>
                               <div className="col-75">
                                   <input

                                       type="text"
                                       id="lname"
                                       name="lastname"
                                       placeholder="Your last name.."
                                   />
                               </div>
                           </div>

                           <div className="row">
                               <div className="col-25">
                                   <label >Subject</label>
                               </div>
                               <div className="col-75">
                                   <textarea
                                       id="subject"
                                       name="subject"
                                       placeholder="Write something.."
                                       style={{height:"200px"}}/>

                               </div>
                           </div>
                           <div className="row">
                               <input type="submit" value="Submit"/>
                           </div>
                       </form>
                   </div>

               </div>
            </div>
        )
    }
}

export default Email