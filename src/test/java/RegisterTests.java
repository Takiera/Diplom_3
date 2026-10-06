import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;
import pageobject.RegisterPage;

public class RegisterTests extends BaseTest {

    @Test
    @Description("Проверка успешной регистрации")
    public void registerSuccess() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openPage();
        registerPage.setRegisterData(NAME, EMAIL, PASSWORD);
        LoginPage loginPage = registerPage.registerButtonClick();
        MainPage mainPage = loginPage.login(EMAIL, PASSWORD);
        ProfilePage profilePage = mainPage.personalAccountButtonRegisteredClick();
        Assert.assertTrue("Не удалось зарегистрироваться", profilePage.isEmailFieldDisplayed(EMAIL));
    }

    @Test
    @Description("Проверка, что попытка войти в аккаунт с некорректным паролем показывает сообщение об ошибке")
    public void incorrectPasswordShowErrorMessage() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openPage();
        registerPage.setRegisterData(NAME, EMAIL, "12345");
        registerPage.registerButtonClick();
        Assert.assertTrue("Ошибка не найдена", registerPage.isIncorrectPasswordMessageDisplayed());
    }

}
