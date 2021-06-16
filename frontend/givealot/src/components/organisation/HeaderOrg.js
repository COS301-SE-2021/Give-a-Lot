import React from 'react';
// import "./Header.css";
// import { useState } from 'react';
// import { Link as RouterLink } from 'react-router-dom';
// import PropTypes from 'prop-types';
import {
  AppBar,
  Box,
  Toolbar
} from '@material-ui/core';
// import MenuIcon from '@material-ui/icons/Menu';
// import NotificationsIcon from '@material-ui/icons/NotificationsOutlined';
// import InputIcon from '@material-ui/icons/Input';
// import logo from './logo.png';
import "./HeaderOrg.css";
// import { fade, makeStyles } from '@material-ui/core/styles';
// import AppBar from '@material-ui/core/AppBar';
// import Toolbar from '@material-ui/core/Toolbar';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';
// import InputBase from '@material-ui/core/InputBase';
// import Badge from '@material-ui/core/Badge';
// import MenuItem from '@material-ui/core/MenuItem';
// import Menu from '@material-ui/core/Menu';
import MenuIcon from '@material-ui/icons/Menu';
import SearchIcon from '@material-ui/icons/Search';
// import AccountCircle from '@material-ui/icons/AccountCircle';
// import MailIcon from '@material-ui/icons/Mail';
// import NotificationsIcon from '@material-ui/icons/Notifications';
// import MoreIcon from '@material-ui/icons/MoreVert';

const HeaderOrg = () => {
    return (
        <AppBar position="static" className="appbar">
            <Toolbar>
            <IconButton
                edge="start"
                className=""
                color="inherit"
                aria-label="open drawer"
            >
                <MenuIcon />
                </IconButton>
                <Typography className="" variant="h6" noWrap>
                    Give A Lot
                </Typography>
                <div className="head">
                    <SearchIcon/>
                    <input placeholder="search" type="text" />
                </div>
            </Toolbar>
        </AppBar>

    )
}

export default HeaderOrg
