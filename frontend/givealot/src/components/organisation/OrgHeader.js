import React, { Component } from 'react'
import "./Organisation.css"
import PrintIcon from '@material-ui/icons/Print';
import SettingsIcon from '@material-ui/icons/Settings';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import {toast} from "react-toastify";
import {makeStyles} from "@material-ui/core/styles";
import Slide from "@material-ui/core/Slide";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import FormControl from "@material-ui/core/FormControl";
import FormLabel from "@material-ui/core/FormLabel";
import FormGroup from "@material-ui/core/FormGroup";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Switch from "@material-ui/core/Switch";
import {Link} from "react-router-dom";
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import LockIcon from "@material-ui/icons/Lock";
import ListItemText from "@material-ui/core/ListItemText";
import FormHelperText from "@material-ui/core/FormHelperText";
import Divider from "@material-ui/core/Divider";
import CardActions from "@material-ui/core/CardActions";


toast.configure()
const useStyles = makeStyles({
    root: {
        minWidth: 275,
    },
    bullet: {
        display: 'inline-block',
        margin: '0 2px',
        transform: 'scale(0.8)',
    },
    title: {
        fontSize: 14,
    },
    pos: {
        marginBottom: 12,
    },
});

const Transition = React.forwardRef(function Transition(props, ref) {
    return <Slide direction="up" ref={ref} {...props} />;
});
export default function OrgHeader()  {


    const classes = useStyles();
    const [state, setState] = React.useState({
        enableDonation: true,
        darkMode: false,
        shareLocation: true,
        deactivate: false,
    });

    const handleChange = (event) => {
        setState({ ...state, [event.target.name]: event.target.checked });
    };

    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const notify=() => {
        toast.success('Changes successfully saved!',
            {position: toast.POSITION.TOP_CENTER,
                autoClose:3000
            })
    }

    const [openDialog, setOpenDialog] = React.useState(false);

    const handlerClick = () => {
        setOpenDialog(true);
    };

    const handlerClose = () => {
        setOpenDialog(false);
    };



    return (
            <div>
                <div className="headerOrg">
                    {/*<div>*/}
                    {/*    <img src={logo} alt="" className="imageAdmin"/>*/}
                    {/*</div>
                    <div className="generate-pdf">
                        <PrintIcon />
                        <h6>Generate pdf</h6>
                    </div>*/}

                    <div className="printer">
                        <PrintIcon />
                    </div>
                    <div className="setting">
                        <SettingsIcon onClick={handlerClick}/>
                        <Dialog open={openDialog} onClose={handlerClose} aria-labelledby="form-dialog-title">
                            

                                    <Card className={classes.root} variant="outlined" >
                                        <CardContent>

                                            <FormControl component="fieldset">
                                                <FormLabel component="legend">Update your settings</FormLabel>
                                                <FormGroup>
                                                    <FormControlLabel
                                                        control={<Switch checked={state.enableDonation} onChange={handleChange} name="enableDonation" />}
                                                        label="Enable Donations"
                                                    />
                                                    <FormControlLabel
                                                        control={<Switch checked={state.darkMode} onChange={handleChange} name="darkMode" />}
                                                        label="Dark Mode"
                                                    />
                                                    <FormControlLabel
                                                        control={<Switch checked={state.shareLocation} onChange={handleChange} name="shareLocation" />}
                                                        label="Share Location"
                                                    />

                                                    <FormControlLabel
                                                        control={<Switch checked={state.deactivate} onChange={handleChange} name="deactivate" />}
                                                        label="Deactivate account"
                                                    />


                                                    <Link to={'/login'} className='text-linkOrg1'>
                                                        <ListItem button>
                                                            <ListItemIcon>
                                                                <LockIcon className="iconOrg1"/>
                                                            </ListItemIcon>
                                                            <ListItemText primary="Change password" />
                                                        </ListItem>
                                                    </Link>

                                                </FormGroup>
                                                <FormHelperText>Be careful</FormHelperText>
                                            </FormControl>

                                        </CardContent>
                                        <Divider />
                                        <Divider />
                                        <CardActions>
                                            <button size="extra-small" className="Dbutton" onClick={handleClickOpen}>
                                                Delete account
                                            </button>
                                            <button size="small" onClick={notify} className="Sbutton" >
                                                Save changes
                                            </button>
                                        </CardActions>
                                    </Card>
                                    <Dialog
                                        open={open}
                                        TransitionComponent={Transition}
                                        keepMounted
                                        onClose={handleClose}
                                        aria-labelledby="alert-dialog-slide-title"
                                        aria-describedby="alert-dialog-slide-description"
                                    >
                                        <DialogTitle id="alert-dialog-slide-title">{"Are you sure you want to delete your Account?"}</DialogTitle>
                                        <DialogContent>
                                            <DialogContentText id="alert-dialog-slide-description">
                                                Alternatively you can Deactivate your account and activate it at anytime you want.
                                            </DialogContentText>
                                        </DialogContent>
                                        <DialogActions>
                                            <Button onClick={handleClose} color="primary">
                                                Cancel
                                            </Button>
                                            <Button onClick={handleClose} color="primary">
                                                Confirm
                                            </Button>
                                        </DialogActions>
                                    </Dialog>




                        </Dialog>

                    </div>
                </div>
            </div>
        )

}

