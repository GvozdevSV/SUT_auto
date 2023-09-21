package pages.base.sut_home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class SutHomePage extends BasePage {
    public SutHomePage(WebDriver driver) {
        super(driver);
    }
    private final By loginField = By.cssSelector("input[name='login']");
    private final By passwordField = By.cssSelector("input[name='password']");
    private final By inButton = By.cssSelector("button[class='MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeSmall MuiButton-containedSizeSmall MuiButton-disableElevation MuiButton-fullWidth MuiButtonBase-root  css-1fwk2ht']");

    public SutHomePage logIn(){
        driver.findElement(loginField).sendKeys("admin");
        driver.findElement(passwordField).sendKeys("password");
        driver.findElement(inButton).click();
        return this;


    }


}
