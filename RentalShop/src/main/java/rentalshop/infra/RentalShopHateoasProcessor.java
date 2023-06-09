package rentalshop.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import rentalshop.domain.*;

@Component
public class RentalShopHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<RentalShop>> {

    @Override
    public EntityModel<RentalShop> process(EntityModel<RentalShop> model) {
        return model;
    }
}
