package Unicam.IDS.DB;


import Unicam.IDS.Model.AccountSystem.Customer;
import Unicam.IDS.Model.AccountSystem.Deliver;
import Unicam.IDS.Model.AccountSystem.Seller;
import Unicam.IDS.Model.*;
import Unicam.IDS.Repo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//SI OCCUPA DI AVVIARE IL DB E DI INSERIRE 1 RECORD PER OGNI TABELLA PER TESTARE IL FUNZIONAMENTO
@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @Bean
    CommandLineRunner initDatabase(CustomerRepository Crepository, SellerRepository Srepository, DeliverRepository Drepository, LockerRepository Lrepository, ParkingRepository PArepository, ProductRepository Prepository, MarketRepository Mrepository, CartRepository CArepository, OrderRepository Orepository) {
        long id = 1;
        OrderStatus status = OrderStatus.recieved;
        return args -> {
            log.info("Preloading " + Crepository.save(new Customer(0000000000,"admin@admin.it", "admin", "admin","admin","")));
           // log.info("cust:" + Crepository.findAll().get(2).getID());
            log.info("Preloading " + Srepository.save(new Seller(0000000000,"admin@admin.it", "admin", "admin","admin")));
            log.info("Preloading " + Drepository.save(new Deliver(0000000000,"admin@admin.it", "admin", "admin","admin")));
            log.info("Preloading " + Lrepository.save(new Locker("locker","test", 00000000, 15,19)));
            log.info("Preloading " + PArepository.save(new Parking("parking","test", 15, 19)));
          //  log.info("Preloading " + Mrepository.save(new Market("market","test", "type", 15,19, PArepository.findAll().stream().findFirst().get())));
           // log.info("Preloading " + Prepository.save(new Product("test",20, "adidas", "test","test,test1", 10,Mrepository.findAll().get(0))));
            log.info("Preloading " + CArepository.save(new Cart(Prepository.findAll())));
          //  log.info("Preloading " + Orepository.save(new Order(Prepository.findAll(),Crepository.findAll().get(1), Drepository.findAll().get(1), status )));


        };
    }
}