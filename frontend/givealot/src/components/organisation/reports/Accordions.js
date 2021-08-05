import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Accordion from '@material-ui/core/Accordion';
import AccordionDetails from '@material-ui/core/AccordionDetails';
import AccordionSummary from '@material-ui/core/AccordionSummary';
import Typography from '@material-ui/core/Typography';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import Button from '@material-ui/core/Button';
import Divider from '@material-ui/core/Divider';
import ReportIcon from '@material-ui/icons/Report';
import AccordionActions from '@material-ui/core/AccordionActions';

const useStyles = makeStyles((theme) => ({
    root: {
        width: '100%',
        padding:  '7px 20px',
    },
    heading: {
        fontSize: theme.typography.pxToRem(15),
        flexBasis: '33.33%',
        flexShrink: 0,

    },
    secondaryHeading: {
        fontSize: theme.typography.pxToRem(15),
        color: theme.palette.text.secondary,
    },
}));

export default function Accordions({id,title, description}) {
    const classes = useStyles();
    const [expanded, setExpanded] = React.useState(false);

    const handleChange = (panel) => (event, isExpanded) => {
        setExpanded(isExpanded ? panel : false);
    };

    return (
        <div className={classes.root}>


            <Accordion expanded={expanded === 'panel2'} onChange={handleChange('panel2')}>
                <AccordionSummary
                    expandIcon={<ExpandMoreIcon />}
                    aria-controls="panel2bh-content"
                    id="panel2bh-header"
                >
                    <Typography className={classes.heading}>
                        <ReportIcon className="iconReport"/>
                        {id}
                    </Typography>

                    <Typography className={classes.secondaryHeading}>
                        {title}
                    </Typography>
                </AccordionSummary>
                <AccordionDetails>
                    <Typography>
                        {description}
                    </Typography>
                </AccordionDetails>
                <Divider />
                <AccordionActions>
                    <Button size="small">Cancel</Button>
                    <button size="small" className="AppealButton">
                        Appeal
                    </button>
                </AccordionActions>
            </Accordion>
        </div>
    );
}
