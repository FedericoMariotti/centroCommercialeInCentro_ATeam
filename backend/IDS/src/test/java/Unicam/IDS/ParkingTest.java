package Unicam.IDS;

import Unicam.IDS.Model.Parking;
import Unicam.IDS.Repo.ParkingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ParkingTest {

    @Autowired
    private ParkingRepository parkingRepository;

    @Test
    public void testSaveAccount(){
        Parking p =new Parking("parkingldl", "ldlpar@outlook.com",9,21);
        parkingRepository.save(p);
        parkingRepository.findById(new Long(1))
                .map(newParking ->{
                    assertEquals("parkingldl", newParking.getName());
                    return true;
                });
    }

    @Test
    public void getAccount(){

        Parking p =new Parking("parkingldl", "ldlpar@outlook.com",9,21);
        Parking p1 =new Parking("parkinges", "espar@outlook.com",9,21);

        parkingRepository.save(p);
        parkingRepository.save(p1);

        parkingRepository.findById(new Long(1))
                .map(newParking ->{
                    assertEquals("parkinges",newParking.getName());
                    return true;
                });

    }

    @Test
    public void getUsers(){

        Parking p =new Parking("parkingldl", "ldlpar@outlook.com",9,21);
        Parking p1 =new Parking("parkinges", "espar@outlook.com",9,21);
        parkingRepository.save(p);

        parkingRepository.save(p1);
        assertTrue(parkingRepository.findAll()!=null);
    }

    @Test
    public void deleteUser(){
        Parking p =new Parking("parkingldl", "ldlpar@outlook.com",9,21);
        parkingRepository.save(p);
        parkingRepository.delete(p);
        assertTrue(parkingRepository.findAll().isEmpty());
    }

}
