package backend.service;

import backend.model.Passenger;
import backend.model.Ticket;
import backend.model.User;
import backend.repository.PassengerRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PassengerService {
    private final PassengerRep passengerRep;

    @Autowired
    public PassengerService(PassengerRep passengerRep) {
        this.passengerRep = passengerRep;
    }

    public void add(Passenger value) {
        this.passengerRep.save(value);
    }

    public void remove(Passenger value) {
        this.passengerRep.delete(value);
    }

    public List<Passenger> getAll() {
        return this.passengerRep.findAll();
    }

    public Passenger getById(Long id) {
        return passengerRep.getById(id);
    }

    //    выдаёт список по точному совпадению в любом из полей имён
//    (например отдаёшь "иван", получаешь всех кто "иван", "иванов" или "иванович" и т.д.)
    public List<Passenger> getByName(String name) {
        name = name.toLowerCase();
        List<Passenger> list = new LinkedList<>();
        for (Passenger value : getAll()) {
            if (value.getSurname().toLowerCase().contains(name) || value.getName().toLowerCase().contains(name)
                    || value.getLastname() != null && value.getLastname().toLowerCase().contains(name)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Passenger> getByPhoneNumber(String number) {
        List<Passenger> list = new LinkedList<>();
        for (Passenger value : getAll()) {
            if (value.getPhoneNumber().equals(number)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Passenger> getByMail(String mail) {
        List<Passenger> list = new LinkedList<>();
        for (Passenger value : getAll()) {
            if (value.getMail().equals(mail)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Passenger> getByDocNum(String doc) {
        List<Passenger> list = new LinkedList<>();
        for (Passenger value : getAll()) {
            if (value.getDocNum().equals(doc)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Passenger> getByDocSeries(String doc) {
        List<Passenger> list = new LinkedList<>();
        for (Passenger value : getAll()) {
            if (value.getDocSeries().equals(doc)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Passenger> getByUser(User user) {
        List<Passenger> list = new LinkedList<>();
        for (Passenger value : getAll()) {
            if (value.getUserId().equals(user)) {
                list.add(value);
            }
        }
        return list;
    }

//    public List<Passenger> getByUser(Ticket ticket) {
//        List<Passenger> list = new LinkedList<>();
//        for (Passenger value : getAll()) {
//            if (value.getTicketNumber().equals(ticket)) {
//                list.add(value);
//            }
//        }
//        return list;
//    }
}
