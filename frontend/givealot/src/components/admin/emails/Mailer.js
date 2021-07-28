import React from "react";
import "./Email.css"

const Mailer=()=>{
    return(
        <div className="container">

            <h2 className="heading">Send an Email</h2>
            <form>
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