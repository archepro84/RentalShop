package rentalshop.external;

import java.util.Date;
import lombok.Data;

@Data
public class Payment {

    private Long id;
    private Long rentalId;
    private Integer price;
}
