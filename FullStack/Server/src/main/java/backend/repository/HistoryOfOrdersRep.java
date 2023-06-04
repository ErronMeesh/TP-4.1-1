package backend.repository;

import backend.model.HistoryOfOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryOfOrdersRep extends JpaRepository<HistoryOfOrders, Long> {
}
