package rentalshop.domain;

import java.util.*;
import lombok.*;
import rentalshop.domain.*;
import rentalshop.infra.AbstractEvent;

@Data
@ToString
public class PaymentReceived extends AbstractEvent {

    private Long id;
    private Long rentalId;
    private Integer price;

    public PaymentReceived(Payment aggregate) {
        super(aggregate);
    }

    public PaymentReceived() {
        super();
    }
}
