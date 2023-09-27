package pages.pivot_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

public class PivotPage extends BasePage {

    public PivotPage(WebDriver driver) {
        super(driver);
    }

    private final By tabAnalytics = By.cssSelector("div[id='analytics']");
    private final By tabPivotTable = By.cssSelector("div[id=\"analytics\"]");
    private final By PivotDropdownButton = By.cssSelector("button[class='MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeSmall MuiButton-textSizeSmall MuiButton-disableElevation MuiButtonBase-root css-1v7gybn']");
    private final By AllFilterTab = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");
    //блок "Таблица"
    private final By tabBlock = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");
    //чекбокс для отображения неактивных пользователей
    private final By notActiveUserCheckbox = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");
    //чекбокс для отображения неактивных проектов
    private final By notActiveProjectCheckbox = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");
    //блок "Роль в проекте"
    private final By projectRuleBlock = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");
    //радиобатон все проекты(выбран по умолчанию)
    private final By allProjectsRadiobutton = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");
    //радиобатон мои проекты
    private final By myProjectsRadiobutton = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");
    //радиобатон участник
    private final By userRadiobutton = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");
    //радиобатон руководитель проекта
    private final By leadProjectRadiobutton = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");
    //блок "Форма трудоустройства"
    private final By formWorkBlock = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");
    //чекбокс для отображения пользователей с почасовой оплатой(выбран по умолчанию)
    private final By hourPayUsersCheckbox = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");
    //чекбокс для отображения пользователей на окладе(выбран по умолчанию)
    private final By monthPayUsersCheckbox = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");
    //блок "Филиалы"
    private final By filialBlock = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");
    //поле с текстовым фильтром и дропдауном с вариантами всех филиалов (данные подтягиваются из раздела филиалов)
    private final By filialDropdown = By.cssSelector("form[class='MuiBox-root css-1l0qm2u']");
    //значение "Все филиалы"(выбран по умолчанию)
    // значение "Пользователи без филиалов"

    public PivotPage openFilter(){
        driver.findElement(PivotDropdownButton).click();
        return this;

    }
    public PivotPage checkDropdown(){

        //System.out.println(allDropdownText);


        WebElement tabBlockText = driver.findElement(tabBlock);
        WebElement notActiveUserCheckboxText = driver.findElement(notActiveUserCheckbox);
        WebElement notActiveProjectCheckboxText = driver.findElement(notActiveProjectCheckbox);
        WebElement projectRuleBlockText = driver.findElement(projectRuleBlock);
        WebElement allProjectsRadiobuttonText = driver.findElement(allProjectsRadiobutton);
        WebElement myProjectsRadiobuttonText = driver.findElement(myProjectsRadiobutton);
        WebElement userRadiobuttonText = driver.findElement(userRadiobutton);
        WebElement leadProjectRadiobuttonText = driver.findElement(leadProjectRadiobutton);
        WebElement formWorkBlockText = driver.findElement(formWorkBlock);
        WebElement hourPayUsersCheckboxText = driver.findElement(hourPayUsersCheckbox);
        WebElement monthPayUsersCheckboxText = driver.findElement(monthPayUsersCheckbox);
        WebElement filialBlockText = driver.findElement(filialBlock);
        WebElement filialDropdownText = driver.findElement(filialDropdown);


        Assert.assertTrue(tabBlockText.isDisplayed());
        Assert.assertTrue(notActiveUserCheckboxText.isDisplayed());
        Assert.assertTrue(notActiveProjectCheckboxText.isDisplayed());
        Assert.assertTrue(projectRuleBlockText.isDisplayed());
        //Сделать ассерт на включенный радиобатон все проекты
        Assert.assertTrue(allProjectsRadiobuttonText.isDisplayed());
        Assert.assertTrue(myProjectsRadiobuttonText.isDisplayed());
        Assert.assertTrue(userRadiobuttonText.isDisplayed());
        Assert.assertTrue(leadProjectRadiobuttonText.isDisplayed());
        Assert.assertTrue(formWorkBlockText.isDisplayed());
        Assert.assertTrue(hourPayUsersCheckboxText.isDisplayed());
        Assert.assertTrue(monthPayUsersCheckboxText.isDisplayed());
        Assert.assertTrue(filialBlockText.isDisplayed());
        Assert.assertTrue(filialDropdownText.isDisplayed());

        return this;


    }
}
