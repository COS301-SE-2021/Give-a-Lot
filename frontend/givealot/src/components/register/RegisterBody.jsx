import React, { Component } from 'react'
import "./register.css"
import PeopleIcon from '@material-ui/icons/People';
import PersonIcon from '@material-ui/icons/Person';
import {Link} from "react-router-dom";

export class RegisterBody extends Component {

    render() {
        return (
            <div className="register">
                <div className="containerRegister">
                    <div className="RegisterContent">
                        <div className="topLine">
                            <p> NGO's Made Safer for you </p>
                        </div>

                        <Link to={'/registerUser'} className="link" >
                            <div className="tabs">
                                <span> <PersonIcon className="registerIcon"/> </span>
                                <p> Register User </p>
                            </div>
                        </Link>
                        <Link to="/registerOrganisations" className="link">
                            <div className="tabs">
                                <span> <PeopleIcon className="registerIcon"/> </span>
                                <p> Register Organisation </p>
                            </div>
                        </Link>
                        <div style={{color: "white"}}>
                            <div id="createAccount">
                               <span>Login?
                                   <Link to="/login">
                                       <span style={{textDecoration:"underline", color: "white", cursor: "pointer", paddingLeft: "8px"}} >
                                           Sign In
                                        </span>
                                  </Link>
                               </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        )
    }
}

export default RegisterBody
