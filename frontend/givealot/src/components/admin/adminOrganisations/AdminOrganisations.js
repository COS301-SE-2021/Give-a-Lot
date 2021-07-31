import React, { Component } from 'react'
import { MDBDataTable, Row, Col, Card, CardBody } from 'mdbreact';
import axios from "axios";
import DialogTitle from '@material-ui/core/DialogTitle'
import Dialog from '@material-ui/core/Dialog'
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import "./AdminOrganisations.css"

export class AdminOrganisations extends Component {

    constructor(props) {
        super(props)

        this.state = {
            posts:[],
            error: "",
            tableRows: [],
            isLoading:true,
            open: false,
        }

    }
    componentWillMount=async() => {
        await axios.get('http://jsonplaceholder.typicode.com/users')
            .then(response => response.data)
            .then(data => {
                this.setState({ posts: data })
            })
            .then(async() => {
                this.setState({ tableRows:this.assemblePosts(), isLoading:false })
                console.log(this.state.tableRows);
            });
    }


    assemblePosts= () => {

        let posts =this.state.posts.map((post) => {
            return (
                {
                    number: post.name,
                    title: post.username,
                    user: post.email,

                }
            )
        });
        return posts;
    }
    render() {
        const data = {
            columns: [
                {
                    label:'#',
                    field:'number',
                },
                {
                    label:'Title',
                    field:'title',
                },
                {
                    label:'User ID',
                    field:'user',
                },
                // {
                //     label:'Body',
                //     field:'body',
                // },
            ],
            rows:this.state.tableRows,
        }

        return (
            <div>
                <div style={{paddingBottom: "50px"}}>
                    <Button
                        variant="outlined"
                        style={{color: "white", backgroundColor: "black"}}
                        onClick={() => this.setState({ open: !this.state.open })}
                    >
                        Add Organisation
                    </Button>

                </div>
                <div>
                    <Row className="mb-4">
                        <Col md="12">
                            <Card>
                                <CardBody>
                                    <MDBDataTable
                                        paging={true}
                                        striped
                                        bordered
                                        scrollY
                                        hover
                                        entriesOptions={[5, 20, 25]}
                                        entries={10}
                                        // maxHeight="250px"
                                        // pagesAmount={4}
                                        data={data}
                                    />
                                </CardBody>
                            </Card>
                        </Col>
                    </Row>
                </div>
                <Dialog open={this.state.open}  aria-labelledby="form-dialog-title">
                    <DialogTitle id="form-dialog-title">Add Organisation</DialogTitle>
                    <DialogContent>
                        <DialogContentText>
                            Add Organisation
                        </DialogContentText>
                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="orgName"
                            label="Organisation Name"
                            name="orgName"
                            // autoFocus
                            // value={orgName} onChange={this.changeHandler}
                        />

                        <TextField
                            id="orgDescription"
                            label="Description"
                            multiline
                            rows={5}
                            fullWidth
                            name="orgDescription"
                            variant="outlined"
                            // value={orgDescription} onChange={this.changeHandler}
                        />

                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="orgSector"
                            label="Sector"
                            name="orgSector"
                            // autoFocus
                            // value={orgSector} onChange={this.changeHandler}
                        />

                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="orgEmail"
                            label="orgEmail"
                            name="orgEmail"
                            // autoFocus
                            // value={orgEmail} onChange={this.changeHandler}
                        />

                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="password"
                            label="password"
                            name="password"
                            // autoFocus
                            // value={password} onChange={this.changeHandler}
                        />

                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="contactPerson"
                            label="contactPerson"
                            name="contactPerson"
                            // autoFocus
                            // value={contactPerson} onChange={this.changeHandler}
                        />
                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="contactNumber"
                            label="contactNumber"
                            name="contactNumber"
                            // autoFocus
                            // value={contactNumber} onChange={this.changeHandler}
                        />
                    </DialogContent>
                    <DialogActions>
                        <Button onClick={() => this.setState({ open: !this.state.open })}  color="primary">
                            Submit
                        </Button>
                    </DialogActions>
                </Dialog>
            </div>
        )
    }
}

export default AdminOrganisations
