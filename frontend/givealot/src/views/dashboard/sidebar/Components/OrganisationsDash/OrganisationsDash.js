// import React, { Component } from 'react'
// import "../../styles/Organisations.css"
//
// export class OrganisationsDash extends Component {
//
//     render() {
//         return (
//             <div className="organisations">
//                 orgs here
//             </div>
//         )
//     }
// }
//
// export default OrganisationsDash

import React, {useState, useEffect} from "react";
import { DataGrid } from '@material-ui/data-grid';
import EditIcon from '@material-ui/icons/Edit';
import IconButton from '@material-ui/core/IconButton';
import { Link } from "react-router-dom";
import SearchIcon from "@material-ui/icons/Search";
import AddCircleOutlinedIcon from "@material-ui/icons/AddCircleOutlined";
import Button from '@material-ui/core/Button';

import "../../styles/Organisations.css"

export default function OrganisationsDash() {
    const [isLoaded,setIsLoaded] = useState(false);
    const [rowData,setRowData] = useState([]);
    useEffect(() => {
        const axios = require('axios').default;
        axios
            .get('http://jsonplaceholder.typicode.com/users')
            .then((response) => {
            setIsLoaded(true);
            console.log(response.data);
            setRowData(response.data);
            response.data.forEach(user => {
            });
        });
    }, []);
    const columns = [
        { field: "id", headerName: "ID", width: 100 },
        { field: 'name', headerName: 'Name', width: 200 },
        { field: 'username', headerName: 'User name', width: 200 },
        { field: 'email', headerName: 'EMail', width: 200 },
        { field: 'website', headerName: 'Website', width: 200 },
        {
            field: "action",
            headerName: "Action",
            width: 150,
            renderCell: (params) => {
                return (
                    <>
                        <Link to={"/org/" + params.row.id}>
                        {/*    <button className="OrgListEdits">Edit</button>*/}
                            <IconButton>
                                <EditIcon />
                            </IconButton>
                        </Link>
                    </>
                );
            },
        },
];
    return(
        <div className="OrganisationsDash">
            {/*<p> Organisations </p>*/}
            <div className="OrgAdd">
                <Button variant="contained" className="buttonAdd">
                    Add Organisation
                    <AddCircleOutlinedIcon/>
                </Button>
                <div>
                    <div className="header__input">
                        <input placeholder="search organisation" type="text" />
                        <SearchIcon/>
                    </div>
                </div>
            </div>

            <div className="table">
                <div style={{ display: 'flex', height: '100%' }}>
                    <div style={{ flexGrow: 1 }}>
                        <DataGrid
                            columns={columns}
                            rows={rowData}
                            id='id'
                            pageSize={15}
                        />
                    </div>
                </div>

            </div>
        </div>
    );
}