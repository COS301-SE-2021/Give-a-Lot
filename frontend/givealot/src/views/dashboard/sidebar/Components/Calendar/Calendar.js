// import React, { Component } from 'react';
// import "./styles/Calendar.css"
//
// export class Calendar extends Component {
//
//
//     render() {
//         return (
//             <div className="calendar">
//                 calendar here
//             </div>
//         )
//     }
// }
//
// export default Calendar

import React from 'react'
import FullCalendar from '@fullcalendar/react' // must go before plugins
import dayGridPlugin from '@fullcalendar/daygrid' // a plugin!
import interactionPlugin from "@fullcalendar/interaction" // needed for dayClick
import "./styles/Calendar.css"

export default class DemoApp extends React.Component {
    render() {
        return (
            <div className="calendar">
                <FullCalendar dateClick={this.handleDateClick} plugins={[ dayGridPlugin, interactionPlugin ]} />
            </div>
        )
    }

    handleDateClick = (arg) => { // bind with an arrow function
        alert(arg.dateStr)
    }
}