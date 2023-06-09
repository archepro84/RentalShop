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
    RentalRepository rentalRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentReceived'"
    )
    public void wheneverPaymentReceived_UpdateRentalStatus(
        @Payload PaymentReceived paymentReceived
    ) {
        PaymentReceived event = paymentReceived;
        System.out.println(
            "\n\n##### listener UpdateRentalStatus : " +
            paymentReceived +
            "\n\n"
        );

        // Sample Logic //
        Rental.updateRentalStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RentalAccepted'"
    )
    public void wheneverRentalAccepted_UpdateRentalStatus(
        @Payload RentalAccepted rentalAccepted
    ) {
        RentalAccepted event = rentalAccepted;
        System.out.println(
            "\n\n##### listener UpdateRentalStatus : " + rentalAccepted + "\n\n"
        );

        // Sample Logic //
        Rental.updateRentalStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RentalRejected'"
    )
    public void wheneverRentalRejected_UpdateRentalStatus(
        @Payload RentalRejected rentalRejected
    ) {
        RentalRejected event = rentalRejected;
        System.out.println(
            "\n\n##### listener UpdateRentalStatus : " + rentalRejected + "\n\n"
        );

        // Sample Logic //
        Rental.updateRentalStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RentalCanceled'"
    )
    public void wheneverRentalCanceled_UpdateRentalStatus(
        @Payload RentalCanceled rentalCanceled
    ) {
        RentalCanceled event = rentalCanceled;
        System.out.println(
            "\n\n##### listener UpdateRentalStatus : " + rentalCanceled + "\n\n"
        );

        // Sample Logic //
        Rental.updateRentalStatus(event);
    }
}
