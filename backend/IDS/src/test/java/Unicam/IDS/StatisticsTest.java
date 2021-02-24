package Unicam.IDS;

import Unicam.IDS.Model.*;
import Unicam.IDS.Model.AccountSystem.Customer;
import Unicam.IDS.Model.AccountSystem.Deliver;
import Unicam.IDS.Repo.OrderRepository;
import Unicam.IDS.Service.StatisticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class StatisticsTest {
    @Autowired
     private StatisticsService statisticsService;
    @Autowired
    private static OrderRepository orderRepository;


    public void testGetStatistics() {
        Statistics s = new Statistics(2,3,15);
        assertEquals(2,s.getCustomersNumber());
        assertEquals(3,s.getOrdersNumber());
        assertEquals(15,s.getOccupiedParkingNumber());
        s.setOccupiedParkingNumber(40);
        assertEquals(40,s.getOccupiedParkingNumber());
        s.setOrderNumber(20);
        assertEquals(20,s.getOrdersNumber());
        s.setCustomersNumber(10);
        assertEquals(10,s.getCustomersNumber());

    }
}
