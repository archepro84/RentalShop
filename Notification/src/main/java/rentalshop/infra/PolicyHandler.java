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
    NotificationRepository notificationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RentalCanceled'"
    )
    public void wheneverRentalCanceled_SendNotification(
        @Payload RentalCanceled rentalCanceled
    ) {
        RentalCanceled event = rentalCanceled;
        System.out.println(
            "\n\n##### listener SendNotification : " + rentalCanceled + "\n\n"
        );

        // Sample Logic //
        Notification.sendNotification(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RentalDropOff'"
    )
    public void wheneverRentalDropOff_SendNotification(
        @Payload RentalDropOff rentalDropOff
    ) {
        RentalDropOff event = rentalDropOff;
        System.out.println(
            "\n\n##### listener SendNotification : " + rentalDropOff + "\n\n"
        );

        // Sample Logic //
        Notification.sendNotification(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RentalAccepted'"
    )
    public void wheneverRentalAccepted_SendNotification(
        @Payload RentalAccepted rentalAccepted
    ) {
        RentalAccepted event = rentalAccepted;
        System.out.println(
            "\n\n##### listener SendNotification : " + rentalAccepted + "\n\n"
        );

        // Sample Logic //
        Notification.sendNotification(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RentalRejected'"
    )
    public void wheneverRentalRejected_SendNotification(
        @Payload RentalRejected rentalRejected
    ) {
        RentalRejected event = rentalRejected;
        System.out.println(
            "\n\n##### listener SendNotification : " + rentalRejected + "\n\n"
        );

        // Sample Logic //
        Notification.sendNotification(event);
    }
}
