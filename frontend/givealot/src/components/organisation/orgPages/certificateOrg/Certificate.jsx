import React from 'react'
import "./certificate.css"
import cert from "./stock.jpg";
import GetAppIcon from '@material-ui/icons/GetApp';
import ArrowUpwardIcon from "@material-ui/icons/ArrowUpward";
import {Link} from "react-router-dom";
import axios from "axios";



export default function Certificate() {


        return (
            <div className="certificate">
                <div className="heading">
                    <p className="level">Level:</p>
                    <p className="status">Intermediate</p>

                </div>
                <button className="button button1" >
                    <Link to="/upgrade" className="certLink"  >
                        <ArrowUpwardIcon className="certIcon"/>Upgrade
                    </Link>
                </button>
                <button className="button button2"><GetAppIcon className="certIcon"/>Download</button>

                <div className="temporary">
                    <img className="image" src={cert} alt="cert" style={{width: "700px", height: "410px"}}/>

                </div>
            </div>
        )

}

//export default Certificate
