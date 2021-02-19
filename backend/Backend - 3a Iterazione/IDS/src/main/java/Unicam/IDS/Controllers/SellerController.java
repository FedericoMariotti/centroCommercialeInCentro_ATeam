package Unicam.IDS.Controllers;

import Unicam.IDS.Model.AccountSystem.Seller;
import Unicam.IDS.Repo.SellerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SellerController {



        private final SellerRepository repository;

        public SellerController(SellerRepository repository) {
            this.repository = repository;
        }


        // SELEZIONARE TUTTI I VENDITORI
        // Aggregate root
        // tag::get-aggregate-root[]
        @GetMapping("/sellers")
        List<Seller> all() {
            return repository.findAll();
        }
        // end::get-aggregate-root[]

        // AGGIUNGERE UN VENDITORE
        @PostMapping("/sellers")
        Seller newSeller(@RequestBody Seller newSeller) {
            return repository.save(newSeller);
        }

        // SELEZIONARE UN VENDITORe
        @GetMapping("/sellers/{id}")
        Seller one(@PathVariable Long id) {

            return repository.findById(id)
                    .orElseThrow(() -> new NullPointerException());
        }
        //AGGIORNARE UN VENDITORe
        @PutMapping("/sellers/{id}")
        Seller replaceSeller(@RequestBody Seller newSeller, @PathVariable Long id) {

            return repository.findById(id)
                    .map(seller -> {
                        seller.setCellNumber(newSeller.getCellNumber());
                        seller.setEmail(newSeller.getEmail());
                        seller.setPassword(newSeller.getPassword());
                        seller.setName(newSeller.getName());
                        seller.setSurname(newSeller.getSurname());
                        return repository.save(seller);
                    })
                    .orElseGet(() -> {
                        //TODO newCustomer.setId(id);
                        return repository.save(newSeller);
                    });
        }

        //RIMUOVERE UN VENDITORe
        @DeleteMapping("/sellers/{id}")
        void deleteSeller(@PathVariable Long id) {
            repository.deleteById(id);
        }
    }


