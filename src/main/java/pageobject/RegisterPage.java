package pageobject;

import config.TestConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private WebDriver driver;

    private final String URL = TestConfig.BASE_URL + "/register";

    private final By nameField = By.xpath("//label[text() ='Имя']/following-sibling::input");
    private final By emailField = By.xpath("//label[text() ='Email']/following-sibling::input");
    private final By passwordField = By.xpath("//label[text() ='Пароль']/following-sibling::input");
    private final By incorrectPasswordMessage = By.xpath("//p[text()='Некорректный пароль']");

    private final By loginButton = By.xpath("//a[text() ='Войти']");
    private final By registerButton = By.xpath("//button[text() ='Зарегистрироваться']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(URL);
        new WebDriverWait(driver, TestConfig.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Регистрация']")));
    }

    @Step("Ввод значения в поле Имя")
    public void enterNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввод значения в поле Email")
    public void enterEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввод значения в поле Password")
    public void enterPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Ввод значений в поля Email, Password и Имя")
    public void setRegisterData(String name, String email, String password) {
        enterNameField(name);
        enterEmailField(email);
        enterPasswordField(password);
    }

    @Step("Клик по кнопке Войти")
    public LoginPage loginButtonClick() {
        new WebDriverWait(driver, TestConfig.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
        new WebDriverWait(driver, TestConfig.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Вход']")));
        return new LoginPage(driver);
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public LoginPage registerButtonClick() {
        new WebDriverWait(driver, TestConfig.DEFAULT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(registerButton));
        driver.findElement(registerButton).click();
        return new LoginPage(driver);
    }

    @Step("Проверка видимости сообщения о некорректном вводе поля Password")
    public boolean isIncorrectPasswordMessageDisplayed() {
        try {
            new WebDriverWait(driver, TestConfig.DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated(incorrectPasswordMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
