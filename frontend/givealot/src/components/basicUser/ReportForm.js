import React from 'react';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import {makeStyles} from "@material-ui/core/styles";
import MenuItem from "@material-ui/core/MenuItem";




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

const currencies = [
    {
        value: 'USD',
        label: 'Incorect Profile Information',
    },
    {
        value: 'EUR',
        label: 'Suspicious Behavior',
    },
    {
        value: 'BTC',
        label: 'Fraud Activity',
    },
    {
        value: 'JPY',
        label: 'Other stuff',
    },
];


export default function ReportForm() {
    const classes = useStyles();
    return (
        <React.Fragment>

            <Grid container spacing={3}>
                <Grid item xs={12} sm={6}>
                    <TextField
                        required
                        id="Name"
                        name="Name"
                        label="Organisation name"
                        fullWidth
                        autoComplete="given-name"
                    />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField
                        required
                        id="department"
                        name="department"
                        label="Department"
                        fullWidth
                        autoComplete="department"
                    />
                </Grid>

                <Grid item xs={12}>

                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField
                        id="time"
                        label="Time"
                        type="time"
                        defaultValue="07:30"
                        fullWidth

                        InputLabelProps={{
                            shrink: true,
                        }}
                        inputProps={{
                            step: 300, // 5 min
                        }}
                    />
                </Grid>
                <Grid item xs={12} sm={6}>
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
                    />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField
                        id="type"
                        select
                        label="Type"
                        fullWidth
                        helperText="Please select report Type"
                    >
                        {currencies.map((option) => (
                            <MenuItem key={option.value} value={option.value}>
                                {option.label}
                            </MenuItem>
                        ))}
                    </TextField>
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField
                        required
                        id="country"
                        name="country"
                        label="Country"
                        fullWidth
                        autoComplete="shipping country"
                    />
                </Grid>
                <Grid item xs={12} >
                    <TextField
                        id="outlined-multiline-static"
                        label="Description"
                        multiline
                        rows={8}
                        fullWidth
                        
                        variant="outlined"
                    />
                </Grid>
                <Grid item xs={12}>
                    <TextField

                        id="Follow"
                        name="Follow"
                        label="Follow Up Recommendations"
                        fullWidth
                        autoComplete="Follow "
                    />
                </Grid>
                <Grid item xs={12}>
                    <Button
                        variant="contained"
                        color="primary"
                       // onClick={handleNext}
                        className={classes.button}
                    >
                        Report
                    </Button>
                </Grid>
            </Grid>
        </React.Fragment>
    );
}
