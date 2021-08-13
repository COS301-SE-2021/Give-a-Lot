import React, { Component } from 'react'
import "./register.css"
import PeopleIcon from '@material-ui/icons/People';
import PersonIcon from '@material-ui/icons/Person';
import {Link} from "react-router-dom";
// import RegisterUser from "./registerUser/RegisterUser";
// import RegisterOrganisation from "./registerOrganisation/RegisterOrganisation";
// import ListItem from '@material-ui/core/ListItem';
// import ListItemText from '@material-ui/core/ListItemText';
// import ListItem from '@material-ui/core/ListItem';
// import ListItemText from '@material-ui/core/ListItemText';

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
                                <span> <PersonIcon /> </span>
                                <p> Register User </p>
                            </div>
                        </Link>
                        <Link to="/registerOrganisations" className="link">
                            <div className="tabs">
                                <span> <PeopleIcon /> </span>
                                <p> Register Organisation </p>
                            </div>
                        </Link>
                    </div>
                    {/*<Switch>*/}
                    {/*    <Route exact path="/registerUser">*/}
                    {/*        <RegisterUser />*/}
                    {/*    </Route>*/}
                    {/*    <Route exact path="/registerOrganisation">*/}
                    {/*        <RegisterOrganisation />*/}
                    {/*    </Route>*/}
                    {/*</Switch>*/}
                </div>
            </div>

        )
    }
}

export default RegisterBody
