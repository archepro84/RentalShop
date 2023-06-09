package rentalshop.domain;

import lombok.Data;
import lombok.ToString;
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

}
