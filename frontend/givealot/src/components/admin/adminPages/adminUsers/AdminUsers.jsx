import React, { Component } from 'react';
import "./adminUsers.css"
import { DataGrid } from '@material-ui/data-grid';
import axios from "axios";

const columns = [
  // { field: "id", headerName: "ID", width: 100 },
  {
    field: "firstName",
    headerName: "First Name",
    width: 200,
    renderCell: (params) => {
      return (
          <div className="userListUsers">
            <img className="userListImgs" src={params.row.avatar} alt="" />
            {params.row.username}
          </div>
      );
    },
  },
  { field: "lastName", headerName: "Last Name", width: 200 },
  {
    field: "activationDate",
    headerName: "Activation Date",
    width: 200,
  },
  {
    field: "email",
    headerName: "Email",
    width: 220,
  },
];
export default class AdminUsers extends Component {
  // const [data, info ,setData] = useState(userRows);
  constructor(props) {
    super(props)

    this.state = {
      users:[],
        adminUserEmail: ""
    }

  }

  componentDidMount(){
      let config = {
          headers: {
              "Content-Type": "application/json",
              'Access-Control-Allow-Origin': '*',
          }
      }
      const adminUsersRequestBody = {
          "adminUserEmail" : this.state.adminUserEmail
      }
    axios.post('http://localhost:8080/v1/user/get/users', adminUsersRequestBody, config)
        .then(response =>{
          console.log(response)
          this.setState({users: response.data})
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
          <DataGrid
              rows={users}
              disableSelectionOnClick
              columns={columns}
              pageSize={8}
              checkboxSelection
          />
        </div>
    );
  }
}
