import React, { Component } from 'react'
import "../../styles/Organisations.css"
import TextField from "@material-ui/core/TextField";
import Grid from "@material-ui/core/Grid";
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import Select from '@material-ui/core/Select';
import axios from "axios";

const initialState = {
    orgName : "",
    orgNameError: '',
    slogan : "",
    sloganError: '',
    orgDescription : "",
    orgDescriptionError: "",
    orgSector : "",
    orgSectorError: '',
    orgEmail : "",
    orgEmailError : "",
    contactPerson : "",
    contactPersonError : "",
    contactNumber : "",
    contactNumberError: '',
    password : "",
    passwordError: '',
    image: '',
    imageError: '',
    sectorS: []
};

export class AddOrg extends Component {
    state = initialState;

    validated = () => {
        let isErrors = false;

            let orgNameError = '';
            let orgEmailError = "";
            let passwordError = '';
            let sloganError = '';
            let orgSectorError = '';
            let orgDescriptionError = '';
            let contactPersonError = "";
            let contactNumberError = '';
            let imageError = '';

        if(this.state.orgEmail.indexOf('@') === -1){
            // isErrors = true;
            orgEmailError = 'Please enter a valid email address';
        }
        if(this.state.password.length < 4){
            // isErrors = true;
            passwordError = 'Password must be at least 4 characters long';
        }
        if(this.state.orgName.length < 1){
            // isErrors = true;
            orgNameError = 'orgName cannot be blank';
        }
        if(this.state.slogan.length < 1){
            // isErrors = true;
            sloganError = 'slogan cannot be blank';
        }

        if(this.state.orgSector.length < 1){
            // isErrors = true;
            orgSectorError = 'Sector cannot be blank';
        }

        if(this.state.orgDescription.length < 1){
            // isErrors = true;
            orgDescriptionError = 'Description cannot be blank';
        }
        if (!this.state.contactNumber.match(/^[0-9]{10}$/)) {
            // isErrors = true;
            contactNumberError = "Please enter valid mobile number";
        }
        if(this.state.contactPerson.length < 1){
            // isErrors = true;
            contactPersonError = 'Contact person cannot be blank';
        }

        if (orgEmailError || contactPersonError || contactNumberError || orgDescriptionError || orgSectorError || sloganError || orgNameError || passwordError) {
            this.setState({ orgEmailError, contactPersonError,contactNumberError, orgDescriptionError, orgSectorError, sloganError, orgNameError, passwordError});
            return false;
        }

        return true;
    }

    changeHandler = (e) =>{
        this.setState({[e.target.name] : e.target.value})
    }

    componentDidMount(){
        this.getSectorS();
    }

    getSectorS(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        axios.get('http://localhost:8080/v1/organisation/get/sectors',  config)
            .then(response =>{
                // console.log(response)
                this.setState({sectorS: response.data.sectors})
                // console.log(this.state.sectorS)

            })
            .catch(error =>{
                // console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })
    }

    submitHandler = (e) =>{
        e.preventDefault();
        const isValid = this.validated();
        if (isValid) {
            let config = {
                headers: {
                    "Content-Type": "application/json",
                    'Access-Control-Allow-Origin': '*',
                }
            }
            console.log(this.state)
            axios.post('http://localhost:8080/v1/organisation/add/org', this.state, config)
                .then(response =>{
                    console.log(response)
                })
                .catch(error =>{
                    console.log(error)
                })
            this.setState(initialState);
        }
    }

    render() {

        const {orgName, slogan, orgEmail, password, orgSector, contactPerson, contactNumber, orgDescription, sectorS} = this.state

        return (
            <div className="add">
                <div  style={{display: "flex", alignItems: "center", justifyContent: "center", marginTop: "1em", flexGrow: 2, width: "50%"}}>
                    <Card>
                        <CardContent>
                            <form onSubmit={this.submitHandler}>
                                <div>
                                    <Grid>
                                        <TextField
                                            id="outlined-full-width"
                                            label="Organisation Name"
                                            style={{ margin: 8 }}
                                            placeholder="Organisation Name"
                                            fullWidth
                                            margin="normal"
                                            // InputLabelProps={{
                                            //     shrink: true,
                                            // }}
                                            variant="outlined"
                                            name="orgName"
                                            onChange={this.changeHandler}
                                            value={orgName}
                                        />
                                    </Grid>
                                    <span className="error">{this.state.orgNameError}</span>
                                </div>

                                <div>
                                    <Grid>
                                        <TextField
                                            id="outlined-full-width"
                                            label="Slogan"
                                            style={{ margin: 8 }}
                                            placeholder="Slogan"
                                            fullWidth
                                            margin="normal"
                                            // InputLabelProps={{
                                            //     shrink: true,
                                            // }}
                                            variant="outlined"
                                            name="slogan"
                                            onChange={this.changeHandler}
                                            value={slogan}
                                        />

                                    </Grid>
                                    <span className="error">{this.state.sloganError}</span>
                                </div>

                                <div>
                                    <Grid>
                                        <TextField
                                            id="outlined-full-width"
                                            label="Email"
                                            type="email"
                                            style={{ margin: 8 }}
                                            placeholder="Email"
                                            fullWidth
                                            margin="normal"
                                            // InputLabelProps={{
                                            //     shrink: true,
                                            // }}
                                            variant="outlined"
                                            name="orgEmail"
                                            onChange={this.changeHandler}
                                            value={orgEmail}
                                        />

                                    </Grid>
                                    <span className="error">{this.state.orgEmailError}</span>
                                </div>

                                <div>
                                    <Grid>
                                        <TextField
                                            id="outlined-full-width"
                                            label="Password"
                                            type="password"
                                            style={{ margin: 8 }}
                                            placeholder="Password"
                                            fullWidth
                                            margin="normal"
                                            // InputLabelProps={{
                                            //     shrink: true,
                                            // }}
                                            variant="outlined"
                                            name="password"
                                            onChange={this.changeHandler}
                                            value={password}

                                        />

                                    </Grid>
                                    <span className="error">{this.state.passwordError}</span>
                                </div>

                                <div>
                                    <Grid>
                                        <Select
                                            variant="outlined"
                                            native
                                            style={{ margin: 8 }}
                                            label="Sector"
                                            fullWidth
                                            placeholder="Placeholder"
                                            // InputLabelProps={{
                                            //     shrink: true,
                                            // }}
                                            name="orgSector"
                                            onChange={this.changeHandler}
                                            value={orgSector}
                                        >
                                            <option key="kidsNextDoors">Enter Sector</option>
                                            {sectorS.map((item) =>
                                                <option key={item} value={item}>{item}</option>
                                            )}
                                        </Select>

                                    </Grid>
                                    <span className="error">{this.state.orgSectorError}</span>
                                </div>

                                <div>
                                    <Grid>
                                        <TextField
                                            id="outlined-full-width"
                                            label="Contact Person"
                                            type="text"
                                            style={{ margin: 8 }}
                                            placeholder="Contact Person"
                                            fullWidth
                                            margin="normal"
                                            // InputLabelProps={{
                                            //     shrink: true,
                                            // }}
                                            variant="outlined"
                                            name="contactPerson"
                                            onChange={this.changeHandler}
                                            value={contactPerson}
                                        />

                                    </Grid>
                                    <span className="error">{this.state.contactPersonError}</span>
                                </div>

                                <div>
                                    <Grid>
                                        <TextField
                                            id="outlined-full-width"
                                            label="Contact Number"
                                            type="text"
                                            style={{ margin: 8 }}
                                            placeholder="Contact Number"
                                            fullWidth
                                            margin="normal"
                                            // InputLabelProps={{
                                            //     shrink: true,
                                            // }}
                                            variant="outlined"
                                            name="contactNumber"
                                            onChange={this.changeHandler}
                                            value={contactNumber}
                                        />

                                    </Grid>
                                    <span className="error">{this.state.contactNumberError}</span>
                                </div>

                                <div>
                                    <Grid>
                                        <TextField
                                            style={{ margin: 8 }}
                                            placeholder="Description"
                                            fullWidth
                                            multiline
                                            maxRows={4}
                                            margin="normal"
                                            // InputLabelProps={{
                                            //     shrink: true,
                                            // }}
                                            variant="outlined"
                                            id="outlined-textarea"
                                            label="Description"
                                            name="orgDescription"
                                            onChange={this.changeHandler}
                                            value={orgDescription}
                                        />
                                    </Grid>
                                    <span className="error">{this.state.orgDescriptionError}</span>
                                </div>

                                <Grid>
                                    <Button variant="contained" type="submit" className="addBtn">
                                        Submit
                                    </Button>
                                </Grid>
                            </form>
                        </CardContent>
                    </Card>
                </div>

            </div>
        )
    }
}

export default AddOrg
