// import React from 'react'
// import "./styles/Calendar.css"
// import { ScheduleComponent, Day, Week, WorkWeek, Month, Agenda, Inject } from '@syncfusion/ej2-react-schedule';
// import { DataManager, ODataV4Adaptor } from '@syncfusion/ej2-data';
//
// export default class DemoApp extends React.Component {
//
//     constructor() {
//         super(...arguments);
//         this.dataManager = new DataManager({
//             url: 'https://ej2services.syncfusion.com/production/web-services/api/Schedule',
//             adaptor: new ODataV4Adaptor
//         });
//         console.log(this.dataManager)
//     }
//
//     render() {
//         return (
//             <div className="calendar">
//                 <ScheduleComponent height='550px' selectedDate={new Date()} readonly={false} eventSettings={{ dataSource: this.dataManager }}>
//                     <Inject services={[Day, Week, WorkWeek, Month, Agenda]}/>
//                 </ScheduleComponent>
//             </div>
//         )
//     }
// }

import * as React from 'react';
import Paper from '@material-ui/core/Paper';
import { ViewState, EditingState } from '@devexpress/dx-react-scheduler';
import "./styles/Calendar.css"
import {
    Scheduler,
    Appointments,
    AppointmentForm,
    AppointmentTooltip,
    WeekView,
    MonthView,
    EditRecurrenceMenu,
    AllDayPanel,
    ConfirmationDialog,
} from '@devexpress/dx-react-scheduler-material-ui';
import axios from "axios";

export default class Demo extends React.PureComponent {
    constructor(props) {
        super(props);
        this.state = {
            data: [],
            currentDate: new Date().toDateString(),
            email: 'coolmail@gmail.com',
            eventAdded: false,
            addedAppointment: {},
            appointmentChanges: {},
            editingAppointment: undefined,
        };

        this.commitChanges = this.commitChanges.bind(this);
        this.changeAddedAppointment = this.changeAddedAppointment.bind(this);
        this.changeAppointmentChanges = this.changeAppointmentChanges.bind(this);
        this.changeEditingAppointment = this.changeEditingAppointment.bind(this);
    }

    changeAddedAppointment(addedAppointment) {
        this.setState({ addedAppointment });
    }

    changeAppointmentChanges(appointmentChanges) {
        this.setState({ appointmentChanges });
    }

    changeEditingAppointment(editingAppointment) {
        this.setState({ editingAppointment });
    }

    commitChanges({ added, changed, deleted }) {

        this.setState((state) => {
            let { data } = state;
            // console.log(data)
            if (added) {
                const startingAddedId = data.length > 0 ? data[data.length - 1].id + 1 : 0;
                data = [...data, { id: startingAddedId, ...added }];
                let startTime = data[data.length-1].startDate.toString().split(" ")[4];
                let endTime = data[data.length-1].endDate.toString().split(" ")[4];
                let title = data[data.length-1].title;
                let description = data[data.length-1].notes;
                let startDateYear = data[data.length-1].startDate.toString().split(" ")[3];
                let startDateMonth = data[data.length-1].startDate.toString().split(" ")[1];
                let startDateDay = data[data.length-1].startDate.toString().split(" ")[2];
                let eventStartDate = startDateYear +'-' + startDateMonth + '-' + startDateDay;

                let endDateYear = data[data.length-1].endDate.toString().split(" ")[3];
                let endDateMonth = data[data.length-1].endDate.toString().split(" ")[1];
                let endDateDay = data[data.length-1].endDate.toString().split(" ")[2];
                let eventEndDate = endDateYear +'-' + endDateMonth + '-' + endDateDay;

                const eventDayAndTime = {
                    eventTitle: title,
                    eventDescription: description,
                    eventStartTime: startTime,
                    eventEndTime: endTime,
                    eventStartDate: eventStartDate,
                    eventEndDate: eventEndDate,
                    // userId: this.state.userId,
                    userEmail : this.state.email
                }

                let config = {
                    headers: {
                        "Content-Type": "application/json",
                        'Access-Control-Allow-Origin': '*',
                    }
                }
                axios.post('http://localhost:8080/event/calender/add', eventDayAndTime ,config)
                    .then(response =>{
                        console.log(response)
                    })
                    .catch(error =>{
                        console.log(error)
                    })
            }
            if (changed) {
                console.log(changed)
                let testing = changed.undefined
                console.log({ testing } )
                // console.log( testing.title  )
                if(testing.title !== undefined){
                    let config = {
                        headers: {
                            "Content-Type": "application/json",
                            'Access-Control-Allow-Origin': '*',
                        }
                    }
                    const titleUpdate ={
                        "userEmail" : this.state.email,
                        "eventId" : data.eventId,
                        "newTitle" : testing.title
                    }
                    axios.post('http://localhost:8080/event/calender/edit/title', titleUpdate ,config)
                        .then(response =>{
                            console.log(response)
                        })
                        .catch(error =>{
                            console.log(error)
                        })
                }

                // if({testing} === testing.title){
                //     console.log("title")
                // }
                // else{
                //         console.log("others")
                // }
                // data = data.map(appointment => (
                //     changed[appointment.id] ? { ...appointment, ...changed[appointment.id] } : appointment));
                // console.log(data)
                // const Event =  data.find( ({ eventId }) => eventId === id );
                // console.log(Event)

            }
            if (deleted !== undefined) {
                data = data.filter(appointment => appointment.id !== deleted);
            }
            return { data };
        });
    }
    componentDidMount() {
        this.getEvents();
    }

    getEvents(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        axios.get('http://localhost:8080/event/get/calender/'+this.state.email,  config)
            .then(response =>{
                console.log(response)
                this.setState({data: response.data.object})
            })
            .catch(error =>{
                console.log(error)
            })
    }

    render() {
        const {
            currentDate, data, addedAppointment, appointmentChanges, editingAppointment,
        } = this.state;

        return (
            <div className="calendar">
                <Paper>
                    <Scheduler
                        data={data}
                        height={660}
                        remoteFiltering={true}
                    >
                        <ViewState
                            currentDate={currentDate}
                        />
                        <EditingState
                            onCommitChanges={this.commitChanges}
                            addedAppointment={addedAppointment}
                            onAddedAppointmentChange={this.changeAddedAppointment}
                            appointmentChanges={appointmentChanges}
                            onAppointmentChangesChange={this.changeAppointmentChanges}
                            editingAppointment={editingAppointment}
                            onEditingAppointmentChange={this.changeEditingAppointment}
                        />
                        <MonthView />
                        <AllDayPanel />
                        <EditRecurrenceMenu />
                        <ConfirmationDialog />
                        <Appointments />
                        <AppointmentTooltip
                            showOpenButton
                            showDeleteButton
                        />
                        <AppointmentForm />
                    </Scheduler>
                </Paper>
            </div>

        );
    }
}
