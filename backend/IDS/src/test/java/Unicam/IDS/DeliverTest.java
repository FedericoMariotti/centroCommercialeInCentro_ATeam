package Unicam.IDS;

import Unicam.IDS.Model.AccountSystem.Deliver;
import Unicam.IDS.Repo.DeliverRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class DeliverTest {



    @Autowired
    private DeliverRepository deliverRepository;

    @Test
    public void testSaveAccount(){
        Deliver d = new Deliver(354554554,"qwerty1@outlook.com","qwerty","Luca","Rossi");
        deliverRepository.save(d);
        deliverRepository.findById(new Long(1))
                .map(newAccount ->{
                    assertEquals("Luca" , newAccount.getName());
                    return true;
                });
    }

    @Test
    public void getAccount(){
        Deliver d = new Deliver(354554554,"qwerty1@outlook.com","qwerty","Luca","Rossi");
        Deliver d1 = new Deliver(354554552,"qwerty1@outlook.com","12345","Francesco","Pecchia");
        deliverRepository.save(d);
        deliverRepository.save(d1);
        deliverRepository.findById(new Long(1))
                .map(newUser ->{
                    assertEquals("Luca",newUser.getName());
                    return true;
                });
        assertFalse(deliverRepository.findById(new Long(1)) == deliverRepository.findById(new Long (2)));

    }

    @Test
    public void getUsers(){
        Deliver d = new Deliver(354554554,"qwerty1@outlook.com","qwerty","Luca","Rossi");
        Deliver d1 = new Deliver(354554552,"qwerty1@outlook.com","12345","Francesco","Pecchia");
        deliverRepository.save(d);

        deliverRepository.save(d1);
        assertTrue(deliverRepository.findAll()!=null);
    }

    @Test
    public void deleteUser(){
        Deliver d = new Deliver(354554554,"qwerty1@outlook.com","qwerty","Luca","Rossi");
        deliverRepository.save(d);
        deliverRepository.delete(d);
        assertTrue(deliverRepository.findAll().isEmpty());
    }


}

