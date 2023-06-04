package backend.repository;

import backend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRep extends JpaRepository<Flight, Long> {
}
