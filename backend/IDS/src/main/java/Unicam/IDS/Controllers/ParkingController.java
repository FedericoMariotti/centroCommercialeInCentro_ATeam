package Unicam.IDS.Controllers;


import Unicam.IDS.Model.Parking;
import Unicam.IDS.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingController {


    @Autowired
    ParkingService service;

    public ParkingController(ParkingService service) {
        this.service = service;
    }


    @GetMapping("/parking")
    public List<Parking> all() {
        return service.getParking();
    }

    // AGGIUNGERE UN PARKING
    @PostMapping("/parking")
    public Parking newParking(@RequestBody  Parking newParking) {
        return service.createParking(newParking);
    }

    // SELEZIONARE UN PARKING
    @GetMapping("/parking/{id}")
    public Parking one(@PathVariable Long id) {

        return service.getParkingbyID(id);
    }



    //AGGIORNARE UN PARKING
    @RequestMapping( value = "/parking/{id}", method = RequestMethod.PUT)
    public Parking replaceParking(@RequestBody Parking newParking, @PathVariable Long id) {

        return service.updateParking(newParking,id);
    }

    //RIMUOVERE UN PARKING
    @DeleteMapping("/parking/{id}")
    public void deleteParking(@PathVariable Long id) {
        service.deleteParking(id);
    }


}


