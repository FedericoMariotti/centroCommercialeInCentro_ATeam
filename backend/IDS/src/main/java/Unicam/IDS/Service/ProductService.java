package Unicam.IDS.Service;

import Unicam.IDS.Model.Product;
import Unicam.IDS.Repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    @Autowired
    ProductRepository repository;


    public Product createProduct(Product product) {

        return repository.save(product);
    }

    public Product updateProduct(Product newProduct, long id) {

        return repository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setDescription(newProduct.getDescription());
                    product.setBrand(newProduct.getBrand());
                    product.setTags(newProduct.getTags());
                    product.setPrice(newProduct.getPrice());
                    product.setQuantity(newProduct.getQuantity());
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setID(id);
                    return repository.save(newProduct);
                });

    }



    public void deleteProduct(long id) {
        repository.deleteById(id);

    }

    public List<Product> getProduct() {
        return repository.findAll();
    }

    public Product getProductbyID(long ID) {
        return repository.findById(ID)
                .orElseThrow(() -> new NullPointerException());
    }


}

