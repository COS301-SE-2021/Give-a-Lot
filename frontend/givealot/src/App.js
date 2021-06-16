import {BrowserRouter as Router,Switch,Route} from "react-router-dom";
import Register from "./components/register/Register";
//import Registration from "./components/registration/Registration";
import Login from './components/login/Login';
import Admin from "./components/admin/Admin";
import Organisation from "./components/organisation/Organisation";
import BasicUser from "./components/basicUser/BasicUser";
import OrganisationReport from './components/organisation/OrganisationReport';
import BasicUserReport from "./components/basicUser/BasicUserReport";
import './App.css';

function App() {
    return (
      <div className="App">
        <Admin />
        {/* <BasicUserReport /> */}
          {/*<OrganisationReport />*/}
      </div>
   );
  
}

export default App;
