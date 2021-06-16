
import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import MenuItem from '@material-ui/core/MenuItem';
import Button from '@material-ui/core/Button';

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

const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
      width: '50%',
    },
  },
}));

export default function OrganisationReport() {
  const classes = useStyles();

  return (

    <div>
        <h4>Report Organisation</h4>
        <form className={classes.root} noValidate autoComplete="off">
            <TextField id="outlined-basic" label="Name" variant="outlined" />
            {/* <div className="dateAndTime"> */}
            <TextField
                id="date"
                label="Date"
                type="date"
                defaultValue="2017-05-24"
                className={classes.textField}
                InputLabelProps={{
                shrink: true,
                }}
            />
            <TextField
                id="time"
                label="Time"
                type="time"
                defaultValue="07:30"
                className={classes.textField}
                InputLabelProps={{
                shrink: true,
                }}
                inputProps={{
                step: 300, // 5 min
                }}
            />
            {/* </div> */}
            <TextField
                id="outlined-multiline-static"
                label="Description"
                multiline
                rows={8}
                // defaultValue="Default Value"
                variant="outlined"
            />

            <TextField
                id="standard-select-currency"
                select
                label="Type"
                // value={currency}
                // onChange={handleChange}
                helperText="Please select report Type"
                >
                {currencies.map((option) => (
                    <MenuItem key={option.value} value={option.value}>
                    {option.label}
                    </MenuItem>
                ))}
            </TextField>
            <TextField
                id="outlined-multiline-static"
                label="Follow up Recommendations"
                multiline
                rows={8}
                // defaultValue="Default Value"
                variant="outlined"
            />

            <Button variant="contained">Submit</Button>
        </form>
    </div>
    
  );
}
