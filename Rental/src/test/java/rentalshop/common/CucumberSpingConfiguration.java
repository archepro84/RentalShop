package rentalshop.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import rentalshop.RentalApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { RentalApplication.class })
public class CucumberSpingConfiguration {}
