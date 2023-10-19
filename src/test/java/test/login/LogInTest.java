package test.login;

import org.testng.annotations.Test;
import test.base.BaseTest;

import static constants.Constant.Urls.LOG_IN_URL;

public class LogInTest extends BaseTest {

    public  void logIn () throws InterruptedException {
        basePage.open(LOG_IN_URL);
        sutHomePage.logIn();
    }
}
