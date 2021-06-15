import './App.css';
import Admin from "./components/admin/Admin";
import {BrowserRouter as Router,Switch,Route} from "react-router-dom";
import Test from "./components/Test/Test";

function App() {
  return (
    <div className="App">
      <Admin />
    </div>
  );
}

export default App;
