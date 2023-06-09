package rentalshop.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "Payment", url = "${api.url.Payment}")
public interface PaymentService {
    @RequestMapping(method = RequestMethod.PUT, path = "/payments/{id}/payment")
    public void payment(
        @PathVariable("id") Long id,
        @RequestBody PaymentCommand paymentCommand
    );
}
