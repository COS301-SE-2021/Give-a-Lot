import React, {Component} from 'react';
import "../Certificate/Style/Certificate.css";
import 'date-fns';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";
import { withStyles} from '@material-ui/core/styles'
import {toast, ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import 'react-datepicker/dist/react-datepicker.css';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Axios from "axios";
import TextField from "@material-ui/core/TextField";
import axios from "axios";
import {ApiContext} from "../../../../../apiContext/ApiContext";

const styles = theme => ({

    root: {
        display: "flex",
        flexWrap: "wrap",
        '& .MuiOutlinedInput-root': {
            '& fieldset': {
                borderColor: '#957b9e',
                borderWidth: 2
            },
        },
    },
    textField: {
        marginLeft: theme.spacing(1),
        marginRight: theme.spacing(1),
        width: "30ch"
    },

});


const initialState = {
    level0:{},
    //orgId: 60,
    orgId:localStorage.getItem("id"),
    startDate: new Date(),
    ngoNumber:"",
    ngoNumberState:false,
    ngoDate:"",
    ngoDateState:false,
    logoState:false,
    logo:"",
    serverDomain : this.context,

};


export class Level0 extends Component {


    static contextType = ApiContext;
    state = initialState;
    constructor (props) {
        super(props)

        this.handleDateChange = this.handleDateChange.bind(this);
    }

    handleDateChange(date) {
        this.setState({startDate: date, ngoDate:document.getElementsByClassName("input3")[0].value, ngoDateState: true} )

    }

    handleNumber =event=>{
        this.setState({ngoNumberState: true})
        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    }


    handleChange = event => {

        this.setState({logoState: true})
        const formData = new FormData();
        formData.append('image', event.target.files[0]);
        formData.append('orgId', this.state.orgId);
        let imageStates = 0;

        alert("Do not submit yet");

        fetch(
            this.state.serverDomain + '/v1/organisation/add/logo',
            {
                method: 'POST',
                body: formData,
            }
        )
            .then((response) => response.json())
            .then((result) => {
                console.log('Success:', result);
                imageStates = 1;

            })
            .catch((error) => {
                console.error('Error:', error);
                imageStates = 2;
            });

        if(imageStates===1)
            alert("You can not submit");
        else if(imageStates === 2)
            alert("Image didnt submit");

        const isCheckbox = event.target.type === "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    };

    handleFormSubmit = e => {
        e.preventDefault();


            const data = {
                orgId: this.state.orgId,
                ngoDate: this.state.ngoDate,
                ngoNumber: this.state.ngoNumber,

            };

            console.log(data)
            Axios
                .post(this.state.serverDomain + "/v1/organisation/add/ngopdate", data)
                .then(res => console.log(res))
                .catch(err => console.log(err));


    };
    onToast0 = () => {
        if ( this.state.logoState || this.state.ngoDateState || this.state.ngoNumberState ) {
            toast.success('Submit successful', {
                position: toast.POSITION.TOP_RIGHT

            });
        }
    }


    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        console.log(this.props)
        axios.get(this.state.serverDomain + '/v1/organisation/sel/organisation/'+this.state.orgId+'/default', config) //Change the API
            .then(response =>{
                console.log(response)
                this.setState({level0: response.data.response})
            })
            .catch(error =>{
                console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })

    }


    render(){
        const { classes } = this.props;
        const { level0 } = this.state;


        return (
            <div className="upgrade">

                <Card className="upgrade_card11" variant="outlined">
                    <CardContent>
                        <div className={classes.root}>
                            <form onSubmit={this.handleFormSubmit}>
                                <span className="upgrade_header1">
                                    Additional credentials needed to Upgrade
                                 </span>
                                <div>

                                    <div >
                                        <span className="upgrade_label">
                                            Registration date
                                         </span>
                                        <DatePicker

                                            className="upgrade_datee input3"
                                            selected={this.state.startDate}
                                            onChange={ this.handleDateChange }
                                            name="startDate"
                                            dateFormat="yyyy/MM/dd"
                                            fullWidth

                                        />
                                    </div>
                                    <TextField
                                        id="outlined-full-width"
                                        label="Registration number"
                                        name="ngoNumber"
                                        style={{ margin: 8 }}
                                        placeholder={level0.dateAdded}
                                        fullWidth
                                        margin="normal"
                                        InputLabelProps={{
                                            shrink: true,
                                        }}
                                        variant="outlined"
                                        onChange={this.handleNumber}
                                    />
                                    <div>
                                        <span className="upgrade_label_logo">
                                            Logo
                                         </span>
                                        <input
                                            className="upgrade_logoo"
                                            type="file"
                                            name="file"
                                            onChange={this.handleInputChange}
                                        />
                                    </div>

                                    <div className="profile_files">
                                        <img src="https://st.depositphotos.com/1428083/2946/i/600/depositphotos_29460297-stock-photo-bird-cage.jpg" alt={"logoPicture"} height={70} width={70} />
                                    </div>

                                </div>
                                <div className="upgrade_Button">
                                    <button className="upgrade-btnn" type="submit" onClick={this.onToast0}>
                                        Submit
                                    </button>
                                </div>
                                <div className="form-group">
                                    <ToastContainer/>
                                </div>

                            </form>
                        </div>

                    </CardContent>

                </Card>


            </div>
        );
    }
}
export default withStyles(styles)(Level0);