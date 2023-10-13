package api;


import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.Constant.Urls.LOG_IN_URL;
import static io.restassured.RestAssured.given;

public class AuthTests {
    //TK 1536 войти в систему admin 200
    @Test
    public void successAuthTests(){
        Specifications.installSpec(Specifications.requestSpec(LOG_IN_URL), Specifications.responseSpecOK200());
        //создаем тело запроса
        Login user = new Login("admin", "password");
        //отправляем запрос и получаем ответ
        SuccessLogin successLogin = given()
                .body(user)
                .when()
                .post("api/auth")
                .then().log().all()
                .extract().as(SuccessLogin.class);
        //проверяем что в ответе есть необходимые поля
        Assert.assertNotNull(successLogin.getAbilityToken(),"AbilityToken не получен");
        Assert.assertNotNull(successLogin.getAccessToken(), "AccessToken не получен");
        Assert.assertNotNull(successLogin.getRefreshToken(),"RefreshToken не получен");
    }
    //TK 1566 войти в систему с неверным паролем admin 400
    @Test
    public void errorAuthTests(){
        Specifications.installSpec(Specifications.requestSpec(LOG_IN_URL), Specifications.responseSpecError400());
        //создаем тело запроса
        Login user = new Login("admin", "pass");
        //отправляем запрос и получаем ответ
        ErrorLogin errorLogin = given()
                .body(user)
                .when()
                .post("api/auth")
                .then().log().all()
                .extract().as(ErrorLogin.class);
        //проверяем что в ответе корректные значения
        Assert.assertEquals(errorLogin.getStatus(),400, "Код ответа не 400");
        Assert.assertEquals(errorLogin.getMessage(),"Неверный или просроченный логин/пароль", "Неверное сообщение об ошибке");
    }

}
