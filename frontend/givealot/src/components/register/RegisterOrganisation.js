import React, { Component } from "react";
class RegisterOrganisation extends Component {
    render() {
        return (
            <div >
                <div className="container" >

                 <form className="form">
                     <div className="top">
                         <h4> Registration | Organisation | Info</h4>
                     </div>
                    <div >
                        <label></label>

                        <input type="name" className="control" placeholder="Name of Organisation" />
                    </div>

                    <div >
                        <label></label>
                        <input type="name" className="control" placeholder="Password" />
                    </div>

                    <div >
                        <label></label>
                        <input type="email" className="control" placeholder="Confrim Password" />
                    </div>
                    <div>
                        <button type="submit" className="button">Proceed</button>
                    </div>

                </form>
                </div>
            </div>
        );
    }

}

export default RegisterOrganisation