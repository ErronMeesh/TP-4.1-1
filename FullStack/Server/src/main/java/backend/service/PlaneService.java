package backend.service;

import backend.model.Plane;
import backend.repository.PlaneRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PlaneService {
    private final PlaneRep planeRep;

    @Autowired
    public PlaneService(PlaneRep planeRep) {
        this.planeRep = planeRep;
    }

    public void add(Plane value) {
        this.planeRep.save(value);
    }

    public void remove(Plane value) {
        this.planeRep.delete(value);
    }

    public List<Plane> getAll() {
        return this.planeRep.findAll();
    }

    public Plane getById(Long id) {
        return planeRep.getById(id);
    }

    public List<Plane> getByName(String name) {
        List<Plane> list = new LinkedList<>();
        for (Plane value : getAll()) {
            if (value.getPlaneName().equals(name)) {
                list.add(value);
            }
        }
        return list;
    }
}
