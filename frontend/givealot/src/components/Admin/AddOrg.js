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
import { withRouter } from 'react-router-dom';
import Popup from 'reactjs-popup';
import "./AddOrgModal.css"
import AdminOrgs from './AdminOrgs';

export class AddOrg extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
            orgName: "",
            orgDescription: "",
            orgSector: "",
            orgEmail: "",
            password: "",
            contactPerson: "",
            contactNumber: "",
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
        // this.props.history.push('/AddOrgModal');
    }
    render() {
        const { orgName, orgDescription,orgSector, orgEmail,password,contactPerson,contactNumber} = this.state
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
                        id="orgName"
                        label="Organisation Name"
                        name="orgName"
                        // autoFocus
                        value={orgName} onChange={this.changeHandler}
                    />

                    <TextField
                        id="orgDescription"
                        label="Description"
                        multiline
                        rows={5}
                        fullWidth
                        name="orgDescription"
                        variant="outlined"
                        value={orgDescription} onChange={this.changeHandler}
                    />
                    
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="orgSector"
                        label="Sector"
                        name="orgSector"
                        // autoFocus
                        value={orgSector} onChange={this.changeHandler}
                    />
                    
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="orgEmail"
                        label="orgEmail"
                        name="orgEmail"
                        // autoFocus
                        value={orgEmail} onChange={this.changeHandler}
                    />
                    
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="password"
                        label="password"
                        name="password"
                        // autoFocus
                        value={password} onChange={this.changeHandler}
                    />

                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="contactPerson"
                        label="contactPerson"
                        name="contactPerson"
                        // autoFocus
                        value={contactPerson} onChange={this.changeHandler}
                    />
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="contactNumber"
                        label="contactNumber"
                        name="contactNumber"
                        // autoFocus
                        value={contactNumber} onChange={this.changeHandler}
                    />
                    {/* <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        color="primary"
                        className=""
                    >
                        Submit
                    </Button> */}

                    <Popup
                        trigger={<Button className="button" type="submit" color="primary"> Submit </Button>}
                        modal
                        nested
                        // style={{position: "absolute", top: "400px", left: "350px"}}
                    >
                        {close => (
                        <div className="modal">
                            <Button className="close" color="primary" onClick={close}>
                                &times;
                            </Button>
                            
                            <div className="content">
                            {' '}
                            <h4>Organisation successfully Added<br/>Send email to Organisation for confirmation</h4>
                            <div className="actions">
                            <button
                                className="button"
                                onClick={() => {
                                console.log('modal closed ');
                                close();
                                window.location.href='AdminOrgs'
                                }}
                            >
                                close
                            </button>
                            </div>
                            </div>
                            
                        </div>
                        )}
                    </Popup>
                    </form>
                </div>
            </Container>
        )
    }
}

// export default withRouter(AddOrg)
export default AddOrg
