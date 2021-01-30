import express from 'express';
import Product from '../models/productModel';
import { isAdmin, isAuth } from '../util';

const router = express.Router();
router.get("/", async(req, res) => {
const product = await Product.find({});
res.send(products);
});

router.post("/", async (req, res) =>{
    const product = new Product({
        name: req.body.name,
        price: req.body.price,
        image: req.body.image,
        brand: req.body.brand,
        category: req.body.category,
        countInStock: req.body.countInStock,
        description: req.body.description,
        rating: req.body.rating,
        numReviews: req.body.numReviews,
    })
    const newProduct = await product.save();
    if(newProduct){
        return res.status(201).send({message: 'Nuovo prodotto creato', data: newProduct});
    }
    return res.status(500).send({message: "Errore nella creazione del prodotto"});
})

router.put("/:id", isAuth, isAdmin, async(req, res) =>{
    const productId = req.params.id;
    const product = await Product.findById(productId);
    if (product) {
        product.name = req.body.name;
        product.price = req.body.price;
        product.image = req.body.image;
        product.brand = req.body.brand;
        product.category = req.body.category;
        product.countInStock = req.body.countInStock;
        product.description = req.body.description;
        
        const updatedProduct = await product.save();
        if (updatedProduct) {
          return res.status(200).send({ message: 'Prodotto aggiornato', data: updatedProduct });
        }
      }
      return res.status(500).send({ message: 'Errore aggiornamento prodotto' });
    });

    router.delete("/:id", isAuth, isAdmin, async (req, res) => {
        const deleteProduct = await Product.findById(req.params.id);
        if (deleteProduct) {
            await deleteProduct.remove();
            res.send({message: "Prodotto eliminato"});
        } else {
            res.send("Errore eliminazione prodotto");
        }
    });

export default router;