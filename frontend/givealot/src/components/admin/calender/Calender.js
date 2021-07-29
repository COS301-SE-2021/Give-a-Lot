import * as React from 'react';
// import * as ReactDOM from 'react-dom';
import { ScheduleComponent, Day, Week, WorkWeek, Month, Agenda, Inject } from '@syncfusion/ej2-react-schedule';
class Calender extends React.Component {
    render() {
        return <ScheduleComponent height='550px' selectedDate={new Date(2021, 7, 29)} eventSettings={{ dataSource: this.data }}>
            <Inject services={[Day, Week, WorkWeek, Month, Agenda]}/>
        </ScheduleComponent>;
    }
}
;

export default Calender

