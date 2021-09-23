import React, {useEffect, useState} from "react";
import "./Blur.css"
import {Box, TextField} from "@material-ui/core";
import blurredFallback from '../../../../../assets/blurredFallback.jpeg';
import {Alert} from "@material-ui/lab";
function BlurImages()
{
    let [current_image, set_current_image] = useState(blurredFallback);
    const uploadImage = event =>
    {
        const form_data = new FormData();
        form_data.append('orgId', localStorage.getItem('id'));
        form_data.append('image', event.target.files[0]);
        form_data.append('type',1);

        document.getElementById("processing_photo_info").style.display = "flex";

        fetch(
            'http://0948-105-208-196-136.ngrok.io/v1/frecognition/blur',
            {
                method: 'POST',
                body: form_data,
            }
        )
        .then((response) => response.json())
        .then((result) =>
        {
            set_current_image("http://0948-105-208-196-136.ngrok.io/pixelorblur/version/" + localStorage.getItem('id'))
            document.getElementById("processing_photo_info").style.display = "none";
        })
        .catch((error) => {
            console.error('Error:', error.response);
        });
    }

    return (
        <div className="blur">
            <Box id={"blur-image-container"}>
                <p>
                    Upload an image to blur faces
                </p>
                    <TextField
                        className={"blur-image-input"}
                        id={"blur-image-input"}
                        variant={"outlined"}
                        type="file"
                        onChange={uploadImage}
                        accept="image/*"
                    />

                <Alert
                    severity={'info'}
                    id={"processing_photo_info"}
                >
                    please wait while we process the photo
                </Alert>
                <Box>
                    <img id={"blurred_image_here"} src={current_image} width={400}/>
                </Box>

            </Box>
        </div>
    );
}

export default BlurImages;
