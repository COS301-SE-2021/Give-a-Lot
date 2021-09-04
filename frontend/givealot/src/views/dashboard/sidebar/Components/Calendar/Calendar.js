import React from 'react'
import Paper from '@material-ui/core/Paper';
import { ViewState, EditingState } from '@devexpress/dx-react-scheduler';
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
    CurrentTimeIndicator,
} from '@devexpress/dx-react-scheduler-material-ui';
import "./styles/Calendar.css"
import { appointments } from "./data"

export default class DemoApp extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data: appointments,
            // currentDate: new Date().toDateString(),
            userId: '',

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
            if (added) {
                console.log("adding")
                const startingAddedId = data.length > 0 ? data[data.length - 1].id + 1 : 0;
                data = [...data, { id: startingAddedId, ...added }];
                console.log(data)
                // console.log(data[data.length-1].startDate)
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
                    userId: this.state.userId
                }

                console.log(eventEndDate);
                console.log(eventStartDate);
                console.log(startTime);
                console.log(endTime);
                console.log(title);
                console.log(description);
            }
            if (changed) {
                data = data.map(appointment => (
                    changed[appointment.id] ? { ...appointment, ...changed[appointment.id] } : appointment));
            }
            if (deleted !== undefined) {
                data = data.filter(appointment => appointment.id !== deleted);
            }
            return { data };
        });
    }

    // componentDidMount() {
    //     // this.getEvents();
    // }

    // getEvents = () => {
    //     let datS = [];
    //     datS[0]  =
    //         {
    //             title: 'Approve New Online Marketing Strategy',
    //             startDate: new Date(2021, 9, 4, 14, 15),
    //             endDate: new Date(2021, 9, 5, 13, 0),
    //             id: 7,
    //             location: 'Room 3'
    //         };
    //     this.setState({data: datS})
    //     console.log(this.state.data)
    // }

    render() {
        const {
            data, addedAppointment, appointmentChanges, editingAppointment,
        } = this.state;
        return (
            <div className="calendar">

                <Paper style={{margin: "1.5em", width: "95%"}}>
                    <Scheduler
                        data={data}
                        height={660}
                    >
                        {/*<ViewState*/}
                        {/*    currentDate={currentDate}*/}
                        {/*/>*/}
                        <EditingState
                            onCommitChanges={this.commitChanges}
                            addedAppointment={addedAppointment}
                            onAddedAppointmentChange={this.changeAddedAppointment}
                            appointmentChanges={appointmentChanges}
                            onAppointmentChangesChange={this.changeAppointmentChanges}
                            editingAppointment={editingAppointment}
                            onEditingAppointmentChange={this.changeEditingAppointment}
                        />
                        {/*<WeekView*/}
                        {/*    startDayHour={9}*/}
                        {/*    endDayHour={17}*/}
                        {/*/>*/}
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
                        <CurrentTimeIndicator />
                    </Scheduler>
                </Paper>
            </div>
        )
    }

}
