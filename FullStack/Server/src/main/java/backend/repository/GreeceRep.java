package backend.repository;

import backend.model.Greece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreeceRep extends JpaRepository<Greece, Long> {
}
