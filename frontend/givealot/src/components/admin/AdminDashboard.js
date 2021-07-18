import React from 'react'
import "./Admin.css"
import Cards from "./Cards"
// import Charts from "./Charts"
import PeopleIcon from '@material-ui/icons/People';
import PersonIcon from '@material-ui/icons/Person';
import NotificationsIcon from '@material-ui/icons/Notifications';
import LibraryBooksIcon from '@material-ui/icons/LibraryBooks';

function AdminDashboard (){

   
        return (
            <div className="adminDashboard">
                <div className="Cards">
                    <Cards Icon={PeopleIcon} title="Organisations" number="123"/>
                    <Cards Icon={PersonIcon} title="Users" number="1245"/>
                    <Cards Icon={NotificationsIcon} title="Notifications" number="1245"/>
                    <Cards Icon={LibraryBooksIcon} title="Reports" number="12"/>
                </div>
                {/* <div className="chartArea">
                    <Charts />
                </div> */}

            </div>
        )
    
}

export default AdminDashboard