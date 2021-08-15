import React, { Component } from 'react';
import "./certificate.css";
import CancelIcon from '@material-ui/icons/Cancel';
import CheckCircleIcon from '@material-ui/icons/CheckCircle';
import Button from '@material-ui/core/Button';
import 'date-fns';
import Grid from '@material-ui/core/Grid';
import DateFnsUtils from '@date-io/date-fns';
import {
    MuiPickersUtilsProvider,
    KeyboardDatePicker,
} from '@material-ui/pickers';




export default function  Upgrade() {

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
               <div className="contain">
                    <form className="upgrade_form">
                        <input
                            name="website"
                            type="text"
                            placeholder="Enter your website url.."
                            className="input1"
                        />
                        <input type="submit" value="Submit" className="submit1"/>
                        <div className="contain_Icon"><CheckCircleIcon className="cross_Icon"/></div>


                    </form>
                   <form className="upgrade_form">
                       <input
                           name="address"
                           type="text"
                           placeholder="Enter your address.."
                           className="input1"
                       />
                       <input type="submit" value="Submit" className="submit1"/>
                       <div className="contain_Icon"><CancelIcon className="tick_Icon"/></div>


                   </form>
                   <div className="date1">
                       <MuiPickersUtilsProvider utils={DateFnsUtils} >
                           <Grid container justifyContent="space-around">

                               <KeyboardDatePicker
                                   margin="normal"
                                   id="date-picker-dialog"
                                   label="Date picker dialog"
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
                       <div className="contain_Icon"><CancelIcon className="tick_Icon"/></div>
                   </div>


               </div>

            </div>
        )

}
