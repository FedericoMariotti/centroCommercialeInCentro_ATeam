package Unicam.IDS;

import Unicam.IDS.Model.AccountSystem.Deliver;
import Unicam.IDS.Model.Locker;
import Unicam.IDS.Repo.DeliverRepository;
import Unicam.IDS.Repo.LockerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class LockerTest {



    @Autowired
    private LockerRepository lockerRepository;

    @Test
    public void testSaveLocker(){
        Locker l = new Locker("Punto di ritiro 1","qwerty1@outlook.com",32834586,10,20);
        lockerRepository.save(l);
        lockerRepository.findById(new Long(1))
                .map(newAccount ->{
                    assertEquals("Luca" , newAccount.getName());
                    return true;
                });
    }

    @Test
    public void getLocker(){
        Locker l = new Locker("Punto di ritiro 1","Loc san paolo",32834586,10,20);
        Locker l1 = new Locker("Ufficio Postale  piazza","Piazza dante",12345,8,13);
        lockerRepository.save(l);
        lockerRepository.save(l1);
        lockerRepository.findById(new Long(1))
                .map(newLocker ->{
                    assertEquals("Luca",newLocker.getName());
                    return true;
                });
        assertFalse(lockerRepository.findById(new Long(1)) != lockerRepository.findById(new Long (2)));

    }

    @Test
    public void getLockers(){
        Locker l = new Locker("Punto di ritiro 1","qwerty1@outlook.com",32834586,10,20);
        Locker l1 = new Locker("Ufficio Postale  piazza","Piazza dante",12345,8,13);
        lockerRepository.save(l);
        lockerRepository.save(l1);
        assertTrue(lockerRepository.findAll()!=null);
    }

    @Test
    public void deleteLocker(){
        Locker l = new Locker("Punto di ritiro 1","qwerty1@outlook.com",32834586,10,20);
        lockerRepository.save(l);
        lockerRepository.delete(l);
        assertTrue(lockerRepository.findAll().isEmpty());
    }




}

