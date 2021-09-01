import React from 'react';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import "./DashHeader.css"

function DashHeader()
{
    return(
        <div className="DashHeader">
            <div className="dashHeader">
                <CardContent>
                    <Typography>
                        Word of the Day
                    </Typography>
                </CardContent>

            </div>
        </div>
    );
}

export default DashHeader;