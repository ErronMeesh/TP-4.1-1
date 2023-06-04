package backend.service;

import backend.model.Passenger;
import backend.model.Ticket;
import backend.repository.TicketRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TicketService {
    private final TicketRep ticketRep;

    @Autowired
    public TicketService(TicketRep ticketRep) {
        this.ticketRep = ticketRep;
    }

    public void add(Ticket value) {
        this.ticketRep.save(value);
    }

    public void remove(Ticket value) {
        this.ticketRep.delete(value);
    }

    public List<Ticket> getAll() {
        return this.ticketRep.findAll();
    }

    public Ticket getById(Long id) {
        return ticketRep.getById(id);
    }

    public List<Ticket> getByFlightId(Long id) {
        List<Ticket> list = new LinkedList<>();
        for (Ticket value : getAll()) {
            if (value.getFlightId().equals(id)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Ticket> getByBusinessC(Boolean businessC) {
        List<Ticket> list = new LinkedList<>();
        for (Ticket value : getAll()) {
            if (value.getBusinessC().equals(businessC)) {
                list.add(value);
            }
        }
        return list;
    }

    //    выдаёт список по цене в указаных пределах (предел можно задать как null, чтоб он не учитывался)
    public List<Ticket> getByPrice(Float min_price, Float max_price) {
        if (min_price == null) {
            min_price = Float.MIN_VALUE;
        }
        if (max_price == null) {
            max_price = Float.MAX_VALUE;
        }
        List<Ticket> list = new LinkedList<>();
        for (Ticket value : getAll()) {
            if (value.getPrice() >= min_price && value.getPrice() <= max_price) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Ticket> getByPassenger(Passenger passenger) {
        List<Ticket> list = new LinkedList<>();
        for (Ticket value : getAll()) {
            if (value.getPassengerId().equals(passenger)) {
                list.add(value);
            }
        }
        return list;
    }
}
