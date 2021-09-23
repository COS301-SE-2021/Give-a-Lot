import React,{useState, createContext} from 'react';

export const ApiContext = createContext();

export const ApiUrlProvider = (props) => {
    let current_url = 'http://0948-105-208-196-136.ngrok.io'
    return(
        <ApiContext.Provider value={current_url}>
            {props.children}
        </ApiContext.Provider>
    )
}