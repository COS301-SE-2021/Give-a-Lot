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
                        <div className="terms_text">
                            Overview

                            The website and the solutions are operated and managed by separate entities. Refsnes Data offers the website (w3schools.com) including all its content, information, and related tools. The solutions (Such as Spaces, Courses, and My learning) and billing system are operated by W3schools Network. The two entities are separately responsible for the services that they provide, manage and operate.

                            Throughout the site, the terms "we", "us" and "our" refer to Refsnes Data and W3schools Network.

                            By visiting our site and/or purchasing something from us, you engage in our "Service" and agree to be bound by the following terms and conditions ("Terms of Service", "Terms"), including those additional terms and conditions and policies referenced herein and/or available by hyperlink. These Terms of Service apply to all users of the site, including without limitation users who are browsers, vendors, customers, merchants, and/or contributors of content.

                            Please read these Terms of Service carefully before accessing or using our website or services. By accessing or using any part of the site, you agree to be bound by these Terms of Service. If you do not agree to all the terms and conditions of this agreement, then you may not access the website or use any services.

                            Any new features or tools which are added to the current site shall also be subject to the Terms of Service. You can review the most current version of the Terms of Service at any time on this page. We reserve the right to update, change or replace any part of these Terms of Service by posting updates and/or changes to our website. It is your responsibility to check this page periodically for changes. Your continued use of or access to the website following the posting of any changes constitutes acceptance of those changes.
                        </div>

                    </div>
                </div>
            </div>
        </div>
    );
}

export default TermsAndConditions;