import React from 'react';
import { Link } from "react-router-dom";
import "../registration/Styles/SignUp.css"
import ArrowBackIcon from '@material-ui/icons/ArrowBack';
import Logo from "../login/Components/TermsLogo"



/*const styles = {
    main: {
        color:"#eff3f6"
    }
}*/

function TermsAndConditions()
{
    return (
        <div>
            <div className="Terms" >
                <div  >
                    <Logo/>
                    <Link to={"/SignUp"}>
                        <ArrowBackIcon style={{color: "black", marginLeft: "30px", fontSize: "xx-large"}}/>
                    </Link>
                    <div >
                        <span className="LoginHeader">
                           Terms of use
                       </span>

                    </div>
                </div>
            </div>
        </div>
    );
}

export default TermsAndConditions;