import * as React from 'react';
import "./orgUsers.css"
import { DataGrid } from '@material-ui/data-grid';
// import { DeleteOutline } from "@material-ui/icons";
import { userRows } from "../../../../DummyData"
import { Link } from "react-router-dom";
import { useState } from "react";

export default function OrgUsers() {
  // const [data, setData] = useState(userRows);
  const [data] = useState(userRows);

  // const handleDelete = (id) => {
  //   setData(data.filter((item) => item.id !== id));
  // };
  
  const columns = [
    { field: "id", headerName: "ID", width: 100 },
    {
      field: "user",
      headerName: "User",
      width: 200,
      renderCell: (params) => {
        return (
          <div className="OrgListUser">
            <img className="OrgListImg" src={params.row.avatar} alt="" />
            {params.row.username}
          </div>
        );
      },
    },
    { field: "email", headerName: "Email", width: 200 },
    {
      field: "status",
      headerName: "Status",
      width: 120,
    },
    {
      field: "transaction",
      headerName: "Transaction Volume",
      width: 160,
    },
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
    },
  ];

  return (
    <div className="orgUsers">
      <DataGrid
        rows={data}
        disableSelectionOnClick
        columns={columns}
        pageSize={8}
        checkboxSelection
      />
    </div>
  );
}
