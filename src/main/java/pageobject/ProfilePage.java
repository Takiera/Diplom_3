package pageobject;

import config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private WebDriver driver;

    public boolean isEmailFieldDisplayed(String email) {
        try {
            String emailFieldLocator = String.format("//input[@value='%s']", email);
            new WebDriverWait(driver, TestConfig.DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(emailFieldLocator)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
}
