import api.UserApiClient;
import io.qameta.allure.Description;
import model.UserModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobject.*;

public class LoginTests extends BaseTest {

    @Before
    public void setUp() {
        UserModel user = new UserModel(EMAIL, PASSWORD, NAME);
        token = UserApiClient.createUser(user);
    }

    @Test
    @Description("Проверка входа в профиль через клик по кнопке Войти в аккаунт ")
    public void mainPageLoginButtonLoginSuccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        LoginPage loginPage = mainPage.loginButtonClick();
        loginPage.login(EMAIL, PASSWORD);
        ProfilePage profilePage = mainPage.personalAccountButtonRegisteredClick();
        Assert.assertTrue("Не удалось войти в профиль", profilePage.isEmailFieldDisplayed(EMAIL));
    }

    @Test
    @Description("Проверка входа в профиль через клик по кнопке Личный кабинет ")
    public void mainPagePersonalAccountButtonLoginSuccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        LoginPage loginPage = mainPage.personalAccountButtonUnregisteredClick();
        loginPage.login(EMAIL, PASSWORD);
        ProfilePage profilePage = mainPage.personalAccountButtonRegisteredClick();
        Assert.assertTrue("Не удалось войти в профиль", profilePage.isEmailFieldDisplayed(EMAIL));
    }

    @Test
    @Description("Проверка входа в профиль через клик по кнопке Войти на странице регистрации ")
    public void registerPageLoginButtonLoginSuccess() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openPage();
        LoginPage loginPage = registerPage.loginButtonClick();
        MainPage mainPage = loginPage.login(EMAIL, PASSWORD);
        ProfilePage profilePage = mainPage.personalAccountButtonRegisteredClick();
        Assert.assertTrue("Не удалось войти в профиль", profilePage.isEmailFieldDisplayed(EMAIL));
    }

    @Test
    @Description("Проверка входа в профиль через клик по кнопке Войти на странице восстановления пароля")
    public void forgotPasswordPageLoginButtonLoginSuccess() {
        ForgotPasswordPage
                forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.openPage();
        LoginPage loginPage = forgotPasswordPage.loginButtonClick();
        MainPage mainPage =  loginPage.login(EMAIL, PASSWORD);
        ProfilePage profilePage = mainPage.personalAccountButtonRegisteredClick();
        Assert.assertTrue("Не удалось войти в профиль", profilePage.isEmailFieldDisplayed(EMAIL));
    }
}
