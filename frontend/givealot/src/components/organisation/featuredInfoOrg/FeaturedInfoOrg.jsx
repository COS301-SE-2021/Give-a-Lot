import React, { Component } from 'react'
import "./featuredInfoOrg.css"
import PeopleIcon from '@material-ui/icons/People';
import axios from "axios";

export class FeaturedInfoOrg extends Component {
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
    render() {
        const { orgs , users} = this.state

        return (
            <div className="featuredOrg">
                <div className="featuredItemOrg">
                   <span className="featuredTitleOrg"> Users</span>
                   <div className="featuredMoneyContainerOrg">
                       <span className="featuredMoneyOrg">8</span>
                       <span className="featuredMoneyRateOrg">
                           <PeopleIcon className="featuredIconOrg"/>
                       </span>
                    </div> 
                    {/* <span className="featureSub">
                        compared to
                    </span> */}
                </div>

                <div className="featuredItemOrg">
                   <span className="featuredTitleOrg"> Organisations</span>
                   <div className="featuredMoneyContainerOrg">
                       <span className="featuredMoneyOrg">{orgs.length}</span>
                       <span className="featuredMoneyRateOrg">
                           <PeopleIcon className="featuredIconOrg"/>
                       </span>
                    </div> 
                    {/* <span className="featuredSub">
                        compared to
                    </span> */}
                </div>

                <div className="featuredItemOrg">
                   <span className="featuredTitleOrg"> Notifications</span>
                   <div className="featuredMoneyContainerOrg">
                       <span className="featuredMoneyOrg">0</span>
                       <span className="featuredMoneyRateOrg">
                           <PeopleIcon className="featuredIconOrg"/>
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

export default FeaturedInfoOrg
