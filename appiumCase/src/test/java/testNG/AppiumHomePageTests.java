package testNG;

import devices.DeviceList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utility.DeviceListUtility;
import utility.ElementVisibility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumHomePageTests {

    public static AppiumDriver<?> Driver;
    HomePage homePage;
    String pixel4XL;
    DesiredCapabilities capabilities;

    public AppiumHomePageTests() {
        pixel4XL = DeviceList.PIXEL_4_XL.path;
    }


    @BeforeClass
    public void setup() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities = DeviceListUtility.pathToDesiredCapabilities(this.pixel4XL);
        capabilities.setCapability("app", new File("src/test/resources/app/patikaappium.apk").getAbsolutePath());

        Driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        homePage = new HomePage();
    }

    @Test(priority = 0, enabled = true)
    public void checkFieldsVisibility() throws NullPointerException, InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(ElementVisibility.isDisplayed(homePage.getAppTitleTop()), true);
        Assert.assertEquals(ElementVisibility.isDisplayed(homePage.getHomePageTitle()), true);
        Assert.assertEquals(ElementVisibility.isDisplayed(homePage.getSignInTitle()), true);
        Assert.assertEquals(ElementVisibility.isDisplayed(homePage.getEmailTitle()), true);
        Assert.assertEquals(ElementVisibility.isDisplayed(homePage.getSignInEmailTextField()), true);
        Assert.assertEquals(ElementVisibility.isDisplayed(homePage.getPasswordTitle()), true);
        Assert.assertEquals(ElementVisibility.isDisplayed(homePage.getSignInPasswordTextField()), true);
        Assert.assertEquals(ElementVisibility.isDisplayed(homePage.getSignInButton()), true);
        Assert.assertEquals(ElementVisibility.isDisplayed(homePage.getErrorMessage()), true);
        Assert.assertEquals(ElementVisibility.isDisplayed(homePage.getRememberMeButton()), true);
        Assert.assertEquals(ElementVisibility.isDisplayed(homePage.getSignUpButton()), true);
        Thread.sleep(1000);
        System.out.println("All Fields Are Visible");
        System.out.println("-----------------------------------------------");
    }

    @Test(priority = 1, enabled = false)
    public void checkFieldsTexts() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(homePage.getAppTitleTopText().getText(), "Appium Patika Tutorial");
        Assert.assertEquals(homePage.getHomePageTitle().getText(), "Appium Patika Tutorial");
        Assert.assertEquals(homePage.getSignInTitle().getText(), "Giriş Yap");
        Assert.assertEquals(homePage.getEmailTitle().getText(), "Email");
        Assert.assertEquals(homePage.getSignInEmailTextField().getText(), "user@domain.com");
        Assert.assertEquals(homePage.getPasswordTitle().getText(), "Password");
        Assert.assertEquals(homePage.getSignInPasswordTextField().getText(), "Password");
        Assert.assertEquals(homePage.getSignInButton().getText(), "GIRIŞ YAP");
        Assert.assertEquals(homePage.getErrorMessage().getText(), "Error View");
        Assert.assertEquals(homePage.getRememberMeButton().getText(), "Beni Hatırla");
        Assert.assertEquals(homePage.getSignUpButton().getText(), "SIGN UP");
        Thread.sleep(1000);
        System.out.println("All Fields' Texts Are True");
        System.out.println("-----------------------------------------------");
    }

    @Test(priority = 2, enabled = false)
    public void checkSigninWithoutInformation() throws InterruptedException{
        Thread.sleep(1000);
        homePage.getSignInButton().click();
        Assert.assertEquals(homePage.getErrorMessage().getText(), "Email boş olamaz");
        Thread.sleep(1000);
        System.out.println("Sign In Without Any Information Is Not Possible");
        System.out.println("-----------------------------------------------");
    }

    @Test(priority = 3, enabled = false)
    public void checkSigninWithEmailAndWithoutPassword() throws InterruptedException{
        Thread.sleep(1000);
        homePage.getSignInEmailTextField().sendKeys("test@testdomain.com");
        homePage.getSignInButton().click();
        Assert.assertEquals(homePage.getErrorMessage().getText(), "Password cant be empty");
        Thread.sleep(1000);
        System.out.println("In Order To Sign In, Password Is Required As Well As E-mail Information");
        System.out.println("-----------------------------------------------");
    }

    @Test(priority = 4, enabled = false)
    public void checkSigninFalseTypeEmailAndWithPassword() throws InterruptedException{
        Thread.sleep(1000);
        homePage.getSignInEmailTextField().sendKeys("test");
        homePage.getSignInPasswordTextField().sendKeys("password");
        homePage.getSignInButton().click();
        Thread.sleep(1000);
        Assert.assertEquals(homePage.getErrorMessage().getText(), "The email address is badly formatted.");
        Thread.sleep(1000);
        System.out.println("Email Format Is Wrong");
        System.out.println("-----------------------------------------------");
        System.out.println("--> Added only @ sign after text");
        homePage.getSignInEmailTextField().sendKeys("test@");
        homePage.getSignInButton().click();
        Thread.sleep(1000);
        Assert.assertEquals(homePage.getErrorMessage().getText(), "The email address is badly formatted.");
        Thread.sleep(1000);
        System.out.println("Email Format Is Wrong Again");
        System.out.println("-----------------------------------------------");
        System.out.println("--> Added only 'test' after @ sign");
        homePage.getSignInEmailTextField().sendKeys("test@test");
        homePage.getSignInButton().click();
        Thread.sleep(1000);
        Assert.assertEquals(homePage.getErrorMessage().getText(), "There is no user record corresponding to this identifier. The user may have been deleted.");
        Thread.sleep(1000);
        System.out.println("No User Error Occurred");
        System.out.println("-> Email Format Is Acceptable At First View.");
        System.out.println("-> This Also Needs To Be Developed.");
        System.out.println("-> There Should Be Correct Email Format Check");
        System.out.println("-----------------------------------------------");
    }

    @Test(priority = 5, enabled = false)
    public void checkSigninFalseEmailAndWithPassword() throws InterruptedException{
        Thread.sleep(1000);
        homePage.getSignInEmailTextField().sendKeys("test@trialmail.com");
        homePage.getSignInPasswordTextField().sendKeys("password");
        homePage.getSignInButton().click();
        Thread.sleep(1000);
        Assert.assertEquals(homePage.getErrorMessage().getText(), "There is no user record corresponding to this identifier. The user may have been deleted.");
        Thread.sleep(1000);
        System.out.println("No User Error Occurred");
        System.out.println("-----------------------------------------------");
    }

}
