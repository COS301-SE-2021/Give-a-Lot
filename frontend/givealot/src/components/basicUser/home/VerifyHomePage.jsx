import React, { Component } from 'react'
import HomeHeader from "./HomeHeader";
import "./home.css"
import axios from 'axios'
// import Button from '@material-ui/core/Button';
// import { render } from 'react-dom';

import { StyledDropZone } from 'react-drop-zone'
import 'react-drop-zone/dist/styles.css'

export class VerifyHomePage extends Component {

    state = {
        file: undefined,
    }

    setFile = (file, text) => {
        this.setState({ file })
    }

    render() {
        console.log(this.state)
        const label = this.state.file ?
            this.state.file.name :
            'Click or drop your file here';
        return (
            <div className="verifyHome">
                <HomeHeader />
                <div className="verifyHomeContent">
                    <div className="VerifyWord">
                        <p>Verify Certificate</p>
                    </div>
                    <div className="inputVerify">
                        <div>
                            <StyledDropZone
                                onDrop={this.setFile}
                                label={label}
                            />
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default VerifyHomePage
