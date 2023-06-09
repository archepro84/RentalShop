package rentalshop.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class PaymentCommand {

    @Id
    private Long id;

    private Long rentalId;
    private Integer price;
}
