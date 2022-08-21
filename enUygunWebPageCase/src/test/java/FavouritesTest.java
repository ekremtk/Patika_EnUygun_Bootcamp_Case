import framework.ConfigReader;
import framework.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class FavouritesTest {

    static WebDriver driver;
    HomePage homePage;

    String originAirport = "istanbul";
    String destinationAirport = "amsterdam";


    // Driver Setup
    @BeforeClass
    public void setup() {
        driver = DriverSetup.initialize_Driver(ConfigReader.initialize_Properties().get("browser").toString());
        homePage = new HomePage(driver);
    }

    // Airports Names Are Written
    @Test(priority = 1, enabled = true)
    public void typeFlights() {
        homePage.typeWithAirports(originAirport, destinationAirport);
    }

    // Dates Are Selected
    @Test(priority = 2, enabled = true)
    public void selectFlightDates() throws InterruptedException {
        homePage.setDepartureDate();
    }

    @Test(priority = 3, enabled = true)
    public void clickCheapFlight() {
        homePage.clickFindButton();
    }

    @Test(priority = 4, enabled = true)
    public void chooseFlight() throws InterruptedException {
        homePage.selectFlights();
    }

}
