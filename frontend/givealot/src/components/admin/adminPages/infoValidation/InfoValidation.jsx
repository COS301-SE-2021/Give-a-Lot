import React from 'react'
import "./infoValidation.css"
import { DataGrid } from '@material-ui/data-grid';
import {Link} from "react-router-dom";
// import {DeleteOutline} from "@material-ui/icons";
import { useState } from "react";
import {orgsRows} from "../../../../DummyData";



// export class InfoValidation extends Component {
    export default function InfoValidation() {
        const [data, setData] = useState(orgsRows);

        const handleDelete = (id) => {
            setData(data.filter((item) => item.id !== id));
        };

    const columns = [
        { field: 'id', headerName: 'ID', width: 100 },
        {
            field: 'orgName',
            headerName: 'Organisation Name',
            width: 300,
            editable: true,
        },
        {
            field: "action",
            headerName: "Action",
            width: 150,
            renderCell: (params) => {
                return (
                    <>
                        <Link to={"/orgValidate/" + params.row.id}>
                            <button className="accept">Validate</button>
                        </Link>
                        {/*<DeleteOutline*/}
                        {/*    className="OrgsListDeletes"*/}
                        {/*    onClick={() => handleDelete(params.row.id)}*/}
                        {/*/>*/}
                        {/*<Link to={"/orgs/" + params.row.id}>*/}
                        {/*    <button className="deny">Deny</button>*/}
                        {/*</Link>*/}
                    </>
                );
            },
        },
    ];

    const rows = [
        { id: 1, orgName: 'Snow something' },
        { id: 2, orgName: 'Lannister something'},
        { id: 3, orgName: 'Lannister something' },
        { id: 4, orgName: 'Stark something' },
        { id: 5, orgName: 'Targaryen something' },
        { id: 6, orgName: 'Melisandre something' },
        { id: 7, orgName: 'Clifford something'},
        { id: 8, orgName: 'Frances something' },
        { id: 9, orgName: 'Roxie something' },
    ];

    // render() {
        return (
            <div className="validate">
                <DataGrid
                    rows={rows}
                    columns={columns}
                    pageSize={5}
                    checkboxSelection
                    disableSelectionOnClick
                />
            </div>
        )
    // }
}

// export default InfoValidation
