import React, { Component } from "react";
// import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import AdminNav from "../../components/Admin/AdminNav/AdminNav";
import Adminsidebar from "../../components/Admin/Adminsidebar/Adminsidebar";
import Orgtable from "../../components/Admin/Orgtable/Orgtable";


export default class Admin extends Component {
    render() {
        return (
            <div>
                {/* <AdminNav/> */}
                <Adminsidebar />
                <Orgtable />

            </div>
        );
    }
}