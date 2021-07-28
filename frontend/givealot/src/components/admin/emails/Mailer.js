import React from "react";

const Mailer=()=>{
    return(
        <div>
            <h1>Send an Email</h1>
            <form>
                <label>name</label>
                <input type="text" name="name"/>

                <label>Email</label>
                <input type="email" name="user_email"/>

                <label>Message</label>
                <textarea name="message" rows='4' />
                <input type="submit" value="send"/>
            </form>
        </div>
    )
};

export default Mailer;