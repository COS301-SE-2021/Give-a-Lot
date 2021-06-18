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
             modalname: ""
        }

        this.showModal = this.showModal.bind(this);
        this.hideModal = this.hideModal.bind(this);
        this.getInitialState = this.getInitialState.bind(this);
        this. change = this. change.bind(this);
    }

    showModal = () => {
        this.setState({ show: true });
      };

      
    
      hideModal = (e) => {
        this.setState({ show: false });
        e.preventDefault()
        console.log(this.state)
        axios.post('http://localhost:8080/report/organisation', this.state)
        .then(response =>{
            console.log(response)
        })
        .catch(error =>{
            console.log(error)
        })
      };

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

    getInitialState() {
        return {
            value: 'Active'
        }
    }
    change(event){
        this.setState({value: event.target.value});
    }

    ModalchangeHandler(e){
        this.setState({[e.target.name] : e.target.value})
    }
    ModalchangeHandler

    render() {
        const { posts, error,name, email,modalname} = this.state
        return (
            <div>
                <TableContainer component={Paper} style={{width: "1000px", position:"absolute", top: "190px"}}>  
                <Table >  
                <TableHead>  
                    <TableRow>  
                    <TableCell align="right">ID</TableCell> 
                    <TableCell align="right">Name</TableCell>
                        <TableCell align="right">Email</TableCell>


                        <TableCell style={{paddingLeft:"60px"}} align="right" >Action</TableCell>
                        <TableCell align="right">Status</TableCell>
                    </TableRow>  
                </TableHead>  
                <TableBody>  
                {  
                    this.state.posts.map((p, index) => {  
                        return <TableRow key={index}>  
                        <TableCell align="right">{p.id}</TableCell>  
                        <TableCell align="right">{p.name}</TableCell>  
                        <TableCell align="right">{p.email}</TableCell>
                            <TableCell align="right">
                                <CreateIcon
                                    style={{cursor: "pointer"}}
                                    onClick={event =>  window.location.href='Manage'}
                                />
                            </TableCell>

                            <TableCell align="right">
                                <Status />
                                {/*} <select id="lang" onChange={this.change} value={this.state.value}>
                                    <option value="Active">Active</option>
                                    <option value="Java">Suspend</option>
                                    <option value="C++">Investigate</option>
                                </select>
                                <p></p>
                                <p>{this.state.value}</p>*/}
                            </TableCell>


                      </TableRow> 
                    })  
                    }  
                </TableBody>  
                </Table>  
                </TableContainer>  
               <div>
                    <div style={{position: "absolute", left: "270px", top: "120px"}}>
                    <Modal className="overlay" show={this.state.show} handleClose={this.hideModal}>
                        <h4>Add Organisation</h4>
                        <form onSubmit={this.hideModal}>
                        <TextField id="outlined-basic" label="Name" variant="outlined" value={modalname} onChange={this.ModalchangeHandler}style={{width: "500px"}}/>
                        <TextField id="outlined-basic" label="email" variant="outlined" value={modalname} onChange={this.ModalchangeHandler}style={{width: "500px"}}/>
                        <TextField id="outlined-basic" label="stuff" variant="outlined" value={modalname} onChange={this.ModalchangeHandler}style={{width: "500px"}}/>
                        <TextField id="outlined-basic" label="like" variant="outlined" value={modalname} onChange={this.ModalchangeHandler}style={{width: "500px"}}/>
                        <TextField id="outlined-basic" label="stuff" variant="outlined" value={modalname} onChange={this.ModalchangeHandler}style={{width: "500px"}}/>
                        </form>
                    </Modal>
                        <Button variant="contained" color="primary" type="submit" onClick={this.showModal}>
                            Add Organisation
                        </Button>
                    </div>
                    <div style={{position: "absolute", right: "100px", top: "120px"}}>
                            search
                    </div>
                </div>
                
                
                
            </div>
        )
    }
}
