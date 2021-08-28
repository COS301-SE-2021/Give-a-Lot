import React, {useState} from 'react';
import {useParams} from 'react-router-dom';
import Navbar from "../Navbar/Navbar";
import Button from '@material-ui/core/Button';
import ImageGallery from 'react-image-gallery';
import "react-image-gallery/styles/css/image-gallery.css";
import TwitterIcon from '../../../../assets/icons/twitter.png';
import view_organisation from '../../Styles/view_organisation.css';
import {Avatar} from "@material-ui/core";
import Footer from "../Footer/Footer";


/*
* certificate component imports
* */
/*
*/
import cert from '../../../../assets/pdfTemplates/CertificateComplete.pdf';
/*
pdfjs.GlobalWorkerOptions.workerSrc = `//cdnjs.cloudflare.com/ajax/libs/pdf.js/${pdfjs.version}/pdf.worker.min.js`;
*/

/*import PDFtoIMG from 'react-pdf-to-image';*/

function myFunction()
{

    var dots = document.getElementById("dots");
    var moreText = document.getElementById("more");
    var btnText = document.getElementById("myBtn");

    if (dots.style.display === "none") {
        dots.style.display = "inline";
        btnText.innerHTML = "Read more";
        moreText.style.display = "none";
    } else {
        dots.style.display = "none";
        btnText.innerHTML = "Read less";
        moreText.style.display = "inline";
    }
}

function ViewOrganisation()
{
    let {id} = useParams();
    let images = [{
                   original : "/assets/homeBackground.jpg",
                   thumbnail: "/assets/homeBackground.jpg"
                  },
        {
            original : "/assets/homeBackground.jpg",
            thumbnail: "/assets/homeBackground.jpg"
        },
        {
            original : "/assets/homeBackground.jpg",
            thumbnail: "/assets/homeBackground.jpg"
        },
        {
            original : "/assets/homeBackground.jpg",
            thumbnail: "/assets/homeBackground.jpg"
        }];

    return (
       <div>
           <Navbar/>
           <div id="view_organisation_container">
               <div id="view_organisation">
                   <div id="view_header">

                       <div id="view_organisations_card">
                           <h1>QuadPara Association of South Africa (QASA)</h1>
                           <h4>we are the beam shines nothing but hope</h4>
                       </div>

                       <img src={"/Children.jpg"} id={"imageCover"}/>

                       <div id={"view_header_meta_content"}>
                           <div>
                               <p>certificate level</p>
                           </div>
                           <img src={"https://avatars.dicebear.com/api/initials/1.svg?w=500"} />
                       </div>

                   </div>

                   <div id="view_organisation_meta_body">
                       <p id="view_organisation_meta_body_about">about us</p>
                       <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus imperdiet, nulla et dictum interdum, nisi lorem egestas vitae scel

                           erisque enim ligula venenatis dolor. Maecenas nisl est, ultrices nec congue eget, auctor vitae massa. Fusce luctus vestibulum augue ut aliquet.
                           Nunc sagittis dictum nisi, sed ullamcorper ipsum dignissim ac.
                           In at libero sed nunc venenatis imperdiet sed <span id="dots">...</span><span id="more">ornare turpis.
                           Donec vitae dui eget tellus gravida venenatis. Integer fringilla congue eros non fermentum.
                           Sed dapibus pulvinar nibh tempor porta.</span></p>
                       <Button
                           onClick={myFunction}
                           id="myBtn"
                           variant="contained"
                           color="secondary" >Read more
                       </Button>
                   </div>
                   <p id="view_organisation_meta_body_about">gallery</p>

                   <div id="view_organisation_gallery">
                       <p>1 of 2 pictures</p>
                       <ImageGallery items={images} />
                   </div>

               </div>

               <div id="view_organisation_right">

                   <div id="certificate_container">
                       {/*<Document file={cert} id="certificate_page">
                           <Page pageNumber={1} size={50} className="image" />
                       </Document>*/}
                       {/*<PDFtoIMG file={cert}>
                           {({pages}) => {
                               if (!pages.length) return 'Loading...';
                                   pages.map((page, index)=>
                                   <img key={index} src={page}/>
                               );
                           }}
                       </PDFtoIMG>*/}

                   </div>
               </div>
           </div>
            <Footer />
       </div>
    )
}

export default ViewOrganisation;