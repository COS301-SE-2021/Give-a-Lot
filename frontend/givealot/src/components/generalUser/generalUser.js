import React, { Component } from "react";
import Navbar from "../../components/GeneralUser/Navbar/Navbar";
import { Button } from 'react-bootstrap';
import { Form } from 'react-bootstrap';
import { FormControl } from 'react-bootstrap';
import { InputGroup } from 'react-bootstrap';

export default class GeneralUser extends Component {
    render() {
        return (
            <div className="">
                <Navbar />
                <h1 style={{position: "absolute", left: "450px", top: "200px"}}>
                    Search for an Organisation
                </h1>
                {/* <form style={{position: "absolute", left: "450px", top: "300px"}} action="/" method="get"> */}
                {/* <Form style={{position: "absolute", left: "450px", top: "300px"}} inline>
                    <FormControl type="text" placeholder="Search" className=" mr-sm-2" />
                    <Button type="submit">Submit</Button>
                </Form> */}
                {/* </form> */}

                <InputGroup style={{position: "absolute", left: "450px", top: "300px", width:"500px"}}>
                    <FormControl
                    placeholder="Search Organisation"
                    aria-label="Search Organisation"
                    aria-describedby="basic-addon2"
                    />
                    <InputGroup.Append>
                    <Button variant="outline-secondary">Search</Button>
                    </InputGroup.Append>
                </InputGroup>
            </div>
        );
    }
}