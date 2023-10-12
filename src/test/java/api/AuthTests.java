package api;

import constants.Constant;
import org.testng.annotations.Test;

import static constants.Constant.Urls.LOG_IN_URL;

public class AuthTests {
    @Test
    public void successAuthTests(){
        Specifications.installSpec(Specifications.requestSpec(LOG_IN_URL), Specifications.responseSpecOK200());
        Login admin = new Login("admin", "password");



    }
}
