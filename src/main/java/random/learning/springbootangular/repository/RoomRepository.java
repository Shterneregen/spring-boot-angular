package random.learning.springbootangular.repository;

import org.springframework.data.repository.CrudRepository;
import random.learning.springbootangular.entity.RoomEntity;

import java.util.Optional;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
    Optional<RoomEntity> findById(Long id);
}
