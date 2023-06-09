package rentalshop.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import rentalshop.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "rentalShops",
    path = "rentalShops"
)
public interface RentalShopRepository
    extends PagingAndSortingRepository<RentalShop, Long> {}
