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
            validation:{},
            error: "",
            openValid: false,
            orgId: ""
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

        const adminUsersRequestBody = {
            "orgId":23
        }

        axios.post('http://localhost:8080/v1/notifications/get/level_information', adminUsersRequestBody ,config)
            .then(response =>{
                // console.log(response)
                this.setState({validation: response.data.object})
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    render() {
        const { validation } = this.state

        // let {isLoggedIn} = this.state;

        const orgValidating = () => {
            if (validation.level === 1) {
                return (
                    <div className="table">
                        <Card style={{margin: "1em", width: "100%"}}>
                            <CardContent>
                                <Typography className="valid">
                                    <Typography>
                                        {validation.ngoNumber}
                                    </Typography>
                                    <Typography style={{
                                        display: "flex",
                                        alignItems: "center",
                                        justifyContent: "space-between"
                                    }}>
                                        <Grid>
                                            <Button variant="contained" className="buttonValidViewAccept">
                                                Accept
                                            </Button>
                                        </Grid>
                                        <Grid style={{marginLeft: "1em"}}>
                                            <Button variant="contained" className="buttonValidViewDeny"
                                                    onClick={this.openValid.bind(this)}>
                                                Deny
                                            </Button>
                                        </Grid>
                                        <Dialog onClose={this.handleCloseValid.bind(this)}
                                                open={this.state.openValid}>
                                            <DialogTitle>Reason for Denial</DialogTitle>
                                            <DialogContent>
                                                Organisation is under investigation
                                            </DialogContent>
                                        </Dialog>
                                    </Typography>
                                </Typography>
                            </CardContent>
                        </Card>
                    </div>
                );
            } else if(validation.level === 2){
                return (<button>level2</button>);
            }else if(validation.level === 3){
                return (<button>level3</button>);
            }else if(validation.level === 4){
                return (<button>level4</button>);
            }
            else if(validation.level === 5){
                return (<button>level5</button>);
            }
            else{
                return ("none")
            }
        }

        return (
            <div className="validate">
                <div className="validBody">
                    <div  className="name">
                        Organisation Name
                    </div>
                    {orgValidating()}
                </div>
            </div>
        )
    }
}

export default OrgValidate
