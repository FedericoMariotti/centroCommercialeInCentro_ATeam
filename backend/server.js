import express from 'express';
import path from 'path';
import mongoose from 'mongoose';
import bodyParser from 'body-parser';
import config from './config';
import userRoute from './routes/userRoute';
import productRoute from './routes/productRoute';
import dotenv from 'dotenv';
import uploadRoute from './routes/uploadRoute';
//import data from 'data';
dotenv.config();

const mongodbUrl = config.MONGODB_URL;
//const port = config.PORT;
mongoose.connect(mongodbUrl, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useCreateIndex: true,
  })
  .catch((error) => console.log(error.reason));

const app = express();

app.use(bodyParser.json());
app.use('/api/uploads', uploadRoute);
app.use("/api/users", userRoute);
app.use('/api/products', productRoute);


app.get("/api/products/:id", (req, res)=> {
    const productId = req.params.id;
    const product = data.products.find(x => x._id === productId);
    if(product)
    res.send(product);
    else 
    res.status(404).send({ msg: "Scusa, non trovo il prodotto che cerchi :("})
} );

app.get("/api/products", (req, res)=> {
    res.send(data.products);
} );


//app.listen(5000, () => {console.log("Server in esecuzione in http://localhost:5000")} )
app.listen(config.PORT, () => {
    console.log('Server in esecuzione su http://localhost:5000');
  });