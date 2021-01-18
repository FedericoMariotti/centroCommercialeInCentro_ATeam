import express from 'express';
import data from './data';
var cors = require('cors');
import config from '/config';
import dotenv from 'dotenv';
import mongoose from 'mongoose';
import userRoute from './routes/userRoute';
import bodyParser from 'body-parser';
import productRoute from './routes/productRoute';
import path from 'path';
import productRoute from './routes/userRoute';


dotenv.config();
const mongodbUrl = config.MONGODB_URL;
mongoose.connect(mongodbUrl, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useCreateIndex: true
}).catch(error => console.log(error.reason));


const app = express();
//app.use(bodyParser.json());
//var cors = require('cors');
app.use(bodyParser.json());
app.use("/apu/users", userRoute);
app.use("api/products", product);

/* app.get("/api/products/:id", (req, res)=> {
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
*/

app.listen(5000, () => {console.log("Server started at http://localhost:5000")} ) 

