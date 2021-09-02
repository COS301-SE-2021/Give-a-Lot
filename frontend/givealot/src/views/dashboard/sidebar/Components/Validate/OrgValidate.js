import React, { Component } from 'react'
import "./Validate.css"
import Grid from "@material-ui/core/Grid";
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import CardActions from '@material-ui/core/CardActions';
import {Link} from "react-router-dom";
import axios from "axios";

export class OrgValidate extends Component {

    constructor(props) {
        super(props)
        this.state = {
            validation:[],
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
        // const adminUsersRequestBody = {
        //     "adminUserEmail" : this.state.adminUserEmail
        // }
        axios.get('http://jsonplaceholder.typicode.com/users',  config)
            .then(response =>{
                // console.log(response)
                this.setState({validation: response.data})
                console.log(this.state.validation)
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }


    render() {
        const { validation } = this.state
        return (
            <div className="validate">
                <div className="validBody">
                    <div  className="name">
                        Organisation Name
                    </div>
                    <div className="table">
                        {validation.map((item, index) =>{
                            return(
                                <Card style={{margin: "1em"}}>
                                    <CardContent>
                                        <Typography className="valid">
                                            {/*<Typography>*/}
                                            {/*    <img src="https://images.unsplash.com/photo-1541963463532-d68292c34b19?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Ym9va3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80"*/}
                                            {/*         style={{width: "100px", height: "100px"}}*/}
                                            {/*    />*/}
                                            {/*</Typography>*/}
                                            <Typography component="p">
                                                {/*{src && <Avatar src={src} />*/}
                                                {item.name}
                                            </Typography>
                                            <Typography style={{display: "flex", alignItems: "center", justifyContent: "space-between"}}>
                                                <Grid>
                                                    <Button variant="contained" className="buttonValidViewAccept">
                                                        Accept
                                                    </Button>
                                                </Grid>
                                                <Grid style={{marginLeft: "1em"}}>
                                                    <Button variant="contained" className="buttonValidViewDeny">
                                                        Deny
                                                    </Button>
                                                </Grid>
                                            </Typography>

                                        </Typography>
                                    </CardContent>
                                </Card>
                            )
                        })}
                    </div>
                </div>

            </div>
        )
    }
}

export default OrgValidate