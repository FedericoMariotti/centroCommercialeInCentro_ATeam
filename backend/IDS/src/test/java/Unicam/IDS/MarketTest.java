package Unicam.IDS;

import Unicam.IDS.Model.Market;
import Unicam.IDS.Model.Parking;
import Unicam.IDS.Repo.MarketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
public class MarketTest {


    @Autowired
    private MarketRepository marketRepository;

    @Test
    public void testSaveMarket() {
        Parking parking = new Parking("parkingldl", "ldlpar@outlook.com", 9, 21);
        Market ldl = new Market("ldl", "ldl@outlook.com", "supermercato", 9, 21, parking);
        marketRepository.save(ldl);
        marketRepository.findById(new Long(1))
                .map(newMarket -> {
                    assertEquals("ldl", newMarket.getName());
                    return true;
                });
    }

        @Test
        public void testGetMarket(){

            Parking parking=new Parking("parkingldl", "ldlpar@outlook.com",9,21);
            Market ldl = new Market("ldl","ldl@outlook.com","supermercato",9,21,parking);

            Parking parkinge=new Parking("parkinges", "espar@outlook.com",9,21);
            Market eurospin = new Market("eurospin","eurospin@outlook.com","supermercato",9,21,parkinge);

            marketRepository.save(ldl);
            marketRepository.save(eurospin);

            marketRepository.findById(new Long(1))
                    .map(newMarket ->{
                        assertEquals("eurospin",newMarket.getName());
                        return true;
                    });

        }

        @Test
        public void testGetMarkets(){

            Parking parking=new Parking("parkingldl", "ldlpar@outlook.com",9,21);
            Market ldl = new Market("ldl","ldl@outlook.com","supermercato",9,21,parking);

            Parking parkinge=new Parking("parkinges", "espar@outlook.com",9,21);
            Market eurospin = new Market("eurospin","eurospin@outlook.com","supermercato",9,21,parkinge);
            marketRepository.save(ldl);

            marketRepository.save(eurospin);
            assertTrue(marketRepository.findAll()!=null);
        }

        @Test
        public void testDeleteMarket(){
            Parking parking = new Parking("parkingldl", "ldlpar@outlook.com",9,21);
            Market ldl = new Market("ldl","ldl@outlook.com","supermercato",9,21,parking);
            marketRepository.save(ldl);
            marketRepository.delete(ldl);
            assertTrue(marketRepository.findAll().isEmpty());
        }
    }