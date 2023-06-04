package backend.repository;

import backend.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRep extends JpaRepository<Discount, String> {
}
