import React from 'react'
import "./Style/Certificate.css"
import cert from "./Style/CertificateComplete.pdf";
import { Document, Page } from 'react-pdf/dist/esm/entry.webpack';
import GetAppIcon from '@material-ui/icons/GetApp';
import ArrowUpwardIcon from "@material-ui/icons/ArrowUpward";
import {Link} from "react-router-dom";
import Axios from "axios";
import { useState} from "react";
import { pdfjs } from 'react-pdf';
pdfjs.GlobalWorkerOptions.workerSrc = `//cdnjs.cloudflare.com/ajax/libs/pdf.js/${pdfjs.version}/pdf.worker.min.js`;





export default function Certificate() {

    const [ Dcertificate, setDcertificate]= useState("")

    const DownloadC=()=>{
        Axios.get("https://official-joke-api.appspot.com/random_joke").then(
            (response)=>{
                console.log(response);
                setDcertificate(response.data.setup + "..." + response.data.punchline);
            })
    }
    return (
        <div className="certificate">
            {/*<div className="heading">
                    <p className="level">Level:</p>
                    <p className="status">Intermediate</p>
                </div>*/}
            <button className="button button1" >
                <Link to="/upgrade" className="certLink"  >
                    <ArrowUpwardIcon className="certIcon"/>Upgrade
                </Link>
            </button>
            <button className="button button2" onClick={DownloadC} ><GetAppIcon className="certIcon"/>Download</button>
            {Dcertificate}

            <div className="temporary">
                {/*} <embed className="image" src="Certificate%20(1).pdf" alt="cert" style={{width: "700px", height: "410px"}}/>*/}

                <Document file={cert}>
                    <Page pageNumber={1} className="image"  style={{width: "700px", height: "410px"}}/>
                </Document>
            </div>
        </div>
    )

}

//export default Certificate