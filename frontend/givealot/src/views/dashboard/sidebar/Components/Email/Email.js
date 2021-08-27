import React, { Component } from 'react'
import "../Email/Styles/Email.css"

export class Email extends Component {

    render() {
        return (
            <div className="email">
               <div className="email-container">

                   <div className="_container">
                       <form >
                           <div className="row">
                               <div className="col-25">
                                   <label >User Email</label>
                               </div>
                               <div className="col-75">
                                   <input
                                       type="text"
                                       id="email"
                                       name="email"
                                       placeholder="User email.."
                                   />
                               </div>
                           </div>
                           <div className="row">
                               <div className="col-25">
                                   <label >Subject</label>
                               </div>
                               <div className="col-75">
                                   <input

                                       type="text"
                                       id="subject"
                                       name="subject"
                                       placeholder="Your subject.."
                                   />
                               </div>
                           </div>

                           <div className="row">
                               <div className="col-25">
                                   <label >Message</label>
                               </div>
                               <div className="col-75">
                                   <textarea
                                       id="message"
                                       name="message"
                                       placeholder="Write something.."
                                       style={{height:"200px"}}/>

                               </div>
                           </div>
                           <div className="bottom_">
                               <div className="row">
                                   <input type="file" />
                               </div>
                               <div className="row">
                               <input type="submit" value="Submit"/>
                           </div>
                           </div>

                       </form>
                   </div>

               </div>
            </div>
        )
    }
}

export default Email