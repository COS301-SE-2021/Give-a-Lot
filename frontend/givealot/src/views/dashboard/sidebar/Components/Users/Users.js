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

import React , { Component } from 'react'
import Avatar from '@material-ui/core/Avatar';
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

// export default function OrganisationsDash() {
export class Users extends Component {

    constructor(props) {
        super(props)

        this.state = {
            users:[],
            error: "",
        }

    }

    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        axios.get('http://jsonplaceholder.typicode.com/users',  config)
            .then(response =>{
                // console.log(response)
                this.setState({users: response.data})
                console.log(this.state.users)
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
                    All Users
                </div>
                <div className="table">
                    <Grid container spacing={3}>
                        <Grid item xs={12} >
                            <TableContainer component={Paper}>
                                <Table >
                                    <TableHead>
                                        {/*table head here*/}
                                    </TableHead>
                                    <TableBody>
                                        {users.map((item, index) =>{
                                            return(
                                                <TableRow>
                                                    <TableCell><Avatar aria-label="recipe" src="https://st.depositphotos.com/1428083/2946/i/600/depositphotos_29460297-stock-photo-bird-cage.jpg" /> </TableCell>
                                                    <TableCell>{item.name}</TableCell>
                                                    <TableCell>{item.username}</TableCell>
                                                    <TableCell>{item.email}</TableCell>
                                                    <TableCell>{item.username}</TableCell>
                                                    <TableCell>{item.email}</TableCell>
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