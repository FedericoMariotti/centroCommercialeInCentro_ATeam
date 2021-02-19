package Unicam.IDS.Controllers;
import Unicam.IDS.Model.Product;
import Unicam.IDS.Repo.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }


    // SELEZIONARE TUTTI I PRODOTTI
    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/products")
    List<Product> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    // AGGIUNGERE UN PRODOTTO
    @PostMapping("/products")
    Product newProduct(@RequestBody Product newProduct) {
        return repository.save(newProduct);
    }

    // SELEZIONARE UN PRODOTTO
    @GetMapping("/products/{id}")
    Product one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NullPointerException());
    }
    //AGGIORNARE UN PRODOTTO
    @PutMapping("/products/{id}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {

        return repository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    product.setBrand(newProduct.getBrand());
                    product.setDescription(newProduct.getDescription());
                    product.setTags(newProduct.getTags());
                    product.setQuantity(newProduct.getQuantity());
                    return repository.save(product);
                })
                .orElseGet(() -> {
                   //TODO newCustomer.setId(id);
                    return repository.save(newProduct);
                });
    }

//RIMUOVERE UN PRODOTTO
    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
