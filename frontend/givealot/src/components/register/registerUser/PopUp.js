import React, { Component } from "react";
import "./PopUp.css"
import {Switch,Route, Link} from "react-router-dom";
import Login from "../../login/Login"

export default class PopUp extends Component {
  handleClick = () => {
    this.props.toggle();
  };

  render() {
    return (
      <div className="modal" >
        <div className="modal_content">
          <span className="close" onClick={this.handleClick}>
            &times;
          </span>
          <div >
            <h5>Thank you for registering</h5>
            {/* <p>Click close to login</p> */}
            <button className="button">
                 <Link to="/login">Close</Link> 
            </button>
          </div>
          <Switch>       
              <Route exact path="/login" component={Login} />
          </Switch>
          
        </div>
      </div>
    );
  }
}
