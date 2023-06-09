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
// @RequestMapping(value="/rentals")
@Transactional
public class RentalController {

    @Autowired
    RentalRepository rentalRepository;

    @RequestMapping(
        value = "rentals/",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Rental rental(
        @RequestBody RentalCommand rentalcommand,
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody Rental rental
    ) throws Exception {
        System.out.println("##### /rental/rental  called #####");
        rental.rental(rentalcommand);
        rentalRepository.save(rental);
        return rental;
    }

    @RequestMapping(
        value = "rentals/{id}/cancel",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Rental cancel(
        @PathVariable(value = "id") Long id,
        @RequestBody CancelCommand cancelCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /rental/cancel  called #####");
        Optional<Rental> optionalRental = rentalRepository.findById(id);

        optionalRental.orElseThrow(() -> new Exception("No Entity Found"));
        Rental rental = optionalRental.get();
        rental.cancel(cancelCommand);

        rentalRepository.save(rental);
        return rental;
    }

    @RequestMapping(
        value = "rentals/{id}/return",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Rental dropoff(
        @PathVariable(value = "id") Long id,
        @RequestBody DropoffCommand dropoffCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /rental/dropoff  called #####");
        Optional<Rental> optionalRental = rentalRepository.findById(id);

        optionalRental.orElseThrow(() -> new Exception("No Entity Found"));
        Rental rental = optionalRental.get();
        rental.dropoff(dropoffCommand);

        rentalRepository.save(rental);
        return rental;
    }
}
