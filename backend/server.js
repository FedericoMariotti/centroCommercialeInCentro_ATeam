import express from 'express';
//import data from '../C3-ATeam/frontend/src/data';
import data from './data';
var cors = require('cors');




const app = express();
var cors = require('cors');

app.get("/api/products/:id", (req, res)=> {
    const productId = req.params.id;
    const product = data.products.find(x => x._id === productId);
    if(product)
    res.send(product);
    else 
    res.status(404).send({ msg: "Scusa frate, non trovo il prodotto che cerchi :("})
} );

app.get("/api/products", (req, res)=> {
    res.send(data.products);
} );

app.listen(5000, () => {console.log("Server started at http://localhost:5000")} ) 

