package pageObjects;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class HomePage {

    //WebDriver setups
    WebDriver driver;

    Helper elementHelper;
    String day2;

    // Web Elements
    By originInput = By.id("OriginInput");
    By destinationInput = By.id("DestinationInput");

    By listForFlight = By.xpath("//*/ul[@role='listbox']/li");

    By departureDate = By.id("DepartureDate");

    By returnDate = By.id("ReturnDate");

    By cheapFlight = By.xpath("//button[@class='primary-btn block']");

    By originFlightBtn = By.xpath("(//span[@class='radioButton'])[1]");

    By destinationFlightBtn = By.xpath("(//span[@class='radioButton'])[2]");

    By selectFlightBtn = By.xpath(" //button[@id='tooltipTarget_0']");



    // Home Page Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementHelper = new Helper(driver);
    }

    // Type Airports
    public void typeWithAirports(String departureAirport, String landingAirport) {
        this.elementHelper.findElement(originInput).click();
        this.elementHelper.typeForInput(departureAirport, this.elementHelper.findElement(originInput));
        this.elementHelper.findElement(listForFlight).click();
        this.elementHelper.findElement(destinationInput).click();
        this.elementHelper.typeForInput(landingAirport, this.elementHelper.findElement(destinationInput));
        this.elementHelper.findElement(listForFlight).click();
    }

    public void setDepartureDate() throws InterruptedException {
        this.elementHelper.findElement(departureDate).click();
        Thread.sleep(1000);

        SimpleDateFormat datePicker = new SimpleDateFormat("dd MMMM yyyy", new Locale("tr"));
        String currentDate = datePicker.format(new Date());
        System.out.println("Today's Date Is: " + currentDate);

        String todaysDay = getCurrentDayAndSplit();
        int todaysDayInt = Integer.parseInt(todaysDay);
        todaysDayInt = todaysDayInt + 5;

        driver.findElement(By.xpath("(//div[@class='CalendarDay__content'][normalize-space()='" + todaysDayInt + "'])[2]")).click();

        this.elementHelper.findElement(returnDate).click();

        int nextDay = todaysDayInt + 3;


        driver.findElement(By.xpath("(//div[@class='CalendarDay__content'][normalize-space()='" + nextDay + "'])[2]")).click();
    }


    public String getCurrentDayAndSplit() {
        SimpleDateFormat datePicker = new SimpleDateFormat("dd MMMM yyyy", new Locale("tr"));
        String currentDate = datePicker.format(new Date());

        String[] splited = currentDate.split("\\s+");
        this.day2 = splited[0];

        return this.day2;
    }

    public void clickFindButton() {
        this.elementHelper.findElement(cheapFlight).click();
    }

    public void selectFlights() throws InterruptedException {
        Thread.sleep(3000);
        this.elementHelper.findElement(originFlightBtn).click();
        Thread.sleep(1500);
        this.elementHelper.findElement(destinationFlightBtn).click();
        Thread.sleep(1500);
        this.elementHelper.findElement(selectFlightBtn).click();
    }



}
