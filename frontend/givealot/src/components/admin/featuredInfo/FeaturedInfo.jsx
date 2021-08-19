import React, { Component } from 'react'
import "./featuredInfo.css"
import PeopleIcon from '@material-ui/icons/People';
import axios from "axios";

export class FeaturedInfo extends Component {
    constructor(props) {
        super(props)

        this.state = {
            orgs:[],
            users: []
        }

    }
    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }
        axios.get('http://localhost:8080/v1/organisation/get/organisations/temporal',  config)
            .then(response =>{
                console.log(response)
                this.setState({orgs: response.data.response})
                console.log(this.state.orgs)
            })
            .catch(error =>{
                // console.log(error)
                this.setState({error : 'Error Retrieving data'})
            })

    }

    // getUsers(){
    //     let config = {
    //         headers: {
    //             "Content-Type": "application/json",
    //             'Access-Control-Allow-Origin': '*',
    //         }
    //     }
    //     const adminUsersRequestBody = {
    //         "adminUserEmail" : this.state.adminUserEmail
    //     }
    //     axios.post('http://localhost:8080/v1/user/get/users', adminUsersRequestBody ,config)
    //         .then(response =>{
    //             console.log(response)
    //             this.setState({users: response.data.response})
    //             console.log(this.state.users)
    //         })
    //         .catch(error =>{
    //             // console.log(error)
    //             this.setState({error : 'Error Retrieving data'})
    //         })
    // }

    render() {

        const { orgs , users} = this.state

        return (
            <div className="featuredA">
                <div className="featuredItemA">
                   <span className="featuredTitleA"> Users</span>
                   <div className="featuredMoneyContainerA">
                       <span className="featuredMoneyA">8</span>
                       <span className="featuredMoneyRateA">
                           <PeopleIcon className="featuredIconA"/>
                       </span>
                    </div> 
                    {/* <span className="featureSub">
                        compared to
                    </span> */}
                </div>

                <div className="featuredItemA">
                   <span className="featuredTitleA"> Organisations</span>
                   <div className="featuredMoneyContainerA">
                       <span className="featuredMoneyA">{orgs.length}</span>
                       <span className="featuredMoneyRateA">
                           <PeopleIcon className="featuredIconA"/>
                       </span>
                    </div> 
                    {/* <span className="featuredSub">
                        compared to
                    </span> */}
                </div>

                <div className="featuredItemA">
                   <span className="featuredTitleA"> Notifications</span>
                   <div className="featuredMoneyContainerA">
                       <span className="featuredMoneyA">0</span>
                       <span className="featuredMoneyRateA">
                           <PeopleIcon className="featuredIconA"/>
                       </span>
                    </div> 
                    {/* <span className="featureSub">
                        compared to
                    </span> */}
                </div>
            </div>
        )
    }
}

export default FeaturedInfo
