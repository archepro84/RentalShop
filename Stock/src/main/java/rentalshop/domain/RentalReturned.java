package rentalshop.domain;

import java.util.*;
import lombok.*;
import rentalshop.domain.*;
import rentalshop.infra.AbstractEvent;

@Data
@ToString
public class RentalReturned extends AbstractEvent {

    private Long id;
    private Long rentalId;
    private Long customerId;
    private Long stockId;
    private String rentalStatus;
    private Integer qty;
}
