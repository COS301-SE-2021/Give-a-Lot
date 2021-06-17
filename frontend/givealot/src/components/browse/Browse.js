import React from 'react';
import "./Browse.css";
import BrowseBody from "./BrowseBody";
import BrowseNav from "./BrowseNav";

function Browse() {
    return (
        <div className="browse">

            <div>
                <BrowseNav />
            </div>
            <div>
                <BrowseBody />
            </div>
        </div>
    )
}

export default Browse