package backend.service;

import backend.model.Spain;
import backend.model.Plane;
import backend.repository.SpainRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class SpainService {
    private final SpainRep spainRep;

    @Autowired
    public SpainService(SpainRep spainRep) {
        this.spainRep = spainRep;
    }

    public void add(Spain value) {
        this.spainRep.save(value);
    }

    public void remove(Spain value) {
        this.spainRep.delete(value);
    }

    public List<Spain> getAll() {
        return this.spainRep.findAll();
    }

    public Spain getById(Long id) {
        return spainRep.getById(id);
    }

    public List<Spain> getByDepartureP(String point) {
        List<Spain> list = new LinkedList<>();
        for (Spain value : getAll()) {
            if (value.getDepartureP().equals(point)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Spain> getByDestinationP(String point) {
        List<Spain> list = new LinkedList<>();
        for (Spain value : getAll()) {
            if (value.getDestinationP().equals(point)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Spain> getByDepartureTime(Date time) {
        List<Spain> list = new LinkedList<>();
        for (Spain value : getAll()) {
            if (value.getDepartureTime().equals(time)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Spain> getByDestinationTime(Date time) {
        List<Spain> list = new LinkedList<>();
        for (Spain value : getAll()) {
            if (value.getDestinationTime().equals(time)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Spain> getByPlane(Plane plane) {
        List<Spain> list = new LinkedList<>();
        for (Spain value : getAll()) {
            if (value.getPlaneId().equals(plane)) {
                list.add(value);
            }
        }
        return list;
    }

    //    выдаёт список по цене в указаных пределах (предел можно задать как null, чтоб он не учитывался)
    public List<Spain> getByPrice(Float min_price, Float max_price) {
        if (min_price == null) {
            min_price = Float.MIN_VALUE;
        }
        if (max_price == null) {
            max_price = Float.MAX_VALUE;
        }
        List<Spain> list = new LinkedList<>();
        for (Spain value : getAll()) {
            if (value.getPriceOfEc() >= min_price && value.getPriceOfEc() <= max_price
                    || value.getPriceOfBc() >= min_price && value.getPriceOfBc() <= max_price) {
                list.add(value);
            }
        }
        return list;
    }
}
