package pageobject;

import config.TestConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    private final By emailField = By.xpath("//label[text() ='Email']/following-sibling::input");
    private final By passwordField = By.xpath("//input[@type='password']");

    private final By loginButton = By.xpath("//button[text() ='Войти']");
    private final By registerButton = By.xpath("//a[text() ='Зарегистрироваться']");
    private final By recoverPasswordButton = By.xpath("//a[text() ='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод значения в поле Email")
    public void enterEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввод значения в поле Password")
    public void enterPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Ввод значений в поля Email, Password и клик по кнопке Войти")
    public MainPage login(String email, String password) {
        new WebDriverWait(driver, TestConfig.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        enterEmailField(email);
        enterPasswordField(password);
        driver.findElement(loginButton).click();
        new WebDriverWait(driver, TestConfig.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Соберите бургер']")));
        return new MainPage(driver);
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public RegisterPage registerButtonClick() {
        driver.findElement(registerButton).click();
        new WebDriverWait(driver, TestConfig.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Регистрация']")));
        return new RegisterPage(driver);
    }

    @Step("Клик по кнопке Восстановить пароль")
    public ForgotPasswordPage recoverPasswordButtonClick() {
        driver.findElement(recoverPasswordButton).click();
        new WebDriverWait(driver, TestConfig.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Восстановление пароля']")));
        return new ForgotPasswordPage(driver);
    }
}
