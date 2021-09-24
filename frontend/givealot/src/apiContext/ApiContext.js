import React,{useState, createContext} from 'react';

export const ApiContext = createContext();

export const ApiUrlProvider = (props) => {
    let current_url = 'http://localhost:8080'
    return(
        <ApiContext.Provider value={current_url}>
            {props.children}
        </ApiContext.Provider>
    )
}