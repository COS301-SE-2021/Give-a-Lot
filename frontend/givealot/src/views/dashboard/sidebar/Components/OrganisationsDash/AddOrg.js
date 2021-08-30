import React, { Component } from 'react'
import "../../styles/Organisations.css"
import TextField from "@material-ui/core/TextField";
import Grid from "@material-ui/core/Grid";
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import Select from '@material-ui/core/Select';
import InputLabel from '@material-ui/core/InputLabel';

export class AddOrg extends Component {

    render() {
        return (
            <div className="organisations">
                <div  style={{display: "flex", alignItems: "center", justifyContent: "center", marginTop: "1em"}}>
                    <Card style={{width: "50%"}}>
                        <CardContent>
                            <Typography style={{margin: "1em", color: "#957b9e"}}>
                                Organisation Name
                            </Typography>
                            <form>
                                <Grid>
                                    <TextField
                                        id="outlined-full-width"
                                        label="Label"
                                        style={{ margin: 8 }}
                                        placeholder="Placeholder"
                                        fullWidth
                                        margin="normal"
                                        InputLabelProps={{
                                            shrink: true,
                                        }}
                                        variant="outlined"
                                    />
                                </Grid>
                                <Grid>
                                    <TextField
                                        id="outlined-full-width"
                                        label="Label"
                                        style={{ margin: 8 }}
                                        placeholder="Placeholder"
                                        fullWidth
                                        margin="normal"
                                        InputLabelProps={{
                                            shrink: true,
                                        }}
                                        variant="outlined"
                                    />
                                </Grid>
                                <Grid>
                                    <TextField
                                        id="outlined-full-width"
                                        label="Label"
                                        style={{ margin: 8 }}
                                        placeholder="Placeholder"
                                        fullWidth
                                        margin="normal"
                                        InputLabelProps={{
                                            shrink: true,
                                        }}
                                        variant="outlined"
                                    />
                                </Grid>
                                <Grid>
                                    <TextField
                                        id="outlined-full-width"
                                        label="Label"
                                        style={{ margin: 8 }}
                                        placeholder="Placeholder"
                                        fullWidth
                                        margin="normal"
                                        InputLabelProps={{
                                            shrink: true,
                                        }}
                                        variant="outlined"
                                    />
                                </Grid>
                                <Grid>
                                    {/*<InputLabel htmlFor="outlined-age-native-simple">Sector</InputLabel>*/}
                                    <Select
                                        // htmlFor="outlined-age-native-simple"
                                        variant="outlined"
                                        native
                                        style={{ margin: 8 }}
                                        // value={state.age}
                                        // onChange={handleChange}
                                        label="Age"
                                        fullWidth
                                        placeholder="Placeholder"
                                        InputLabelProps={{
                                            shrink: true,
                                        }}
                                    >
                                        <option aria-label="None" value="" />
                                        <option value={10}>Ten</option>
                                        <option value={20}>Twenty</option>
                                        <option value={30}>Thirty</option>
                                    </Select>
                                </Grid>
                                <Grid>
                                    <TextField
                                        style={{ margin: 8 }}
                                        placeholder="Description"
                                        fullWidth
                                        multiline
                                        maxRows={4}
                                        margin="normal"
                                        InputLabelProps={{
                                            shrink: true,
                                        }}
                                        variant="outlined"

                                        id="outlined-textarea"
                                        label="Multiline Placeholder"
                                    />
                                </Grid>
                                <Grid>
                                    <Button variant="contained" className="addBtn">
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
