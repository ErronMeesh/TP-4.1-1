package backend.repository;

import backend.model.Plane;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
// в типах данных указываем тип объекта который храним (модель) и тип ключа (id)
public interface PlaneRep extends JpaRepository<Plane, Long> {
}
