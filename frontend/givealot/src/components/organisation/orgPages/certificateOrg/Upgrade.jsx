import React, { Component } from 'react';
import "./certificate.css";
import CancelIcon from '@material-ui/icons/Cancel';


export default function  Upgrade() {


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
                            placeholder="Website"
                            className="input1"

                        />
                        <input type="submit" value="Submit" className="submit1"/>
                        <div className="contain_Icon"><CancelIcon className="formIcon"/></div>


                    </form>
               </div>

            </div>
        )

}
