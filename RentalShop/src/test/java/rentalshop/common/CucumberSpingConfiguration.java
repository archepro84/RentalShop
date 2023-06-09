package rentalshop.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import rentalshop.RentalShopApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { RentalShopApplication.class })
public class CucumberSpingConfiguration {}
