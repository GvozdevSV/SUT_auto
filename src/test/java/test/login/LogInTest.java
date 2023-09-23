package test.login;

import org.testng.annotations.Test;
import pages.base.BasePage;
import test.base.BaseTest;

import static constants.Constant.Urls.LOG_IN_URL;

public class LogInTest extends BaseTest {
@Test
    public  void logIn (){
        basePage.open(LOG_IN_URL);
        sutHomePage.logIn();
    }
}
