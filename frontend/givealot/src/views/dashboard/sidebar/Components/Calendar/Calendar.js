import React from 'react'
import Paper from '@material-ui/core/Paper';
import { ViewState, EditingState } from '@devexpress/dx-react-scheduler';
import {
    Scheduler,
    Appointments,
    AppointmentForm,
    AppointmentTooltip,
    WeekView,
    EditRecurrenceMenu,
    AllDayPanel,
    ConfirmationDialog,
} from '@devexpress/dx-react-scheduler-material-ui';
import "./styles/Calendar.css"
import { appointments } from "./data"

export default class DemoApp extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data: appointments,
            date: '',

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
                const startingAddedId = data.length > 0 ? data[data.length - 1].id + 1 : 0;
                data = [...data, { id: startingAddedId, ...added }];
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

    componentDidMount() {
        this.getDate();
    }

    getDate = () => {
        let date = new Date().toDateString();
        this.setState({ date });
    };

    render() {
        const {
            currentDate, data, addedAppointment, appointmentChanges, editingAppointment,
        } = this.state;
        return (
            <div className="calendar">

                <Paper style={{margin: "1.5em", width: "95%"}}>
                    <Scheduler
                        data={data}
                        height={660}
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
                        <WeekView
                            startDayHour={9}
                            endDayHour={17}
                        />
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
        )
    }

}