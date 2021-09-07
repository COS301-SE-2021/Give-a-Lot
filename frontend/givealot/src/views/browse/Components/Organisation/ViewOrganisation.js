import React, {useEffect, useState} from 'react';
import {useParams} from 'react-router-dom';
import Navbar from "../Navbar/Navbar";
import Button from '@material-ui/core/Button';
import ImageGallery from 'react-image-gallery';
import "react-image-gallery/styles/css/image-gallery.css";
import InstagramIcon from '@material-ui/icons/Instagram';

import view_organisation from '../../Styles/view_organisation.css';
import {Accordion, AccordionDetails, Avatar, Box, Paper} from "@material-ui/core";
import Footer from "../Footer/Footer";
import Container from '@material-ui/core/Container';


import Timeline from "@material-ui/lab/Timeline";
import OrganisationTimeLineItem from '../OrganisationTimeLineItem/OrganisationTimeLineItem'
import {Instagram} from "@material-ui/icons";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";
import AccordionSummary from "@material-ui/core/AccordionSummary";
import Typography from "@material-ui/core/Typography";
import {makeStyles} from "@material-ui/core/styles";
import Loader from "../../../loader/Loader";

/*
 * certificate component imports
 */

const useStyles = makeStyles((theme) => ({
    root: {
        width: '100%',
    },
    heading: {
        fontSize: theme.typography.pxToRem(15),
        flexBasis: '33.33%',
        flexShrink: 0,
    },
    secondaryHeading: {
        fontSize: theme.typography.pxToRem(15),
        color: theme.palette.text.secondary,
    },
}));


/*timeline*/

function trim_description(descr)
{
    let summary = "";
    let complete_descr = "";
    if(descr !== undefined) {
        if (descr.length > 50) {
            summary = "";
            let i;
            let upperbound = 200;
            for (i = 0; i < upperbound && i < descr.length; i++) {
                if (i + 1 === upperbound && descr[i] !== " ")
                    upperbound++;
                summary = summary + descr[i];
            }

            summary = summary + "[expand to read more]";


            for (let k = i; k < descr.length; k++) {
                complete_descr = complete_descr + descr[k];
            }

        }
    }
    return [summary, complete_descr];
}
function ViewOrganisation()
{
    const classes = useStyles();
    const [expanded, setExpanded] = React.useState(false);
    const [pageLoaded, setPageLoaded] = React.useState(true);
    const [organisationData, setOrganisationData] = React.useState([]);
    const [selectedUserId, setSelectedUserId] = React.useState("default");
    const [selectedOrgId, setSelectedOrgId] = React.useState(null);
    const [updatedSelectedId, setUpdatedSelectedId] = React.useState(false);

    const handleChange = (panel) => (event, isExpanded) => {
        setExpanded(isExpanded ? panel : false);
    };

    let {id} = useParams();
    let image_id = id + "";

    let images = [{
        original : "/images_tmp/1.jpg",
        thumbnail: "/images_tmp/1.jpg"
    },
        {
            original : "/images_tmp/2.jpg",
            thumbnail: "/images_tmp/2.jpg"
        },
        {
            original : "/images_tmp/15.png",
            thumbnail: "/images_tmp/15.png"
        },
        {
            original : "/images_tmp/23.jpg",
            thumbnail: "/images_tmp/23.jpg"
        }];

    useEffect(() => {

            fetch("http://localhost:8080/v1/organisation/sel/organisation/" + id + "/" + selectedUserId)
            .then(async response =>
            {
                const data = await response.json();

                if (!response.ok) /* error handling here */
                {
                    if (response.status === 500) {
                        alert("bad parameters, fatal");
                    } else if (response.status === 401) {
                        alert("this token is unauthorized"); /* take them back to login */
                    }

                    if (typeof data !== 'undefined') {
                        alert(data.message);
                    }
                }

                if (data.message === "success") /*successfully fetched*/
                {
                    setOrganisationData(data.response);
                    setPageLoaded(true);
                } else {
                    alert("error occured: " + data.code);
                    setOrganisationData([]);
                }
            })

            .catch(error => {
                alert("failed - organisations - sector")
            });


        }
        ,[])
    /* fetch request - organisations by sections - end*/

    console.log(organisationData);

    let description = [];
    description[0] = "";
    description[1] = "";

    if(organisationData !== undefined)
    {
        description = trim_description(organisationData.orgDescription);
    }

    return (
       <div>
           {pageLoaded === false && <Loader />}

           <Navbar/>
           <Container maxWidth={"xl"}  id="view_organisation_container">
               <Container maxWidth={"sm"} id="view_organisation">
                   <div id="view_header">
                       <div id="view_organisations_card">
                           <h1>{organisationData.orgName}</h1>
                           <h4>{organisationData.slogan}</h4>
                       </div>

                       <img src={""} id={"imageCover"}/>

                       <div id={"id_social_media"}>
                           <Button id={"instaIcon"} size={"small"} startIcon={<InstagramIcon />}>
                                instagram
                           </Button>

                           <Button id={"FacebookIcon"} size={"small"} startIcon={<InstagramIcon />}>
                               facebook
                           </Button>

                           <Button id={"TwitterIcon"} size={"small"} startIcon={<InstagramIcon />}>
                               twitter
                           </Button>
                       </div>

                   </div>

                   <div id="view_organisation_meta_body">
                       <p id="view_organisation_meta_body_about">about us</p>

                       <Accordion elevation={0} expanded={expanded === 'panel1'} onChange={handleChange('panel1')}>
                           <AccordionSummary
                               expandIcon={<ExpandMoreIcon />}
                               aria-controls="panel1bh-content"
                               id="panel1bh-header"
                           >
                               {/*  <Typography className={classes.heading}>General settings</Typography> */}
                               <Typography className={classes.secondaryHeading}>{description[0]}</Typography>
                           </AccordionSummary>
                           <AccordionDetails>
                               <Typography>
                                   {description[1]}
                               </Typography>
                           </AccordionDetails>
                       </Accordion>

                   </div>
                   <p id="view_organisation_meta_body_about">gallery</p>

                   <div id="view_organisation_gallery">

                       <p>{images.length} pictures</p>
                       <ImageGallery items={images} />
                   </div>
               </Container>

               <Container maxWidth="sm" id="view_organisation_right">
                   <Box maxWidth={500} id="certificate_container" color="text.primary">
                       <div>
                           <div id={"view_header_meta_content"}>
                               <div>
                                   <p>certificate level</p>
                               </div>
                               <img src={"https://avatars.dicebear.com/api/initials/1.svg?w=500"} />
                           </div>

                           <Box id={"donateSection"}>
                               <img src={"/qrcode.png"} width={128} height={128}/>
                               <Button variant={"contained"}>
                                   donate
                               </Button>
                           </Box>
                       </div>

                       <p id={"certificate_award_message"}>
                          the following certificate was awarded by givealot to
                           <em>QUADPARA ASSOCIATION OF SOUTH AFRICA (QASA)</em> upon reviewing
                          their organisation and the information they provided to givealot
                       </p>

                       <img src={"/images_tmp/somecert.png"}  />
                       <Button variant="contained" color="secondary">
                           Download
                       </Button>
                   </Box>

                   <p id="view_organisation_meta_body_about">timeline</p>
                   <Box id={"organisation_timeline"}>

                        <Timeline align="alternate">
                            <OrganisationTimeLineItem id={1} date={"2021-09-16"}
                            title={"Joined givealot"}
                            description={"The givealot team welcomes your organisation family after" +
                                           " passing our verification process"}
                            />

                            <OrganisationTimeLineItem id={2} date={"2021-09-21"}
                                                      title={"level 5 verification "}
                                                      description={"The givealot team congratulates the organisation" +
                                                      " for reaching level 5 verification"}
                            />

                            <OrganisationTimeLineItem id={3} date={"2021-09-21"}
                                                      title={"level 5 verification "}
                                                      description={"The givealot team congratulates the organisation" +
                                                      " for reaching level 5 verification"}
                            />

                            <OrganisationTimeLineItem id={4} date={"2021-09-21"}
                                                      title={"level 5 verification "}
                                                      description={"The givealot team congratulates the organisation" +
                                                      " for reaching level 5 verification"}
                            />

                            <OrganisationTimeLineItem id={5} date={"2021-09-21"}
                                                      title={"level 5 verification "}
                                                      description={"The givealot team congratulates the organisation" +
                                                      " for reaching level 5 verification"}
                            />

                            <OrganisationTimeLineItem id={6} date={"2021-09-21"}
                                                      title={"level 5 verification "}
                                                      description={"The givealot team congratulates the organisation" +
                                                      " for reaching level 5 verification"}
                            />
                        </Timeline>
                   </Box>
               </Container>
           </Container>
            <Footer />
       </div>
    )
}

export default ViewOrganisation;