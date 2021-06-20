import React, { Component } from 'react';
import { DataGrid } from '@material-ui/data-grid';
import axios from 'axios';
import { TextField } from '@material-ui/core';
import Table from '@material-ui/core/Table';  
import TableBody from '@material-ui/core/TableBody';  
import TableCell from '@material-ui/core/TableCell';  
import TableContainer from '@material-ui/core/TableContainer';  
import TableHead from '@material-ui/core/TableHead';  
import TableRow from '@material-ui/core/TableRow';  
import Paper from '@material-ui/core/Paper';  
import CreateIcon from '@material-ui/icons/Create';
import Link from '@material-ui/core/Link';
import TablePagination from '@material-ui/core/TablePagination';
import AddIcon from '@material-ui/icons/Add';
import Button from '@material-ui/core/Button';
import Modal from './Modal.js';
import Status from "./Status"
import "./AdminOrgs.css";

const columns = [
    { field: 'id', headerName: 'ID', width: "100px" },
    { field: 'name', headerName: 'Organisation Name', width: "300px" },
    { field: 'email', headerName: 'email', width: "300px" },
    { field: 'action', headerName: 'Action', width: "300px" },  
    
  ];
  
export default class AdminOrgs extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
             posts:[],
             error: "",
             show: false,
             name: "",
             email: "",
            //  modalname: ""
        }

    }
    componentDidMount(){
        axios.get('https://jsonplaceholder.typicode.com/users')
        .then(response =>{
            console.log(response)
            this.setState({posts: response.data})
        })
        .catch(error =>{
            console.log(error)
            this.setState({error : 'Error Retrieving data'})
        })
    }


    ModalchangeHandler(e){
        this.setState({[e.target.name] : e.target.value})
    }
    ModalchangeHandler

    render() {
        const { posts, error,name, email} = this.state
        return (
            <div>
                <div>
                    <div style={{position: "absolute", left: "270px", top: "120px"}}>
                        <Button variant="contained" color="primary" type="submit"
                            style={{cursor: "pointer"}}
                            onClick={event =>  window.location.href='AddOrg'} >
                            Add Organisation
                        </Button>
                    </div>
                    <div style={{position: "absolute", right: "100px", top: "120px"}}>
                        search
                    </div>
                </div>
                <TableContainer component={Paper} style={{width: "1000px", position:"absolute", top: "190px"}}>  
                <Table >  
                <TableHead>  
                    <TableRow>  
                    <TableCell align="right">ID</TableCell> 
                    <TableCell align="right">Name</TableCell>
                        <TableCell align="right">Description</TableCell>
                        <TableCell align="right">Slogan</TableCell>
                        <TableCell align="right">Sector</TableCell>
                        {/* <TableCell align="right">Password</TableCell>
                        <TableCell align="right">Contact Person</TableCell>
                        <TableCell align="right">Contact Number</TableCell> */}
                        <TableCell style={{paddingLeft:"60px"}} align="right" >Action</TableCell>
                        <TableCell align="right">Status</TableCell>
                    </TableRow>  
                </TableHead>  
                <TableBody>  
                {  
                    this.state.posts.map((p, index) => {  
                        return <TableRow key={index}>  
                        <TableCell align="right">{p.org_id}</TableCell>  
                        <TableCell align="right">{p.org_name}</TableCell>  
                        <TableCell align="right">{p.org_short_description}</TableCell>
                        <TableCell align="right">{p.org_slogan}</TableCell>
                        <TableCell align="right">{p.org_sector}</TableCell>
                        {/* <TableCell align="right">{p.password}</TableCell>
                        <TableCell align="right">{p.contactPerson}</TableCell>
                        <TableCell align="right">{p.contactNumber}</TableCell> */}
                            <TableCell align="right">
                                <CreateIcon
                                    style={{cursor: "pointer"}}
                                    onClick={event =>  window.location.href='Manage'}
                                />
                            </TableCell>

                            <TableCell align="right">
                                <Status />

                            </TableCell>


                      </TableRow> 
                    })  
                    }  
                </TableBody>  
                </Table>  
                </TableContainer>  
               
            </div>
        )
    }
}
