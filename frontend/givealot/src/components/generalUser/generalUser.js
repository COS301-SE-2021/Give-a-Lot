import React, { Component } from "react";
import Navbar from "../../components/GeneralUser/Navbar/Navbar";

export default class GeneralUser extends Component {
    render() {
        return (
            <div className="">
                <Navbar />
                <h1 style={{position: "absolute", left: "450px", top: "300px"}}>
                    here are the stuff
                </h1>
            </div>
        );
    }
}