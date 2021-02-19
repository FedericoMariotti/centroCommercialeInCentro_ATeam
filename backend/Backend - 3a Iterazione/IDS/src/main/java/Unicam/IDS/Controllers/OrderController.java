package Unicam.IDS.Controllers;


import Unicam.IDS.Model.Locker;
import Unicam.IDS.Model.Market;
import Unicam.IDS.Model.Order;
import Unicam.IDS.Model.OrderStatus;
import Unicam.IDS.Service.LockerService;
import Unicam.IDS.Service.MarketService;
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
    List<Order> all() {
        return service.getOrder();
    }
    // end::get-aggregate-root[]

    // AGGIUNGERE UN ORDER
    @PostMapping("/orders")
    Order newOrder(@RequestBody Order newOrder) {
        return service.createOrder(newOrder);
    }

    // SELEZIONARE UN ORDER
    @GetMapping("/orders/{id}")
    Order one(@PathVariable Long id) {

        return service.getOrderbyID(id);
    }



    //AGGIORNARE UN ORDER
    @RequestMapping( value = "/orders/{id}", method = RequestMethod.PUT)
    Order replaceOrder(@RequestBody Order newOrder, @PathVariable Long id) {

        return service.updateOrder(newOrder,id);
    }

    //RIMUOVERE UN ORDER
    @DeleteMapping("/orders/{id}")
    void deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
    }


}


