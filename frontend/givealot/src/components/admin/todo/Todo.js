import React, { Component } from 'react'
import "./Todo.css"
import data from "./Dataset.json"
import Board from "react-trello";
export class Todo extends Component {

    render() {
        return (
            <div className="todos">
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

export default Todo
