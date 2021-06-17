import {BrowserRouter as Router,Switch,Route} from "react-router-dom";
import Register from "./components/register/Register";
//import Registration from "./components/registration/Registration";
import Login from './components/login/Login';
import Admin from "./components/Admin/Admin";
import Organisation from "./components/organisation/Organisation";
import BasicUser from "./components/basicUser/BasicUser";
import OrganisationReport from './components/organisation/OrganisationReport';
import BasicUserReport from "./components/basicUser/BasicUserReport";
import './App.css';
import Browse from "./components/browse/Browse";

function App() {
    return (
      <div className="App">
          {/*<OrganisationReport />*/}
          <Browse />

      </div>
   );
  
}

export default App;
