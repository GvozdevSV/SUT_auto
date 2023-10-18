package test.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.base.sut_home.SutHomePage;
import pages.add_user_page.AddNewUserPage;
import pages.labor_costs_page.LaborCostsPage;
import pages.pivot_page.DropdownFilterPivotPage;
import pages.pivot_page.PivotPage;

import static common.config.CLEAR_COOKIES_AND_STORAGE;
import static common.config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected SutHomePage sutHomePage = new SutHomePage(driver);
    protected PivotPage pivotPage = new PivotPage(driver);
    protected DropdownFilterPivotPage dropdownFilterPivotPage = new DropdownFilterPivotPage(driver);
    protected AddNewUserPage addNewUserPage = new AddNewUserPage(driver);
    protected LaborCostsPage laborCostsPage = new LaborCostsPage(driver);


    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }


    }
}