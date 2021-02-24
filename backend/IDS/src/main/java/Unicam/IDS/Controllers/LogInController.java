package Unicam.IDS.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogInController {
    @Autowired
    CustomerController customerController;
    @Autowired
    SellerController sellerController;
    @Autowired
    DeliverController deliverController;


    @GetMapping("/accounts/{id}")
    public String getPassword(@PathVariable Long id) {

            for (int i = 0; i < customerController.all().size(); i++) {
                if (customerController.all().get(i).getID() == id) return customerController.all().get(i).getPassword();
            }
            for (int i = 0; i < sellerController.all().size(); i++) {
                if (sellerController.all().get(i).getID() == id) return sellerController.all().get(i).getPassword();
            }
            for (int i = 0; i < deliverController.all().size(); i++) {
                if (deliverController.all().get(i).getID() == id) return deliverController.all().get(i).getPassword();
            }

      return  null;

    }
}
