package Unicam.IDS.Service;
import Unicam.IDS.Model.Market;
import Unicam.IDS.Model.Order;
import Unicam.IDS.Repo.MarketRepository;
import Unicam.IDS.Repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {

    @Autowired
    OrderRepository repository;


    public Order createOrder(Order order) {

        return repository.save(order);
    }

    public Order updateOrder(Order newOrder, long id) {

        return repository.findById(id)
                .map(order -> {
                    order.setProducts(newOrder.getProducts());
                    order.setCustomer(newOrder.getCustomer());
                    order.setDeliver(newOrder.getDeliver());
                    order.setStatus(newOrder.getStatus());
                    order.setPrice();
                    return repository.save(order);
                })
                .orElseGet(() -> {
                    newOrder.setID(id);
                    return repository.save(newOrder);
                });

    }



    public void deleteOrder(long id) {
        repository.deleteById(id);

    }

    public List<Order> getOrder() {
        return repository.findAll();
    }

    public Order getOrderbyID(long ID) {
        return repository.findById(ID)
                .orElseThrow(() -> new NullPointerException());
    }


}

