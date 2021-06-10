import React from 'react';
import "./AdminBodyUser.css";
import SearchIcon from '@material-ui/icons/Search';
import PropTypes from 'prop-types';
import { makeStyles } from '@material-ui/core/styles';
import Box from '@material-ui/core/Box';
import Collapse from '@material-ui/core/Collapse';
import IconButton from '@material-ui/core/IconButton';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Typography from '@material-ui/core/Typography';
import Paper from '@material-ui/core/Paper';
import KeyboardArrowDownIcon from '@material-ui/icons/KeyboardArrowDown';
import KeyboardArrowUpIcon from '@material-ui/icons/KeyboardArrowUp';
import Button from '@material-ui/core/Button';
import Header from "./Header";


const useRowStyles = makeStyles({
  root: {
    '& > *': {
      borderBottom: 'unset',
    },
  },
});

function createData(name, email, donation, datejoined, status) {
  return {
    name,
    email,
    donation,
    datejoined,
    status,
  };
}

function Row(props) {
  const { row } = props;
  const [open, setOpen] = React.useState(false);
  const classes = useRowStyles();

  return (
    <React.Fragment>
      <TableRow className={classes.root}>
        <TableCell>
          <IconButton aria-label="expand row" size="small" onClick={() => setOpen(!open)}>
            {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
          </IconButton>
        </TableCell>
        <TableCell component="th" scope="row">
          {row.name}
        </TableCell>
        <TableCell align="right">{row.email}</TableCell>
        <TableCell align="right">{row.donation}</TableCell>
        <TableCell align="right">{row.datejoined}</TableCell>
        <TableCell align="right">{row.status}</TableCell>
      </TableRow>
      <TableRow>
        <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
          <Collapse in={open} timeout="auto" unmountOnExit>
            <Box margin={1}>
              <Typography variant="h6" gutterBottom component="div">
                Manage
              </Typography>
              <Table size="small" aria-label="purchases">
                <TableHead>
                  <TableRow>
                    <TableCell>
                      <Button variant="contained" color="primary">
                          Revoke
                      </Button>
                    </TableCell>
                    <TableCell>
                        <Button variant="contained" color="primary">
                              View
                          </Button>
                    </TableCell>
                    <TableCell>
                        <Button variant="contained" color="primary">
                              Verify
                          </Button>
                    </TableCell>
                    <TableCell>
                        <Button variant="contained" color="primary">
                              Generate
                          </Button>
                    </TableCell>
                  </TableRow>
                </TableHead>
              </Table>
            </Box>
          </Collapse>
        </TableCell>
      </TableRow>
    </React.Fragment>
  );
}

// Row.propTypes = {
//   row: PropTypes.shape({
//     calories: PropTypes.number.isRequired,
//     carbs: PropTypes.number.isRequired,
//     fat: PropTypes.number.isRequired,
//     history: PropTypes.arrayOf(
//       PropTypes.shape({
//         amount: PropTypes.number.isRequired,
//         customerId: PropTypes.string.isRequired,
//         date: PropTypes.string.isRequired,
//       }),
//     ).isRequired,
//     name: PropTypes.string.isRequired,
//     price: PropTypes.number.isRequired,
//     protein: PropTypes.number.isRequired,
//   }).isRequired,
// };

const rows = [
  createData('Give A lot', "give@gmail.com", 50, "12-12-12","Active"),
  createData('Give A lot', "give@gmail.com", 50, "12-12-12","Active"),
  createData('Give A lot', "give@gmail.com", 50, "12-12-12","Active"),
  createData('Give A lot', "give@gmail.com", 50, "12-12-12","Active"),
  createData('Give A lot', "give@gmail.com", 50, "12-12-12","Active"),
  createData('Give A lot', "give@gmail.com", 50, "12-12-12","Active"),
  createData('Give A lot', "give@gmail.com", 50, "12-12-12","Active"),
  createData('Give A lot', "give@gmail.com", 50, "12-12-12","Active"),
];



function AdminBodyUser() {
    return (
        <div className="adminbodyUser">
          <Header />
          <div className="tablecontent">
            <TableContainer component={Paper}>
              <Table aria-label="collapsible table">
                <TableHead>
                  <TableRow>
                    <TableCell />
                    <TableCell>Name and Surname</TableCell>
                    <TableCell align="right">Email</TableCell>
                    <TableCell align="right">Donation&nbsp;(R)</TableCell>
                    <TableCell align="right">Date Joined</TableCell>
                    <TableCell align="right">Status</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {rows.map((row) => (
                    <Row key={row.name} row={row} />
                  ))}
                </TableBody>
              </Table>
            </TableContainer>

            
          </div>
        </div>
    )
}

export default AdminBodyUser
