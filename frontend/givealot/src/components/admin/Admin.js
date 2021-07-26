// import React, { Component } from 'react'
// import logo from "./imagesRegister/ID2.png"
// import AdminSidebar from "./AdminSidebar"
// import AdminDashboard from "./AdminDashboard";
// import "./Admin.css"
// import {Switch,Route} from "react-router-dom";
// import AdminUsers from "./adminUsers/AdminUsers"
// import Calender from "./calender/Calender"

// export class Admin extends Component {

//     render() {
//         return (
//             <div className="admin">
//                 <div className="Adminheader">
//                     <div className="imageDiv">
//                         <img src={logo} alt="" className="imageAdmin"/>
//                     </div>
//                 </div>
//                 <div className="mainBodyAdmin" >
//                     <div>
//                         <AdminSidebar />
//                     </div>
//                     <div>
//                         <Switch>
//                            <Route exact path="/adminUsers" component={AdminUsers} />
//                             <Route exact path="/" component={AdminDashboard} />
//                             <Route exact path="/calendar" component={Calender} />
//                         </Switch>
//                     </div>
                    
//                 </div>
//             </div>
//         )
//     }
// }

// export default Admin


import React, { Component } from 'react'
import logo from "./imagesRegister/ID2.png"
import AdminSidebar from "./AdminSidebar"
import AdminDashboard from "./AdminDashboard";
import "./Admin.css"
import {Switch,Route} from "react-router-dom";
import AdminUsers from "./adminUsers/AdminUsers"
import Calender from "./calender/Calender";
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import LogOut from "./LogOut";

export class Admin extends Component {

    render() {
        return (
            <React.Fragment>
                <Grid item >
                    <Paper className="HeaderA">
                        <img src={logo} alt="" className="imageAdmin"/>
                    </Paper>
                </Grid>
                <Grid className="AdminBody">
                    <Grid item >
                        <Paper className="sidabar">
                            <AdminSidebar />
                        </Paper>
                    </Grid>
                    <Grid item  >
                        <Paper className="">
                            <Switch>
                                <Route exact path="/adminUsers" component={AdminUsers} />
                                <Route exact path="/calendar" component={Calender} />
                                <Route exact path="/" component={AdminDashboard} />
                                <Route exact path="/logout" component={LogOut} />
                            </Switch>
                        </Paper>
                    </Grid>
                </Grid>
                
            </React.Fragment>
        )
    }
}

export default Admin
