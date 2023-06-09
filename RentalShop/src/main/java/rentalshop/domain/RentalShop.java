package rentalshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import rentalshop.RentalShopApplication;
import rentalshop.domain.RentalAccepted;
import rentalshop.domain.RentalCanceled;
import rentalshop.domain.RentalDropOff;
import rentalshop.domain.RentalRejected;

@Entity
@Table(name = "RentalShop_table")
@Data
public class RentalShop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long ownerId;

    private String shopName;

    private String address;

    @PostPersist
    public void onPostPersist() {
        RentalAccepted rentalAccepted = new RentalAccepted(this);
        rentalAccepted.publishAfterCommit();

        RentalRejected rentalRejected = new RentalRejected(this);
        rentalRejected.publishAfterCommit();

        RentalCanceled rentalCanceled = new RentalCanceled(this);
        rentalCanceled.publishAfterCommit();

        RentalDropOff rentalDropOff = new RentalDropOff(this);
        rentalDropOff.publishAfterCommit();
    }

    public static RentalShopRepository repository() {
        RentalShopRepository rentalShopRepository = RentalShopApplication.applicationContext.getBean(
            RentalShopRepository.class
        );
        return rentalShopRepository;
    }

    public void accept(AcceptCommand acceptCommand) {
        //implement business logic here:

    }

    public void reject(RejectCommand rejectCommand) {
        //implement business logic here:

    }

    public static void createRental(CarRented carRented) {
        //implement business logic here:

        /** Example 1:  new item 
        RentalShop rentalShop = new RentalShop();
        repository().save(rentalShop);

        */

        /** Example 2:  finding and process
        
        repository().findById(carRented.get???()).ifPresent(rentalShop->{
            
            rentalShop // do something
            repository().save(rentalShop);


         });
        */

    }

    public static void cancelRental(CarCanceled carCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        RentalShop rentalShop = new RentalShop();
        repository().save(rentalShop);

        */

        /** Example 2:  finding and process
        
        repository().findById(carCanceled.get???()).ifPresent(rentalShop->{
            
            rentalShop // do something
            repository().save(rentalShop);


         });
        */

    }

    public static void dropOffRental(CarDropOff carDropOff) {
        //implement business logic here:

        /** Example 1:  new item 
        RentalShop rentalShop = new RentalShop();
        repository().save(rentalShop);

        */

        /** Example 2:  finding and process
        
        repository().findById(carDropOff.get???()).ifPresent(rentalShop->{
            
            rentalShop // do something
            repository().save(rentalShop);


         });
        */

    }
}
