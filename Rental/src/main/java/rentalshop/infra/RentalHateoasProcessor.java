package rentalshop.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import rentalshop.domain.*;

@Component
public class RentalHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Rental>> {

    @Override
    public EntityModel<Rental> process(EntityModel<Rental> model) {
        return model;
    }
}
