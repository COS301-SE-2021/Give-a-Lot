// import React from 'react';
// import "./Cards.css";
// import { makeStyles } from '@material-ui/core/styles';
// import Card from '@material-ui/core/Card';
// import CardActions from '@material-ui/core/CardActions';
// import CardContent from '@material-ui/core/CardContent';
// import Button from '@material-ui/core/Button';
// import Typography from '@material-ui/core/Typography';

// const useStyles = makeStyles({
//     root: {
//       minWidth: 220,
//     },
//     bullet: {
//       display: 'inline-block',
//       margin: '0 2px',
//       transform: 'scale(0.8)',
//     },
//     title: {
//       fontSize: 14,
//     },
//     pos: {
//       marginBottom: 12,
//     },
//   });

// function Cards() {
//     const classes = useStyles();
// //   const bull = <span className={classes.bullet}>•</span>;

//     return (
//         <div className="cards">
//              <Card className={classes.root} variant="outlined">
//                 <CardContent>
//                     <Typography className={classes.title} color="textSecondary" gutterBottom>
//                     Org name
//                     </Typography>
//                     <Typography >
//                        Short description
//                     </Typography>
                    
//                 </CardContent>
//                 <CardActions>
//                     <Button size="small">Learn More</Button>
//                 </CardActions>
//             </Card>
            
//         </div>
//     )
// }

// export default Cards



import {
    Avatar,
    Box,
    Card,
    CardContent,
    Grid,
    Typography
  } from '@material-ui/core';
  import ArrowDownwardIcon from '@material-ui/icons/ArrowDownward';
  import MoneyIcon from '@material-ui/icons/Money';
  import { red } from '@material-ui/core/colors';
  
  const Cards = (props) => (
    <Card
      sx={{ height: '100%' }}
      {...props}
      className="card"
    >
      <CardContent  style={{backgroundColor:"#f4c7ab"}}>
      {/* <CardContent> */}
        <Grid
          container
          spacing={3}
          sx={{ justifyContent: 'space-between' }}
        >
          <Grid item>
            <Typography
              color="textSecondary"
              gutterBottom
              variant="h6"
            >
              Total Donations
            </Typography>
            <Typography
              color="textPrimary"
              variant="h3"
            >
              $24,000
            </Typography>
          </Grid>
          <Grid item>
            <Avatar
              sx={{
                backgroundColor: red[600],
                height: 56,
                width: 56
              }}
            >
              <MoneyIcon />
            </Avatar>
          </Grid>
        </Grid>
        <Box
          sx={{
            pt: 2,
            display: 'flex',
            alignItems: 'center'
          }}
        >
          <ArrowDownwardIcon sx={{ color: red[900] }} />
          <Typography
            sx={{
              color: red[900],
              mr: 1
            }}
            variant="body2"
          >
            12%
          </Typography>
          <Typography
            color="textSecondary"
            variant="caption"
          >
            Since last month
          </Typography>
        </Box>
      </CardContent>
    </Card>
  );
  
  export default Cards;
