// import React, { Component } from 'react'
// import "../../styles/Organisations.css"
//
// export class Users extends Component {
//
//     render() {
//         return (
//             <div className="organisations">
//                 users here
//             </div>
//         )
//     }
// }
//
// export default Users


import React, { Component } from 'react';
import "../../styles/Organisations.css"
import { DataGrid } from '@material-ui/data-grid';
import axios from "axios";

const columns = [
    { field: "id", headerName: "ID", width: 100 },
    // {
    //   field: "firstname",
    //   headerName: "First Name",
    //   width: 200,
    //   renderCell: (params) => {
    //     return (
    //         <div className="userListUsers">
    //           <img className="userListImgs" src={params.row.avatar} alt="" />
    //           {params.row.username}
    //         </div>
    //     );
    //   },
    // },
    { field: "firstname", headerName: "First Name", width: 200 },
    { field: "lastname", headerName: "Last Name", width: 200 },
    {
        field: "email",
        headerName: "Email",
        width: 220,
    },
    { field: "activateDate", headerName: "Activation Date", width: 200 },
];
export default class Users extends Component {
    // const [data, info ,setData] = useState(userRows);
    constructor(props) {
        super(props)

        this.state = {
            users:[],
            adminUserEmail: "admin@email.com"
        }

    }

    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const adminUsersRequestBody = {
            "adminUserEmail" : this.state.adminUserEmail
        }
        axios.post('http://localhost:8080/v1/user/get/users', adminUsersRequestBody, config)
            .then(response =>{
                console.log(response)
                this.setState({users: response.data.response})
                console.log(this.state.users)
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }
    render() {
        const { users } = this.state
        return (
            <div className="UsersDash">
                <DataGrid
                    rows={users}
                    disableSelectionOnClick
                    columns={columns}
                    pageSize={8}
                    checkboxSelection
                />
            </div>
        );
    }
}