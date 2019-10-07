package random.learning.springbootangular.repository;

import org.springframework.data.repository.CrudRepository;
import random.learning.springbootangular.entity.ReservationEntity;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {
}
