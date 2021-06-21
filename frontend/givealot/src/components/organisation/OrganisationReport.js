import React, { Component } from 'react'
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import OrgReportForm from './OrgReportForm';
import axios from 'axios';

const useStyles = makeStyles((theme) => ({
    appBar: {
        position: 'relative',
    },
    layout: {
        width: 'auto',
        marginLeft: theme.spacing(2),
        marginRight: theme.spacing(2),
        [theme.breakpoints.up(600 + theme.spacing(2) * 2)]: {
            width: 700,
            marginLeft: 'auto',
            marginRight: 'auto',
        },
    },
    paper: {
        marginTop: theme.spacing(3),
        marginBottom: theme.spacing(3),
        padding: theme.spacing(2),
        [theme.breakpoints.up(600 + theme.spacing(3) * 2)]: {
            marginTop: theme.spacing(6),
            marginBottom: theme.spacing(6),
            padding: theme.spacing(3),
        },
    },

    buttons: {
        display: 'flex',
        justifyContent: 'flex-end',
    },
    button: {
        marginTop: theme.spacing(3),
        marginLeft: theme.spacing(1),
    },
}));
class OrganisationReport extends Component {
// export default function OrganisationReport() {
    // const classes = useStyles();

    constructor(props) {
        super(props)

        this.state = {
            users: [],
            //org_id: "",
           // org_name: "",
           // org_description: ""
        }
    }

    componentDidMount(){
        axios.post('http://localhost:8080/organisation/get')
        .then(response =>{
            console.log(response)
            this.setState({users: response.data})
        })
        .catch(error =>{
            console.log(error)
            this.setState({error : 'Error Retrieving data'})
        })
    }

render() {
    const {  users} = this.state
    return (
        <React.Fragment>
            <main className="">
                <Paper className="">
                    <Typography component="h1" variant="h4" align="center" style={{color: "black", border:"5px solid #3f51b5"}} >
                        Report Organisation
                    </Typography>

                    <Typography component="h1" variant="h4" align="center" >
                        {users.org_name}
                        {/*{
                            users.length ?
                                users.map(user => <div >{user.org_name}</div>):
                                null
                        }*/}
                        name goes here
                    </Typography>
                    

                    <React.Fragment>
                        <OrgReportForm />

                    </React.Fragment>
                </Paper>

            </main>
        </React.Fragment>
    );
}
}

export default OrganisationReport