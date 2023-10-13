package api;

import constants.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.Constant.Urls.LOG_IN_URL;
import static io.restassured.RestAssured.given;

public class AuthTests {
    @Test
    public void successAuthTests(){
        Specifications.installSpec(Specifications.requestSpec(LOG_IN_URL), Specifications.responseSpecOK200());

        Login user = new Login("admin", "password");
        SuccessLogin successLogin = given()
                .body(user)
                .when()
                .post("api/auth")
                .then().log().all()
                .extract().as(SuccessLogin.class);

        Assert.assertNotNull(successLogin.getAbilityToken(),"AbilityToken не получен");
        Assert.assertNotNull(successLogin.getAccessToken(), "AccessToken не получен");
        Assert.assertNotNull(successLogin.getRefreshToken(),"RefreshToken не получен");
    }
    @Test
    public void errorAuthTests(){
        Specifications.installSpec(Specifications.requestSpec(LOG_IN_URL), Specifications.responseSpecError400());

        Login user = new Login("admin", "pass");
        ErrorLogin errorLogin = given()
                .body(user)
                .when()
                .post("api/auth")
                .then().log().all()
                .extract().as(ErrorLogin.class);

        Assert.assertEquals(errorLogin.getStatus(),400, "Код ответа не 400");
        Assert.assertEquals(errorLogin.getMessage(),"Неверный или просроченный логин/пароль", "Не верное сообщение об ошибке");
    }

}
