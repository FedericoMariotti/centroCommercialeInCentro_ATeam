package Unicam.IDS.Controllers;

import Unicam.IDS.Model.AccountSystem.Seller;
import Unicam.IDS.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellerController {

    @Autowired
    SellerService service;

    public SellerController(SellerService service) {
        this.service = service;
    }


    // SELEZIONARE TUTTI I SELLER
    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/sellers")
    public List<Seller> all() {
        return service.getSeller();
    }
    // end::get-aggregate-root[]

    // AGGIUNGERE UN SELLER
    @PostMapping("/sellers")
    public Seller newSeller(@RequestBody Seller newSeller) {
        return service.createSeller(newSeller);
    }

    // SELEZIONARE UN SELLER
    @GetMapping("/sellers/{id}")
    public Seller one(@PathVariable Long id) {

        return service.getSellerbyID(id);
    }



    //AGGIORNARE UN SELLER
    @RequestMapping( value = "/sellers/{id}", method = RequestMethod.PUT)
    Seller replaceSeller(@RequestBody Seller newSeller, @PathVariable Long id) {

        return service.updateSeller(newSeller,id);
    }

    //RIMUOVERE UN SELLER
    @DeleteMapping("/sellers/{id}")
    void deleteSeller(@PathVariable Long id) {
        service.deleteSeller(id);
    }
}
