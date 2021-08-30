import React, {Component} from 'react'
import "./Style/Certificate.css";
import {Link} from "react-router-dom";
import Button from '@material-ui/core/Button';
import { withStyles } from '@material-ui/core/styles';
import DeleteIcon from '@material-ui/icons/Delete';
import SaveIcon from '@material-ui/icons/Save';


const styles = theme => ({
    button: {
        margin: theme.spacing(1),
    },
});

export class Certificate extends Component {

    constructor (props) {
        super(props)
        this.state={
            level: 2,

        };
    }


    render(){
    const { classes } = this.props;

        let upgrade
        if (this.state.level===0){
            upgrade= <Link to="/upgrade" className="certLink"  >
                <Button
                    variant="contained"
                    color="secondary"
                    size="large"
                    className={classes.button}
                    startIcon={<DeleteIcon />}
                >
                    Upgrade
                </Button>
            </Link>
        }else if (this.state.level===1) {
            upgrade = <Link to="/upgrade2" className="certLink">
                <Button
                    variant="contained"
                    color="secondary"
                    size="large"
                    className={classes.button}
                    startIcon={<DeleteIcon/>}
                >
                    Upgrade
                </Button>
            </Link>
        }else if (this.state.level===2) {
            upgrade = <Link to="/upgrade3" className="certLink">
                <Button
                    variant="contained"
                    color="secondary"
                    size="large"
                    className={classes.button}
                    startIcon={<DeleteIcon/>}
                >
                    Upgrade
                </Button>
            </Link>
        }else if (this.state.level===3) {
            upgrade = <Link to="/upgrade4" className="certLink">
                <Button
                    variant="contained"
                    color="secondary"
                    size="large"
                    className={classes.button}
                    startIcon={<DeleteIcon/>}
                >
                    Upgrade
                </Button>
            </Link>
        }else if (this.state.level===4) {
            upgrade = <Link to="/upgrade5" className="certLink">
                <Button
                    variant="contained"
                    color="secondary"
                    size="large"
                    className={classes.button}
                    startIcon={<DeleteIcon/>}
                >
                    Upgrade
                </Button>
            </Link>
        } else if (this.state.level===5) {
            upgrade = <Link to="/upgrade" className="certLink">
                <Button
                    variant="contained"
                    color="secondary"
                    size="large"
                    className={classes.button}
                    startIcon={<DeleteIcon/>}
                >
                    Upgrade
                </Button>
            </Link>
        }

    return (
        <div className="certificate">
            {upgrade}

            <Button
                variant="contained"
                color="primary"
                size="large"
                className={classes.button}
                startIcon={<SaveIcon />}
            >
                Download
            </Button>


            <Button
                variant="contained"
                color="default"
                size="large"
                className={classes.button}
                startIcon={<SaveIcon />}
            >
                View
            </Button>
        </div>
    );
    }
}
export default withStyles(styles)(Certificate);