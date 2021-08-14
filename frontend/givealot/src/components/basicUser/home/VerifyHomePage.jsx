import React, { Component } from 'react'
import HomeHeader from "./HomeHeader";
import "./home.css"
import Button from '@material-ui/core/Button';

export class VerifyHomePage extends Component {

    render() {
        return (
            <div className="verifyHome">
                <HomeHeader />
                <div className="verifyHomeContent">
                    <div className="VerifyWord">
                        <p>Verify Certificate</p>
                    </div>
                    <div className="inputVerify">
                        <div className="header__input">
                            <input placeholder="Verify Certificate" type="file" />
                            {/*<input type="file" onChange={this.onFileChange} />*/}
                        </div>
                        <Button variant="outlined" color="primary" style={{backgroundColor:"#2ab27b" }}>
                            Verify
                        </Button>
                    </div>
                </div>
            </div>
        )
    }
}

export default VerifyHomePage
