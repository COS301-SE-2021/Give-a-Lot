import React, { Component } from 'react';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import {makeStyles} from "@material-ui/core/styles";
import MenuItem from "@material-ui/core/MenuItem";
import axios from 'axios';
import InputLabel from '@material-ui/core/InputLabel';
// import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import NativeSelect from '@material-ui/core/NativeSelect';
import InputBase from '@material-ui/core/InputBase';

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

const TypeChoices = [
    {
        value: 'one',
        label: 'Incorect Profile Information',
    },
    {
        value: 'two',
        label: 'Suspicious Behavior',
    },
    {
        value: 'three',
        label: 'Fraud Activity',
    },
    {
        value: 'four',
        label: 'Other stuff',
    },
];

class OrgReportForm extends Component {
     
    constructor(props) {
        super(props)
    
        this.state = {
            description : "",
            type	     : "",
            // username    : "",
            userEmail   : "",
            country: "",
            Follow: ""
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
        const {Name, department, time,date, type, description,country,Follow} = this.state
        // const classes = useStyles();
        return (
            <form onSubmit={this.submitHandler}>
                <React.Fragment >
                <Grid container spacing={3}>
                    {/* <Grid item xs={12} sm={6}>
                        <TextField
                            required
                            id="Name"
                            name="username"
                            label="Organisation name"
                            fullWidth
                            autoComplete="given-name"
                            value={Name} onChange={this.changeHandler}
                        />
                    </Grid> */}
                    <Grid item xs={12} sm={6}>
                        <TextField
                            required
                            id="department"
                            name="userEmail"
                            label="Useremail"
                            fullWidth
                            autoComplete="department"
                            value={department} onChange={this.changeHandler}
                        />
                    </Grid>

                    {/*<Grid item xs={12}>
    
                    </Grid>
                     <Grid item xs={12} sm={6}>
                        <TextField
                            id="time"
                            label="Time"
                            type="time"
                            name="time"
                            defaultValue="07:30"
                            fullWidth
                            InputLabelProps={{
                                shrink: true,
                            }}
                            inputProps={{
                                step: 300, // 5 min
                            }}
                            value={time} onChange={this.changeHandler}
                        />
                    </Grid> */}
                    {/* <Grid item xs={12} sm={6}>
                        <TextField
                            required
                            id="date"
                            name="date"
                            label="Date"
                            type="date"
                            fullWidth
                            defaultValue="2017-05-24"
    
                            InputLabelProps={{
                                shrink: true,
                            }}
                            value={date} onChange={this.changeHandler}
                        />
                    </Grid> */}
                    <Grid item xs={12} sm={6}>
                    <InputLabel htmlFor="demo-customized-select-native">Select Type</InputLabel>
                    <NativeSelect
                    id="demo-customized-select-native"
                    value={type} onChange={this.changeHandler}
                    // input={<BootstrapInput />}
                    >
                    <option aria-label="None" value="" />
                    <option value={10}>Incorect Profile Information</option>
                    <option value={20}>Suspicious Behavior</option>
                    <option value={30}>Fraud Activity</option>
                    </NativeSelect>
                    </Grid>
                    {/* <Grid item xs={12} sm={6}>
                        <TextField
                            required
                            id="country"
                            name="country"
                            label="Country"
                            fullWidth
                            autoComplete="shipping country"
                            value={country} onChange={this.changeHandler}
                        />
                    </Grid> */}
                    <Grid item xs={12} >
                        <TextField
                            id="outlined-multiline-static"
                            label="Description"
                            multiline
                            rows={8}
                            fullWidth
                            name="description"
                            variant="outlined"
                            value={description} onChange={this.changeHandler}
                        />
                    </Grid>
                     <Grid item xs={12}>
                        <TextField
    
                            id="Follow"
                            name="Follow"
                            label="Follow Up Recommendations"
                            fullWidth
                            autoComplete="Follow "
                            value={Follow} onChange={this.changeHandler}
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
            
        );

    }

}

export default OrgReportForm