import React from "react";
import "./Email.css"
import emailjs from 'emailjs-com'

const Mailer=()=>{
    function sendEmail(e){
        e.preventDefault();
        emailjs.sendForm('service_s7iplid',
            'template_eo3u89b',
            e.target,"user_dwkkxAdQWfhgV56uUzFdb"
        ).then(res=>{
            console.log(res);
        }).catch(err=> console.log(err));
    }
    return(
        <div className="container">

            <h2 className="heading">Send an Email</h2>
            <form onSubmit={sendEmail}>
                <label>name</label>
                <input type="text" name="name"/>

                <label>Email</label>
                <input type="email" name="user_email"/>

                <label>Message</label>
                <textarea name="message" rows='7' />
                <input type="submit" value="send"/>
            </form>
        </div>
    )
};

export default Mailer;