import React, { Component } from 'react'
import { MDBDataTable, Row, Col, Card, CardBody } from 'mdbreact';
import axios from "axios";
import "./AdminUsers.css"

export class AdminUsers extends Component {

    constructor(props) {
        super(props)

        this.state = {
            posts:[],
            error: "",
            tableRows: [],
            isLoading:true,
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

        // const { posts } = this.state
        return (
            <div >
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
            </div>
        )
    }
}

export default AdminUsers

