package backend.repository;

import backend.model.Spain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpainRep extends JpaRepository<Spain, Long> {
}
