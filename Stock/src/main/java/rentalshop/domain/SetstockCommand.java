package rentalshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class SetstockCommand {

    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long rentalShopId;
    private String carName;
    private String carType;
    private Integer qty;
}
