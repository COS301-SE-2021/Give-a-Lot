import React, { Component } from 'react'
import "./OrgTodo.css"
import data from "./Dataset.json"
import Board from "react-trello";
export class OrgTodo extends Component {

    render() {
        return (
            <div className="todo">
                <Board
                    data={data}
                    draggable
                    editable
                    canAddLanes
                    addLaneTitle="Add Column"
                    addCardTitle="Add Item"
                />
            </div>
        )
    }
}

export default OrgTodo
