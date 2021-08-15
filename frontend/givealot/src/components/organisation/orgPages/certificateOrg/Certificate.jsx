import React, { Component } from 'react'
import "./certificate.css"
import cert from "./stock.jpg";
import GetAppIcon from '@material-ui/icons/GetApp';
import ArrowUpwardIcon from "@material-ui/icons/ArrowUpward";
import {Link} from "react-router-dom";
import PeopleOutlineIcon from "@material-ui/icons/PeopleOutline";


export default function Certificate() {


        return (
            <div className="certificate">

                <div className="temporary">
                    <img className="image" src={cert} alt="cert" style={{width: "700px", height: "410px"}}/>

                </div>
            </div>
        )

}

//export default Certificate
