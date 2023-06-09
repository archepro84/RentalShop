package rentalshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class RentalCommand {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long customerId;
    private Long rentalShopId;
    private Long stockId;
    private String rentalStatus;
    private Integer qty;
    private Date startedAt;
    private Date endedAt;
}
