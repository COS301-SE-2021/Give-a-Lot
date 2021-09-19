import {Box, TextField} from "@material-ui/core";
import Button from "@material-ui/core/Button";
import axios from "axios";
import React, {useEffect, useState} from "react";
import Timeline from "@material-ui/lab/Timeline";
import OrganisationTimeLineItem from "../../../../browse/Components/OrganisationTimeLineItem/OrganisationTimeLineItem";


function useForceUpdate()
{
    const [value, setValue] = useState(0); // integer state
    return () => setValue(value => value + 1); // update the state to force render
}


function OrganisationTimeline()
{
    let [timelineEvents, setTimelineEvents] = useState([]);
    let [curr_organisation_id, set_curr_organisation_id] = useState(localStorage.getItem('id'));
    const forceUpdate = useForceUpdate();
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

    useEffect(() => {
            fetch( "http://localhost:8080/event/get/timeline/" + curr_organisation_id)
                .then(async response =>{

                    const data = await response.json();

                    if(!response.ok) /* error handling here */
                    {
                        if(response.status === 500)
                        {
                            alert("bad parameters, fatal");
                        }
                        else if(response.status === 401)
                        {
                            alert("this token is unauthorized"); /* take them back to login */
                        }

                        if(typeof data !== 'undefined')
                        {
                            alert(data.message);
                        }
                    }

                    if(data.message === "success") /*successfully fetched*/
                    {
                        console.log(data.object);
                        setTimelineEvents(data.object)
                    }
                    else
                    {
                        alert("error occured: " + data.code);
                    }
                })

                .catch(error => {
                    alert("failed - organisations - sector")
                });
        }
        ,[])

    let fetched_timeline_events = [];
    if(timelineEvents !== undefined)
    {
        for (let i = 0; i < timelineEvents.length; i++)
        {
            let timeline_event_date = timelineEvents[i].eventDate;
            let timeline_event_title = timelineEvents[i].eventTitle;
            let timeline_event_id = timelineEvents[i].eventId;
            let timeline_event_description = timelineEvents[i].eventShortDescription;

            fetched_timeline_events.push(
                <OrganisationTimeLineItem id={timeline_event_id}
                                          date={timeline_event_date}
                                          title={timeline_event_title}
                                          description={timeline_event_description}
                />
            )
        }
    }

    return (
        <div>
            <Box id={"timeline_container"}>
                <Box id={"timeline_add_event_container"}>
                    <p id={"timeline_title"}>TIMELINE - REMEMBER WHAT'S IMPORTANT</p>
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
                        onClick={forceUpdate}
                    >
                        add event
                    </Button>
                </Box>

                <Box id={"timeline-event-dashboard-container"}>
                    <Timeline align="alternate">
                        {fetched_timeline_events}
                    </Timeline>
                </Box>

            </Box>
        </div>
    );
}

export default OrganisationTimeline;
