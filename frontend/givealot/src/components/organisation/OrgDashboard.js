import React from 'react'
import "./Organisation.css"
import OrgCards from "./OrgCards"
import OrgCharts from "./OrgCharts"
import PeopleIcon from '@material-ui/icons/People';
import PersonIcon from '@material-ui/icons/Person';
import NotificationsIcon from '@material-ui/icons/Notifications';
import LibraryBooksIcon from '@material-ui/icons/LibraryBooks';

function OrgDashboard (){
    return (
        <div className="OrgDashboard">
            <div className="Cardss">
                <OrgCards Icon={PeopleIcon} title="Organisations" number="123"/>
                <OrgCards Icon={PersonIcon} title="Users" number="1245"/>
                <OrgCards Icon={NotificationsIcon} title="Notifications" number="1245"/>
                <OrgCards Icon={LibraryBooksIcon} title="Reports" number="45"/>
            </div>
            <div className="chartArea">
                <OrgCharts />
            </div>
        </div>
    )
}

export default OrgDashboard