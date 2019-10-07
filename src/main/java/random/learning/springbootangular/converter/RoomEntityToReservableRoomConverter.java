package random.learning.springbootangular.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import random.learning.springbootangular.entity.RoomEntity;
import random.learning.springbootangular.model.Links;
import random.learning.springbootangular.model.Self;
import random.learning.springbootangular.model.response.ReservableRoomResponse;
import random.learning.springbootangular.rest.ResourceConstants;

@Component
public class RoomEntityToReservableRoomConverter implements Converter<RoomEntity, ReservableRoomResponse> {

    @Override
    public ReservableRoomResponse convert(RoomEntity source) {
        ReservableRoomResponse reservableRoomResponse = new ReservableRoomResponse();
        reservableRoomResponse.setId(source.getId());
        reservableRoomResponse.setRoomNumber(source.getRoomNumber());
        reservableRoomResponse.setPrice(Integer.valueOf(source.getPrice()));

        Links links = new Links();
        Self self = new Self();
        self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
        links.setSelf(self);
        reservableRoomResponse.setLinks(links);
        return reservableRoomResponse;
    }
}
