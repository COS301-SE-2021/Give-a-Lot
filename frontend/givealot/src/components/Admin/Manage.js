import React, { Component } from 'react'
import "./Manage.css"
// import React, { Component } from 'react';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import {makeStyles} from "@material-ui/core/styles";
import MenuItem from "@material-ui/core/MenuItem";
import axios from 'axios';

const useStyles = makeStyles((theme) => ({

    buttons: {
        display: 'flex',
        justifyContent: 'flex-end',
    },
    button: {
        marginTop: theme.spacing(3),
        marginLeft: theme.spacing(1),
    },
}));

export class Manage extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
            username    : "",
            userEmail   : "",
        }
    }

    changeHandler = (e) =>{
        this.setState({[e.target.name] : e.target.value})
    }
    submitHandler = (e) =>{
        e.preventDefault()
        console.log(this.state)
        axios.post('http://localhost:8080/report/organisation', this.state)
        .then(response =>{
            console.log(response)
        })
        .catch(error =>{
            console.log(error)
        })
    }
    render() {

        const {username, userEmail} = this.state
        return (
            <div className="manage">
                <div className="Orgname">
                            <form onSubmit={this.submitHandler}>
                            <React.Fragment >
                            <Grid container spacing={3}>
                                <Grid item xs={12} sm={6}>
                                    <TextField
                                        required
                                        id="Name"
                                        name="username"
                                        label="Organisation name"
                                        fullWidth
                                        autoComplete="given-name"
                                        value={username} onChange={this.changeHandler}
                                    />
                                </Grid>
                                <Grid item xs={12} sm={6}>
                                    <TextField
                                        required
                                        id="department"
                                        name="userEmail"
                                        label="Useremail"
                                        fullWidth
                                        autoComplete="department"
                                        value={userEmail} onChange={this.changeHandler}
                                    />
                                </Grid>

                                <Grid item xs={12}>
                                    <Button
                                        variant="contained"
                                        color="primary"
                                    // onClick={handleNext}
                                        // className={classes.button}
                                    >
                                        Report
                                    </Button>
                                </Grid>
                            </Grid>
                        </React.Fragment>
                    </form>
                </div>
            </div>
        )
    }
}

export default Manage
