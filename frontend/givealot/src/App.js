import './App.css';
//import Admin from "./components/admin/Admin";
//import BasicUser from "./components/basicUser/BasicUser";
import Login from "./components/login/Login";
//import Register from "./components/basic/Register";
import BasicUser from "./components/basicUser/BasicUser";
//import Organisation from "./components/organisation/Organisation";
//import Registration from "./components/registration/Registration";
//import OrgRegistration from "./components/registration/OrgRegistration";

function App() {
  const na=1;
  if(na==0){
    return (
      <div className="App">
        <Login />
      </div>
   );
  }
  else{
    return (
      <div className="App">
        <BasicUser />
      </div>
   );
  }
}

export default App;
