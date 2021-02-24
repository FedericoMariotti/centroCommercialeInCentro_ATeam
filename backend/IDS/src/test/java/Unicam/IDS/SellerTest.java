package Unicam.IDS;

import Unicam.IDS.Model.AccountSystem.Deliver;
import Unicam.IDS.Model.AccountSystem.Seller;
import Unicam.IDS.Repo.DeliverRepository;
import Unicam.IDS.Repo.SellerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class SellerTest {



    @Autowired
    private SellerRepository sellerRepository;

    @Test
    public void testSaveAccount(){
        Seller s = new Seller(354554554,"qwerty1@outlook.com","qwerty","Luca","Rossi");
        sellerRepository.save(s);
        sellerRepository.findById(new Long(1))
                .map(newAccount ->{
                    assertEquals("Luca" , newAccount.getName());
                    return true;
                });
    }

    @Test
    public void getAccount(){
        Seller s = new Seller(354554554,"qwerty1@outlook.com","qwerty","Luca","Rossi");
        Seller s1 = new Seller(354554552,"qwerty1@outlook.com","12345","Francesco","Pecchia");
        sellerRepository.save(s);
        sellerRepository.save(s1);
        sellerRepository.findById(new Long(1))
                .map(newUser ->{
                    assertEquals("Luca",newUser.getName());
                    return true;
                });
        assertFalse(sellerRepository.findById(new Long(1)) != sellerRepository.findById(new Long (2)));

    }

    @Test
    public void getUsers(){
        Seller s = new Seller(354554554,"qwerty1@outlook.com","qwerty","Luca","Rossi");
        Seller s1 = new Seller(354554552,"qwerty1@outlook.com","12345","Francesco","Pecchia");
        sellerRepository.save(s);

        sellerRepository.save(s1);
        assertTrue(sellerRepository.findAll()!=null);
    }

    @Test
    public void deleteUser(){
        Seller s = new Seller(354554554,"qwerty1@outlook.com","qwerty","Luca","Rossi");
        sellerRepository.save(s);
        sellerRepository.delete(s);
        assertTrue(sellerRepository.findAll().isEmpty());
    }


}

