import {Paper} from "@material-ui/core";
import Grid from "@material-ui/core/Grid";
import Avatar from "@material-ui/core/Avatar";
import Typography from "@material-ui/core/Typography";
import React from "react";

function SearchResults(props)
{
    return (
        <Paper id={"searchResults"}>
            <Grid container wrap="nowrap" spacing={2}>
                <Grid item>
                    <img src={""} />
                </Grid>
                <Grid item xs zeroMinWidth>
                    <Typography noWrap>{props.orgName}</Typography>
                    <Typography noWrap>{props.orgDescription}</Typography>
                </Grid>
            </Grid>
        </Paper>
    )
}

export default SearchResults;