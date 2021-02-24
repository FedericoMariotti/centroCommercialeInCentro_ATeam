package Unicam.IDS.Controllers;


import Unicam.IDS.Model.Product;
import Unicam.IDS.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    ProductService service;

    public ProductController( ProductService service) {
        this.service = service;
    }

    //SELEZIONA TUTTI I PRODOTTI
    @GetMapping("/products")
    public List< Product> all() {
        return service.getProduct();
    }


    // AGGIUNGERE UN PRODUCT
    @PostMapping("/products")
    public Product newProduct(@RequestBody Product newProduct) {
        return service.createProduct(newProduct);
    }

    // SELEZIONARE UN PRODUCT
    @GetMapping("/products/{id}")
    public Product one(@PathVariable Long id) {

        return service.getProductbyID(id);
    }



    //AGGIORNARE UN PRODUCT
    @RequestMapping( value = "/products/{id}", method = RequestMethod.PUT)
    public Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {

        return service.updateProduct(newProduct,id);
    }

    //RIMUOVERE UN PRODUCT
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
    }


}


