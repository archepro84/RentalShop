package rentalshop.domain;

import java.util.*;
import lombok.*;
import rentalshop.domain.*;
import rentalshop.infra.AbstractEvent;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@ToString
public class RentalDropOff extends AbstractEvent {

    private Long id;
    private Long rentalId;
    private Long customerId;
    private Long stockId;
    private String rentalStatus;
    private Integer qty;
}
