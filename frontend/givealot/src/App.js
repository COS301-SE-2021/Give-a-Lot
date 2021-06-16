import './App.css';
import Admin from "./components/admin/Admin";
import {BrowserRouter as Router,Switch,Route} from "react-router-dom";
import Test from "./components/Test/Test";
//import Admin from "./components/admin/Admin";
//import BasicUser from "./components/basicUser/BasicUser";
//import Login from "./components/login/Login";
import Register from "./components/register/Register";
import BasicUser from "./components/basicUser/BasicUser";
import Login from './components/login/Login';

//import Organisation from "./components/organisation/Organisation";
//import Registration from "./components/registration/Registration";
//import OrgRegistration from "./components/registration/OrgRegistration";

function App() {
 
    return (
      <div className="App">
        <BasicUser />
      </div>
   );
  
}

export default App;
