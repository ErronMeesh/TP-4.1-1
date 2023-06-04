package backend.repository;

import backend.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRep extends JpaRepository<Passenger, Long> {
}
