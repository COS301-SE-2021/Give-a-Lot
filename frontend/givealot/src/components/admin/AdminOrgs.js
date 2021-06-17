import React, { Component } from 'react';
import { DataGrid } from '@material-ui/data-grid';
import axios from 'axios';
import { TextField } from '@material-ui/core';
import List from '@material-ui/core/List';
import Table from '@material-ui/core/Table';  

import TableBody from '@material-ui/core/TableBody';  

import TableCell from '@material-ui/core/TableCell';  

import TableContainer from '@material-ui/core/TableContainer';  

import TableHead from '@material-ui/core/TableHead';  

import TableRow from '@material-ui/core/TableRow';  

import Paper from '@material-ui/core/Paper';  

import CreateIcon from '@material-ui/icons/Create';

// import Manage from "./Manage"

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
             error: ""
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

    render() {
        const { posts, error} = this.state


        return (
            <div>
                {/* <h4>List of Organisations</h4>
                {
                    <div style={{ height: 500, width: '1000px' }}>
                        <DataGrid
                            rows={posts} 
                            columns={columns} 
                            pageSize={10} checkboxSelection
                         />
                    </div> 
                    
                    
                }
                {
                    error ? <div>{error}</div> : null
                } */}

            <TableContainer component={Paper} style={{width: "1000px"}}>  

                    <Table stickyHeader  aria-label="sticky table">  

                    <TableHead>  

                        <TableRow>  

                        <TableCell align="right">ID</TableCell> 

                        <TableCell align="right">Name</TableCell>  

                        <TableCell align="right">Email</TableCell> 

                        <TableCell style={{paddingLeft:"60px"}} align="right" >Action</TableCell>  

                        </TableRow>  

                    </TableHead>  

                    <TableBody>  

                        {  

                        this.state.posts.map((p, index) => {  

                            return <TableRow key={index}>  

                            {/* <TableCell component="th" scope="row">  

                                {p.Id}  

                            </TableCell>   */}

                            <TableCell align="right">{p.id}</TableCell>  

                            <TableCell align="right">{p.name}</TableCell>  

                            <TableCell align="right">{p.email}</TableCell> 

                            <TableCell align="right">
                                <CreateIcon
                                    style={{cursor: "pointer"}}
                                    onClick={event =>  window.location.href='Manage'} 
                                    // onClick={this.handle}
                                />
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
