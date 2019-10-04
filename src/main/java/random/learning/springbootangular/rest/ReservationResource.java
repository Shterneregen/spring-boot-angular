package random.learning.springbootangular.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import random.learning.springbootangular.converter.RoomEntityToReservationResponseConverter;
import random.learning.springbootangular.entity.RoomEntity;
import random.learning.springbootangular.model.request.ReservationRequest;
import random.learning.springbootangular.model.response.ReservationResponse;
import random.learning.springbootangular.repository.PageableRoomRepository;
import random.learning.springbootangular.repository.RoomRepository;

import java.time.LocalDate;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {

    @Autowired
    private PageableRoomRepository pageableRoomRepository;
    @Autowired
    private RoomRepository roomRepository;

    private RoomEntityToReservationResponseConverter converter = new RoomEntityToReservationResponseConverter();

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<ReservationResponse> getAvailableRooms(
            @RequestParam(value = "checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkin,
            @RequestParam(value = "checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkout,
            Pageable pageable) {

        Page<RoomEntity> roomEntityList = pageableRoomRepository.findAll(pageable);
        return roomEntityList.map(converter::convert);
    }

    @GetMapping(path = "/{roomId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RoomEntity> getRoomById(@PathVariable Long roomId) {
        return ResponseEntity.of(roomRepository.findById(roomId));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> createReservation(@RequestBody ReservationRequest reservationRequest) {
        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> updateReservation(
            @RequestBody ReservationRequest reservationRequest) {
        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{reservationId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable long reservationId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
