package testNG;

import devices.DeviceList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SignUpPage;
import utility.DeviceListUtility;
import utility.ElementVisibility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class AppiumSignUpPageTests {

    public static AppiumDriver<?> Driver;

    SignUpPage signUpPage;
    String pixel4XL;
    DesiredCapabilities capabilities;

    // create instance of Random class
    Random rand = new Random();
    // Generate random integers in range 0 to 999
    int random_int = rand.nextInt(1000);
    String createdUser = "test" + random_int + "@trialdomain.com";
    String createdPassword = "password" + random_int;



    public AppiumSignUpPageTests() {
        pixel4XL = DeviceList.PIXEL_4_XL.path;
    }

    @BeforeClass
    public void setup() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities = DeviceListUtility.pathToDesiredCapabilities(this.pixel4XL);
        capabilities.setCapability("app", new File("src/test/resources/app/patikaappium.apk").getAbsolutePath());

        Driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        signUpPage = new SignUpPage();
    }

    @Test(priority = 0, enabled = false)
    public void checkFieldsVisibility() throws NullPointerException, InterruptedException {
        signUpPage.getSignUpButtonAtHome().click();
        Thread.sleep(1000);
        Assert.assertEquals(ElementVisibility.isDisplayed(signUpPage.getTitleTop()), true);
        Assert.assertEquals(ElementVisibility.isDisplayed(signUpPage.getUsernameField()), true);
        Assert.assertEquals(ElementVisibility.isDisplayed(signUpPage.getPasswordField()), true);
        Assert.assertEquals(ElementVisibility.isDisplayed(signUpPage.getSignUpButton()), true);
        Assert.assertEquals(ElementVisibility.isDisplayed(signUpPage.getSignInButton()), true);
        Thread.sleep(1000);
        System.out.println("All Fields Are Visible");
        System.out.println("-----------------------------------------------");
    }

    @Test(priority = 1, enabled = false)
    public void checkFieldsTexts() throws InterruptedException {
        signUpPage.getSignUpButtonAtHome().click();
        Thread.sleep(1000);
        Assert.assertEquals(signUpPage.getTitleTopText().getText(), "Appium Patika Tutorial");
        Assert.assertEquals(signUpPage.getUsernameField().getText(), "Username");
        Assert.assertEquals(signUpPage.getPasswordField().getText(), "Password");
        Assert.assertEquals(signUpPage.getSignUpButton().getText(), "SIGN UP");
        Assert.assertEquals(signUpPage.getSignInButton().getText(), "SIGN IN");
        Thread.sleep(1000);
        System.out.println("All Fields' Texts Are True");
        System.out.println("-----------------------------------------------");
    }


    @Test(priority = 2, enabled = true)
    public void createAccountWithPassword() throws InterruptedException{
        signUpPage.getSignUpButtonAtHome().click();
        Thread.sleep(1000);
        signUpPage.getUsernameField().sendKeys(createdUser);
        signUpPage.getPasswordField().sendKeys(createdPassword);
        signUpPage.getSignUpButton().click();
        Thread.sleep(1000);
        this.createdUser = signUpPage.getUsernameField().getText();
        System.out.println("Created Username Is: " + createdUser);
        System.out.println("Created Password Is: " + createdPassword);
        System.out.println("Username and Password Successfully Added");
        System.out.println("-----------------------------------------------");
    }

    @Test(priority = 3, enabled = true)
    public void signinWithCreatedUserAtHomePage() throws InterruptedException{
        signUpPage.getSignInButton().click();
        Thread.sleep(1000);
        signUpPage.getSignInEmailTextFieldAtHome().sendKeys(createdUser);
        signUpPage.getSignInPasswordTextFieldAtHome().sendKeys(createdPassword);
        signUpPage.getSignInButtonAtHome().click();
        Thread.sleep(1000);
        System.out.println("Successfully Sign-in");
        System.out.println("-----------------------------------------------");
    }

}
