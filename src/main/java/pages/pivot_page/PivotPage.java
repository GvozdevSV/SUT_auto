package pages.pivot_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class PivotPage extends BasePage {

    public PivotPage(WebDriver driver) {
        super(driver);
    }
    private final By tabAnalytics = By.cssSelector("div[id='analytics']");
    private final By tabPivotTable = By.cssSelector("div[id=\"analytics\"]");
    private final By PivotDropdownButton = By.cssSelector("button[class='MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeSmall MuiButton-textSizeSmall MuiButton-disableElevation MuiButtonBase-root css-1v7gybn']");
    private final By AllFilterTab = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");


    public PivotPage openFilter(){
        driver.findElement(PivotDropdownButton).click();
        return this;

    }
    public PivotPage checkDropdown(){
        String allDropdownText = driver.findElement(AllFilterTab).getText();
        System.out.println(allDropdownText);
        return this;



    }
}
