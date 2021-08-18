// import * as React from 'react';
// import "./orgUsers.css"
// import { DataGrid } from '@material-ui/data-grid';
// // import { DeleteOutline } from "@material-ui/icons";
// import { userRows } from "../../../../DummyData"
// import { Link } from "react-router-dom";
// import { useState } from "react";
//
// export default function OrgUsers() {
//   // const [data, setData] = useState(userRows);
//   const [data] = useState(userRows);
//
//   // const handleDelete = (id) => {
//   //   setData(data.filter((item) => item.id !== id));
//   // };
//
//   const columns = [
//     { field: "id", headerName: "ID", width: 100 },
//     {
//       field: "user",
//       headerName: "User",
//       width: 200,
//       renderCell: (params) => {
//         return (
//           <div className="OrgListUser">
//             <img className="OrgListImg" src={params.row.avatar} alt="" />
//             {params.row.username}
//           </div>
//         );
//       },
//     },
//     { field: "email", headerName: "Email", width: 200 },
//     {
//       field: "status",
//       headerName: "Status",
//       width: 120,
//     },
//     {
//       field: "transaction",
//       headerName: "Transaction Volume",
//       width: 160,
//     },
//     {
//       field: "action",
//       headerName: "Action",
//       width: 150,
//       renderCell: (params) => {
//         return (
//           <>
//             <Link to={"/user/" + params.row.id}>
//               <button className="OrgListEdit">View User</button>
//             </Link>
//             {/*<DeleteOutline*/}
//             {/*  className="OrgListDelete"*/}
//             {/*  onClick={() => handleDelete(params.row.id)}*/}
//             {/*/>*/}
//           </>
//         );
//       },
//     },
//   ];
//
//   return (
//     <div className="orgUsers">
//       <DataGrid
//         rows={data}
//         disableSelectionOnClick
//         columns={columns}
//         pageSize={8}
//         checkboxSelection
//       />
//     </div>
//   );
// }

import React, { Component } from 'react';
import "./orgUsers.css"
import { DataGrid } from '@material-ui/data-grid';
import axios from "axios";
import { Link } from "react-router-dom";

const columns = [
  { field: "id", headerName: "ID", width: 100 },
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
            <Link to={"/user/" + params.row.id}>
              <button className="OrgListEdit">View User</button>
            </Link>
            {/*<DeleteOutline*/}
            {/*  className="OrgListDelete"*/}
            {/*  onClick={() => handleDelete(params.row.id)}*/}
            {/*/>*/}
          </>
        );
      },
  }
];
export default class OrgUsers extends Component {
  // const [data, info ,setData] = useState(userRows);
  constructor(props) {
    super(props)

    this.state = {
      usersOrg:[],
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
          this.setState({usersOrg: response.data.response})
          console.log(this.state.usersOrg)
        })
        .catch(error =>{
          console.log(error)
          this.setState({error : 'Error Retrieving data'})
        })
  }
  render() {
    const { usersOrg } = this.state
    return (
        <div className="orgUsers">
          <DataGrid
              rows={usersOrg}
              disableSelectionOnClick
              columns={columns}
              pageSize={8}
              checkboxSelection
          />
        </div>
    );
  }
}
