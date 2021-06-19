/*import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import InputLabel from '@material-ui/core/InputLabel';
 import MenuItem from '@material-ui/core/MenuItem';
import FormHelperText from '@material-ui/core/FormHelperText';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import axios from "axios";

 const useStyles = makeStyles((theme) => ({
     formControl: {
        margin: theme.spacing(1),
         minWidth: 100,

    },
     selectEmpty: {
         marginTop: theme.spacing(2),

     },
 }));
 export default function Status() {
     const classes = useStyles();
     const [status, setStatus] = React.useState('');

     useEffect(() => {

         axios.get('https://jsonplaceholder.typicode.com/users',{status})
             .then(response =>{
                 console.log(response)
                 this.setState({posts: response.data})
             })
             .catch(error =>{
                 console.log(error)
                 this.setState({error : 'Error Retrieving data'})
             })



     },[]);


     const handleChange = (event) => {

         useEffect(() => {

             axios.post('https://jsonplaceholder.typicode.com/users',{state:this.state})
                 .then(response =>{
                     console.log(response)
                     this.setState({posts: response.data})
                 })
                 .catch(error =>{
                     console.log(error)
                     this.setState({error : 'Error Retrieving data'})
                 })
                 },[]);
         setStatus(event.target.value);

     };

     return (
        <div>

            <FormControl variant="outlined" className={classes.formControl}>
                <InputLabel id="label">{status}</InputLabel>
                <Select
                     labelId="label"
                     value={status}
                     onChange={handleChange}
                     label="Status"
                >
                     <MenuItem value="">
                         <em>None</em>
                     </MenuItem>
                     <MenuItem value={10}>Active</MenuItem>
                     <MenuItem value={20}>Suspend</MenuItem>
                     <MenuItem value={30}>UnderInvestigation</MenuItem>
               </Select>
             </FormControl>

         </div>
     );
 }*/

import React, { Component } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { withStyles } from "@material-ui/core/styles";
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormHelperText from '@material-ui/core/FormHelperText';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import axios from "axios";


import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogContentText from "@material-ui/core/DialogContentText";
import DialogTitle from "@material-ui/core/DialogTitle";


const useStyles = theme => ({
    formControl: {
        margin: theme.spacing(1),
        minWidth: 100,

    },
    selectEmpty: {
        marginTop: theme.spacing(2),

    },
});

export class Status extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
            status: "",

        }
    }
    state = {
        open: false
    };


    componentDidMount(){
        axios.get('https://api.npms.io/v2/search?q=react')
            .then(response =>
           this.setState({ status: response.data.total }))


    }



    handleChange = (e) => {
        console.log(e);
        this.setState({[e.target.name] : e.target.value})
            axios.post('https://jsonplaceholder.typicode.com/users',{state:this.status})
                .then(response =>{
                    console.log(response)
                    this.setState({posts: response.data})
                })
                .catch(error =>{
                    console.log(error)
                    this.setState({error : 'Error Retrieving data'})
                })
    };

    handleClickOpen = (e) => {
        this.setState({ open: true });
    };

    handleClose = () => {
        this.setState({ open: false });
    };

    handleAgree = (e) => {
        // console.log("Proceed!");
        this.handleClose();
        this.setState({[e.target.name] : e.target.value})
            axios.post('https://jsonplaceholder.typicode.com/users',{state:this.status})
                .then(response =>{
                    console.log(response)
                    this.setState({posts: response.data})
                })
                .catch(error =>{
                    console.log(error)
                    this.setState({error : 'Error Retrieving data'})
                })
    };
    handleDisagree = () => {
        console.log("Cancel.");
        this.handleClose();
    };

    handleSubmit = (e) => {
        console.log(e);
        this.setState({[e.target.name] : e.target.value})
            axios.post('https://jsonplaceholder.typicode.com/users',{state:this.status})
                .then(response =>{
                    console.log(response)
                    this.setState({posts: response.data})
                })
                .catch(error =>{
                    console.log(error)
                    this.setState({error : 'Error Retrieving data'})
                })
    }

    render() {
        const { classes } = this.props;
    const { status} = this.state

        return (
            <div>
                <FormControl variant="outlined" className={classes.formControl} onSubmit={this.handleSubmit}>
                 <InputLabel id="label" >{status}</InputLabel>
                 <Select
                    labelId="label"
                    id="id"
                    value={this.status}
                    //onChange={this.handleChange}
                     onChange={this.handleClickOpen}
                    label="Status"
                >
                    <MenuItem value={status} name="status">
                        <em>None</em>
                    </MenuItem>
                    <MenuItem value={10}>Active</MenuItem>
                    <MenuItem value={20}>Suspend</MenuItem>
                    <MenuItem value={30}>UnderInvestigation</MenuItem>
                </Select>
                <Dialog
                    open={this.state.open}
                    onClose={this.handleClose}
                    aria-labelledby="alert-dialog-title"
                    aria-describedby="alert-dialog-description"
                >
                    <DialogTitle id="alert-dialog-title">
                        {"Status change Alert!"}
                    </DialogTitle>
                    <DialogContent>
                        <DialogContentText id="alert-dialog-description">
                            Are you sure?
                        </DialogContentText>
                    </DialogContent>
                    <DialogActions>
                        <Button onClick={this.handleDisagree} color="primary">
                           Cancel
                        </Button>
                        <Button onClick={this.handleAgree} color="primary" autoFocus>
                            Proceed
                        </Button>
                    </DialogActions>
                </Dialog>
            </FormControl>


                

            </div>
        )
    }
}

export default withStyles(useStyles)(Status);
