package backend.service;

import backend.model.Discount;
import backend.repository.DiscountRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {
    private final DiscountRep discountRep;

    @Autowired
    public DiscountService(DiscountRep discountRep) {
        this.discountRep = discountRep;
    }

    public void add(Discount value) {
        this.discountRep.save(value);
    }

    public void remove(Discount value) {
        this.discountRep.delete(value);
    }

    public List<Discount> getAll() {
        return this.discountRep.findAll();
    }

    public Discount getById(String id) {
        return discountRep.getById(id);
    }
}
