import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = "com.despegar.test.steps",
    plugin = {"pretty", "html:target/cucumber", "json:target/flightreservation.json"},
    tags = "@FlightReservation"
)
public class TestRunnerFlightReservation {
}