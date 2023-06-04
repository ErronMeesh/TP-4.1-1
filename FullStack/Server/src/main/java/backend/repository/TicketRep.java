package backend.repository;

import backend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRep extends JpaRepository<Ticket, Long> {
}
