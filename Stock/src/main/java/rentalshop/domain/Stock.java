package rentalshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import rentalshop.StockApplication;
import rentalshop.domain.OutOfStocked;

@Entity
@Table(name = "Stock_table")
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long rentalShopId;

    private String carName;

    private String carType;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {
        OutOfStocked outOfStocked = new OutOfStocked(this);
        outOfStocked.publishAfterCommit();
    }

    public static StockRepository repository() {
        StockRepository stockRepository = StockApplication.applicationContext.getBean(
            StockRepository.class
        );
        return stockRepository;
    }

    public void setstock(SetstockCommand setstockCommand) {
        //implement business logic here:

    }

    public static void increaseStock(RentalDropOff rentalDropOff) {
        //implement business logic here:

        /** Example 1:  new item 
        Stock stock = new Stock();
        repository().save(stock);

        */

        /** Example 2:  finding and process
        
        repository().findById(rentalDropOff.get???()).ifPresent(stock->{
            
            stock // do something
            repository().save(stock);


         });
        */

    }

    public static void decreaseStock(RentalAccepted rentalAccepted) {
        //implement business logic here:

        /** Example 1:  new item 
        Stock stock = new Stock();
        repository().save(stock);

        */

        /** Example 2:  finding and process
        
        repository().findById(rentalAccepted.get???()).ifPresent(stock->{
            
            stock // do something
            repository().save(stock);


         });
        */

    }
}
