import {Box, TextField} from "@material-ui/core";
import Button from "@material-ui/core/Button";
import axios from "axios";
import React from "react";
import Timeline from "@material-ui/lab/Timeline";
import OrganisationTimeLineItem from "../../../../browse/Components/OrganisationTimeLineItem/OrganisationTimeLineItem";

function OrganisationTimeline()
{
    const addTimelineEvent = event =>
    {
        event.preventDefault();
        let timelineTitle = document.getElementById("timeline-event-title-input").value;
        let timelineDate = document.getElementById("timeline-event-date-input").value;
        let timelineDescription = document.getElementById("timeline-event-description-input").value;

        const addTimeLineEventRequest =
        {
            orgId : localStorage.getItem('id'),
            eventDate: timelineDate,
            eventTitle : timelineTitle,
            eventShortDescription : timelineDescription
        }

        console.log(addTimeLineEventRequest)

        axios.post('http://localhost:8080/event/add/timeline/', addTimeLineEventRequest)
            .then(response =>
            {
                console.log(response)
                if(response)
                {
                    if(response.data.message.includes("success"))
                    {
                         alert("okay")
                    }
                    else
                    {
                        alert(response.data.message);
                    }
                }
            })
            .catch(error =>
            {
                if(error.response)
                {
                    console.log(error.response)
                }
                else
                {
                    console.error(error)
                }
            })
    }

    return (
        <div>
            <Box id={"timeline_container"}>
                <Box id={"timeline_add_event_container"}>
                    <p id={"timeline_title"}>TIMELINE - ORGANISATION NAME HERE</p>
                    <p id={"timeline_slogan"}>
                        Keep everyone updated, add a timeline event
                        for your organisation.
                    </p>

                    <TextField
                        className={"timeline-text-field"}
                        id={"timeline-event-title-input"}
                        variant={"outlined"}
                        label="event title"
                        type="text"

                    />

                    <TextField
                        className={"timeline-text-field"}
                        id={"timeline-event-date-input"}
                        variant={"outlined"}
                        type="date"
                    />

                    <TextField
                        className={"timeline-text-field"}
                        variant={"outlined"}
                        id={"timeline-event-description-input"}
                        label="describe the event"
                        placeholder="describe the event in 50 characters"
                        maxRows={2}
                        multiline
                    />

                    <Button
                        variant={"contained"}
                        color={"secondary"}
                        onClick={addTimelineEvent}
                    >
                        add event
                    </Button>
                </Box>

                <Timeline align="alternate">
                    <OrganisationTimeLineItem id={1} date={"2021-09-16"}
                                              title={"Joined givealot"}
                                              description={"The givealot team welcomes your organisation family after" +
                                              " passing our verification process"}
                    />
                </Timeline>

            </Box>
        </div>
    );
}

export default OrganisationTimeline;
