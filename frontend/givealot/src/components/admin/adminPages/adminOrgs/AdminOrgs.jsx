// import React, { Component } from 'react';
// import "./adminOrgs.css"
// import { DataGrid } from '@material-ui/data-grid';
// import axios from "axios";
// import { Link } from "react-router-dom";
// // import { DeleteOutline } from "@material-ui/icons";
//
// const columns = [
//
//     { field: "orgId", headerName: "ID", width: 100 },
//     { field: "orgName", headerName: "Org Name", width: 200 },
//     { field: "slogan", headerName: "Slogan", width: 200 },
//     {
//         field: "orgDescription",
//         headerName: "Org Description",
//         width: 200,
//     },
//     { field: "orgSector", headerName: "Sector", width: 130 },
//     { field: "orgEmail", headerName: "Email", width: 200 },
//     { field: "contactNumber", headerName: "Number", width: 160 },
//     { field: "status", headerName: "Status", width: 130 },
//     { field: "contactPerson", headerName: "Contact Person", width: 200 },
//
//     {
//         field: "action",
//         headerName: "Action",
//         width: 150,
//         renderCell: (params) => {
//             return (
//                 <>
//                     <Link to={"/orgs/" + params.row.id}>
//                         <button className="OrgsListEdits">Edit</button>
//                     </Link>
//                 </>
//             );
//         },
//     },
// ];
//
// export default class AdminOrgs extends Component {
//     constructor(props) {
//         super(props)
//
//         this.state = {
//             organisations:[],
//             adminUserEmail: "admin@email.com"
//         }
//
//     }
//
//     componentDidMount(){
//         let config = {
//             headers: {
//                 "Content-Type": "application/json",
//                 'Access-Control-Allow-Origin': '*',
//             }
//         }
//         axios.get('http://localhost:8080/v1/organisation/get/organisations/temporal', config)
//             .then(response =>{
//                 console.log(response)
//                 this.setState({organisations: response.data.response})
//             })
//             .catch(error =>{
//                 console.log(error)
//                 this.setState({error : 'Error Retrieving data'})
//             })
//     }
//     render() {
//         const { organisations } = this.state
//         // console.log(orgs);
//         return (
//
//             <div className="adminOrgss">
//                 <Link to="/addOrg">
//                     <button className="AddButton">Create</button>
//                 </Link>
//                 <DataGrid
//                     rows={organisations}
//                     disableSelectionOnClick
//                     columns={columns}
//                     pageSize={8}
//                     checkboxSelection
//                 />
//             </div>
//         );
//     }
// }


import React, { Component } from 'react';
import "./adminOrgs.css"
import { DataGrid } from '@material-ui/data-grid';
import axios from "axios";
import { Link } from "react-router-dom";
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

const columns = [


    { field: "orgName", headerName: "Org Name", width: 200 },
    { field: "slogan", headerName: "Slogan", width: 200 },
    {
        field: "orgDescription",
        headerName: "Org Description",
        width: 200,
    },
    { field: "orgSector", headerName: "Sector", width: 130 },
    { field: "orgEmail", headerName: "Email", width: 200 },
    { field: "orgId", headerName: "ID", width: 100 },
    { field: "status", headerName: "Status", width: 130 },
    { field: "contactPerson", headerName: "Contact Person", width: 200 },
    { field: "contactNumber", headerName: "Number", width: 160 },

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
                </>
            );
        },
    },
];
export default class AdminOrgs extends Component {
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
        // const adminUsersRequestBody = {
        //     "adminUserEmail" : this.state.adminUserEmail
        // }
        axios.get('http://localhost:8080/v1/organisation/get/organisations/temporal',  config)
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
            <div className="adminUserss">
                {/*<DataGrid*/}
                {/*    rows={users}*/}
                {/*    disableSelectionOnClick*/}
                {/*    columns={columns}*/}
                {/*    pageSize={8}*/}
                {/*    checkboxSelection*/}
                {/*/>*/}

                <TableContainer>
                    <Table>
                        <TableHead>
                            <TableRow>
                                <TableCell align="center">ID</TableCell>
                                <TableCell align="center">Name</TableCell>
                                <TableCell align="center">Description</TableCell>
                                <TableCell align="center">Slogan</TableCell>
                                <TableCell align="center">Sector</TableCell>
                                <TableCell align="center">Contact Person</TableCell>
                                <TableCell align="center">Contact Number</TableCell>
                                {/* <TableCell align="right">Password</TableCell>
                        <TableCell align="right">Contact Person</TableCell>
                        <TableCell align="right">Contact Number</TableCell> */}
                                <TableCell style={{paddingLeft:"60px"}} align="right" >Action</TableCell>
                                <TableCell align="right">Status</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {
                                this.state.users.map((p, index) => {
                                    return <TableRow key={index}>
                                        <TableCell align="center">{p.orgId}</TableCell>
                                        <TableCell align="center">{p.orgName}</TableCell>
                                        <TableCell align="center">{p.orgDescription}</TableCell>
                                        <TableCell align="center">{p.slogan}</TableCell>
                                        <TableCell align="center">{p.orgSector}</TableCell>
                                        <TableCell align="center">{p.contactPerson}</TableCell>
                                        <TableCell align="center">{p.contactNumber}</TableCell>


                                    </TableRow>
                                })
                            }
                        </TableBody>
                    </Table>
                </TableContainer>
            </div>
        );
    }
}

