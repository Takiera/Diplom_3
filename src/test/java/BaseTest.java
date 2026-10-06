import api.UserApiClient;
import driver.FactoryDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected static final String NAME = "Влад";
    protected static final String PASSWORD = "123asd";
    protected static final String EMAIL = "vlad" + System.currentTimeMillis() % 10000 + "@yandex.ru";
    protected String token;

    @Rule
    public FactoryDriver factoryDriver = new FactoryDriver();

    protected WebDriver driver;

    @Before
    public void initDriver() {
        driver = factoryDriver.getDriver();
    }

    @After
    public void tearDown() {
        String currentToken = token;
        if (currentToken == null) {
            currentToken = getToken();
        }
        if (currentToken != null) {
            UserApiClient.deleteUser(currentToken);
        }
    }

    protected String getToken() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return window.localStorage.getItem('accessToken');");
    }

}
