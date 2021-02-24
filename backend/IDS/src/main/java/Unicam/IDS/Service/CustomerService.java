package Unicam.IDS.Service;


import Unicam.IDS.Model.AccountSystem.Customer;
import Unicam.IDS.Repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;


    public Customer createCustomer(Customer customer) {

       return repository.save(customer);
    }

    public Customer updateCustomer(Customer newCustomer, long id) {

        return repository.findById(id)
                .map(customer -> {
                    customer.setCellNumber(newCustomer.getCellNumber());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setPassword(newCustomer.getPassword());
                    customer.setName(newCustomer.getName());
                    customer.setSurname(newCustomer.getSurname());
                    return repository.save(customer);
                })
                .orElseGet(() -> {
                     newCustomer.setId(id);
                    return repository.save(newCustomer);
                });

    }



    public void deleteCustomer(long id) {
        repository.deleteById(id);

    }

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    public Customer getCustomerbyID(long ID) {
        return repository.findById(ID)
                .orElseThrow(() -> new NullPointerException());
    }

}