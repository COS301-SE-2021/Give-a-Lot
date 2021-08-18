import './App.css';
import Admin from "./components/Admin/Admin"
import "./components/basicUser/browse/css/browse.css";
import "./components/basicUser/browse/css/recommended.css";
import "./components/basicUser/browse/css/navbar.css";
import "./components/basicUser/browse/css/overlay.css";
import "./components/basicUser/browse/css/search.css";
import Register from "./components/register/Register";
import Home from "./components/basicUser/home/Home"
import React from "react";
import {Route, Switch} from "react-router-dom";
import Login from "./components/login/Login";
import VerifyHomePage from "./components/basicUser/home/VerifyHomePage";
import RegisterUser from "./components/register/registerUser/RegisterUser";
import RegisterOrganisation from "./components/register/registerOrganisation/RegisterOrganisation";
import Browse from "./components/basicUser/browse/Browse"
import Organisation from "./components/organisation/Organisaion";
// import AdminDash from './components/Admin/adminPages/dashboard/Dashboard'

function App() {
  return (
   <div>
       <Switch>
           <Route exact path="/">
               <Home />
           </Route>
           <Route exact path="/login">
               <Login />
           </Route>
           <Route exact path="/verifyPage">
               <VerifyHomePage />
           </Route>
           <Route exact path="/register">
               <Register />
           </Route>
           <Route exact path="/registerUser">
               <RegisterUser />
           </Route>
           <Route exact path="/registerOrganisations">
               <RegisterOrganisation />
           </Route>
            <Route exact path="/browse">
                <Browse />
            </Route>
           <Route exact path="/admin">
               <Admin />
           </Route>
           <Route exact path="/org">
               <Organisation />
           </Route>
           <Route exact path="/home">
               <Home />
           </Route>
       </Switch>
       {/*<Admin />*/}
   </div>
    
  );
}

export default App;
