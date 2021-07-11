import React, { Component } from "react";
import "./PopUp.css"

export default class PopUp extends Component {
  handleClick = () => {
    this.props.toggle();
  };

  render() {
    return (
      <div className="modal" style={{position: "absolute", top: "-100px", left: "900"}}>
        <div className="modal_content">
          <span className="close" onClick={this.handleClick}>
            &times;
          </span>
          <div >
            <h5>Thank you for registering</h5>
            <button className="button">
                Close
            </button>
          </div>
          
        </div>
      </div>
    );
  }
}
