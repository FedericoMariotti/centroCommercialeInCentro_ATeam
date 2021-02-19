package Unicam.IDS.Service;

import Unicam.IDS.Model.AccountSystem.Deliver;
import Unicam.IDS.Model.OrderStatus;
import Unicam.IDS.Repo.DeliverRepository;
import Unicam.IDS.Repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeliverService {

        @Autowired
        DeliverRepository repository;


        public Deliver createDeliver(Deliver deliver) {

            return repository.save(deliver);
        }

        public Deliver updateDeliver(Deliver newDeliver, long id) {

            return repository.findById(id)
                    .map(deliver -> {
                        deliver.setCellNumber(newDeliver.getCellNumber());
                        deliver.setEmail(newDeliver.getEmail());
                        deliver.setPassword(newDeliver.getPassword());
                        deliver.setName(newDeliver.getName());
                        deliver.setSurname(newDeliver.getSurname());
                        return repository.save(deliver);
                    })
                    .orElseGet(() -> {
                        newDeliver.setId(id);
                        return repository.save(newDeliver);
                    });

        }



        public void deleteDeliver(long id) {
            repository.deleteById(id);

        }

        public List<Deliver> getDeliver() {
            return repository.findAll();
        }

        public Deliver getDeliverbyID(long ID) {
            return repository.findById(ID)
                    .orElseThrow(() -> new NullPointerException());
        }


        public void changeStatus(OrderStatus newStatus, long orderId){
            OrderService.getOrderbyID(orderId).setStatus(newStatus);
            return;

        }
}

