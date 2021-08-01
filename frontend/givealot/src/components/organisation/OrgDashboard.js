import React from 'react'
import "./Organisation.css"
import Cards from "./Cards"
import Charts from "./Charts"
import PeopleIcon from '@material-ui/icons/People';
import PersonIcon from '@material-ui/icons/Person';
import NotificationsIcon from '@material-ui/icons/Notifications';
import LibraryBooksIcon from '@material-ui/icons/LibraryBooks';

function OrgDashboard (){
    return (
        <div className="OrgDashboard">
            <div className="Cardss">
                <Cards Icon={PeopleIcon} title="Organisations" number="123"/>
                <Cards Icon={PersonIcon} title="Users" number="1245"/>
                <Cards Icon={NotificationsIcon} title="Notifications" number="1245"/>
                <Cards Icon={LibraryBooksIcon} title="Reports" number="45"/>
            </div>
            <div className="chartArea">
                <Charts />
            </div>
        </div>
    )
}

export default OrgDashboard