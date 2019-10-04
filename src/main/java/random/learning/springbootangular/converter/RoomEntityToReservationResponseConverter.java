package random.learning.springbootangular.converter;

import org.springframework.core.convert.converter.Converter;
import random.learning.springbootangular.entity.RoomEntity;
import random.learning.springbootangular.model.Links;
import random.learning.springbootangular.model.Self;
import random.learning.springbootangular.model.response.ReservationResponse;
import random.learning.springbootangular.rest.ResourceConstants;

public class RoomEntityToReservationResponseConverter implements Converter<RoomEntity, ReservationResponse> {

    @Override
    public ReservationResponse convert(RoomEntity source) {
        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setId(source.getId());
        reservationResponse.setRoomNumber(source.getRoomNumber());
        reservationResponse.setPrice(Integer.valueOf(source.getPrice()));

        Links links = new Links();
        Self self = new Self();
        self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
        links.setSelf(self);
        reservationResponse.setLinks(links);
        return reservationResponse;
    }
}
