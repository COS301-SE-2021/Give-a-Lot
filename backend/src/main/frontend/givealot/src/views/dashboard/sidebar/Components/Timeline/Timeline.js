import {Box, TextField} from "@material-ui/core";
import Button from "@material-ui/core/Button";

function Timeline()
{
    const addTimelineEvent = event =>
    {
        event.preventDefault();
        let timelineTitle = document.getElementById("timeline-event-title-input").value;
        let timelineDate = document.getElementById("timeline-event-date-input").value;
        let timelineDescription = document.getElementById("timeline-event-description-input").value;

        console.log(timelineTitle);
        console.log(timelineDate);
        console.log(timelineDescription);

        const addTimeLineEventRequest = {
            orgId : localStorage.getItem('id'),

        }
    }

    return (
        <div>
            <Box id={"timeline_container"}>
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
        </div>
    );
}

export default Timeline;
