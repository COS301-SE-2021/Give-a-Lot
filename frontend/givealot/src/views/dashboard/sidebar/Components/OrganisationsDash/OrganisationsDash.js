// import React, { Component } from 'react'
// import "../../styles/Organisations.css"
//
// export class OrganisationsDash extends Component {
//
//     render() {
//         return (
//             <div className="organisations">
//                 orgs here
//             </div>
//         )
//     }
// }
//
// export default OrganisationsDash

import React from "react";
import { Link } from "react-router-dom";
import SearchIcon from "@material-ui/icons/Search";
import AddCircleOutlinedIcon from "@material-ui/icons/AddCircleOutlined";
import Card from '@material-ui/core/Card'
import CardActions from '@material-ui/core/CardActions'
import CardContent from '@material-ui/core/CardContent'
// import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button'
import Typography from '@material-ui/core/Typography'
import "../../styles/Organisations.css"

export default function OrganisationsDash() {
    return(
        <div className="OrganisationsDash">
            <div className="OrgAdd">
                <Link to={"/addOrg"} className="link">
                    <Button variant="contained" className="buttonAdd">
                        Add Organisation
                        <AddCircleOutlinedIcon/>
                    </Button>
                </Link>
                <div>
                    <div className="header__input">
                        <input placeholder="search organisation" type="text" />
                        <SearchIcon/>
                    </div>
                </div>
            </div>

            <div className="table">
                <Card style={{margin: "1em"}}>
                    <CardContent>
                        <Typography gutterBottom variant="headline" component="h4">
                            {/*<Avatar aria-label="recipe" >*/}
                            {/*    R*/}
                            {/*</Avatar>*/}
                            Organisation Name
                        </Typography>
                        <Typography style={{display: "flex", alignContent: "center", justifyContent: "space-between"}}>
                            <Typography>
                                <Typography component="p">
                                    Email
                                </Typography>
                                {/*<Typography component="p" secondary= "email" />*/}
                            </Typography>

                            <Typography component="p">
                                Contact Person
                            </Typography>
                            <Typography component="p">
                                Contact Number
                            </Typography>
                            <Typography component="p">
                                Sector
                            </Typography>
                            <Typography component="p">
                                Status
                            </Typography>
                        </Typography>
                    </CardContent>

                    <CardActions>
                        <Button size="small" color="primary"  target="_blank">
                            View
                        </Button>
                    </CardActions>
                </Card>
            </div>
        </div>
    );
}