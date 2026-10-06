package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FactoryDriver extends ExternalResource {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void initDriver() {
        String browser = System.getProperty("browser");
        if ("chrome".equals(browser)) {
            startChrome();
        } else {
            startYandex();
        }
    }

    private void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private void startYandex() {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/yandexdriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary(
                System.getProperty("yandex.binary.path",
                        "/Applications/Yandex.app/Contents/MacOS/Yandex"));
        driver = new ChromeDriver(options);
    }

    @Override
    protected void before() throws Throwable {
        initDriver();
    }

    @Override
    protected void after() {
        driver.quit();
    }
}