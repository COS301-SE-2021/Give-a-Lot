import React, { Component } from 'react'
import { withStyles } from "@material-ui/core/styles";
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
// import profile from "./imagesRegister/profile.jpg";
import "./Admin.css"
import {Redirect} from "react-router-dom";


const styles = theme =>({
    root: {
        maxWidth: 345,
    },
    media: {
        height: 140,
    },
});
export class LogOut extends Component {

    state={
        navigate: false
    };


    logout=()=>{
        localStorage.clear("token");
        this.setState({navigate:true});

    };
    render() {

        const { navigate}=this.state;
        const {classes} = this.props;
        if(navigate){
            return <Redirect to="/" push={true} />;
        }
        return (
                <div className="logout">

                    <Card className={classes.root}>
                        <CardActionArea>
                            <CardMedia
                                className={classes.media}
                                image="/imagesRegister/profile.jpg"
                                title="Contemplative Reptile"
                            />
                            <CardContent>
                                <Typography gutterBottom variant="h5" component="h2">
                                    User name
                                </Typography>
                                <Typography variant="body2" color="textSecondary" component="p">
                                   Are you sure you want to log out?,
                                    You can always log back in at any time.
                                </Typography>
                            </CardContent>
                        </CardActionArea>
                        <CardActions>
                            <Button size="small" color="primary" onClick={this.logout}>
                                Logout
                            </Button>

                        </CardActions>
                    </Card>


            </div>
        )
    }
}

export default withStyles(styles, { withTheme: true })(LogOut);

