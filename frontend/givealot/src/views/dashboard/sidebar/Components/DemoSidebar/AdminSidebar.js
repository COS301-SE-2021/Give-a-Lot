/*import React from 'react'
import './Side.css'
import {AdminData} from "./AdminData";

function AdminSidebar(){
    return(
        <div className="AdminSidebar">
            <ul className="UnorderedList">
                {AdminData.map((val,key)=>{
                    return(
                        <li
                            key={key}
                            id={window.location.pathname==val.link ? "active" : "y"}
                            onClick={()=>{window.location.pathname= val.link}}
                            className="row"
                        >

                            <div id="sidebarIcon">{ val.icon}</div>
                            <div id="sidebarTitle">{ val.title}</div>
                        </li>
                    )
                })}
            </ul>
        </div>
    )
}
export default AdminSidebar*/
