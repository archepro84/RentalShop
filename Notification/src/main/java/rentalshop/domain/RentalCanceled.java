package rentalshop.domain;

import lombok.Data;
import lombok.ToString;
import rentalshop.infra.AbstractEvent;

@Data
@ToString
public class RentalCanceled extends AbstractEvent {

    private Long id;
    private Long rentalId;
    private Long customerId;
    private String rentalStatus;

}
