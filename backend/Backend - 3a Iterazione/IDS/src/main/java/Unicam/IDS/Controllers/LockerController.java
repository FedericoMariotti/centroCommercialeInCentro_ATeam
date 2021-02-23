package Unicam.IDS.Controllers;


import Unicam.IDS.Model.Locker;
import Unicam.IDS.Model.OrderStatus;
import Unicam.IDS.Service.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LockerController {


    @Autowired
    LockerService service;

    public LockerController(LockerService service) {
        this.service = service;
    }


    @GetMapping("/lockers")
    List<Locker> all() {
        return service.getLocker();
    }
    // end::get-aggregate-root[]

    // AGGIUNGERE UN LOCKER
    @PostMapping("/lockers")
    Locker newLocker(@RequestBody  Locker newLocker) {
        return service.createLocker(newLocker);
    }

    // SELEZIONARE UN LOCKER
    @GetMapping("/lockers/{id}")
    Locker one(@PathVariable Long id) {

        return service.getLockerbyID(id);
    }



    //AGGIORNARE UN LOCKER
    @RequestMapping( value = "/lockers/{id}", method = RequestMethod.PUT)
    Locker replaceLocker(@RequestBody Locker newLocker, @PathVariable Long id) {

        return service.updateLocker(newLocker,id);
    }

    //RIMUOVERE UN LOCKER
    @DeleteMapping("/lockers/{id}")
    void deleteLocker(@PathVariable Long id) {
        service.deleteLocker(id);
    }


    @RequestMapping( value = "/lockers/status", method = RequestMethod.PUT)
    void changeStatus(@RequestBody OrderStatus newStatus, @PathVariable Long Orderid) {

        service.changeStatus(newStatus,Orderid);
    }

}


