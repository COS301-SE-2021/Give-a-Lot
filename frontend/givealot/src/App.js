import './App.css';
// import Admin from "./components/admin/Admin"
// import Organisation from "./components/organisation/Organisaion"
// import Login from "./components/login/Login"
// import Register from "./components/register/Register";
// import RegisterUser from "./components/register/registerUser/RegisterUser";
// import RegisterOrganisation from "./components/register/registerOrganisation/RegisterOrganisation";
import Home from "./components/basicUser/home/Home"
// import {Route, Switch} from "react-router-dom";
// import VerifyHomePage from "./components/basicUser/home/VerifyHomePage";
// import Login from "./components/login/Login";
// import Landing from "./components/basicUser/home/Landing"
import React from "react";
import {Route, Switch} from "react-router-dom";
import Login from "./components/login/Login";
import VerifyHomePage from "./components/basicUser/home/VerifyHomePage";


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
       </Switch>
   </div>
    
  );
}

export default App;
