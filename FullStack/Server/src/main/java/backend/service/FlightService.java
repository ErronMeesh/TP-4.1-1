package backend.service;

import backend.model.Flight;
import backend.model.Plane;
import backend.repository.FlightRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class FlightService {
    private final FlightRep flightRep;

    @Autowired
    public FlightService(FlightRep flightRep) {
        this.flightRep = flightRep;
    }

    public void add(Flight value) {
        this.flightRep.save(value);
    }

    public void remove(Flight value) {
        this.flightRep.delete(value);
    }

    public List<Flight> getAll() {
        return this.flightRep.findAll();
    }

    public Flight getById(Long id) {
        return flightRep.getById(id);
    }

    public List<Flight> getByDepartureP(String point) {
        List<Flight> list = new LinkedList<>();
        for (Flight value : getAll()) {
            if (value.getDepartureP().equals(point)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Flight> getByDestinationP(String point) {
        List<Flight> list = new LinkedList<>();
        for (Flight value : getAll()) {
            if (value.getDestinationP().equals(point)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Flight> getByDepartureTime(Date time) {
        List<Flight> list = new LinkedList<>();
        for (Flight value : getAll()) {
            if (value.getDepartureTime().equals(time)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Flight> getByDestinationTime(Date time) {
        List<Flight> list = new LinkedList<>();
        for (Flight value : getAll()) {
            if (value.getDestinationTime().equals(time)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Flight> getByPlane(Plane plane) {
        List<Flight> list = new LinkedList<>();
        for (Flight value : getAll()) {
            if (value.getPlaneId().equals(plane)) {
                list.add(value);
            }
        }
        return list;
    }

    //    выдаёт список по цене в указаных пределах (предел можно задать как null, чтоб он не учитывался)
    public List<Flight> getByPrice(Float min_price, Float max_price) {
        if (min_price == null) {
            min_price = Float.MIN_VALUE;
        }
        if (max_price == null) {
            max_price = Float.MAX_VALUE;
        }
        List<Flight> list = new LinkedList<>();
        for (Flight value : getAll()) {
            if (value.getPriceOfEc() >= min_price && value.getPriceOfEc() <= max_price
                    || value.getPriceOfBc() >= min_price && value.getPriceOfBc() <= max_price) {
                list.add(value);
            }
        }
        return list;
    }
}
