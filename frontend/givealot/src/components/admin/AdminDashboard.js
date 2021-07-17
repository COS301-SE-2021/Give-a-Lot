import React, { Component } from 'react'
import "./Admin.css"
import Cards from "./Cards"

export class AdminDashboard extends Component {

    render() {
        return (
            <div className="adminDashboard">
                <div className="cards">
                    <Cards />
                    <Cards />
                    <Cards />
                    <Cards />
                </div>

            </div>
        )
    }
}

export default AdminDashboard