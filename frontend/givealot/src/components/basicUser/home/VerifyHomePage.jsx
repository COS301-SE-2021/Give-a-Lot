import React, { Component } from 'react'
import HomeHeader from "./HomeHeader";
import "./home.css"
import axios from 'axios'
import Button from '@material-ui/core/Button';

export class VerifyHomePage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            uploadStatus: false
        }
        this.handleUploadImage = this.handleUploadImage.bind(this);
    }


    handleUploadImage(ev) {
        ev.preventDefault();

        const data = new FormData();
        data.append('file', this.uploadInput.files[0]);
        data.append('filename', this.fileName.value);

        axios.post('http://localhost:8000/upload', data)
            .then(function (response) {
                // this.setState({ imageURL: `http://localhost:8000/${body.file}`, uploadStatus: true });
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    render() {
        return (
            <div className="verifyHome">
                <HomeHeader />
                <div className="verifyHomeContent">
                    <div className="VerifyWord">
                        <p>Verify Certificate</p>
                    </div>
                    <div className="inputVerify">
                        {/*<div className="header__input">*/}
                        {/*    <input placeholder="Verify Certificate" type="file" />*/}
                        {/*    /!*<input type="file" onChange={this.onFileChange} />*!/*/}
                        {/*</div>*/}
                        {/*<Button variant="outlined" color="primary" style={{backgroundColor:"#2ab27b" }}>*/}
                        {/*    Verify*/}
                        {/*</Button>*/}
                        <div className="row">
                            <div className="col-md-6">
                                <div className="form-group files color">
                                    <label>Upload Certificate </label>
                                    <input type="file" className="form-control" name="file" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default VerifyHomePage
