import React, { Component } from 'react';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import { makeStyles, withStyles } from '@material-ui/core/styles';
import MenuItem from "@material-ui/core/MenuItem";
import axios from 'axios';
import InputLabel from '@material-ui/core/InputLabel';
// import MenuItem from '@material-ui/core/MenuItem';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import NativeSelect from '@material-ui/core/NativeSelect';
import InputBase from '@material-ui/core/InputBase';

// const useStyles = makeStyles((theme) => ({

//     buttons: {
//         display: 'flex',
//         justifyContent: 'flex-end',
//     },
//     button: {
//         marginTop: theme.spacing(3),
//         marginLeft: theme.spacing(1),
//     },
// }));

const BootstrapInput = withStyles((theme) => ({
    root: {
      'label + &': {
        marginTop: theme.spacing(3),
      },
    },
    input: {
      borderRadius: 4,
      position: 'relative',
      backgroundColor: theme.palette.background.paper,
      border: '1px solid #ced4da',
      fontSize: 16,
      padding: '10px 26px 10px 12px',
      transition: theme.transitions.create(['border-color', 'box-shadow']),
      // Use the system font instead of the default Roboto font.
      fontFamily: [
        '-apple-system',
        'BlinkMacSystemFont',
        '"Segoe UI"',
        'Roboto',
        '"Helvetica Neue"',
        'Arial',
        'sans-serif',
        '"Apple Color Emoji"',
        '"Segoe UI Emoji"',
        '"Segoe UI Symbol"',
      ].join(','),
      '&:focus': {
        borderRadius: 4,
        borderColor: '#80bdff',
        boxShadow: '0 0 0 0.2rem rgba(0,123,255,.25)',
      },
    },
  }))(InputBase);

  const useStyles = makeStyles((theme) => ({
    margin: {
      margin: theme.spacing(1),
    },
  }));
  
class OrgReportForm extends Component {
     
    constructor(props) {
        super(props)
    
        this.state = {
            description : "",
            type: "",
            // username    : "",
            userEmail: "",
            country: "",
            Follow: ""
        }
    }

    changeHandler = (e) =>{
        // console.log(this)
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

                    <Grid item xs={12} sm={6}>
                        <NativeSelect
                        value={type}
                        onChange={this.changeHandler}
                        name="type"
                        //   className={classes.selectEmpty}
                        inputProps={{ 'aria-label': 'type' }}
                        >
                        <option disabled value="">Select Type</option>
                        <option value={"Incorect Profile Information"}>Incorect Profile Information</option>
                        <option value={"Suspicious Behavior"}>Suspicious Behavior</option>
                        <option value={"Fraud Activity"}>Fraud Activity</option>
                        </NativeSelect>
                    </Grid>
            
                    <Grid item xs={12} >
                        <TextField
                            id="outlined-multiline-static"
                            label="Description"
                            multiline
                            rows={5}
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
                            type="submit"
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