package rentalshop.domain;

import java.util.*;
import lombok.*;
import rentalshop.domain.*;
import rentalshop.infra.AbstractEvent;

@Data
@ToString
public class CarRented extends AbstractEvent {

    private Long id;
    private Long customerId;
    private Long rentalShopId;
    private Long stockId;
    private String rentalStatus;
    private Integer qty;
    private Date startedAt;
    private Date endedAt;

    public CarRented(Rental aggregate) {
        super(aggregate);
    }

    public CarRented() {
        super();
    }
}
