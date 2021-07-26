import React, { Component } from 'react'
import { MDBDataTable, Row, Col, Card, CardBody } from 'mdbreact';
import axios from "axios";

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
            <div style={{position: "absolute", top: "65px", left: "240px", width: "1050px", height: "100%"}} >
                {/*<MDBDataTable striped bordered hover data={posts} />*/}
                <Row className="mb-4">
                    <Col md="12">
                        <Card>
                            <CardBody>
                                <MDBDataTable
                                    striped
                                    bordered
                                    paging={true}
                                    hover
                                    data={data}
                                />
                            </CardBody>
                        </Card>
                    </Col>
                </Row>
            </div>
        )
    }
}

export default AdminUsers

