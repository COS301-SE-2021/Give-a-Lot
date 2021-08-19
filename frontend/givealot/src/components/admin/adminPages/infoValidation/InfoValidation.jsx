import React, { Component } from 'react';
import "./infoValidation.css"
import { DataGrid } from '@material-ui/data-grid';
import {Link} from "react-router-dom";
import axios from "axios";

const columns = [
    { field: 'id', headerName: 'ID', width: 100 },
    {
        field: 'orgName',
        headerName: 'Organisation Name',
        width: 300,
        editable: true,
    },
    {
        field: 'update',
        headerName: 'Update Field',
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

export class InfoValidation extends Component {

    constructor(props) {
        super(props)

        this.state = {
            updates:[],
            adminUserEmail: "admin@email.com",
            address: '',
            audit: '',
            auditor: '',
            committee: '' ,
            establishment_date: '',
            facebook: '',
            instagram: '',
            twitter: '',
            ngo_date:'' ,
            ngo_number: '',
            tax_raf: '',
        }

    }

    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const updateRequestBody = {
            "adminUserEmail" : this.state.adminUserEmail
        }
        axios.get(' http://localhost:8080/v1/organisation/delete/validity/confirm/orgId/adminId/type/confirm', config)
            .then(response =>{
                console.log(response)
                this.setState({updates: response.data.response})
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    render() {
        const { updates } = this.state
        return (
            <div className="validate">
                <DataGrid
                    rows={updates}
                    columns={columns}
                    pageSize={5}
                    checkboxSelection
                    disableSelectionOnClick
                />
            </div>
        )
    }
}

export default InfoValidation
