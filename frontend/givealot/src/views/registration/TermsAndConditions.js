import React from 'react';
import { Link } from "react-router-dom";
import "../registration/Styles/SignUp.css"
import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import Logo from "../login/Components/Logo"

import backgroundImg from "../../assets/homeBackground.jpg";
import Button from "@material-ui/core/Button";
import PeopleAltIcon from '@material-ui/icons/PeopleAlt';
import PersonIcon from '@material-ui/icons/Person';



const styles = {
    main: {

    }
}

function TermsAndConditions()
{
    return (
        <div>
            <div className="signup" style={styles.main}>
                <div  id={"banner_filter"}>
                    <Logo/>
                    <Link to={"/SignUp"}>
                        <ArrowBackIcon style={{color: "white", marginLeft: "30px", fontSize: "xx-large"}}/>
                    </Link>
                    <div >


                    </div>
                </div>
            </div>
        </div>
    );
}

export default TermsAndConditions;