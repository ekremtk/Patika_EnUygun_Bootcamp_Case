package utility;

import io.appium.java_client.MobileElement;

public class ElementVisibility {
    public static boolean isDisplayed(MobileElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
