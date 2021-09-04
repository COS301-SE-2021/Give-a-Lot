import React from 'react'
import "./styles/Calendar.css"
import { ScheduleComponent, Day, Week, WorkWeek, Month, Agenda, Inject } from '@syncfusion/ej2-react-schedule';

export default class DemoApp extends React.Component {

    constructor() {
        super(...arguments);
        this.data = [{
            Id: 1,
            Subject: 'Scrum Meeting',
            StartTime: new Date(2021, (9-1), 5, 10, 0),
            EndTime: new Date(2021, (9-1), 5, 12, 30),
            IsAllDay: false,
            // RecurrenceRule: 'FREQ=DAILY;INTERVAL=1;UNTIL=20180129T043000Z;',
            // RecurrenceException: '20180130T043000Z'
        },
            {
                Id: 2,
                Subject: 'Scrum Meeting',
                StartTime: new Date(2021, 8, 30, 9, 0),
                EndTime: new Date(2021, 8, 30, 10, 30),
                Description: "Meeting time changed based on team activities.",
                RecurrenceID: 1
            }];
    }

    render() {
        return (
            <div className="calendar">
                <ScheduleComponent height='550px' selectedDate={new Date()} eventSettings={{ dataSource: this.data }}>
                    <Inject services={[Day, Week, WorkWeek, Month, Agenda]}/>
                </ScheduleComponent>;
            </div>
        )
    }

}
