import React, { Component } from 'react';
import { DataGrid } from '@material-ui/data-grid';
import axios from 'axios';

const columns = [
    { field: 'id', headerName: 'ID', width: "100px" },
    { field: 'title', headerName: 'Organisation Name', width: "300px" },
    { field: 'body', headerName: 'stuff', width: "300px" },
    
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
                    <div style={{ height: 500, width: '1000px' }}>
                        <DataGrid
                            rows={posts} columns={columns} pageSize={10} checkboxSelection
                         />
                    </div>    
                }
                {
                    error ? <div>{error}</div> : null
                }
                
            </div>
        )
    }
}
