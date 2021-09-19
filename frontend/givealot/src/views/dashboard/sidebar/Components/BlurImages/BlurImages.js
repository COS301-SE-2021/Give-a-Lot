import React, {useEffect, useState} from "react";
import "./Blur.css"
import {Box, TextField} from "@material-ui/core";
import blurredFallback from '../../../../../assets/blurredFallback.jpeg';
function BlurImages()
{

    let [current_image, set_current_image] = useState(blurredFallback);
    const uploadImage = event =>
    {
        event.preventDefault();
        const form_data = new FormData();
        form_data.append('orgId', localStorage.getItem('id'));
        form_data.append('images', event.target.files);

        console.log(event.target.files)

        set_current_image("http://localhost:8080/logo/version/84")

        /*fetch(
            'http://localhost:8080/v1/organisation/add/qrcode',
            {
                method: 'POST',
                body: form_data,
            }
        )
        .then((response) => response.json())
        .then((result) => {

        })
        .catch((error) => {
            console.error('Error:', error.response);
        });*/
    }


    return (
        <div className="blur">
            <Box id={"blur-image-container"}>
                <p>
                    upload an image to blur faces from
                </p>
                    <TextField
                        className={"blur-image-input"}
                        id={"blur-image-input"}
                        variant={"outlined"}
                        type="file"
                        onChange={uploadImage}
                        accept="image/*"
                    />

                <Box>
                    <img id={"blurred_image_here"} src={current_image} width={400}/>
                </Box>
            </Box>
        </div>
    );
}

export default BlurImages;
