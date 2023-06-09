package rentalshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import rentalshop.RentalApplication;
import rentalshop.domain.CarCanceled;
import rentalshop.domain.CarDropOff;
import rentalshop.domain.CarRented;

@Entity
@Table(name = "Rental_table")
@Data
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long customerId;

    private Long rentalShopId;

    private Long stockId;

    private String rentalStatus;

    private Integer qty;

    private Date startedAt;

    private Date endedAt;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        rentalshop.external.PaymentCommand paymentCommand = new rentalshop.external.PaymentCommand();
        // mappings goes here
        RentalApplication.applicationContext
            .getBean(rentalshop.external.PaymentService.class)
            .payment(this.id, paymentCommand);

        CarRented carRented = new CarRented(this);
        carRented.publishAfterCommit();

        CarDropOff carDropOff = new CarDropOff(this);
        carDropOff.publishAfterCommit();

        CarCanceled carCanceled = new CarCanceled(this);
        carCanceled.publishAfterCommit();
    }

    public static RentalRepository repository() {
        RentalRepository rentalRepository = RentalApplication.applicationContext.getBean(
            RentalRepository.class
        );
        return rentalRepository;
    }

    public void rental(RentalCommand rentalCommand) {
        //implement business logic here:

    }

    public void cancel(CancelCommand cancelCommand) {
        //implement business logic here:

    }

    public void dropoff(DropoffCommand dropoffCommand) {
        //implement business logic here:

    }

    public static void updateRentalStatus(PaymentReceived paymentReceived) {
        //implement business logic here:

        /** Example 1:  new item 
        Rental rental = new Rental();
        repository().save(rental);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentReceived.get???()).ifPresent(rental->{
            
            rental // do something
            repository().save(rental);


         });
        */

    }

    public static void updateRentalStatus(RentalAccepted rentalAccepted) {
        //implement business logic here:

        /** Example 1:  new item 
        Rental rental = new Rental();
        repository().save(rental);

        */

        /** Example 2:  finding and process
        
        repository().findById(rentalAccepted.get???()).ifPresent(rental->{
            
            rental // do something
            repository().save(rental);


         });
        */

    }

    public static void updateRentalStatus(RentalRejected rentalRejected) {
        //implement business logic here:

        /** Example 1:  new item 
        Rental rental = new Rental();
        repository().save(rental);

        */

        /** Example 2:  finding and process
        
        repository().findById(rentalRejected.get???()).ifPresent(rental->{
            
            rental // do something
            repository().save(rental);


         });
        */

    }

    public static void updateRentalStatus(RentalCanceled rentalCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Rental rental = new Rental();
        repository().save(rental);

        */

        /** Example 2:  finding and process
        
        repository().findById(rentalCanceled.get???()).ifPresent(rental->{
            
            rental // do something
            repository().save(rental);


         });
        */

    }
}
