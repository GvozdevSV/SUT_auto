package pages.pivot_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class PivotPage extends BasePage {

    public PivotPage(WebDriver driver) {
        super(driver);
    }




    //Изменение отображение таблици по неделям
    private final By periodSelectButton = By.cssSelector("div[class=\"MuiInput-root MuiInputBase-root MuiInputBase-colorPrimary onboaring__period-select css-1wjoqn2\"]");
    private final By weekPeriodSelect = By.cssSelector("li[data-value=\"week\"]");
    private final By getRowId = By.xpath("//h6[text()='Avrora']//ancestor::div[@row-id]");


    public void selectWeekPeriodOnLabor(){
        waitElementIsVisible(driver.findElement(periodSelectButton)).click();
        waitElementIsVisible(driver.findElement(weekPeriodSelect)).click();
    }
    public int getAvroraSum(){
        String rowId = waitElementIsVisible(driver.findElement(getRowId)).getAttribute("row-id");
        System.out.println(rowId);
        final By avroraSum = By.xpath("//div[@row-id='"+rowId+"']//div[@aria-colindex=\"10\"]//p");
        String outputText = waitElementIsVisible(driver.findElement(avroraSum)).getAttribute("innerText");
        System.out.println(outputText);
        int outputSum = Integer.parseInt(outputText);
        return outputSum;
    }
}
