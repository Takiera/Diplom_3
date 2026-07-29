package api;

import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class UserApiClient {

    @Step("Удаления пользователя")
    public static void deleteUser(String token) {
        given()
                .header("Authorization", token)
                .delete("https://stellarburgers.education-services.ru/api/auth/user")
                .then()
                .statusCode(202);
    }
}
