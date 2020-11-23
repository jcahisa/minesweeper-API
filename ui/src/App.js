import React, { useState, useEffect } from 'react';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import { makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';

const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
    },
    paper: {
        height: 100,
        width: 600,
        padding: '20px 20px 20px 30px'
    },
    control: {
        padding: theme.spacing(2),
    },
    mainContainer: {
        backgroundColor: '#cfe8fc',
        height: '50vh'
    },
    actionButton: {
        margin: '5px'
    }
}));

export default function App(){
    const classes = useStyles();
    const [username, setUsername] = useState('');

    const createNewGame = () => {
        console.log(`creating new game for user = ${username}`);
    }

    const retrieveGameHistory = () => {
        console.log(`retrieving game history for user ${username}`);
    }

    return(
        <React.Fragment>
            <CssBaseline />
                <Grid className={classes.mainContainer} container direction="row" justify="center" alignItems="center">
                    <Grid item >
                        <Paper className={classes.paper} >
                            <TextField
                                id="userName"
                                label="Username"
                                value={username}
                                InputLabelProps={{
                                    shrink: true,
                                }}
                                onChange={(event) => {
                                    setUsername(event.target.value);
                                }}
                            />
                            <Button variant="outlined" color="primary" className={classes.actionButton} onClick={createNewGame}>
                                New Game
                            </Button>
                            <Button variant="outlined" color="secondary" className={classes.actionButton} onClick={retrieveGameHistory}>
                                Game History
                            </Button>
                        </Paper>
                    </Grid>
                </Grid>
        </React.Fragment>
    );
}
