import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import pageobject.MainPage;

public class ConstructorTests extends BaseTest {

    @Test
    @Description("Проверка перехода к разделу Булки ")
    public void bunsClickScrollToBunsSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.fillingsClick();
        mainPage.bunsClick();
        Assert.assertTrue("Переход к разделу 'Булки' не произошел", mainPage.isBunsActive());
    }

    @Test
    @Description("Проверка перехода к разделу Соусы ")
    public void saucesClickScrollToSaucesSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.saucesClick();
        Assert.assertTrue("Переход к разделу 'Соусы' не произошел", mainPage.isSaucesActive());
    }

    @Test
    @Description("Проверка перехода к разделу Начинки ")
    public void fillingsClickScrollToFillingsSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.fillingsClick();
        Assert.assertTrue("Переход к разделу 'Начинки' не произошел", mainPage.isFillingsActive());
    }
}
