package random.learning.springbootangular.converter;

import org.springframework.core.convert.converter.Converter;
import random.learning.springbootangular.entity.ReservationEntity;
import random.learning.springbootangular.model.request.ReservationRequest;

public class ReservationRequestToReservationEntityConverter implements Converter<ReservationRequest, ReservationEntity> {
    @Override
    public ReservationEntity convert(ReservationRequest source) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setCheckin(source.getCheckin());
        reservationEntity.setCheckout(source.getCheckout());
        if (source.getId() != null) {
            reservationEntity.setId(source.getId());
        }
        return reservationEntity;
    }
}
