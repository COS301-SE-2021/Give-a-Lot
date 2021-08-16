import React, {Component} from 'react';
import "./certificate.css";
import CancelIcon from '@material-ui/icons/Cancel';
import CheckCircleIcon from '@material-ui/icons/CheckCircle';
import AddAPhotoIcon from '@material-ui/icons/AddAPhoto';
import Button from '@material-ui/core/Button';
import 'date-fns';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";
import { withStyles } from '@material-ui/core/styles'
import {toast} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css'

toast.configure()
const useStyles = theme => ({
    root: {
        '& > *': {
            margin: theme.spacing(1),
        },
    },
    input: {
        display: 'none',
    },
});

export class Upgrade extends Component {

    constructor (props) {
        super(props)
        this.state = {
            startDate: new Date(),

            status1: true,
            status2: true,
            status3: false,
            status4: false,
            status5: false,
            status6: false,
            status7: true,
            status8: true,
            status9: false,
            status10: true,
            status11: false,
            status12: false,
        };
        this.handleChange = this.handleChange.bind(this);
        this.onFormSubmit = this.onFormSubmit.bind(this);

    }

    handleChange(date) {
        this.setState({
            startDate: date
        })
    }

    onFormSubmit(e) {
        e.preventDefault();
        console.log(this.state.startDate)
    }

    onSubmit = () => {
        toast.success('upload success')

    }

render(){
    const { classes } = this.props;



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
                        <input type="submit" value="Submit" className="submit1" onSubmit={this.onSubmit}/>
                        {
                            !this.state.status1
                                ? <div className="contain_Icon"><CancelIcon className="cross_Icon"/></div>
                                : <div className="contain_Icon"><CheckCircleIcon className="tick_Icon"/></div>
                        }



                    </form>
                   <form className="upgrade_form">
                       <input
                           name="address"
                           type="text"
                           placeholder="Enter your address.."
                           className="input1"
                       />

                       <input type="submit" value="Submit" className="submit1"/>
                       {
                           !this.state.status2
                               ? <div className="contain_Icon"><CancelIcon className="cross_Icon"/></div>
                               : <div className="contain_Icon"><CheckCircleIcon className="tick_Icon"/></div>
                       }

                   </form>

                   <div className="upgrade_form">
                       <label className="upgrade_sublabel">Enter Establishment date</label>
                   </div>

                      <div className="upgrade_form">
                       <form onSubmit={ this.onFormSubmit }>
                           <div >
                               <DatePicker
                                   selected={ this.state.startDate }
                                   onChange={ this.handleChange }
                                   name="startDate"
                                   dateFormat="MM/dd/yyyy"
                                   className="input1"
                               />

                           </div>

                       </form>
                          <input type="submit" value="Submit" className="submit1"/>
                          {
                              !this.state.status3
                                  ? <div className="contain_Icon"><CancelIcon className="cross_Icon"/></div>
                                  : <div className="contain_Icon"><CheckCircleIcon className="tick_Icon"/></div>
                          }

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
                       {
                           !this.state.status4
                               ? <div className="contain_Icon"><CancelIcon className="cross_Icon"/></div>
                               : <div className="contain_Icon"><CheckCircleIcon className="tick_Icon"/></div>
                       }

                   </form>
                   <form className="upgrade_form">
                       <input
                           name="socialMedia2"
                           type="text"
                           placeholder="Enter your social media url"
                           className="input1"
                       />
                       <input type="submit" value="Submit" className="submit1"/>
                       {
                           !this.state.status5
                               ? <div className="contain_Icon"><CancelIcon className="cross_Icon"/></div>
                               : <div className="contain_Icon"><CheckCircleIcon className="tick_Icon"/></div>
                       }

                   </form>


                   <div className="upgrade_form">
                       <label className="upgrade_label">Organisation images section</label>
                   </div>
                   <div className="upgrade_form">
                       <label className="upgrade_sublabel">Upload up to 10 images, each image has 1 point</label>
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
                       <input type="submit" value="Upload" className="img_submit"/>
                       {
                           !this.state.status7
                               ? <div className="img_Icon"><CancelIcon className="_cross_Icon"/></div>
                               : <div className="img_Icon"><CheckCircleIcon className="_tick_Icon"/></div>
                       }


                   </div>

               </div>





                <div className="contain2">

                    <form className="upgrade_form">
                        <input
                            name="tax"
                            type="text"
                            placeholder="Enter your Tax reference number"
                            className="input1"
                        />
                        <input type="submit" value="Submit" className="submit1"/>

                        {
                            !this.state.status8
                                ? <div className="contain_Icon"><CancelIcon className="cross_Icon"/></div>
                                : <div className="contain_Icon"><CheckCircleIcon className="tick_Icon"/></div>
                        }
                    </form>

                    <form className="upgrade_form">
                        <input
                            name="registered_no"
                            type="text"
                            placeholder="Enter your registered NGO number"
                            className="input1"
                        />
                        <input type="submit" value="Submit" className="submit1"/>
                        {
                            !this.state.status8
                                ? <div className="contain_Icon"><CancelIcon className="cross_Icon"/></div>
                                : <div className="contain_Icon"><CheckCircleIcon className="tick_Icon"/></div>
                        }
                    </form>

                    <div className="upgrade_form">
                        <label className="upgrade_sublabel">Date the NGO was registered</label>
                    </div>

                    <div className="upgrade_form">
                        <form onSubmit={ this.onFormSubmit }>
                            <div >
                                <DatePicker
                                    selected={ this.state.startDate }
                                    onChange={ this.handleChange }
                                    name="startDate"
                                    dateFormat="MM/dd/yyyy"
                                    className="input1"
                                />

                            </div>

                        </form>
                        <input type="submit" value="Submit" className="submit1"/>
                        {
                            !this.state.status9
                                ? <div className="contain_Icon"><CancelIcon className="cross_Icon"/></div>
                                : <div className="contain_Icon"><CheckCircleIcon className="tick_Icon"/></div>
                        }
                    </div>


                    <div className="upgrade_form">
                        <label className="upgrade_label">Organisation Auditing section</label>
                    </div>

                    <div className="upgrade_form">
                        <label className="upgrade_sublabel">Upload your Audit document</label>
                    </div>

                    <form className="upgrade_form">

                        <input type="file" name="file"  className="form_file"/>
                        <input type="submit" value="Upload" className="file_submit"/>
                        {
                            !this.state.status10
                                ? <div className="file_Icon"><CancelIcon className="f_cross_Icon"/></div>
                                : <div className="file_Icon"><CheckCircleIcon className="f_tick_Icon"/></div>
                        }
                    </form>



                    <div className="upgrade_form">
                        <label className="upgrade_sublabel">Upload the Auditors certificate</label>
                    </div>

                    <form className="upgrade_form">

                        <input type="file" name="file"  className="form_file"/>
                        <input type="submit" value="Upload" className="file_submit"/>
                        {
                            !this.state.status11
                                ? <div className="file_Icon"><CancelIcon className="f_cross_Icon"/></div>
                                : <div className="file_Icon"><CheckCircleIcon className="f_tick_Icon"/></div>
                        }
                    </form>


                    <div className="upgrade_form">
                        <label className="upgrade_label">Organisation Donation section</label>
                    </div>

                    <div className="upgrade_form">
                        <label className="upgrade_sublabel">Upload your donation certificate</label>
                    </div>

                    <form className="upgrade_form">

                        <input type="file" name="file"  className="form_file"/>
                        <input type="submit" value="Upload" className="file_submit"/>
                        {
                            !this.state.status12
                                ? <div className="file_Icon"><CancelIcon className="f_cross_Icon"/></div>
                                : <div className="file_Icon"><CheckCircleIcon className="f_tick_Icon"/></div>
                        }
                    </form>



                </div>
            </div>
            </div>
        )
    }
}

export default withStyles(useStyles)(Upgrade)
