package rentalshop.domain;

import java.util.*;
import lombok.*;
import rentalshop.domain.*;
import rentalshop.infra.AbstractEvent;

@Data
@ToString
public class OutOfStocked extends AbstractEvent {

    private Long id;

    public OutOfStocked(Stock aggregate) {
        super(aggregate);
    }

    public OutOfStocked() {
        super();
    }
}
