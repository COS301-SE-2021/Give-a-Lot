// import * as React from 'react';
// import "./adminOrgs.css"
// import { DataGrid } from '@material-ui/data-grid';
// import { DeleteOutline } from "@material-ui/icons";
// import { orgsRows } from "../../../../DummyData"
// import { Link } from "react-router-dom";
// import { useState } from "react";
//
// export default function UserList() {
//     const [data, setData] = useState(orgsRows);
//
//     const handleDelete = (id) => {
//         setData(data.filter((item) => item.id !== id));
//     };
//
//     const columns = [
//         { field: "id", headerName: "ID", width: 100 },
//         {
//             field: "user",
//             headerName: "User",
//             width: 200,
//             renderCell: (params) => {
//                 return (
//                     <div className="OrgsListUsers">
//                         <img className="OrgsListImgs" src={params.row.avatar} alt="" />
//                         {params.row.username}
//                     </div>
//                 );
//             },
//         },
//         { field: "email", headerName: "Email", width: 200 },
//         {
//             field: "status",
//             headerName: "Status",
//             width: 120,
//         },
//         {
//             field: "transaction",
//             headerName: "Transaction Volume",
//             width: 160,
//         },
//         {
//             field: "action",
//             headerName: "Action",
//             width: 150,
//             renderCell: (params) => {
//                 return (
//                     <>
//                         <Link to={"/orgs/" + params.row.id}>
//                             <button className="OrgsListEdits">Edit</button>
//                         </Link>
//                         <DeleteOutline
//                             className="OrgsListDeletes"
//                             onClick={() => handleDelete(params.row.id)}
//                         />
//                     </>
//                 );
//             },
//         },
//     ];
//
//     return (
//         <div className="adminOrgss">
//             <Link to="/addOrg">
//                 {/*<div style={{paddingBottom: "10px"}}>*/}
//                     <button className="AddButton">Create</button>
//                 {/*</div>*/}
//             </Link>
//             <DataGrid
//                 rows={data}
//                 disableSelectionOnClick
//                 columns={columns}
//                 pageSize={8}
//                 checkboxSelection
//             />
//         </div>
//     );
// }


import React, { Component } from 'react';
import "./adminOrgs.css"
import { DataGrid } from '@material-ui/data-grid';
import axios from "axios";
import { Link } from "react-router-dom";
import { DeleteOutline } from "@material-ui/icons";

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
    {
        field: "action",
        headerName: "Action",
        width: 150,
        renderCell: (params) => {
            return (
                <>
                    <Link to={"/orgs/" + params.row.id}>
                        <button className="OrgsListEdits">Edit</button>
                    </Link>
                    {/*<DeleteOutline*/}
                    {/*    className="OrgsListDeletes"*/}
                    {/*    onClick={() => handleDelete(params.row.id)}*/}
                    {/*/>*/}
                </>
            );
        },
    },
];

// const handleDelete = (id) => {
//         // setData(this.state.orgs.filter((item) => item.id !== id));
//     this.setState(this.state.orgs.filter((item) => item.id !== id))
//     };

export default class AdminOrgs extends Component {
    // const [data, info ,setData] = useState(userRows);
    constructor(props) {
        super(props)

        this.state = {
            orgs:[],
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
        axios.post('http://localhost:8080/v1/organisation/get/organisations', adminUsersRequestBody, config)
            .then(response =>{
                console.log(response)
                this.setState({orgs: response.data.response})
                console.log(this.state.orgs)
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }
    render() {
        const { orgs } = this.state
        return (
            <div className="adminOrgss">
                <Link to="/addOrg">
                    <button className="AddButton">Create</button>
                </Link>
                <DataGrid
                    rows={orgs}
                    disableSelectionOnClick
                    columns={columns}
                    pageSize={8}
                    checkboxSelection
                />
            </div>
        );
    }
}
