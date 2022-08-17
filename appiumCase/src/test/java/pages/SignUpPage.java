package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;
import testNG.AppiumSignUpPageTests;

@Data
public class SignUpPage {

    public SignUpPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppiumSignUpPageTests.Driver), this);
    }

    // HomePage Sign-up Button
    @AndroidFindBy(id = "signUpBtn")
    private MobileElement signUpButtonAtHome;

    // App Title
    @AndroidFindBy(id = "action_bar")
    private MobileElement TitleTop;

    // App Title Text with xpath
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Appium Patika Tutorial']")
    private MobileElement TitleTopText;

    // Username Field
    @AndroidFindBy(id = "username")
    private MobileElement usernameField;

    // Password Field
    @AndroidFindBy(id = "password1")
    private MobileElement passwordField;

    // Sing-up Button
    @AndroidFindBy(id = "sign")
    private MobileElement signUpButton;

    // Sing-in Button
    @AndroidFindBy(id = "signin")
    private MobileElement signInButton;

    // Hoem Page Sign-in Button
    @AndroidFindBy(id = "signInButton")
    private MobileElement signInButtonAtHome;

    // Home Page Email Text Field
    @AndroidFindBy(id = "signInEmailTextInput")
    private MobileElement signInEmailTextFieldAtHome;

    // Home Page Password Text Field
    @AndroidFindBy(id = "signInPasswordTextInput")
    private MobileElement signInPasswordTextFieldAtHome;
}
