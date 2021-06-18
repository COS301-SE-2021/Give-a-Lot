import React, { Component } from 'react';
import { TextField } from '@material-ui/core';
import axios from 'axios';
import "./AddOrg.css";
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import PhotoLibraryIcon from '@material-ui/icons/PhotoLibrary';
import Fab from "@material-ui/core/Fab";
import Icon from "@material-ui/core/Icon";
import PageviewIcon from "@material-ui/icons/Pageview";
import SearchIcon from "@material-ui/icons/Search";
import AddPhotoAlternateIcon from "@material-ui/icons/AddPhotoAlternate";
import CollectionsIcon from "@material-ui/icons/Collections";
import Popover from "@material-ui/core/Popover";

export class AddOrg extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
            name: "",
            description: "",
            image: "",
            email: "",
            /////////image upload
            mainState: "initial", // initial, search, gallery, uploaded
            imageUploaded: 0,
            selectedFile: null
        }
    }
    changeHandler = (e) =>{
        this.setState({[e.target.name] : e.target.value})
    }
    handleSearchClick = event => {
        this.setState({
          mainState: "search"
        });
      };
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
        const { name, description,image, email} = this.state
        return (
            <Container component="main" maxWidth="xs" style={{position: "absolute", left: "500px", padding: "20px"}}>
                <div className="">
                    <Typography component="h1" variant="h5">
                        Add Organisation
                    </Typography>
                    <form className=""noValidate onSubmit={this.submitHandler}>
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="name"
                        label="Organisation Name"
                        name="name"
                        autoFocus
                        value={name} onChange={this.changeHandler}
                    />
                    
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="email"
                        label="Email"
                        name="email"
                        autoFocus
                        value={email} onChange={this.changeHandler}
                    />
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
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="name"
                        label="Address"
                        name="name"
                        autoFocus
                        value={name} onChange={this.changeHandler}
                    />
                    
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="email"
                        label="Something"
                        name="email"
                        autoFocus
                        value={name} onChange={this.changeHandler}
                    />

                    <Fab className="" onClick={this.handleSearchClick}>
                        <AddPhotoAlternateIcon />
                    </Fab>
                    <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        color="primary"
                        className=""
                    >
                        Submit
                    </Button>
                    </form>
                </div>
            </Container>
        )
    }
}

export default AddOrg
