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
import Galleryy from "./Galleryy";
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
        backgroundColor:'#94f8b9'
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
                <div >

                    <div >
                        <h2>The givers of hope</h2>

                        <p>Here is the description of what the organisation does and stuuff do not mind my typos , matter of
                            fact do not mnd this text at all , it should be replaxced with the te description bla bla bla
                            Here is the description of what the organisation does and stuuff do not mind my typos , matter of
                            fact do not mnd this text at all , it should be replaxced with the te description bla bla bla

                            Here is the description of what the organisation does and stuuff do not mind my typos , matter of
                            fact do not mnd this text at all , it should be replaxced with the te description bla bla bla</p>
                        <Galleryy />
                        <h2 style={{color: "white"}}>Lazy space, don't remove</h2>
                    </div>


                    <form onSubmit={this.submitHandler}>
                        <React.Fragment >
                            <Grid container spacing={3}>
                                {/*<Grid item xs={12} sm={6}>
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
                                </Grid>*/}

                                <Grid item xs={12} sm={3}>
                                    <Button
                                        variant="contained"
                                        color="primary"
                                        // onClick={handleNext}
                                        // className={classes.button}
                                    >
                                        Verify
                                    </Button>
                                </Grid>
                                <Grid item xs={12} sm={3}>
                                    <Button
                                        variant="contained"
                                        color="primary"
                                        // onClick={handleNext}
                                        // className={classes.button}
                                    >
                                        Generate
                                    </Button>
                                </Grid>
                                <Grid item xs={12} sm={3}>
                                    <Button
                                        variant="contained"
                                        color="primary"
                                        // onClick={handleNext}
                                        // className={classes.button}
                                    >
                                        Revoke
                                    </Button>
                                </Grid>
                                <Grid item xs={12} sm={3}>
                                    <Button
                                        variant="contained"
                                        color="primary"
                                        // onClick={handleNext}
                                        // className={classes.button}
                                    >
                                        Something
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
