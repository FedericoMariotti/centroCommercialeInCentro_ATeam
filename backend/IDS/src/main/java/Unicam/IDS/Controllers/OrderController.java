package Unicam.IDS.Controllers;


import Unicam.IDS.Model.Order;
import Unicam.IDS.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {


    @Autowired
    OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }


    @GetMapping("/orders")
    public  List<Order> all() {
        return service.getOrder();
    }


    // AGGIUNGERE UN ORDER
    @PostMapping("/orders")
    public Order newOrder(@RequestBody Order newOrder) {
        return service.createOrder(newOrder);
    }

    // SELEZIONARE UN ORDER
    @GetMapping("/orders/{id}")
    public Order one(@PathVariable Long id) {

        return service.getOrderbyID(id);
    }



    //AGGIORNARE UN ORDER
    @RequestMapping( value = "/orders/{id}", method = RequestMethod.PUT)
    public  Order replaceOrder(@RequestBody Order newOrder, @PathVariable Long id) {

        return service.updateOrder(newOrder,id);
    }

    //RIMUOVERE UN ORDER
    @DeleteMapping("/orders/{id}")
    public  void deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
    }


}


