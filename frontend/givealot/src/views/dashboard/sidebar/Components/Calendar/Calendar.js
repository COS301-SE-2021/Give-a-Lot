import React from 'react'
import "./styles/Calendar.css"
import { ScheduleComponent, Day, Week, WorkWeek, Month, Agenda, Inject } from '@syncfusion/ej2-react-schedule';
import { DataManager, ODataV4Adaptor } from '@syncfusion/ej2-data';

export default class DemoApp extends React.Component {

    constructor() {
        super(...arguments);
        this.dataManager = new DataManager({
            url: 'https://ej2services.syncfusion.com/production/web-services/api/Schedule',
            adaptor: new ODataV4Adaptor
        });
        console.log(this.dataManager)
    }

    render() {
        return (
            <div className="calendar">
                <ScheduleComponent height='550px' selectedDate={new Date()} readonly={false} eventSettings={{ dataSource: this.dataManager }}>
                    <Inject services={[Day, Week, WorkWeek, Month, Agenda]}/>
                </ScheduleComponent>
            </div>
        )
    }

}
