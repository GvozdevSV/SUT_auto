package test.base;

import common.CommonActions;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.base.sut_home.SutHomePage;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected SutHomePage sutHomePage = new SutHomePage(driver);

    public void  clearCookiesAndLocalStorage(){


    }
}
