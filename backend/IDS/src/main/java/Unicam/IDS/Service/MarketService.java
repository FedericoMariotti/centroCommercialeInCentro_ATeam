package Unicam.IDS.Service;
import Unicam.IDS.Model.Market;
import Unicam.IDS.Repo.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarketService {

    @Autowired
    MarketRepository repository;


    public Market createMarket(Market market) {

        return repository.save(market);
    }

    public Market updateMarket(Market newMarket, long id) {

        return repository.findById(id)
                .map(market -> {
                    market.setName(newMarket.getName());
                    market.setAddress(newMarket.getAddress());
                    market.setType(newMarket.getType());
                    market.setOpeningTime(newMarket.getOpeningTime());
                    market.setClosingTime(newMarket.getClosingTime());
                    return repository.save(market);
                })
                .orElseGet(() -> {
                    newMarket.setID(id);
                    return repository.save(newMarket);
                });

    }



    public void deleteMarket(long id) {
        repository.deleteById(id);

    }

    public List<Market> getMarket() {
        return repository.findAll();
    }

    public Market getMarketbyID(long ID) {
        return repository.findById(ID)
                .orElseThrow(() -> new NullPointerException());
    }


}

