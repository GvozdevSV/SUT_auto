package pages.base.sut_home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pages.base.BasePage;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class SutHomePage extends BasePage {
    public SutHomePage(WebDriver driver) {

        super(driver);
    }
    private final By loginField = By.cssSelector("input[name='login']");
    private final By passwordField = By.cssSelector("input[name='password']");
    private final By inButton = By.cssSelector("button[class='MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeSmall MuiButton-containedSizeSmall MuiButton-disableElevation MuiButton-fullWidth MuiButtonBase-root  css-1fwk2ht']");
    private final By tabAnalytics = By.cssSelector("div[id='analytics']");
    private final By tabPivotTable = By.cssSelector("a[href=\"/pivot-table/project\"]");
    public SutHomePage logIn(){
        driver.findElement(loginField).sendKeys("admin");
        driver.findElement(passwordField).sendKeys("password");
        driver.findElement(inButton).click();
        return this;


    }
    public SutHomePage goToPivotPage() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(tabAnalytics)).build().perform();
        driver.findElement(tabPivotTable).click();
        return this;

    }


}
