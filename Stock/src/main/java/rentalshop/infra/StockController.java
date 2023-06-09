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
// @RequestMapping(value="/stocks")
@Transactional
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @RequestMapping(
        value = "stocks/",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Stock setstock(
        @RequestBody SetstockCommand setstockcommand,
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody Stock stock
    ) throws Exception {
        System.out.println("##### /stock/setstock  called #####");
        stock.setstock(setstockcommand);
        stockRepository.save(stock);
        return stock;
    }
}
