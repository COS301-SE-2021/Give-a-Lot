import React, { Component } from 'react'
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import DashboardIcon from '@material-ui/icons/Dashboard';
import PeopleIcon from '@material-ui/icons/People';
// import BarChartIcon from '@material-ui/icons/BarChart';
import AssignmentIcon from '@material-ui/icons/Assignment';
import { Link } from 'react-router-dom';
import MailOutlineIcon from '@material-ui/icons/MailOutline';
import CalendarTodayIcon from '@material-ui/icons/CalendarToday';
import DescriptionIcon from '@material-ui/icons/Description';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import "./Admin.css"
import logo from "./imagesRegister/ID2.png"
import { withStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';
import InboxIcon from '@material-ui/icons/MoveToInbox';
import DraftsIcon from '@material-ui/icons/Drafts';
import SendIcon from '@material-ui/icons/Send';
import Divider from '@material-ui/core/Divider';
import SettingsIcon from '@material-ui/icons/Settings';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';

const StyledMenu = withStyles({
    paper: {
        border: '1px solid #d3d4d5',
    },
})((props) => (
    <Menu
        elevation={0}
        getContentAnchorEl={null}
        anchorOrigin={{
            vertical: 'bottom',
            horizontal: 'center',
        }}
        transformOrigin={{
            vertical: 'top',
            horizontal: 'center',
        }}
        {...props}
    />
));

const StyledMenuItem = withStyles((theme) => ({
    root: {
        '&:focus': {
            backgroundColor: theme.palette.primary.main,
            '& .MuiListItemIcon-root, & .MuiListItemText-primary': {
                color: theme.palette.common.white,
            },
        },
    },
}))(MenuItem);

// export class AdminSidebar extends Component {
    export default function AdminSidebar() {

    // render() {
        const [anchorEl, setAnchorEl] = React.useState(null);

        const handleClick = (event) => {
            setAnchorEl(event.currentTarget);
        };

        const handleClose = () => {
            setAnchorEl(null);
        };
        return (
            <div>
                <div className="sidebar">
                    <div>
                        <img src={logo} alt="" className="imageAdmin"/>
                    </div>

                    <Link to={'/'} className='text-link active'>
                        <ListItem button>
                            <ListItemIcon>
                                <DashboardIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Dashboard" />
                        </ListItem>
                    </Link>
                    <Link to={'/adminUsers'} className='text-link' >
                        <ListItem button>
                            <ListItemIcon>
                                <PeopleIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="View Users" />
                        </ListItem>
                    </Link>

                    <Link to={'/adminOrganisations'} className='text-link' >
                        <ListItem button>
                            <ListItemIcon>
                                <PeopleIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="View Organisations" />
                        </ListItem>
                    </Link>

                    <Link to={'/emails'} className='text-link' >
                        <ListItem button>
                            <ListItemIcon>
                                <MailOutlineIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Emails" />
                        </ListItem>
                    </Link>

                    <Link to={'/calendar'} className='text-link'>
                        <ListItem button>
                            <ListItemIcon>
                                <CalendarTodayIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Calendar" />
                        </ListItem>
                    </Link>

                    <Link to={'/todos'} className='text-link'>
                        <ListItem button>
                            <ListItemIcon>
                                <AssignmentIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="TO-DO's" />
                        </ListItem>
                    </Link>

                    <Link to={'/settings'} className='text-link' >
                        <ListItem button>
                            <ListItemIcon>
                                <SettingsIcon className="icon"/>
                            </ListItemIcon >
                            <ListItemText primary="Settings" />
                        </ListItem>
                    </Link>
                    <Divider />

                    {/*<Link to={'/logout'} className='text-link'>*/}
                    <ListItem button
                              onClick={handleClick}
                              className='profile'
                    >
                        <ListItemIcon>
                            <AccountCircleIcon
                                className="icon"
                            />
                        </ListItemIcon>
                        <ListItemText primary="" />
                    </ListItem>
                    <StyledMenu
                        id="customized-menu"
                        anchorEl={anchorEl}
                        keepMounted
                        open={Boolean(anchorEl)}
                        onClose={handleClose}
                    >
                        <StyledMenuItem>
                            <ListItemIcon>
                                <SettingsIcon fontSize="small" />
                            </ListItemIcon>
                            <ListItemText primary="Settings" />
                        </StyledMenuItem>
                        <StyledMenuItem>
                            <ListItemIcon>
                                <InboxIcon fontSize="small" />
                            </ListItemIcon>
                            <ListItemText primary="inbox" />
                        </StyledMenuItem>
                        <StyledMenuItem>
                            <ListItemIcon>
                                <ExitToAppIcon fontSize="small" />
                            </ListItemIcon>
                            <ListItemText primary="Logout" />
                        </StyledMenuItem>
                    </StyledMenu>
                    {/*</Link>*/}
                </div>

            </div>

        )
    // }
}

// export default AdminSidebar