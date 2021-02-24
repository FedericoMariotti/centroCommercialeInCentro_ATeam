package Unicam.IDS.Service;

import Unicam.IDS.Model.Parking;
import Unicam.IDS.Repo.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParkingService {

    @Autowired
    ParkingRepository repository;


    public Parking createParking(Parking parking) {

        return repository.save(parking);
    }

    public Parking updateParking(Parking newParking, long id) {

        return repository.findById(id)
                .map(parking -> {
                    parking.setName(newParking.getName());
                    parking.setAddress(newParking.getAddress());
                    parking.setOpeningTime(newParking.getOpeningTime());
                    parking.setClosingTime(newParking.getClosingTime());
                    return repository.save(parking);
                })
                .orElseGet(() -> {
                    newParking.setID(id);
                    return repository.save(newParking);
                });

    }



    public void deleteParking(long id) {
        repository.deleteById(id);

    }

    public List<Parking> getParking() {
        return repository.findAll();
    }

    public Parking getParkingbyID(long ID) {
        return repository.findById(ID)
                .orElseThrow(() -> new NullPointerException());
    }


}

