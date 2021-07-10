import React, { Component } from 'react'
import PeopleIcon from '@material-ui/icons/People';
import PersonIcon from '@material-ui/icons/Person';
import { Link } from 'react-router-dom';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';

export class RegisterBack extends Component {
    render() {
        return (
            <div>
                <div className="buttons">
                    <div>
                    <Link to={'/registerOrgs'} className="orgs">
                        <ListItem button>
                        <PeopleIcon />
                            <ListItemText primary="signup  as organization" style={{textDecoration:"none"}}/>
                        </ListItem>
                    </Link>
                    <Link to={'/registeruser'} className="user">
                        <ListItem button>
                            
                        <PersonIcon />
                            <ListItemText primary="signup  as user" style={{textDecoration:"none"}}/>
                        </ListItem>
                    </Link>
                    </div>
                    <div>
                        <div id="Already_have_an_account_Log_in">
                            <span>Already have an account? <span style={{textDecoration:"underline"}} >Log in</span> </span>
                        </div>
                        <div id="By_signing_up_you_agree_to_Giv">
                            <span>By signing up, you agree to Givealot's </span>
                            <span style={{textDecoration:"underline"}} >Terms of Service<br/>and Privacy Policy.</span>
                        </div>
                    </div>  
                </div>
            </div>
        )
    }
}

export default RegisterBack
