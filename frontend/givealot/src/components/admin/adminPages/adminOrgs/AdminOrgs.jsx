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
// import { DeleteOutline } from "@material-ui/icons";

const columns = [

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
    { field: "orgId", headerName: "ID", width: 100 },
    { field: "orgName", headerName: "Org Name", width: 200 },
    { field: "slogan", headerName: "Slogan", width: 200 },
    {
        field: "orgDescription",
        headerName: "Org Description",
        width: 200,
    },
    { field: "orgSector", headerName: "Sector", width: 130 },
    { field: "orgEmail", headerName: "Email", width: 200 },
    { field: "contactNumber", headerName: "Number", width: 160 },
    { field: "status", headerName: "Status", width: 130 },
    { field: "contactPerson", headerName: "Contact Person", width: 200 },

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
            organisations:[],
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
        // const adminUserRequestBody = {
        //     "adminUserEmail" : this.state.adminUserEmail
        // }
        axios.get('http://localhost:8080/v1/organisation/get/organisations', config)
            .then(response =>{
                console.log(response)
                this.setState({organisations: response.data.response})
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }
    render() {
        const { organisations } = this.state
        // console.log(orgs);
        return (

            <div className="adminOrgss">
                <Link to="/addOrg">
                    <button className="AddButton">Create</button>
                </Link>
                <DataGrid
                    rows={organisations}
                    disableSelectionOnClick
                    columns={columns}
                    pageSize={8}
                    checkboxSelection
                />
            </div>
        );
    }
}
