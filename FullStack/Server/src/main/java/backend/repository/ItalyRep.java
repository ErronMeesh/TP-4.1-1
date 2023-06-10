package backend.repository;

import backend.model.Italy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItalyRep extends JpaRepository<Italy, Long> {
}
