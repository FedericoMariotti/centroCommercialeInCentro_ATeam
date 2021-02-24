package Unicam.IDS;

import Unicam.IDS.Model.AccountSystem.Deliver;
import Unicam.IDS.Model.Market;
import Unicam.IDS.Model.Product;
import Unicam.IDS.Repo.DeliverRepository;
import Unicam.IDS.Repo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductTest {



    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSaveProduct(){
        Market KingSport = new Market();
        Product p = new Product( "Superstar",80 , "Adidas", "Scarpe da ginnastica", "scarpe,ginnastica,sport", 39,KingSport);
        productRepository.save(p);
        productRepository.findById(new Long(1))
                .map(newProduct ->{
                    assertEquals("Superstar" , newProduct.getName());
                    return true;
                });
    }

    @Test
    public void testGetProduct(){
        Market KingSport = new Market();
        Product p = new Product( "Superstar",80 , "Adidas", "Scarpe da ginnastica", "scarpe,ginnastica,sport", 39,KingSport);
        Product p1 = new Product( "Yeezy",200, "Adidas", "Scarpe da ginnastica", "scarpe,ginnastica,sport", 39,KingSport);
        productRepository.save(p);
        productRepository.save(p1);
        productRepository.findById(new Long(1))
                .map(newProduct ->{
                    assertEquals("Superstar",newProduct.getName());
                    return true;
                });
        assertFalse(productRepository.findById(new Long(1)) != productRepository.findById(new Long (0)));

    }

    @Test
    public void testGetProducts(){
        Market KingSport = new Market();
        Product p = new Product( "Superstar",80 , "Adidas", "Scarpe da ginnastica", "scarpe,ginnastica,sport", 39,KingSport);
        Product p1 = new Product( "Yeezy",200, "Adidas", "Scarpe da ginnastica", "scarpe,ginnastica,sport", 39,KingSport);
        productRepository.save(p);
        productRepository.save(p1);
        assertTrue(productRepository.findAll()!=null);
    }

    @Test
    public void testDeleteProduct(){
        Market KingSport = new Market();
        Product p = new Product( "Superstar",80 , "Adidas", "Scarpe da ginnastica", "scarpe,ginnastica,sport", 39,KingSport);
        productRepository.save(p);
        productRepository.delete(p);
        assertTrue(productRepository.findAll().isEmpty());
    }


}

