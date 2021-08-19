import React, { Component } from 'react'
import "./todos.css"
import data from "./Dataset.json"
import Board from "react-trello";
export class Todos extends Component {

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

export default Todos