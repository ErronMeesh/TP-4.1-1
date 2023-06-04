package backend.service;

import backend.model.HistoryOfOrders;
import backend.model.User;
import backend.repository.HistoryOfOrdersRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class HistoryOfOrdersService {
    private final HistoryOfOrdersRep historyOfOrdersRep;

    @Autowired
    public HistoryOfOrdersService(HistoryOfOrdersRep historyOfOrdersRep) {
        this.historyOfOrdersRep = historyOfOrdersRep;
    }

    public void add(HistoryOfOrders value) {
        this.historyOfOrdersRep.save(value);
    }

    public void remove(HistoryOfOrders value) {
        this.historyOfOrdersRep.delete(value);
    }

    public List<HistoryOfOrders> getAll() {
        return this.historyOfOrdersRep.findAll();
    }

    public HistoryOfOrders getById(Long id) {
        return historyOfOrdersRep.getById(id);
    }

    public List<HistoryOfOrders> getByUser(User user) {
        List<HistoryOfOrders> list = new LinkedList<>();
        for (HistoryOfOrders value : getAll()) {
            if (value.getUserId().equals(user)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<HistoryOfOrders> getByDepartureP(String point) {
        List<HistoryOfOrders> list = new LinkedList<>();
        for (HistoryOfOrders value : getAll()) {
            if (value.getDepartureP().equals(point)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<HistoryOfOrders> getByDestinationP(String point) {
        List<HistoryOfOrders> list = new LinkedList<>();
        for (HistoryOfOrders value : getAll()) {
            if (value.getDestinationP().equals(point)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<HistoryOfOrders> getByDepartureTime(Date time) {
        List<HistoryOfOrders> list = new LinkedList<>();
        for (HistoryOfOrders value : getAll()) {
            if (value.getDepartureTime().equals(time)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<HistoryOfOrders> getByFlightId(Long id) {
        List<HistoryOfOrders> list = new LinkedList<>();
        for (HistoryOfOrders value : getAll()) {
            if (value.getFlightId().equals(id)) {
                list.add(value);
            }
        }
        return list;
    }

    //    выдаёт список по цене в указаных пределах (предел можно задать как null, чтоб он не учитывался)
    public List<HistoryOfOrders> getByPrice(Float min_price, Float max_price) {
        if (min_price == null) {
            min_price = Float.MIN_VALUE;
        }
        if (max_price == null) {
            max_price = Float.MAX_VALUE;
        }
        List<HistoryOfOrders> list = new LinkedList<>();
        for (HistoryOfOrders value : getAll()) {
            if (value.getPrice() >= min_price && value.getPrice() <= max_price) {
                list.add(value);
            }
        }
        return list;
    }
}
