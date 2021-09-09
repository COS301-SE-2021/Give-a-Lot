import React, { Component } from 'react'
import backgroundImg from "../../assets/homeBackground.jpg";
import Logo from "../login/Components/Logo";
import {Link} from "react-router-dom";
import ArrowBackIcon from "@material-ui/icons/ArrowBack";
import "./styles/VerifyCert.css"
import axios from "axios";

const styles = {
    main: {
        backgroundImage: `url(${backgroundImg})`
    }
}

export class VerifyCertificate extends Component {

    constructor() {
        super();
        this.state = {
            selectedFile: '',
        };
    }

    onChange = (e) => {
        switch (e.target.name) {
            case 'selectedFile':
                this.setState({ selectedFile: e.target.files[0] });
                break;
            default:
                this.setState({ [e.target.name]: e.target.value });
        }
    }

    onSubmit = (e) => {
        e.preventDefault();
        const { selectedFile } = this.state;
        let formData = new FormData();
        formData.append('selectedFile', selectedFile);

        fetch(
            'http://localhost:8080/certificate/compare',
            {
                method: 'POST',
                body: formData,
            }
        )
        .then((response) => response.json())
        .then((result) => {
            console.log('Success:', result);

        })
        .catch((error) => {
            console.error('Error:', error);

        });
    }

    render() {
        const { selectedFile } = this.state;
        return (
            <div className="verifyCert" style={styles.main}>
                <div  id={"banner_filter"}>
                    <Logo/>
                    <Link to={"/"}>
                        <ArrowBackIcon style={{color: "white", marginLeft: "30px", fontSize: "xx-large"}}/>
                    </Link>
                    <div className="fileUpload" >
                        <div>
                            <h3 className="verify">Verify Certificate</h3>
                        </div>
                        <div className="upload">
                            <div className="Upload">
                                <span className="Title">Upload Certificate</span>
                                <div className="Content">
                                    <div>
                                        <form onSubmit={this.onSubmit}>
                                            <input
                                                type="file"
                                                name="selectedFile"
                                                onChange={this.onChange}
                                            />
                                            <button type="submit">Submit</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default VerifyCertificate
