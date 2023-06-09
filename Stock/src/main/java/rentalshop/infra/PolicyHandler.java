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
    StockRepository stockRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RentalDropOff'"
    )
    public void wheneverRentalDropOff_IncreaseStock(
        @Payload RentalDropOff rentalDropOff
    ) {
        RentalDropOff event = rentalDropOff;
        System.out.println(
            "\n\n##### listener IncreaseStock : " + rentalDropOff + "\n\n"
        );

        // Sample Logic //
        Stock.increaseStock(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RentalAccepted'"
    )
    public void wheneverRentalAccepted_DecreaseStock(
        @Payload RentalAccepted rentalAccepted
    ) {
        RentalAccepted event = rentalAccepted;
        System.out.println(
            "\n\n##### listener DecreaseStock : " + rentalAccepted + "\n\n"
        );

        // Sample Logic //
        Stock.decreaseStock(event);
    }
}
