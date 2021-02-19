package Unicam.IDS.Controllers;


import Unicam.IDS.Model.Locker;
import Unicam.IDS.Model.Market;
import Unicam.IDS.Model.OrderStatus;
import Unicam.IDS.Service.LockerService;
import Unicam.IDS.Service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarketController {


    @Autowired
    MarketService service;

    public MarketController(MarketService service) {
        this.service = service;
    }


    @GetMapping("/markets")
    List<Market> all() {
        return service.getMarket();
    }
    // end::get-aggregate-root[]

    // AGGIUNGERE UN MARKET
    @PostMapping("/markets")
    Market newMarket(@RequestBody  Market newMarket) {
        return service.createMarket(newMarket);
    }

    // SELEZIONARE UN MARKET
    @GetMapping("/markets/{id}")
    Market one(@PathVariable Long id) {

        return service.getMarketbyID(id);
    }



    //AGGIORNARE UN MARKET
    @RequestMapping( value = "/markets/{id}", method = RequestMethod.PUT)
    Market replaceMarket(@RequestBody Market newMarket, @PathVariable Long id) {

        return service.updateMarket(newMarket,id);
    }

    //RIMUOVERE UN MARKET
    @DeleteMapping("/markets/{id}")
    void deleteMarket(@PathVariable Long id) {
        service.deleteMarket(id);
    }


}


