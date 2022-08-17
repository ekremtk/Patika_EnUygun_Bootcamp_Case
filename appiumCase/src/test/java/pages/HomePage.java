package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import lombok.Data;
import org.openqa.selenium.support.PageFactory;
import testNG.AppiumHomePageTests;

@Data
public class HomePage {

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppiumHomePageTests.Driver), this);
    }

    // App Title
    @AndroidFindBy(id = "action_bar")
    private MobileElement appTitleTop;

    // App Title Text with xpath
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Appium Patika Tutorial']")
    private MobileElement appTitleTopText;

    // Home Page Main Title
    @AndroidFindBy(id = "Title")
    private MobileElement homePageTitle;

    // Login Title
    @AndroidFindBy(id = "signUpPageTitle")
    private MobileElement signInTitle;

    // Email Title
    @AndroidFindBy(id = "signInEmailTitle")
    private MobileElement emailTitle;

    // Email Text Field
    @AndroidFindBy(id = "signInEmailTextInput")
    private MobileElement signInEmailTextField;

    // Password Title
    @AndroidFindBy(id = "SignInPasswordTitle")
    private MobileElement passwordTitle;

    // Password Text Field
    @AndroidFindBy(id = "signInPasswordTextInput")
    private MobileElement signInPasswordTextField;

    // Sign-in Button
    @AndroidFindBy(id = "signInButton")
    private MobileElement signInButton;

    // Error Text
    @AndroidFindBy(id = "signInErrorView")
    private MobileElement errorMessage;

    // Remember Me Field
    @AndroidFindBy(id = "saveLoginCheckBox")
    private MobileElement rememberMeButton;

    // Sign-up Button
    @AndroidFindBy(id = "signUpBtn")
    private MobileElement signUpButton;
}
