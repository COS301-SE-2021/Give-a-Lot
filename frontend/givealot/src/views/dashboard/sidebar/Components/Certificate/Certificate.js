import React, {Component} from 'react'
import "./Style/Certificate.css";
import {Link} from "react-router-dom";
import Button from '@material-ui/core/Button';
import { withStyles } from '@material-ui/core/styles';
import ArrowUpwardIcon from '@material-ui/icons/ArrowUpward';
import SaveIcon from '@material-ui/icons/Save';
import pic from "./Style/cert5Complete.png"
import DashHeader from "../../DashHeader/DashHeader";
import axios from "axios";


const styles = theme => ({
    button: {
        margin: theme.spacing(4),

    },

});

export class Certificate extends Component {

    constructor (props) {
        super(props)
        this.state={
            level: 3,
            orgId:localStorage.getItem("id"),
        };
    }
    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        const dataa = {
            "orgId" : this.state.orgId
        }

        axios.post('http://localhost:8080/v1/organisation/get/org_level', dataa  ,config)
            .then(response =>{
               // this.setState({level: response.data.level})
                console.log(response)




            })
            .catch(error =>{
                console.log(error)
            })
    }

    render(){
    const { classes } = this.props;

        let upgrade
        if (this.state.level===0){
            upgrade= <Link to="/upgrade0" className="certLink"  >
                <Button
                    variant="contained"
                    color="secondary"
                    style={{backgroundColor: " #957b9e"}}
                    size="large"
                    className={classes.button}
                    startIcon={<ArrowUpwardIcon style={{backgroundColor: " #957b9e"}}/>}
                >
                    Upgrade
                </Button>
            </Link>
        }else if (this.state.level===1) {
            upgrade = <Link to="/upgrade1" className="certLink">
                <Button
                    variant="contained"
                    color="secondary"
                    style={{backgroundColor: " #957b9e"}}
                    size="large"
                    className={classes.button}
                    startIcon={<ArrowUpwardIcon style={{backgroundColor: " #957b9e"}}/>}
                >
                    Upgrade
                </Button>
            </Link>
        }else if (this.state.level===2) {
            upgrade = <Link to="/upgrade2" className="certLink">
                <Button
                    variant="contained"
                    color="secondary"
                    style={{backgroundColor: " #957b9e"}}
                    size="large"
                    className={classes.button}
                    startIcon={<ArrowUpwardIcon style={{backgroundColor: " #957b9e"}}/>}
                >
                    Upgrade
                </Button>
            </Link>
        }else if (this.state.level===3) {
            upgrade = <Link to="/upgrade3" className="certLink">
                <Button
                    variant="contained"
                    color="secondary"
                    style={{backgroundColor: " #957b9e"}}
                    size="large"
                    className={classes.button}
                    startIcon={<ArrowUpwardIcon style={{backgroundColor: " #957b9e"}}/>}
                >
                    Upgrade
                </Button>
            </Link>
        }else if (this.state.level===4) {
            upgrade = <Link to="/upgrade4" className="certLink">
                <Button
                    variant="contained"
                    color="secondary"
                    style={{backgroundColor: " #957b9e"}}
                    size="large"
                    className={classes.button}
                    startIcon={<ArrowUpwardIcon style={{backgroundColor: " #957b9e"}}/>}
                >
                    Upgrade
                </Button>
            </Link>
        } else if (this.state.level===5) {
            upgrade = <Link to="/upgrade5" className="certLink">
                <Button
                    variant="contained"
                    color="secondary"
                    style={{backgroundColor: " #957b9e"}}
                    size="large"
                    className={classes.button}
                    startIcon={<ArrowUpwardIcon style={{backgroundColor: " #957b9e"}}/>}
                >
                    Upgrade
                </Button>
            </Link>
        }

    return (
        <div className="certificate">


            <div className="view">
                {upgrade}

                     <Button
                        variant="outlined"
                        size="large"
                        style={{border: '3px solid', borderColor: "#957b9e", color: " #957b9e"}}

                        className={classes.button}
                        startIcon={<SaveIcon />}
                        onClick={(e) => {
                            e.preventDefault();
                            window.open('http://localhost:8080/cert/version/pdf/' + this.state.orgId);
                        }}
                    >
                        Download

                    </Button>


            </div>

            <div className="display">
                <img src={"http://localhost:8080/cert/version/png/" + this.state.orgId} height={566} width={733}/>
            </div>
        </div>
    );
    }
}
export default withStyles(styles)(Certificate);