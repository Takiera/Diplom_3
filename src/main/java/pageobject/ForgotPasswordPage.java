package pageobject;

import config.TestConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;

    private final String URL = TestConfig.BASE_URL + "/forgot-password";

    private final By loginButton = By.xpath("//a[text() ='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(URL);
    }

    @Step("Клик по кнопке Войти")
    public LoginPage loginButtonClick() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
}
