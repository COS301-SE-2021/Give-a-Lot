import './App.css';
import Home from './views/home/Home';
import Browse from './views/browse/Browse';
import Dashboard from './views/dashboard/Dashboard';
import Login from './views/login/Login';
import {BrowserRouter as Router, Switch, Route, Link} from 'react-router-dom'; 

function App()
{
  return(
    <Router>
      <Switch>
        <Route path="/" exact component={Home}/>
        <Route path="/browse" exact component={Browse}/>
        <Route path="/login" exact component={Login}/>
        <Route path="/dashboard" exact component={Dashboard}/>
      </Switch>
    </Router>
  );
}

export default App;
