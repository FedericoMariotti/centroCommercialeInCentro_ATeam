package Unicam.IDS.Service;

import Unicam.IDS.Model.AccountSystem.Deliver;
import Unicam.IDS.Model.Locker;
import Unicam.IDS.Model.OrderStatus;
import Unicam.IDS.Repo.DeliverRepository;
import Unicam.IDS.Repo.LockerRepository;
import Unicam.IDS.Repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LockerService {

    @Autowired
    LockerRepository repository;


    public Locker createLocker(Locker locker) {

        return repository.save(locker);
    }

    public Locker updateLocker(Locker newLocker, long id) {

        return repository.findById(id)
                .map(locker -> {
                    locker.setCellNumber(newLocker.getCellNumber());
                    locker.setName(newLocker.getName());
                    locker.setAddress(newLocker.getAddress());
                    locker.setOpeningTime(newLocker.getOpeningTime());
                    locker.setClosingTime(newLocker.getClosingTime());
                    return repository.save(locker);
                })
                .orElseGet(() -> {
                    newLocker.setID(id);
                    return repository.save(newLocker);
                });

    }



    public void deleteLocker(long id) {
        repository.deleteById(id);

    }

    public List<Locker> getLocker() {
        return repository.findAll();
    }

    public Locker getLockerbyID(long ID) {
        return repository.findById(ID)
                .orElseThrow(() -> new NullPointerException());
    }


    public void changeStatus(OrderStatus newStatus, long orderId){
        OrderService.getOrderbyID(orderId).setStatus(newStatus);
        return;

    }
}

