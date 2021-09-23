import React , { Component } from 'react'
import "../../styles/Organisations.css"
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import axios from 'axios'

export class Users extends Component {

    constructor(props) {
        super(props)

        this.state = {
            users:[],
            error: "",
            adminUserEmail: localStorage.getItem('curr_user_email'),
            serverDomain: "http://0948-105-208-196-136.ngrok.io"
        }

    }

    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        const users = {
            "adminUserEmail":this.state.adminUserEmail
        }

        axios.post('http://0948-105-208-196-136.ngrok.io/v1/user/get/users', users ,config)
            .then(response =>{
                this.setState({users: response.data.response})
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }
    render () {
        const { users } = this.state
        return(
            <div className="OrganisationsDash">
                <div className="userTitle">
                    All Basic Users on Givealot
                </div>
                <div className="table">
                    <Grid container spacing={3}>
                        <Grid item xs={12} >
                            <TableContainer component={Paper}>
                                <Table >
                                    <TableHead style={{backgroundColor: "#957b9e"}}>
                                        <TableRow>
                                            <TableCell style={{color: "white"}}>First Name</TableCell>
                                            <TableCell style={{color: "white"}}>Last Name</TableCell>
                                            <TableCell style={{color: "white"}}>Email</TableCell>
                                            <TableCell style={{color: "white"}}>Activation Date</TableCell>
                                        </TableRow>
                                    </TableHead>
                                    <TableBody>
                                        {users.map((item) =>{
                                            return(
                                                <TableRow key={item.id}>
                                                    <TableCell>{item.firstname}</TableCell>
                                                    <TableCell>{item.lastname}</TableCell>
                                                    <TableCell>{item.email}</TableCell>
                                                    <TableCell>{item.activateDate}</TableCell>
                                                </TableRow>
                                            )
                                        })}
                                    </TableBody>
                                </Table>
                            </TableContainer>
                        </Grid>
                    </Grid>
                </div>
            </div>
        );
    }


}

export default Users
