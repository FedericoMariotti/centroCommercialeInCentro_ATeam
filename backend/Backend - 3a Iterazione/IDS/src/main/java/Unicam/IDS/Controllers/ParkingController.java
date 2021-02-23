package Unicam.IDS.Controllers;
import Unicam.IDS.Model.Parking;
import Unicam.IDS.Repo.ParkingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingController {

    private final ParkingRepository repository;

    public ParkingController(ParkingRepository repository) {
        this.repository = repository;
    }


    // SELEZIONARE TUTTI I PARCHEGGI
    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/parking")
    List<Parking> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    // AGGIUNGERE UN PARCHEGGIO
    @PostMapping("/parking")
    Parking newParking(@RequestBody Parking newParking) {
        return repository.save(newParking);
    }

    // SELEZIONARE UN PARCHEGGIO
    @GetMapping("/parking/{id}")
    Parking one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NullPointerException());
    }
    //AGGIORNARE UN PARCHEGGIO
    @PutMapping("/parking/{id}")
    Parking replaceParking(@RequestBody Parking newParking, @PathVariable Long id) {

        return repository.findById(id)
                .map(parking -> {
                    parking.setName(newParking.getName());
                    parking.setAddress(newParking.getAddress());
                    parking.setOpeningTime(newParking.getOpeningTime());
                    parking.setClosingTime(newParking.getClosingTime());
                    return repository.save(parking);
                })
                .orElseGet(() -> {
                   //TODO newCustomer.setId(id);
                    return repository.save(newParking);
                });
    }

//RIMUOVERE UN PARCHEGGIO
    @DeleteMapping("/parking/{id}")
    void deleteParking(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
