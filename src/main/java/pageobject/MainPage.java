package pageobject;

import config.TestConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;

    private final String URL = TestConfig.BASE_URL + "/";

    private final By personalAccountButton = By.xpath("//p[text() ='Личный Кабинет']");
    private final By loginButton = By.xpath("//button[text() ='Войти в аккаунт']");

    private final By buns = By.xpath("//span[text() ='Булки']");
    private final By sauces = By.xpath("//span[text() ='Соусы']");
    private final By fillings = By.xpath("//span[text() ='Начинки']");

    private final By activeBuns = By.xpath("//span[text() ='Булки']/parent::div[contains(@class, 'tab_tab_type_current')]");
    private final By activeSauces = By.xpath("//span[text() ='Соусы']/parent::div[contains(@class, 'tab_tab_type_current')]");
    private final By activeFillings = By.xpath("//span[text() ='Начинки']/parent::div[contains(@class, 'tab_tab_type_current')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(URL);
    }

    @Step("Клик по кнопке Личный кабинет если вход в профиль выполнен")
    public ProfilePage personalAccountButtonRegisteredClick() {
        driver.findElement(personalAccountButton).click();
        return new ProfilePage(driver);
    }

    @Step("Клик по кнопке Личный кабинет если вход в профиль не выполнен")
    public LoginPage personalAccountButtonUnregisteredClick() {
        driver.findElement(personalAccountButton).click();
        return new LoginPage(driver);
    }

    @Step("Клик по кнопке Войти в аккаунт")
    public LoginPage loginButtonClick() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    @Step("Клик по заголовку раздела Булочки")
    public void bunsClick() {
        driver.findElement(buns).click();
    }

    @Step("Клик по заголовку раздела Соусы")
    public void saucesClick() {
        driver.findElement(sauces).click();
    }

    @Step("Клик по заголовку раздела Начинки")
    public void fillingsClick() {
        driver.findElement(fillings).click();
    }

    @Step("Проверка активности раздела Булочки")
    public boolean isBunsActive() {
        try {
            new WebDriverWait(driver, TestConfig.DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated(activeBuns));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Проверка активности раздела Соусы")
    public boolean isSaucesActive() {
        try {
            new WebDriverWait(driver, TestConfig.DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated(activeSauces));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Проверка активности раздела Начинки")
    public boolean isFillingsActive() {
        try {
            new WebDriverWait(driver, TestConfig.DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated(activeFillings));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
