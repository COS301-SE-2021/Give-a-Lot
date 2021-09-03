import React, { Component } from 'react'
import "./Validate.css"
import Grid from "@material-ui/core/Grid";
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import axios from "axios";
import DialogTitle from "@material-ui/core/DialogTitle";
import DialogContent from "@material-ui/core/DialogContent";
import Dialog from "@material-ui/core/Dialog";

export class OrgValidate extends Component {

    constructor(props) {
        super(props)
        this.state = {
            validation:[],
            error: "",
            openValid: false,
        }
    }
    openValid() {
        this.setState({ openValid: true });
    }
    handleCloseValid = () => {
        this.setState({ openValid: false });
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
                                <Card style={{margin: "1em", width: "100%"}}>
                                    <CardContent>
                                        <Typography className="valid">
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
                                                    <Button variant="contained" className="buttonValidViewDeny" onClick={this.openValid.bind(this)}>
                                                        Deny
                                                    </Button>
                                                </Grid>
                                                <Dialog onClose={this.handleCloseValid.bind(this)} open={this.state.openValid}>
                                                    <DialogTitle>Reason for Denial</DialogTitle>
                                                    <DialogContent>
                                                        Organisation is under investigation
                                                    </DialogContent>
                                                </Dialog>
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
