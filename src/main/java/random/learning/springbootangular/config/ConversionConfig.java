package random.learning.springbootangular.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import random.learning.springbootangular.converter.ReservationEntityToReservationResponseConverter;
import random.learning.springbootangular.converter.ReservationRequestToReservationEntityConverter;
import random.learning.springbootangular.converter.RoomEntityToReservableRoomConverter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionConfig {

    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<>();
        converters.add(new RoomEntityToReservableRoomConverter());
        converters.add(new ReservationEntityToReservationResponseConverter());
        converters.add(new ReservationRequestToReservationEntityConverter());
        return converters;
    }

    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();
        return bean.getObject();
    }

}
