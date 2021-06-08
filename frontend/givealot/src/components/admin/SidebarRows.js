import React from 'react';
import "./SidebarRows.css";
import { Avatar } from '@material-ui/core';

function SidebarRows({src, Icon, title}) {
    return (
        <div className="sidebarRow">
            {/* if you pass a source, render a source, if oyu pass an icon render an icon */}
            {src && <Avatar src={src} /> }
            {Icon && <Icon /> }
            <h4>{title}</h4>
        </div>
    )
}

export default SidebarRows
