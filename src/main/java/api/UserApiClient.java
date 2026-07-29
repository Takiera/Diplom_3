package api;

import config.TestConfig;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.UserModel;

import static io.restassured.RestAssured.given;

public class UserApiClient {

    @Step("Удаления пользователя")
    public static void deleteUser(String token) {
        given()
                .header("Authorization", token)
                .delete(TestConfig.BASE_URL + "/api/auth/user")
                .then()
                .statusCode(202);
    }

    @Step("Создание пользователя")
    public static String createUser(UserModel user) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(TestConfig.BASE_URL + "/api/auth/register");
        response.then().statusCode(200);
        return response.path("accessToken");
    }
}
