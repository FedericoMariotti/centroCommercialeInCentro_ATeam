package Unicam.IDS.Service;


import Unicam.IDS.Model.AccountSystem.Seller;
import Unicam.IDS.Repo.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SellerService {

    @Autowired
    SellerRepository repository;


    public Seller createSeller(Seller seller) {

        return repository.save(seller);
    }

    public Seller updateSeller(Seller newSeller, long id) {

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
                    newSeller.setId(id);
                    return repository.save(newSeller);
                });

    }



    public void deleteSeller(long id) {
        repository.deleteById(id);

    }

    public List<Seller> getSeller() {
        return repository.findAll();
    }

    public Seller getSellerbyID(long ID) {
        return repository.findById(ID)
                .orElseThrow(() -> new NullPointerException());
    }

}