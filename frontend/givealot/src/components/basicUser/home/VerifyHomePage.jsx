import React, { Component } from 'react'
import HomeHeader from "./HomeHeader";
import "./home.css"
import axios from 'axios'
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Button from '@material-ui/core/Button';

export class VerifyHomePage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            selectedFile: null
        }

    }

    onChangeHandler=event=>{
        this.setState({
            selectedFile: event.target.files[0],
            loaded: 0,
        })
    }
    onClickHandler = () => {
        const data = new FormData()
        data.append('file', this.state.selectedFile)
        axios.post("http://localhost:8000/upload", data, {
            // receive two    parameter endpoint url ,form data
        })
            .then(res => { // then print response status
                console.log(res.statusText)
                toast.success('upload success')
                // window.location.href = "/";
            })
            .catch(err => {
                toast.error('upload fail')
                // window.location.href = "/";
                window.open("/");
            })
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
                        <div className="cardVerify">
                            <input type="file" name="file" onChange={this.onChangeHandler}/>
                        </div>
                        <div style={{paddingTop: "20px"}}>
                            <Button variant="contained" color="primary" onClick={this.onClickHandler} style={{width: "300px", backgroundColor: "green"}}>
                                Submit
                            </Button>
                        </div>
                    </div>
                </div>
                <div className="form-group">
                    <ToastContainer/>
                </div>
            </div>
        )
    }
}

export default VerifyHomePage
