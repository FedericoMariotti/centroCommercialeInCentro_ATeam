package Unicam.IDS;

import Unicam.IDS.Model.*;
import Unicam.IDS.Model.AccountSystem.Customer;
import Unicam.IDS.Model.AccountSystem.Deliver;
import Unicam.IDS.Repo.DeliverRepository;
import Unicam.IDS.Repo.OrderRepository;
import Unicam.IDS.Repo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class OrderTest {



    @Autowired
    private OrderRepository orderRepository;

    List<Product> productList = new ArrayList<Product>();
    Parking parking = new Parking("parkingldl", "ldlpar@outlook.com",9,21);
    Market esse = new Market("ldl","ldl@outlook.com","supermercato",9,21,parking);
    Product p = new Product( "a",80 , "Adidas", "Scarpe da ginnastica", "scarpe,ginnastica,sport", 39,esse);
    Product p1 = new Product( "Superstar",80 , "Adidas", "Scarpe da ginnastica", "scarpe,ginnastica,sport", 39,esse);
    Customer c = new Customer(354554554,"qwerty1@outlook.com","qwerty","johhny","ard","Via de gasperi, Matewlica,IT");
    Customer c1 = new Customer(354554552,"qwerty1@outlook.com","aaaa","Francesco","ard","Via de gasperi, Matewlica,IT");
    Deliver d = new Deliver(354554554,"qwerty1@outlook.com","qwerty","Luca","Rossi");
    OrderStatus orderStatus = OrderStatus.recieved;
    Order o = new Order(productList,c,d,orderStatus);
    Order o1 = new Order(productList,c1,d,orderStatus);

    @Test
    public void testSaveOrder(){
        productList.add(p);
        productList.add(p1);
        orderRepository.save(o);
        orderRepository.findById(new Long(1))
                .map(newOrder ->{
                    assertEquals("Superstar" , newOrder.getProducts().get(1));
                    return true;
                });
    }

    @Test
    public void testGetOrder(){
        orderRepository.save(o);
        orderRepository.save(o1);
        orderRepository.findById(new Long(1))
                .map(newOrder ->{
                    assertEquals("Superstar" , newOrder.getProducts().get(1));
                    return true;
                });
        assertFalse(orderRepository.findById(new Long(1)) != orderRepository.findById(new Long (0)));

    }

    @Test
    public void testGetOrders(){
        orderRepository.save(o);
        orderRepository.save(o1);
        assertTrue(orderRepository.findAll()!=null);
    }

    @Test
    public void testDeleteOrder(){
        orderRepository.save(o);
        orderRepository.delete(o);
        assertTrue(orderRepository.findAll().isEmpty());
    }


}

