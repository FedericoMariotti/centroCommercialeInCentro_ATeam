package Unicam.IDS.Controllers;


import Unicam.IDS.Model.AccountSystem.Deliver;
import Unicam.IDS.Model.Order;
import Unicam.IDS.Model.OrderStatus;
import Unicam.IDS.Repo.DeliverRepository;
import Unicam.IDS.Service.CustomerService;
import Unicam.IDS.Service.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliverController {


        @Autowired
        DeliverService service;

        public DeliverController(DeliverService service) {
            this.service = service;
        }


        @GetMapping("/delivers")
        List< Deliver> all() {
            return service.getDeliver();
        }
        // end::get-aggregate-root[]

        // AGGIUNGERE UN DELIVER
        @PostMapping("/delivers")
        Deliver newDeliver(@RequestBody  Deliver newDeliver) {
            return service.createDeliver(newDeliver);
        }

        // SELEZIONARE UN DELIVER
        @GetMapping("/delivers/{id}")
        Deliver one(@PathVariable Long id) {

            return service.getDeliverbyID(id);
        }



        //AGGIORNARE UN DELIVER
        @RequestMapping( value = "/delivers/{id}", method = RequestMethod.PUT)
        Deliver replaceDeliver(@RequestBody Deliver newDeliver, @PathVariable Long id) {

            return service.updateDeliver(newDeliver,id);
        }

        //RIMUOVERE UN DELIVER
        @DeleteMapping("/delivers/{id}")
        void deleteDeliver(@PathVariable Long id) {
            service.deleteDeliver(id);
        }


    @RequestMapping( value = "/delivers/status", method = RequestMethod.PUT)
    void changeStatus(@RequestBody OrderStatus newStatus, @PathVariable Long Orderid) {

        service.changeStatus(newStatus,Orderid);
    }

}


