package backend.service;

import backend.model.Italy;
import backend.model.Plane;
import backend.repository.ItalyRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class ItalyService {
    private final ItalyRep italyRep;

    @Autowired
    public ItalyService(ItalyRep italyRep) {
        this.italyRep = italyRep;
    }

    public void add(Italy value) {
        this.italyRep.save(value);
    }

    public void remove(Italy value) {
        this.italyRep.delete(value);
    }

    public List<Italy> getAll() {
        return this.italyRep.findAll();
    }

    public Italy getById(Long id) {
        return italyRep.getById(id);
    }

    public List<Italy> getByDepartureP(String point) {
        List<Italy> list = new LinkedList<>();
        for (Italy value : getAll()) {
            if (value.getDepartureP().equals(point)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Italy> getByDestinationP(String point) {
        List<Italy> list = new LinkedList<>();
        for (Italy value : getAll()) {
            if (value.getDestinationP().equals(point)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Italy> getByDepartureTime(Date time) {
        List<Italy> list = new LinkedList<>();
        for (Italy value : getAll()) {
            if (value.getDepartureTime().equals(time)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Italy> getByDestinationTime(Date time) {
        List<Italy> list = new LinkedList<>();
        for (Italy value : getAll()) {
            if (value.getDestinationTime().equals(time)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Italy> getByPlane(Plane plane) {
        List<Italy> list = new LinkedList<>();
        for (Italy value : getAll()) {
            if (value.getPlaneId().equals(plane)) {
                list.add(value);
            }
        }
        return list;
    }

    //    выдаёт список по цене в указаных пределах (предел можно задать как null, чтоб он не учитывался)
    public List<Italy> getByPrice(Float min_price, Float max_price) {
        if (min_price == null) {
            min_price = Float.MIN_VALUE;
        }
        if (max_price == null) {
            max_price = Float.MAX_VALUE;
        }
        List<Italy> list = new LinkedList<>();
        for (Italy value : getAll()) {
            if (value.getPriceOfEc() >= min_price && value.getPriceOfEc() <= max_price
                    || value.getPriceOfBc() >= min_price && value.getPriceOfBc() <= max_price) {
                list.add(value);
            }
        }
        return list;
    }
}
