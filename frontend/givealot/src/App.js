// import Register from "./components/register/Register";
// import Login from "./components/login/Login";
// import Home from "./components/basicUser/home/Home"
// import {Switch,Route} from "react-router-dom";
// import RegisterOrganisation from "./components/register/registerOrganisation/RegisterOrganisation";
// import RegisterUser from "./components/register/registerUser/RegisterUser";
// import Admin from "./components/admin/Admin"
import "./components/basicUser/browse/css/browse.css";
import "./components/basicUser/browse/css/recommended.css";
import "./components/basicUser/browse/css/navbar.css";
import "./components/basicUser/browse/css/overlay.css";
import "./components/basicUser/browse/css/search.css";
import './App.css';
import Organisation from "./components/organisation/Organisation";
import Browse from "./components/basicUser/browse/Browse"

function App() {
    return (
      <div className="AppContainer">
          {/*} <Switch>
         <Route exact path="/">
           <Home />
         </Route>
         <Route path="/login">
           <Login />
         </Route>
         <Route path="/register">
           <Register />
         </Route>
         <Route path="/registerOrgs">
           <RegisterOrganisation />
         </Route>
         <Route path="/registeruser">
           <RegisterUser />
         </Route>
        </Switch>*/}
        
         <Organisation/>
      </div>
   );
  
}

export default App;
