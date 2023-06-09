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
        condition = "headers['type']=='CarReturned'"
    )
    public void wheneverCarReturned_ReturnRental(
        @Payload CarReturned carReturned
    ) {
        CarReturned event = carReturned;
        System.out.println(
            "\n\n##### listener ReturnRental : " + carReturned + "\n\n"
        );

        // Sample Logic //
        RentalShop.returnRental(event);
    }
}
