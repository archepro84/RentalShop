package rentalshop.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rentalshop.domain.*;

@RestController
// @RequestMapping(value="/rentalShops")
@Transactional
public class RentalShopController {

    @Autowired
    RentalShopRepository rentalShopRepository;

    @RequestMapping(
        value = "rentalShops/{id}/accept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public RentalShop accept(
        @PathVariable(value = "id") Long id,
        @RequestBody AcceptCommand acceptCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /rentalShop/accept  called #####");
        Optional<RentalShop> optionalRentalShop = rentalShopRepository.findById(
            id
        );

        optionalRentalShop.orElseThrow(() -> new Exception("No Entity Found"));
        RentalShop rentalShop = optionalRentalShop.get();
        rentalShop.accept(acceptCommand);

        rentalShopRepository.save(rentalShop);
        return rentalShop;
    }

    @RequestMapping(
        value = "rentalShops/{id}/reject",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public RentalShop reject(
        @PathVariable(value = "id") Long id,
        @RequestBody RejectCommand rejectCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /rentalShop/reject  called #####");
        Optional<RentalShop> optionalRentalShop = rentalShopRepository.findById(
            id
        );

        optionalRentalShop.orElseThrow(() -> new Exception("No Entity Found"));
        RentalShop rentalShop = optionalRentalShop.get();
        rentalShop.reject(rejectCommand);

        rentalShopRepository.save(rentalShop);
        return rentalShop;
    }
}
