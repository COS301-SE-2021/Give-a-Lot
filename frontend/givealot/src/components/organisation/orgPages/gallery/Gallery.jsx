import React, { Component } from 'react'
import "./gallery.css"
import {Publish} from "@material-ui/icons";


export class Gallery extends Component {

    render() {
        return (
            <div className="gallery">
                <div className="GalOrgContainer">
                    <div className="userUpdateRight">
                        <div className="userUpdateUpload">
                            <img
                                className="userUpdateImg"
                                src="https://images.pexels.com/photos/1152994/pexels-photo-1152994.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
                                alt=""
                            />
                            <label htmlFor="file">
                                <Publish className="userUpdateIcon" />
                            </label>
                            <input type="file" id="file" style={{ display: "none" }} />
                        </div>
                        <button className="userUpdateButton">Update</button>
                    </div>
                </div>

            </div>
        )
    }
}

export default Gallery
