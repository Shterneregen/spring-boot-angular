package random.learning.springbootangular.converter;

import org.springframework.core.convert.converter.Converter;
import random.learning.springbootangular.entity.ReservationEntity;
import random.learning.springbootangular.model.response.ReservationResponse;

public class ReservationEntityToReservationResponseConverter
        implements Converter<ReservationEntity, ReservationResponse> {

    @Override
    public ReservationResponse convert(ReservationEntity source) {
        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setId(source.getId());
        reservationResponse.setCheckin(source.getCheckin());
        reservationResponse.setCheckout(source.getCheckout());
        return reservationResponse;
    }
}
