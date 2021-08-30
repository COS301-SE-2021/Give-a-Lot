import React, { Component } from 'react'
import "../../styles/Organisations.css"
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Grid from "@material-ui/core/Grid";
import Card from '@material-ui/core/Card';

export class AddOrg extends Component {

    render() {
        return (
            <div className="organisations">
                <Card className="form">
                    {/*<div className="form">*/}
                        {/*<form noValidate autoComplete="off">*/}
                        <span className="AddHeader">
                               Add Organisation
                        </span>

                        {/*</form>*/}
                        <form noValidate className="form">
                            <Grid container spacing={24}>
                                {/*<Grid item xs={4}>*/}
                                <TextField
                                    variant="outlined"
                                    margin="normal"
                                    required
                                    fullWidth
                                    id="orgName"
                                    label="Organisation Name"
                                    name="orgName"
                                    // autoComplete="orgName"
                                    autoFocus

                                />
                                <TextField
                                    variant="outlined"
                                    margin="normal"
                                    required
                                    fullWidth
                                    name="slogan"
                                    label="Slogan"
                                    type="slogan"
                                    id="slogan"
                                    // autoComplete="current-password"
                                />
                                {/*</Grid>*/}
                                <TextField
                                    variant="outlined"
                                    margin="normal"
                                    required
                                    fullWidth
                                    id="orgDescription"
                                    label="Description"
                                    name="orgDescription"
                                    // autoComplete="email"
                                    autoFocus
                                    multiline
                                    rows={4}
                                />
                                <Grid item xs={4} spacing={4}>
                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="email"
                                        label="Email Address"
                                        name="email"
                                        // autoComplete="email"
                                        autoFocus
                                    />
                                </Grid>
                                <Grid item xs={2}>

                                </Grid>
                                <Grid item xs={4} spacing={4}>
                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        name="password"
                                        label="Password"
                                        type="password"
                                        id="password"
                                        // autoComplete="current-password"
                                    />
                                </Grid>

                                {/*<Grid item xs={4}>*/}
                                <TextField
                                    variant="outlined"
                                    margin="normal"
                                    required
                                    fullWidth
                                    id="contactPerson"
                                    label="Contact Person"
                                    name="contactPerson"
                                    // autoComplete="contactPerson"
                                    autoFocus
                                />
                                {/*</Grid>*/}

                                <Grid item xs={4}>
                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="contactNumber"
                                        label="Contact Number"
                                        name="contactNumber"
                                        // autoComplete="email"
                                        autoFocus
                                    />
                                </Grid>
                                <Grid item xs={2}>

                                </Grid>
                                <Grid item xs={4}>
                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="orgSector"
                                        label="Sector"
                                        name="orgSector"
                                        // autoComplete="email"
                                        autoFocus
                                    />
                                </Grid>

                            </Grid>

                            <Button type="submit"
                                    fullWidth variant="contained"
                                // color="#957b9e"
                                    className="addBtn"
                            >
                                Add Organisation

                            </Button>
                        </form>
                    {/*</div>*/}
                </Card>

            </div>
        )
    }
}

export default AddOrg
