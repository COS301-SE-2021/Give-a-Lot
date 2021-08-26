import React, { Component } from 'react'
import "../../styles/Organisations.css"
import OrganisationsBody from "./OrganisationsBody";
import SearchIcon from '@material-ui/icons/Search';
import AddCircleOutlinedIcon from '@material-ui/icons/AddCircleOutlined';

export class Organisations extends Component {

    render() {
        return (
            <div className="organisations">
                <div className="OrgWrapper">
                    <div className="OrgSearch">
                        <div className="header__input">
                            <input placeholder="search organisation..." type="text" />
                            <SearchIcon/>
                        </div>
                    </div>
                    <div className="OrgAdd">
                        Add Organisation
                        <AddCircleOutlinedIcon/>
                    </div>
                    <div className="OrgBody">
                        <OrganisationsBody />
                        <OrganisationsBody />
                        <OrganisationsBody />
                    </div>
                </div>
            </div>
        )
    }
}

export default Organisations