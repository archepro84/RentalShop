package rentalshop.domain;

import java.util.*;
import lombok.*;
import rentalshop.domain.*;
import rentalshop.infra.AbstractEvent;

@Data
@ToString
public class CarCanceled extends AbstractEvent {

    private Long id;
    private Long customerId;
    private Long rentalShopId;
    private Long stockId;
    private String rentalStatus;
    private Integer qty;

    public CarCanceled(Rental aggregate) {
        super(aggregate);
    }

    public CarCanceled() {
        super();
    }
}
