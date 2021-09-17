import './App.css';
import Home from './views/home/Home';
import Browse from './views/browse/Browse';
import Dashboard from './views/dashboard/Dashboard';
import Login from './views/login/Login';
import SignUp from './views/registration/SignUp'
import RegisterOrg from './views/registration/registerOrganisation/RegisterOrganisation'
import RegisterUser from './views/registration/registerUser/RegisterUser'
import VerifyCertificate from './views/verifyCertificate/VerifyCertificate'
import {BrowserRouter as Router, Switch, Route, Link} from 'react-router-dom';
import ViewOrganisation from "./views/browse/Components/Organisation/ViewOrganisation";
import UserSuccess from "./views/registration/registerUser/UserSuccess";
import EmailSent from "./views/login/Components/EmailSent";
import Password from "./views/login/Components/Password";
import ResetPassword from "./views/login/Components/ResetPassword";
import ResetSuccess from "./views/login/Components/ResetSuccess";
import TermsAndConditions from "./views/registration/TermsAndConditions";


function App()
{
  return(
   <Router>
      <Switch>
        <Route path="/" exact component={Home}/>
        <Route path="/browse" exact component={Browse}/>
        <Route path="/login" exact component={Login}/>
        <Route path="/signUp" exact component={SignUp}/>
        <Route path="/UserSuccess" exact component={UserSuccess}/>
        <Route path="/ResetPassword" exact component={ResetPassword}/>
        <Route path="/ResetSuccess" exact component={ResetSuccess}/>
        <Route path="/TermsAndConditions" exact component={TermsAndConditions}/>
        <Route path="/Password" exact component={Password}/>
        <Route path="/EmailSent" exact component={EmailSent}/>
        <Route path="/registerOrg" exact component={RegisterOrg}/>
        <Route path="/registerUser" exact component={RegisterUser}/>
        <Route path="/dashboard/" exact component={Dashboard}/>
        <Route path="/organisation/:id" exact component={ViewOrganisation} />
        <Route path="/verifyCertificate" exact component={VerifyCertificate} />
      </Switch>
    </Router>

  );
}

export default App;
