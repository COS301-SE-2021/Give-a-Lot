// import React, { Component } from 'react'
// import "./register.css"
// // import FeaturedHeader from "../featuredHeader/FeaturedHeader"
// import { BrowserRouter as Router} from "react-router-dom";
// // import RegisterUser from "./registerUser/RegisterUser"
// import RegisterBody from "./RegisterBody";
// // import RegisterOrganisation from "./registerOrganisation/RegisterOrganisation";
// import FeaturedHeader from "../featuredHeader/FeaturedHeader";
//
// export class Login extends Component {
//
//     render() {
//         return (
//             <Router>
//                 <div className="register">
//                     <FeaturedHeader />
//                     <div className="containerRegister">
//                         <RegisterBody />
//                     </div>
//                 </div>
//             </Router>
//         )
//     }
// }
//
// export default Login

import "./register.css"
import FeaturedHeader from "../featuredHeader/FeaturedHeader"
import {
    Switch,
    Route
} from "react-router-dom";
import RegisterUser from "./registerUser/RegisterUser"
import RegisterOrganisation from "./registerOrganisation/RegisterOrganisation";
import RegisterBody from "./RegisterBody";

function Register() {
    return (
        // <Router>
            <div className="register">
                <FeaturedHeader />
                <RegisterBody />
                <div>
                    <Switch>
                        <Route exact path="/registerUser">
                            <RegisterUser />
                        </Route>
                        <Route path="/registerOrganisations">
                            <RegisterOrganisation />
                        </Route>
                    </Switch>

                </div>
            </div>
        // </Router>

    );
}

export default Register;

