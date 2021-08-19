import * as React from 'react';
// import * as ReactDOM from 'react-dom';
import "./orgcalendar.css"
import { ScheduleComponent, Day, Week, WorkWeek, Month, Agenda, Inject } from '@syncfusion/ej2-react-schedule';
class OrgCalendar extends React.Component {
    render() {

        return (
            <div className="calendar">
                <ScheduleComponent height='550px' selectedDate={new Date(2021, 7, 29)} eventSettings={{ dataSource: this.data }}>
                    <Inject services={[Day, Week, WorkWeek, Month, Agenda]}/>
                </ScheduleComponent>
            </div>

        )
    }
}
;

export default OrgCalendar