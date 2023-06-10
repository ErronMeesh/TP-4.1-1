package backend.service;

import backend.model.Greece;
import backend.model.Plane;
import backend.repository.GreeceRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class GreeceService {
    private final GreeceRep greeceRep;

    @Autowired
    public GreeceService(GreeceRep greeceRep) {
        this.greeceRep = greeceRep;
    }

    public void add(Greece value) {
        this.greeceRep.save(value);
    }

    public void remove(Greece value) {
        this.greeceRep.delete(value);
    }

    public List<Greece> getAll() {
        return this.greeceRep.findAll();
    }

    public Greece getById(Long id) {
        return greeceRep.getById(id);
    }

    public List<Greece> getByDepartureP(String point) {
        List<Greece> list = new LinkedList<>();
        for (Greece value : getAll()) {
            if (value.getDepartureP().equals(point)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Greece> getByDestinationP(String point) {
        List<Greece> list = new LinkedList<>();
        for (Greece value : getAll()) {
            if (value.getDestinationP().equals(point)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Greece> getByDepartureTime(Date time) {
        List<Greece> list = new LinkedList<>();
        for (Greece value : getAll()) {
            if (value.getDepartureTime().equals(time)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Greece> getByDestinationTime(Date time) {
        List<Greece> list = new LinkedList<>();
        for (Greece value : getAll()) {
            if (value.getDestinationTime().equals(time)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<Greece> getByPlane(Plane plane) {
        List<Greece> list = new LinkedList<>();
        for (Greece value : getAll()) {
            if (value.getPlaneId().equals(plane)) {
                list.add(value);
            }
        }
        return list;
    }

    //    выдаёт список по цене в указаных пределах (предел можно задать как null, чтоб он не учитывался)
    public List<Greece> getByPrice(Float min_price, Float max_price) {
        if (min_price == null) {
            min_price = Float.MIN_VALUE;
        }
        if (max_price == null) {
            max_price = Float.MAX_VALUE;
        }
        List<Greece> list = new LinkedList<>();
        for (Greece value : getAll()) {
            if (value.getPriceOfEc() >= min_price && value.getPriceOfEc() <= max_price
                    || value.getPriceOfBc() >= min_price && value.getPriceOfBc() <= max_price) {
                list.add(value);
            }
        }
        return list;
    }
}
