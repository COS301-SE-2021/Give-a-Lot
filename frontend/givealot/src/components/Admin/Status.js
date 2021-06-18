// import React from 'react';
// import { makeStyles } from '@material-ui/core/styles';
// import InputLabel from '@material-ui/core/InputLabel';
// import MenuItem from '@material-ui/core/MenuItem';
// import FormHelperText from '@material-ui/core/FormHelperText';
// import FormControl from '@material-ui/core/FormControl';
// import Select from '@material-ui/core/Select';

// const useStyles = makeStyles((theme) => ({
//     formControl: {
//         margin: theme.spacing(1),
//         minWidth: 100,

//     },
//     selectEmpty: {
//         marginTop: theme.spacing(2),

//     },
// }));

// export default function Status() {
//     const classes = useStyles();
//     const [status, setStatus] = React.useState('');

//     const handleChange = (event) => {
//         setStatus(event.target.value);
//     };

//     return (
//         <div>

//             <FormControl variant="outlined" className={classes.formControl}>
//                 <InputLabel id="label">Active</InputLabel>
//                 <Select
//                     labelId="label"
//                     id="id"
//                     value={status}
//                     onChange={handleChange}
//                     label="Status"
//                 >
//                     <MenuItem value="">
//                         <em>None</em>
//                     </MenuItem>
//                     <MenuItem value={10}>Active</MenuItem>
//                     <MenuItem value={20}>Suspend</MenuItem>
//                     <MenuItem value={30}>UnderInvestigation</MenuItem>
//                 </Select>
//             </FormControl>

//         </div>
//     );
// }

import React, { Component } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import FormHelperText from '@material-ui/core/FormHelperText';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';

export class Status extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
            status: "",
            setStatus: "",
        }
    }
    handleChange = (e) => {
        this.setState({[e.target.name] : e.target.value})
    };

    render() {
    const { status, setStatus} = this.state
        return (
            <div>
                <FormControl variant="outlined" className="formControl">
                 <InputLabel id="label">Active</InputLabel>
                 <Select
                    labelId="label"
                    id="id"
                    value={status}
                    onChange={this.handleChange}
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
        )
    }
}

export default Status
