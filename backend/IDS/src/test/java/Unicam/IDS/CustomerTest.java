package Unicam.IDS;

import Unicam.IDS.Model.AccountSystem.Customer;
import Unicam.IDS.Repo.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CustomerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveAccount(){
        Customer c = new Customer(354554554,"qwerty1@outlook.com","qwerty","johhny","ard","Via de gasperi, Matewlica,IT");
        customerRepository.save(c);
        customerRepository.findById(new Long(1))
                .map(newAccount ->{
                    assertEquals("johhny" , newAccount.getName());
                    return true;
                });
    }

    @Test
    public void testGetAccount(){
        Customer c = new Customer(354554554,"qwerty1@outlook.com","qwerty","johhny","ard","Via de gasperi, Matewlica,IT");
        Customer c2 = new Customer(458454443,"eruiuqro@ioppo.it","elallala","danie","super","via corso 3");
        customerRepository.save(c);

        customerRepository.save(c2);

        customerRepository.findById(new Long(1))
                .map(newUser ->{
                    assertEquals("danie",newUser.getName());
                    return true;
                });

    }

    @Test
    public void testGetUsers(){
        Customer c = new Customer(354554554,"qwerty1@outlook.com","qwerty","johhny","ard","Via de gasperi, Matewlica,IT");
        Customer c2 = new Customer(458454443,"eruiuqro@ioppo.it","elallala","danie","super","via corso 3");
        customerRepository.save(c);

        customerRepository.save(c2);
        assertTrue(customerRepository.findAll()!=null);
    }

    @Test
    public void testDeleteUser(){
        Customer c = new Customer(354554554,"qwerty1@outlook.com","qwerty","johhny","ard","Via de gasperi, Matewlica,IT");
        customerRepository.save(c);
        customerRepository.delete(c);
        assertTrue(customerRepository.findAll().isEmpty());
    }


}

