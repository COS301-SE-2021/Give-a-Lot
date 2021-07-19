import React, { Component } from 'react'
import { jsonServerRestClient, Admin, Resource } from 'admin-on-rest';
import User  from './User';

export class AdminUsers extends Component {

    render() {
        return (
            // <div className="adminUsers" >
            //     here is the users
            // </div>
            <Admin restClient={jsonServerRestClient('http://jsonplaceholder.typicode.com')} style={{width: "1000px"}}>
                <Resource name="users" list={User} edit create remove style={{width: "1000px"}}/>
            </Admin>
        )
    }
}

export default AdminUsers

