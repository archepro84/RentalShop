package rentalshop.domain;

import java.util.*;
import lombok.*;
import rentalshop.domain.*;
import rentalshop.infra.AbstractEvent;

@Data
@ToString
public class CarDropOff extends AbstractEvent {

    private Long id;
    private Long customerId;
    private Long rentalShopId;
    private Long stockId;
    private String rentalStatus;
}
