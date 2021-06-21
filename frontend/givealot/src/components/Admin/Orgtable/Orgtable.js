import React, { Component } from "react";

export default class Orgtable extends Component {
    render() {
        return (
            <div>
                <table className="table table-bordered" style={{position:"absolute", top: "100px", left:"300px", width:"800px"}}>
                <thead>
                    <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Certificate</th>
                    </tr>
                </thead>
                <tbody>
                    {/* loop */}
                    <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>
                        <button className="btn btn-primary" style={{margin:"0 4px"}}>Issue</button>
                        <button className="btn btn-primary" style={{margin:"0 4px"}}>Revoke</button>
                        <button className="btn btn-primary" style={{margin:"0 4px"}}>View</button>
                    </td>
                    </tr>
                </tbody>
                </table>
            </div>
        );
    }
}