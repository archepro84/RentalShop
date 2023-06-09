package rentalshop.domain;

import java.util.*;
import lombok.*;
import rentalshop.domain.*;
import rentalshop.infra.AbstractEvent;

@Data
@ToString
public class RentalRejected extends AbstractEvent {

    private Long id;
    private Long rentalId;
    private Long customerId;
    private String rentalStatus;
}
