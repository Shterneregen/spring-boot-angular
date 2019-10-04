package random.learning.springbootangular.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import random.learning.springbootangular.entity.RoomEntity;

public interface PageableRoomRepository extends PagingAndSortingRepository<RoomEntity, Long> {

    Page<RoomEntity> findById(Long id, Pageable page);
}
