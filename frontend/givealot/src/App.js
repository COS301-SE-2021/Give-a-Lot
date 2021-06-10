import './App.css';
import Admin from "./components/admin/Admin";
import BasicUser from "./components/basicUser/BasicUser";
import Login from "./components/login/Login";
import Organisation from "./components/organisation/Organisation";
import Registration from "./components/registration/Registration";
import OrgRegistration from "./components/registration/OrgRegistration";
import AdminSidebar from "./components/admin/AdminSidebar";

function App() {
  return (
    <div className="App">
      <Admin />
    </div>
  );
}

export default App;
