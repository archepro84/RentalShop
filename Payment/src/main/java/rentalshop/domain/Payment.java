package rentalshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import rentalshop.PaymentApplication;
import rentalshop.domain.PaymentReceived;

@Entity
@Table(name = "Payment_table")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long rentalId;

    private Integer price;

    @PostPersist
    public void onPostPersist() {
        PaymentReceived paymentReceived = new PaymentReceived(this);
        paymentReceived.publishAfterCommit();
    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    public void payment(PaymentCommand paymentCommand) {
        //implement business logic here:

    }

    public static void paymentCancel(CarCanceled carCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(carCanceled.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

    }
}
