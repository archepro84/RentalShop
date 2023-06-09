package rentalshop.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import rentalshop.config.kafka.KafkaProcessor;
import rentalshop.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    RentalShopRepository rentalShopRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CarRented'"
    )
    public void wheneverCarRented_CreateRental(@Payload CarRented carRented) {
        CarRented event = carRented;
        System.out.println(
            "\n\n##### listener CreateRental : " + carRented + "\n\n"
        );

        // Sample Logic //
        RentalShop.createRental(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CarCanceled'"
    )
    public void wheneverCarCanceled_CancelRental(
        @Payload CarCanceled carCanceled
    ) {
        CarCanceled event = carCanceled;
        System.out.println(
            "\n\n##### listener CancelRental : " + carCanceled + "\n\n"
        );

        // Sample Logic //
        RentalShop.cancelRental(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CarDropOff'"
    )
    public void wheneverCarDropOff_DropOffRental(
        @Payload CarDropOff carDropOff
    ) {
        CarDropOff event = carDropOff;
        System.out.println(
            "\n\n##### listener DropOffRental : " + carDropOff + "\n\n"
        );

        // Sample Logic //
        RentalShop.dropOffRental(event);
    }
}
