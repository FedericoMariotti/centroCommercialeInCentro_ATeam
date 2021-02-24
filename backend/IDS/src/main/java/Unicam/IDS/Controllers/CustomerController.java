package Unicam.IDS.Controllers;

import Unicam.IDS.Model.AccountSystem.Customer;
import Unicam.IDS.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }


    // SELEZIONARE TUTTI I CUSTOMER
    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/customers")
    public List<Customer> all() {
        return service.getCustomers();
    }
    // end::get-aggregate-root[]

    // AGGIUNGERE UN CUSTOMER
    @PostMapping("/customers")
    public Customer newCustomer(@RequestBody Customer newCustomer) {
        return service.createCustomer(newCustomer);
    }

    // SELEZIONARE UN CUSTOMER
    @GetMapping("/customers/{id}")
    public Customer one(@PathVariable Long id) {

        return service.getCustomerbyID(id);
    }



    //AGGIORNARE UN CUSTOMER
    @RequestMapping( value = "/customers/{id}", method = RequestMethod.PUT)
    public Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {

        return service.updateCustomer(newCustomer,id);
    }

//RIMUOVERE UN CUSTOMER
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }
}
