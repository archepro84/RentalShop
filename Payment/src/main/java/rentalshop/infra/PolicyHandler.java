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
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CarCanceled'"
    )
    public void wheneverCarCanceled_PaymentCancel(
        @Payload CarCanceled carCanceled
    ) {
        CarCanceled event = carCanceled;
        System.out.println(
            "\n\n##### listener PaymentCancel : " + carCanceled + "\n\n"
        );

        // Sample Logic //
        Payment.paymentCancel(event);
    }
}
