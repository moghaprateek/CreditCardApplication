import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import TextField from '@material-ui/core/TextField';
import { Container, Paper, Button, Grid } from '@material-ui/core';


const useStyles = makeStyles((theme) => ({
    root: {
        '& > *': {
            margin: theme.spacing(1),

        },
    },
}));

export default function Cards() {
    const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" }
    const [name, setName] = useState('')
    const [cardNumber, setCardNumber] = useState('')
    const [cardLimit, setCardLimit] = useState('')
    const [cards, setCards] = useState([])
    const classes = useStyles();
    readData()


    const handleClick = (e) => {
        e.preventDefault()
        const cardDetails = { name, cardNumber, cardLimit }
        console.log(cardDetails)
        fetch("http://127.0.0.1:8181/add", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(cardDetails)
        }).then(res => res.json())
          .then((result)=>{
            console.log(result)
            readData()
          })
    }

    useEffect(() => {
        fetch("http://127.0.0.1:8181/")
            .then(res => res.json())
            .then((result) => {
                console.log(result)
                setCards(result);
            }
            )
    }, [])

    function readData (){
    useEffect(() => {
        fetch("http://127.0.0.1:8181/")
            .then(res => res.json())
            .then((result) => {
                console.log(result)
                setCards(result);
            }
            )
    }, [])}

    return (
        <Container>
            <Grid container direction={'row'} spacing={2}>
                <Grid item xm={4}>
                    <Paper elevation={3} style={paperStyle}>
                        <h1 style={{ color: "blue" }}> Add New Credit Card </h1>

                        <form className={classes.root} noValidate autoComplete="off">

                            <TextField id="outlined-basic" label="Card Holder Name" variant="outlined" fullWidth
                                value={name}
                                onChange={(e) => setName(e.target.value)}
                            />
                            <TextField id="outlined-basic" label="Card Number" variant="outlined" fullWidth
                                value={cardNumber}
                                onChange={(e) => setCardNumber(e.target.value)}
                            />
                            <TextField id="outlined-basic" label="Card Limit" variant="outlined" fullWidth
                                value={cardLimit}
                                onChange={(e) => setCardLimit(e.target.value)}
                            />
                            <Button variant="contained" color="secondary" onClick={handleClick}>
                                Submit
                            </Button>
                        </form>
                    </Paper>
                </Grid>
                <Grid item xm={6}>
                   
                    <h1 style={{ color: "blue" }}>Cards Data</h1>

                    <TableContainer component={Paper}>
                        <Table sx={{ minWidth: 500 }} size="small" aria-label="a dense table">
                            <TableHead>
                                <TableRow>
                                    <TableCell align="right">Name&nbsp;</TableCell>
                                    <TableCell align="right">Card Number&nbsp;</TableCell>
                                    <TableCell align="right">Card Limit&nbsp;</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {cards.map(card => (
                                    <TableRow
                                        key={card.id}
                                        sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                    >
                                        <TableCell align="right">{card.name}</TableCell>
                                        <TableCell align="right">{card.cardNumber}</TableCell>
                                        <TableCell align="right">{card.cardLimit}</TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                </Grid>
            </Grid>
        </Container>
    );
}