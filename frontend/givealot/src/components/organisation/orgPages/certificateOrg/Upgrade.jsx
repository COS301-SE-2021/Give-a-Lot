import React from 'react';
import "./certificate.css";
import CancelIcon from '@material-ui/icons/Cancel';
import CheckCircleIcon from '@material-ui/icons/CheckCircle';
import AddAPhotoIcon from '@material-ui/icons/AddAPhoto';
import Button from '@material-ui/core/Button';
import 'date-fns';
import Grid from '@material-ui/core/Grid';
import DateFnsUtils from '@date-io/date-fns';
import { makeStyles } from '@material-ui/core/styles';
import {
    MuiPickersUtilsProvider,
    KeyboardDatePicker,
} from '@material-ui/pickers';


const useStyles = makeStyles((theme) => ({
    root: {
        '& > *': {
            margin: theme.spacing(1),
        },
    },
    input: {
        display: 'none',
    },
}));


export default function  Upgrade() {
    const classes = useStyles();

    const [selectedDate, setSelectedDate] = React.useState(new Date('2021-07-18T21:11:54'));

    const handleDateChange = (date) => {
        setSelectedDate(date);
    };


    return (
            <div className="upgrade">
                <div className="upgrade_heading">
                    <p className="upgrade_level">Current level:</p>
                    <p className="upgrade_status"> Intermediate</p>

                </div>
                <div className="upgrade_container">
               <div className="contain">
                    <form className="upgrade_form">
                        <input
                            name="website"
                            type="text"
                            placeholder="Enter your website url.."
                            className="input1"
                        />
                        <input type="submit" value="Submit" className="submit1"/>
                        <div className="contain_Icon"><CheckCircleIcon className="tick_Icon"/></div>


                    </form>
                   <form className="upgrade_form">
                       <input
                           name="address"
                           type="text"
                           placeholder="Enter your address.."
                           className="input1"
                       />
                       <input type="submit" value="Submit" className="submit1"/>
                       <div className="contain_Icon"><CancelIcon className="cross_Icon"/></div>
                   </form>


                   <div className="date1">
                       <MuiPickersUtilsProvider utils={DateFnsUtils} >
                           <Grid container justifyContent="space-around">

                               <KeyboardDatePicker
                                   margin="normal"
                                   id="date-picker-dialog"
                                   label="Organisation Establishment date"
                                   format="MM/dd/yyyy"
                                   value={selectedDate}
                                   onChange={handleDateChange}
                                   KeyboardButtonProps={{
                                       'aria-label': 'change date',
                                   }}
                               />

                           </Grid>
                       </MuiPickersUtilsProvider>
                       <input type="submit" value="Submit" className="submit2"/>
                       <div className="contain_Icon"><CheckCircleIcon className="tick_Icon"/></div>
                   </div>
                   <div className="upgrade_form">
                       <label className="upgrade_label">Social media section</label>
                   </div>

                   <form className="upgrade_form">
                       <input
                           name="socialMedia1"
                           type="text"
                           placeholder="Enter your social media url"
                           className="input1"
                       />
                       <input type="submit" value="Submit" className="submit1"/>
                       <div className="contain_Icon"><CancelIcon className="cross_Icon"/></div>
                   </form>
                   <form className="upgrade_form">
                       <input
                           name="socialMedia2"
                           type="text"
                           placeholder="Enter your social media url"
                           className="input1"
                       />
                       <input type="submit" value="Submit" className="submit1"/>
                       <div className="contain_Icon"><CancelIcon className="cross_Icon"/></div>
                   </form>


                   <div className="upgrade_form">
                       <label className="upgrade_label">Organisation images section</label>
                   </div>

                   <div className="upgrade_form1">
                       <input
                           accept="image/*"
                           className={classes.input}
                           id="contained-button-file"
                           multiple
                           type="file"
                       />
                       <label htmlFor="contained-button-file">
                           <Button  size="small" variant="contained" color="default" component="span">
                              <AddAPhotoIcon  color="default"/> Choose a file
                           </Button>
                       </label>
                       <input type="submit" value="Submit" className="img_submit"/>
                       <div className="img_Icon"><CancelIcon className="_Icon"/></div>

                   </div>

                   <div className="upgrade_form1">
                       <input
                           accept="image/*"
                           className={classes.input}
                           id="contained-button-file"
                           multiple
                           type="file"
                       />
                       <label htmlFor="contained-button-file">
                           <Button  size="small" variant="contained" color="default" component="span">
                               <AddAPhotoIcon  color="default"/> Choose a file
                           </Button>
                       </label>
                       <input type="submit" value="Submit" className="img_submit"/>
                       <div className="img_Icon"><CancelIcon className="_Icon"/></div>

                   </div>

                   <div className="upgrade_form1">
                       <input
                           accept="image/*"
                           className={classes.input}
                           id="contained-button-file"
                           multiple
                           type="file"
                       />
                       <label htmlFor="contained-button-file">
                           <Button  size="small" variant="contained" color="default" component="span">
                               <AddAPhotoIcon  color="default"/> Choose a file
                           </Button>
                       </label>
                       <input type="submit" value="Submit" className="img_submit"/>
                       <div className="img_Icon"><CancelIcon className="_Icon"/></div>

                   </div>

                   <div className="upgrade_form1">
                       <input
                           accept="image/*"
                           className={classes.input}
                           id="contained-button-file"
                           multiple
                           type="file"
                       />
                       <label htmlFor="contained-button-file">
                           <Button  size="small" variant="contained" color="default" component="span">
                               <AddAPhotoIcon  color="default"/> Choose a file
                           </Button>
                       </label>
                       <input type="submit" value="Submit" className="img_submit"/>
                       <div className="img_Icon"><CancelIcon className="_Icon"/></div>

                   </div>

                   <div className="upgrade_form1">
                       <input
                           accept="image/*"
                           className={classes.input}
                           id="contained-button-file"
                           multiple
                           type="file"
                       />
                       <label htmlFor="contained-button-file">
                           <Button  size="small" variant="contained" color="default" component="span">
                               <AddAPhotoIcon  color="default"/> Choose a file
                           </Button>
                       </label>
                       <input type="submit" value="Submit" className="img_submit"/>
                       <div className="img_Icon"><CancelIcon className="_Icon"/></div>

                   </div>


               </div>





                <div className="contain2">
                    <div className="upgrade_form">
                        <label className="upgrade_label">Donation details section</label>
                    </div>

                    <form className="upgrade_form">
                        <input
                            name="address"
                            type="text"
                            placeholder="Enter your address.."
                            className="input1"
                        />
                        <input type="submit" value="Submit" className="submit1"/>
                        <div className="contain_Icon"><CancelIcon className="cross_Icon"/></div>
                    </form>

                    <form className="upgrade_form">
                        <input
                            name="address"
                            type="text"
                            placeholder="Enter your address.."
                            className="input1"
                        />
                        <input type="submit" value="Submit" className="submit1"/>
                        <div className="contain_Icon"><CancelIcon className="cross_Icon"/></div>
                    </form>
                </div>
            </div>
            </div>
        )

}
