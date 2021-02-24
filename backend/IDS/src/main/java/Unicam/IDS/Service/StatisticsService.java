package Unicam.IDS.Service;

import Unicam.IDS.Model.AccountSystem.Customer;
import Unicam.IDS.Model.Statistics;
import Unicam.IDS.Repo.MarketRepository;
import Unicam.IDS.Repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    OrderRepository Orepository;
    @Autowired
    MarketRepository Mrepository;


    public Statistics getStatistics (long id) {
        int Onumbers = 0;
        int Parksnumbers = 0;
        List<Customer> Cnumber = new ArrayList<Customer>();
        for (int i = 0; i < Orepository.findAll().size(); i++) {
            if (Orepository.findAll().get(i).getProducts().get(0).getMarket().getID() == id) {
                Onumbers++;
                if (Cnumber.contains(Orepository.findAll().get(i).getCustomer()) == false) {
                    Cnumber.add(Orepository.findAll().get(i).getCustomer());
                }
            } else Onumbers = Onumbers;
        }
        for (int i = 0; i < Mrepository.getOne(id).getParking().size(); i++) {
               Parksnumbers += Mrepository.getOne(id).getParking().get(i).getOccupied();
        }
        Statistics statistics = new Statistics(Onumbers,Cnumber.size(),Parksnumbers);
        return statistics;
    }


}

