package Unicam.IDS.Controllers;


import Unicam.IDS.Model.AccountSystem.Deliver;
import Unicam.IDS.Model.OrderStatus;
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
        public List< Deliver> all() {
            return service.getDeliver();
        }
        // end::get-aggregate-root[]

        // AGGIUNGERE UN DELIVER
        @PostMapping("/delivers")
        public Deliver newDeliver(@RequestBody  Deliver newDeliver) {
            return service.createDeliver(newDeliver);
        }

        // SELEZIONARE UN DELIVER
        @GetMapping("/delivers/{id}")
        public Deliver one(@PathVariable Long id) {

            return service.getDeliverbyID(id);
        }



        //AGGIORNARE UN DELIVER
        @RequestMapping( value = "/delivers/{id}", method = RequestMethod.PUT)
        public Deliver replaceDeliver(@RequestBody Deliver newDeliver, @PathVariable Long id) {

            return service.updateDeliver(newDeliver,id);
        }

        //RIMUOVERE UN DELIVER
        @DeleteMapping("/delivers/{id}")
        public  void deleteDeliver(@PathVariable Long id) {
            service.deleteDeliver(id);
        }


         @RequestMapping( value = "/delivers/status", method = RequestMethod.PUT)
          public  void changeStatus(@RequestBody OrderStatus newStatus, @PathVariable Long orderid) {

           service.changeStatus(newStatus,orderid);
    }

}


