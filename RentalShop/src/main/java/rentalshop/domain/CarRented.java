package rentalshop.domain;

import lombok.Data;
import lombok.ToString;
import rentalshop.infra.AbstractEvent;

import java.util.Date;

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

}
