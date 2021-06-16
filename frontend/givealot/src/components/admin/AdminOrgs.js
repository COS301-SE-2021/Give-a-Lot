import React, { Component } from 'react';
import { DataGrid } from '@material-ui/data-grid';
import axios from 'axios';

const columns = [
    { field: 'id', headerName: 'ID', width: "100px" },
    { field: 'title', headerName: 'Organisation Name', width: "300px" },
    { field: 'body', headerName: 'stuff', width: "300px" },
    
  ];
//   const rows = [
//     { field: 'id', headerName: 'ID', width: 70 },
//     { field: 'firstName', headerName: 'First name', width: 130 },
//     { field: 'lastName', headerName: 'Last name', width: 130 },
    
//   ];
  

export default class AdminOrgs extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
             posts:[],
             error: ""
        }
    }

    componentDidMount(){
        axios.get('https://jsonplaceholder.typicode.com/posts')
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
                <h4>List of Organisations</h4>
                {
                    // posts.length ?
                    // posts.map(post => <div key={post.id}>
                    //     {post.title}
                    //     {post.body}
                    // </div>):
                    // null
                    <div style={{ height: 500, width: '1000px' }}>
                        <DataGrid rows={posts} columns={columns} pageSize={10} checkboxSelection />
                    </div>    
                }
                
                {
                    error ? <div>{error}</div> : null
                }
                
            </div>
        )
    }
}
