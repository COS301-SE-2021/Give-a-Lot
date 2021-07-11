import Register from "./components/register/Register";
 import Login from "./components/login/Login";
import Home from "./components/basicUser/home/Home"
import './App.css';
import {Switch,Route} from "react-router-dom";
import RegisterOrganisation from "./components/register/registerOrganisation/RegisterOrganisation";
import RegisterUser from "./components/register/registerUser/RegisterUser";
// import RegisterOrganisation from "./components/register/RegisterOrganisation";
// import RegisterUser from "./components/register/RegisterUser";

function App() {
    return (
      <div className="App">
        <Switch>
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
        </Switch>
        
        {/* <Register /> */}
      </div>
   );
  
}

export default App;
