import React, { Component } from 'react'
import "./Validate.css"
import Grid from "@material-ui/core/Grid";
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import axios from "axios";
import DialogTitle from "@material-ui/core/DialogTitle";
import DialogContent from "@material-ui/core/DialogContent";
import Dialog from "@material-ui/core/Dialog";

export class OrgValidate extends Component {

    constructor(props) {
        super(props)
        this.state = {
            validation:{},
            error: "",
            openValid: false,
            openValidDate: false,
            openNgoNumber: false,
            openNgoNumberDeny: false,
            openNgoImage: false,
            openNgoImageDeny: false,
            orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1],
            adminId: localStorage.getItem("id"),
            serverDomain: "http://localhost:8080"
        }
    }
    handleClose = () => {
        this.setState({ openValid: false });

    }
    handleCloseDate = () => {
        this.setState({ openValidDate: false });
    }

    handleCloseNgoNumber = () => {
        this.setState({ openNgoNumber: false });
    }
    handleCloseNgoNumberDeny = () => {
        this.setState({ openNgoNumberDeny: false });
    }
    handleCloseNgoImage = () => {
        this.setState({ openNgoImage: false });
    }
    handleCloseNgoImageDeny = () => {
        this.setState({ openNgoImageDeny: false });
    }

    acceptNgoDate() {
        this.setState({ openValid: true });
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+this.state.adminId+ '/ngo_date/true', config)
            .then(response =>{
                console.log(response)
                // console.log(this.state.validation)
                // this.setState({ validation: {} });

            })
            .catch(error =>{
                console.log(error)
            })
    }
    denyNgoDate(){
        this.setState({ openValidDate: true });
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/ngo_date/false', config)
            .then(response =>{
                // console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    acceptNgoNumber(){
        this.setState({ openNgoNumber: true });
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/ngo_number/true', config)
            .then(response =>{
                // console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }


    denyNgoNumber(){
        this.setState({ openNgoNumberDeny: true });
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/ngo_number/false', config)
            .then(response =>{
                // console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    acceptNgoImage(){
        this.setState({ openNgoImage: true });
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/image/true', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    denyNgoImage(){

        this.setState({ openNgoImageDeny: true });
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/image/false', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    acceptNgoWebsite(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/website/true', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    denyNgoWebsite(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/website/false', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    acceptNgoAddress(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/address/true', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    denyNgoAddress(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/address/false', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    acceptNgoEstablish(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/establishment_date/true', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    denyNgoEstablish(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/establishment_date/false', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    acceptNgoDonateUrl(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/donation_url/true', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    denyNgoDonateUrl(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/donation_url/false', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    acceptNgoQrUrl(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/qrCodeUrl/true', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    denyNgoQrUrl(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/qrCodeUrl/false', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }


    acceptCommitteeDetails(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/committee_details/true', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    denyCommitteeDetails(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/committee_details/false', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    acceptSocialMedia1(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/socialMedia1/true', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    denySocialMedia1(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/socialMedia1/false', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    acceptSocialMedia2(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/socialMedia2/true', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    denySocialMedia2(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/socialMedia2/false', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    acceptAuditDocument(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/audit_document/true', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    denyAuditDocument(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/audit_document/false', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }


    acceptImages(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/images/true', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    denyImages(){
        this.setState({ orgId: window.location.pathname.split('/')[window.location.pathname.split('/').length - 1] });
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        axios.put('http://localhost:8080/v1/organisation/delete/validity/confirm/'+this.state.orgId+ '/'+ this.state.adminId+ '/images/false', config)
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    componentDidMount(){
        let config = {
            headers: {
                "Content-Type": "application/json",
                'Access-Control-Allow-Origin': '*',
            }
        }

        const adminUsersRequestBody = {
            "orgId":this.state.orgId
        }

        axios.post('http://localhost:8080/v1/notifications/get/level_information', adminUsersRequestBody ,config)
            .then(response =>{
                // console.log(response)
                this.setState({validation: response.data.object})
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    render() {
        const { validation } = this.state

        const orgValidating = () => {
            if (validation.level === 1) {
                return (
                    <div className="table">
                        <Card style={{margin: "1em", width: "100%"}}>
                            <CardContent>
                                <Typography className="valid">
                                    <Typography style={{display: "flex"}}>
                                        <div>
                                            Ngo Date:
                                        </div>
                                        <div style={{marginLeft: "1em"}}>
                                            {validation.ngoDate}
                                        </div>
                                    </Typography>
                                    <Typography style={{
                                        display: "flex",
                                        alignItems: "center",
                                        justifyContent: "space-between"
                                    }}>
                                        <Grid>
                                            <Button variant="contained" className="buttonValidViewAccept"
                                                    onClick={this.acceptNgoDate.bind(this)}
                                            >
                                                Accept
                                            </Button>
                                            <Dialog onClose={this.handleClose.bind(this)} open={this.state.openValid}>
                                                <DialogTitle>NGO Date accepted</DialogTitle>
                                                <DialogContent>
                                                    <Button variant="contained" color="primary"
                                                            onClick={this.handleClose.bind(this)}
                                                            style={{paddingTop: "0.5em", paddingBottom: "0.5em"}}
                                                    >
                                                        Close
                                                    </Button>
                                                </DialogContent>
                                            </Dialog>
                                        </Grid>
                                        <Grid style={{marginLeft: "1em"}}>
                                            <Button variant="contained" className="buttonValidViewDeny"
                                                    onClick={this.denyNgoDate.bind(this)}
                                                >
                                                Deny
                                            </Button>
                                        </Grid>
                                        <Dialog onClose={this.handleCloseDate.bind(this)} open={this.state.openValidDate}>
                                            <DialogTitle>NGO Date Denied</DialogTitle>
                                            <DialogContent>
                                                <Button variant="contained" color="primary"
                                                        onClick={this.handleCloseDate.bind(this)}
                                                        style={{paddingTop: "0.5em", paddingBottom: "0.5em"}}
                                                >
                                                    Close
                                                </Button>
                                            </DialogContent>
                                        </Dialog>
                                    </Typography>
                                </Typography>
                            </CardContent>
                        </Card>

                        <Card style={{margin: "1em", width: "100%"}}>
                            <CardContent>
                                <Typography className="valid">
                                    <Typography style={{display: "flex"}}>
                                        <div>
                                            Ngo Number:
                                        </div>
                                        <div style={{marginLeft: "1em"}}>
                                            {validation.ngoNumber}
                                        </div>
                                    </Typography>
                                    <Typography style={{
                                        display: "flex",
                                        alignItems: "center",
                                        justifyContent: "space-between"
                                    }}>
                                        <Grid>
                                            <Button variant="contained" className="buttonValidViewAccept"
                                                    onClick={this.acceptNgoNumber.bind(this)}
                                            >
                                                Accept
                                            </Button>
                                            <Dialog onClose={this.handleCloseNgoNumber.bind(this)} open={this.state.openNgoNumber}>
                                                <DialogTitle>NGO Number Accepted</DialogTitle>
                                                <DialogContent>
                                                    <Button variant="contained" color="primary"
                                                            onClick={this.handleCloseNgoNumber.bind(this)}
                                                            style={{paddingTop: "0.5em", paddingBottom: "0.5em"}}
                                                    >
                                                        Close
                                                    </Button>
                                                </DialogContent>
                                            </Dialog>
                                        </Grid>
                                        <Grid style={{marginLeft: "1em"}}>
                                            <Button variant="contained" className="buttonValidViewDeny"
                                                    onClick={this.denyNgoNumber.bind(this)}
                                            >
                                                Deny
                                            </Button>
                                            <Dialog onClose={this.handleCloseNgoNumberDeny.bind(this)} open={this.state.openNgoNumberDeny}>
                                                <DialogTitle>NGO Number Denied</DialogTitle>
                                                <DialogContent>
                                                    <Button variant="contained" color="primary"
                                                            onClick={this.handleCloseNgoNumberDeny.bind(this)}
                                                            style={{paddingTop: "0.5em", paddingBottom: "0.5em"}}
                                                    >
                                                        Close
                                                    </Button>
                                                </DialogContent>
                                            </Dialog>
                                        </Grid>
                                    </Typography>
                                </Typography>
                            </CardContent>
                        </Card>

                        <Card style={{margin: "1em", width: "100%"}}>
                            <CardContent>
                                <Typography className="valid">
                                    <Typography style={{display: "flex"}}>
                                        <div>
                                            Ngo Image:
                                        </div>
                                        <div style={{marginLeft: "1em"}}>
                                            <img src={validation.url}/>
                                        </div>

                                    </Typography>
                                    <Typography style={{
                                        display: "flex",
                                        alignItems: "center",
                                        justifyContent: "space-between"
                                    }}>
                                        <Grid>
                                            <Button variant="contained" className="buttonValidViewAccept"
                                                    onClick={this.acceptNgoImage.bind(this)}
                                            >
                                                Accept
                                            </Button>
                                            <Dialog onClose={this.handleCloseNgoImage.bind(this)} open={this.state.openNgoImage}>
                                                <DialogTitle>NGO Image accepted</DialogTitle>
                                                <DialogContent>
                                                    <Button variant="contained" color="primary"
                                                            onClick={this.handleCloseNgoImage.bind(this)}
                                                            style={{paddingTop: "0.5em", paddingBottom: "0.5em"}}
                                                    >
                                                        Close
                                                    </Button>
                                                </DialogContent>
                                            </Dialog>
                                        </Grid>
                                        <Grid style={{marginLeft: "1em"}}>
                                            <Button variant="contained" className="buttonValidViewDeny"
                                                    onClick={this.denyNgoImage.bind(this)}
                                            >
                                                Deny
                                            </Button>
                                            <Dialog onClose={this.handleCloseNgoImageDeny.bind(this)} open={this.state.openNgoImageDeny}>
                                                <DialogTitle>NGO Image Denied</DialogTitle>
                                                <DialogContent>
                                                    <Button variant="contained" color="primary"
                                                            onClick={this.handleCloseNgoImageDeny.bind(this)}
                                                            style={{paddingTop: "0.5em", paddingBottom: "0.5em"}}
                                                    >
                                                        Close
                                                    </Button>
                                                </DialogContent>
                                            </Dialog>
                                        </Grid>
                                    </Typography>
                                </Typography>
                            </CardContent>
                        </Card>
                    </div>
                );
            } else if(validation.level === 2){
                return (
                    <div className="table">
                        <Card style={{margin: "1em", width: "100%"}}>
                            <CardContent>
                                <Typography className="valid">
                                    <Typography>
                                        <div>
                                            Website:
                                        </div>
                                        <div style={{marginLeft: "1em"}}>
                                            {validation.website}
                                        </div>
                                    </Typography>
                                    <Typography style={{
                                        display: "flex",
                                        alignItems: "center",
                                        justifyContent: "space-between"
                                    }}>
                                        <Grid>
                                            <Button variant="contained" className="buttonValidViewAccept"
                                                    onClick={this.acceptNgoWebsite.bind(this)}
                                            >
                                                Accept
                                            </Button>
                                        </Grid>
                                        <Grid style={{marginLeft: "1em"}}>
                                            <Button variant="contained" className="buttonValidViewDeny"
                                                    onClick={this.denyNgoWebsite.bind(this)}
                                            >
                                                Deny
                                            </Button>
                                        </Grid>
                                    </Typography>
                                </Typography>
                            </CardContent>
                        </Card>

                        <Card style={{margin: "1em", width: "100%"}}>
                            <CardContent>
                                <Typography className="valid">
                                    <Typography>
                                        <div>
                                            Address:
                                        </div>
                                        <div style={{marginLeft: "1em"}}>
                                            {validation.address}
                                        </div>
                                    </Typography>
                                    <Typography style={{
                                        display: "flex",
                                        alignItems: "center",
                                        justifyContent: "space-between"
                                    }}>
                                        <Grid>
                                            <Button variant="contained" className="buttonValidViewAccept"
                                                    onClick={this.acceptNgoAddress.bind(this)}
                                            >
                                                Accept
                                            </Button>
                                        </Grid>
                                        <Grid style={{marginLeft: "1em"}}>
                                            <Button variant="contained" className="buttonValidViewDeny"
                                                onClick={this.denyNgoAddress.bind(this)}
                                            >
                                                Deny
                                            </Button>
                                        </Grid>
                                    </Typography>
                                </Typography>
                            </CardContent>
                        </Card>
                    </div>
                );
            }else if(validation.level === 3){
                return (
                    <div className="table">
                        <Card style={{margin: "1em", width: "100%"}}>
                            <CardContent>
                                <Typography className="valid">
                                    <Typography>
                                        <div>
                                            Establishment Date:
                                        </div>
                                        <div style={{marginLeft: "1em"}}>
                                            {validation.establishementDate}
                                        </div>
                                    </Typography>
                                    <Typography style={{
                                        display: "flex",
                                        alignItems: "center",
                                        justifyContent: "space-between"
                                    }}>
                                        <Grid>
                                            <Button variant="contained" className="buttonValidViewAccept"
                                                    onClick={this.acceptNgoEstablish.bind(this)}
                                            >
                                                Accept
                                            </Button>
                                        </Grid>
                                        <Grid style={{marginLeft: "1em"}}>
                                            <Button variant="contained" className="buttonValidViewDeny"
                                                    onClick={this.denyNgoEstablish.bind(this)}
                                            >
                                                Deny
                                            </Button>
                                        </Grid>
                                    </Typography>
                                </Typography>
                            </CardContent>
                        </Card>

                        <Card style={{margin: "1em", width: "100%"}}>
                            <CardContent>
                                <Typography className="valid">
                                    <Typography>
                                        <div>
                                            Donation Url:
                                        </div>
                                        <div style={{marginLeft: "1em"}}>
                                            {validation.donation_url}
                                        </div>
                                    </Typography>
                                    <Typography style={{
                                        display: "flex",
                                        alignItems: "center",
                                        justifyContent: "space-between"
                                    }}>
                                        <Grid>
                                            <Button variant="contained" className="buttonValidViewAccept"
                                                    onClick={this.acceptNgoDonateUrl.bind(this)}
                                            >
                                                Accept
                                            </Button>
                                        </Grid>
                                        <Grid style={{marginLeft: "1em"}}>
                                            <Button variant="contained" className="buttonValidViewDeny"
                                                onClick={this.denyNgoDonateUrl.bind(this)}
                                            >
                                                Deny
                                            </Button>
                                        </Grid>
                                    </Typography>
                                </Typography>
                            </CardContent>
                        </Card>

                        <Card style={{margin: "1em", width: "100%"}}>
                            <CardContent>
                                <Typography className="valid">
                                    <Typography>
                                        <div>
                                            QR code Url:
                                        </div>
                                        <div style={{marginLeft: "1em"}}>
                                            {validation.qrCodeUrl}
                                        </div>
                                    </Typography>
                                    <Typography style={{
                                        display: "flex",
                                        alignItems: "center",
                                        justifyContent: "space-between"
                                    }}>
                                        <Grid>
                                            <Button variant="contained" className="buttonValidViewAccept"
                                                    onClick={this.acceptNgoQrUrl.bind(this)}
                                            >
                                                Accept
                                            </Button>
                                        </Grid>
                                        <Grid style={{marginLeft: "1em"}}>
                                            <Button variant="contained" className="buttonValidViewDeny"
                                                onClick={this.denyNgoQrUrl.bind(this)}
                                            >
                                                Deny
                                            </Button>
                                        </Grid>
                                    </Typography>
                                </Typography>
                            </CardContent>
                        </Card>
                    </div>
                );
            }else if(validation.level === 4){
                return (
                    <div className="table">
                        <Card style={{margin: "1em", width: "100%"}}>
                            <CardContent>
                                <Typography className="valid">
                                    <Typography>
                                        <div>
                                            Commitee Details:
                                        </div>
                                        <div style={{marginLeft: "1em"}}>
                                            {validation.committee_details}
                                        </div>

                                    </Typography>
                                    <Typography style={{
                                        display: "flex",
                                        alignItems: "center",
                                        justifyContent: "space-between"
                                    }}>
                                        <Grid>
                                            <Button variant="contained" className="buttonValidViewAccept"
                                                    onClick={this.acceptCommitteeDetails.bind(this)}
                                            >
                                                Accept
                                            </Button>
                                        </Grid>
                                        <Grid style={{marginLeft: "1em"}}>
                                            <Button variant="contained" className="buttonValidViewDeny"
                                                    onClick={this.denyCommitteeDetails.bind(this)}
                                                >
                                                Deny
                                            </Button>
                                        </Grid>
                                    </Typography>
                                </Typography>
                            </CardContent>
                        </Card>

                        <Card style={{margin: "1em", width: "100%"}}>
                            <CardContent>
                                <Typography className="valid">
                                    <Typography>
                                        <div>
                                            Social Media 1:
                                        </div>
                                        <div style={{marginLeft: "1em"}}>
                                            {validation.socialMedia1}
                                        </div>

                                    </Typography>
                                    <Typography style={{
                                        display: "flex",
                                        alignItems: "center",
                                        justifyContent: "space-between"
                                    }}>
                                        <Grid>
                                            <Button variant="contained" className="buttonValidViewAccept"
                                                    onClick={this.acceptSocialMedia1.bind(this)}
                                            >
                                                Accept
                                            </Button>
                                        </Grid>
                                        <Grid style={{marginLeft: "1em"}}>
                                            <Button variant="contained" className="buttonValidViewDeny"
                                                    onClick={this.denySocialMedia1.bind(this)}
                                            >
                                                Deny
                                            </Button>
                                        </Grid>
                                    </Typography>
                                </Typography>
                            </CardContent>
                        </Card>

                        <Card style={{margin: "1em", width: "100%"}}>
                            <CardContent>
                                <Typography className="valid">
                                    <Typography>
                                        <div>
                                            Social Media 2:
                                        </div>
                                        <div style={{marginLeft: "1em"}}>
                                            {validation.socialMedia2}
                                        </div>

                                    </Typography>
                                    <Typography style={{
                                        display: "flex",
                                        alignItems: "center",
                                        justifyContent: "space-between"
                                    }}>
                                        <Grid>
                                            <Button variant="contained" className="buttonValidViewAccept"
                                                    onClick={this.acceptSocialMedia2.bind(this)}
                                            >
                                                Accept
                                            </Button>
                                        </Grid>
                                        <Grid style={{marginLeft: "1em"}}>
                                            <Button variant="contained" className="buttonValidViewDeny"
                                                    onClick={this.denySocialMedia2.bind(this)}
                                            >
                                                Deny
                                            </Button>
                                        </Grid>
                                    </Typography>
                                </Typography>
                            </CardContent>
                        </Card>
                    </div>
                );
            }
            else if(validation.level === 5){
                return (
                    <div className="table">
                        <Card style={{margin: "1em", width: "100%"}}>
                            <CardContent>
                                <Typography className="valid">
                                    <Typography>
                                        <div>
                                            Audit Document:
                                        </div>
                                        <div style={{marginLeft: "1em"}}>
                                            {validation.audit_document}
                                        </div>
                                    </Typography>
                                    <Typography style={{
                                        display: "flex",
                                        alignItems: "center",
                                        justifyContent: "space-between"
                                    }}>
                                        <Grid>
                                            <Button variant="contained" className="buttonValidViewAccept"
                                                    onClick={this.acceptAuditDocument.bind(this)}
                                            >
                                                Accept
                                            </Button>
                                        </Grid>
                                        <Grid style={{marginLeft: "1em"}}>
                                            <Button variant="contained" className="buttonValidViewDeny"
                                                    onClick={this.denyAuditDocument.bind(this)}
                                                >
                                                Deny
                                            </Button>
                                        </Grid>
                                    </Typography>
                                </Typography>
                            </CardContent>
                        </Card>

                        <Card style={{margin: "1em", width: "100%"}}>
                            <CardContent>
                                <Typography className="valid">
                                    <Typography>
                                        <div>
                                            Images:
                                        </div>
                                        <div style={{marginLeft: "1em"}}>
                                            <img src={validation.images}/>
                                        </div>
                                    </Typography>
                                    <Typography style={{
                                        display: "flex",
                                        alignItems: "center",
                                        justifyContent: "space-between"
                                    }}>
                                        <Grid>
                                            <Button variant="contained" className="buttonValidViewAccept"
                                                    onClick={this.acceptImages.bind(this)}
                                            >
                                                Accept
                                            </Button>
                                        </Grid>
                                        <Grid style={{marginLeft: "1em"}}>
                                            <Button variant="contained" className="buttonValidViewDeny"
                                                    onClick={this.denyImages.bind(this)}
                                            >
                                                Deny
                                            </Button>
                                        </Grid>
                                    </Typography>
                                </Typography>
                            </CardContent>
                        </Card>
                    </div>
                );
            }
            else{
                return (<div className="table">
                    <Card style={{margin: "1em", width: "100%"}}>
                        <CardContent>
                            <Typography className="valid">
                                <Typography>
                                   No Information to update
                                </Typography>
                            </Typography>
                        </CardContent>
                    </Card>
                </div>);
            }
        }

        return (
            <div className="validate">
                <div className="validBody">
                    <div  className="name">
                        {validation.orgName}
                    </div>
                    {orgValidating()}
                </div>
            </div>
        )
    }
}

export default OrgValidate
